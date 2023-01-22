package com.greenhood.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CartException;
import com.greenhood.exception.OrderException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.model.CustomerCurrentSession;
import com.greenhood.model.Order;
import com.greenhood.model.OrderDTO;
import com.greenhood.repository.CartDao;
import com.greenhood.repository.CustomerDao;
import com.greenhood.repository.CustomerSessionDao;
import com.greenhood.repository.OrderDao;


@Service
public class OrderServiceImpl implements OrdersService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerSessionDao cSDao;
	
	@Autowired
	private CartDao cDao;
	
	@Autowired
	private OrderDao oDao;

	@Override
	public OrderDTO placeOrder(Integer cartId, String key) throws CartException, AuthorizationException {
		
		CustomerCurrentSession loggedInUser = cSDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide valid details!");
		}
		
		Optional<Cart> getCart = cDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(cart.getCustomer().getCustomerId()==loggedInUser.getCustomerId()) {
			
			if(cart.getTotalPrice()>0) {
				
				Order res = new Order();
				res.setOrderDate(LocalDateTime.now());
				res.setTotalCost(cart.getTotalPrice());
				res.setCart(cart);
				res.setCustomer(customerDao.findById(loggedInUser.getCustomerId()).get());
				
				oDao.save(res);
				
				return new OrderDTO(res.getOrderId(),res.getOrderDate(),res.getTotalCost());
			}
			else {
				throw new CartException("Cart is empty!");
			}
			
		}
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
		
	}

	@Override
	public List<Order> viewOrders(String key) throws OrderException, AuthorizationException {
		
		CustomerCurrentSession loggedInUser = cSDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide valid details!");
		}
		
		Customer getCustomer = customerDao.findById(loggedInUser.getCustomerId()).get();
		
		if(getCustomer.getOrderList().size()<0) {
			throw new OrderException("No orders available");
		}
		
		return getCustomer.getOrderList();
	}

}
