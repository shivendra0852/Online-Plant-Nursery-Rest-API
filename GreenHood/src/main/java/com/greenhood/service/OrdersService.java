package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CartException;
import com.greenhood.exception.OrderException;
import com.greenhood.model.Order;
import com.greenhood.model.OrderDTO;

public interface OrdersService {
	public Order placeOrder(Integer cartId, String key) throws CartException, AuthorizationException;
	
	public List<OrderDTO> viewOrders(String key) throws OrderException, AuthorizationException;
}
