package com.greenhood.service;

import com.greenhood.exception.CustomerException;
import com.greenhood.model.*;

import java.util.List;

	public interface CustomerService {
	    public Customer registerCustomer(Customer customer) throws CustomerException;

	    public Customer updateCustomer(Customer customer,String key) throws CustomerException;
	    public Customer deleteCustomer(Integer id,String key) throws CustomerException;
//	    public List<Customer> getAllCustomer(String key) throws CustomerException;
	    public Customer getCustomerById(Integer id,String key) throws CustomerException;
	    
	    public Cart addPlantToCart(Integer plantId,String key) throws CustomerException;
	    public Cart addPlanterToCart(Integer planterId, String key) throws CustomerException;
	    public Cart addSeedsToCart(Integer seedsId,String key) throws CustomerException;
	    
	    public Cart decreaseQuantityOfSeeds(Integer seedsId,String key) throws CustomerException;
	    public Cart decreaseQuantityOfPlant(Integer plantId,String key) throws CustomerException;
	    public Cart decreaseQuantityOfPlanter(Integer planterId,String key) throws CustomerException;


	}

