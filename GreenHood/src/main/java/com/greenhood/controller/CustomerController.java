package com.greenhood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CustomerException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService cService;

@PostMapping("/registerCustomer")
public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException
{
	Customer registerCustomer=cService.registerCustomer(customer);
	return new ResponseEntity<Customer>(registerCustomer,HttpStatus.CREATED);
} 

@PutMapping("/updateCustomer/{key}")
public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer,@PathVariable("key") String key) throws CustomerException, AuthorizationException
{
	Customer updatedCustomer=cService.updateCustomer(customer,key);
	return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.CREATED);
} 

@PostMapping("/addPlantToCart/{cid}/{pid}/{key}")
public ResponseEntity<Cart> addPlantToCart(@PathVariable("cid") Integer cid,@PathVariable("pid") Integer pid, @PathVariable("key") String key) throws CustomerException, AuthorizationException,PlantException {
    
	return new ResponseEntity<Cart>(cService.addPlantToCart(cid,pid,key),HttpStatus.OK);
}


@DeleteMapping("/removePlantFromCart/{cid}/{pid}/{key}")
public ResponseEntity<Cart> removePlantFromCart(@PathVariable("cid") Integer cid,@PathVariable("pid") Integer pid, @PathVariable("key") String key) throws CustomerException, AuthorizationException,PlantException {
    
	return new ResponseEntity<Cart>(cService.removePlantFromCart(cid,pid,key),HttpStatus.OK);
}
}
