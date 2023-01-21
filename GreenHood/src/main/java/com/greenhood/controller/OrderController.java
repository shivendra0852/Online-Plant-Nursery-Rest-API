package com.greenhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CartException;
import com.greenhood.model.Order;
import com.greenhood.model.OrderDTO;
import com.greenhood.service.OrdersService;

@RestController
public class OrderController {
	@Autowired
	private OrdersService oService;
	
	@PostMapping("/orders/{cartId}/{key}")
	public ResponseEntity<Order> placeOrder(@PathVariable("cartId") Integer cartId, @PathVariable("key") String key) throws CartException, AuthorizationException{
		
		Order res = oService.placeOrder(cartId, key);
		
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
}
