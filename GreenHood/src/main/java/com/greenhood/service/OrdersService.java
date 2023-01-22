package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CartException;
import com.greenhood.exception.OrderException;
import com.greenhood.model.Order;
import com.greenhood.model.OrderDTO;

public interface OrdersService {
	public OrderDTO placeOrder(Integer cartId, String key) throws CartException, AuthorizationException;
	
	public List<Order> viewOrders(String key) throws OrderException, AuthorizationException;
}
