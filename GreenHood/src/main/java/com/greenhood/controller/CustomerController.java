package com.greenhood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.exception.CustomerException;
import com.greenhood.exception.LoginException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.service.CustomerService;
import com.greenhood.service.PlantException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
CustomerService cService;

@PostMapping("/registerCustomer")
public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException
{
	Customer registerCustomer=cService.registerCustomer(customer);
	return new ResponseEntity<Customer>(registerCustomer,HttpStatus.CREATED);
} 

@PutMapping("/updateCustomer/{key}")
public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer,@PathVariable("key") String key) throws CustomerException, LoginException
{
	Customer registerCustomer=cService.updateCustomer(customer,key);
	return new ResponseEntity<Customer>(registerCustomer,HttpStatus.CREATED);
} 

@PostMapping("/addPlantToCart/{pid}/{key}")
public ResponseEntity<Cart> addPlantToCart(@PathVariable("pid") Integer pid, @PathVariable("key") String key) throws CustomerException, LoginException,PlantException {
    
	return new ResponseEntity<Cart>(cService.addPlantToCart(pid,key),HttpStatus.OK);
}
}
