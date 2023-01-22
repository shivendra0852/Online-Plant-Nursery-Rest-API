package com.greenhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<OrderDTO> placeOrder(@PathVariable("cartId") Integer cartId, @PathVariable("key") String key) throws CartException, AuthorizationException{
		
		OrderDTO res = oService.placeOrder(cartId, key);
		
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{key}")
	public ResponseEntity<List<Order>> viewOrders(@PathVariable("key") String key){
		
		List<Order> list = oService.viewOrders(key);
		
		return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
	}
}
