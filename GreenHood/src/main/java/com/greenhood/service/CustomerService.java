package com.greenhood.service;


import com.greenhood.exception.CustomerException;
import com.greenhood.exception.LoginException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.*;

import java.util.List;

	public interface CustomerService {
	    public Customer registerCustomer(Customer customer) throws CustomerException;

	    public Customer updateCustomer(Customer customer,String key) throws CustomerException, LoginException;
	    public Customer deleteCustomer(Integer customerId,String key) throws CustomerException, LoginException;
//	    public List<Customer> getAllCustomer(String key) throws CustomerException;
	    public Customer getCustomerById(Integer customerId,String key) throws CustomerException, LoginException;
	    
	    public Cart addPlantToCart(Integer plantId,String key) throws CustomerException, LoginException,PlantException;
	    public Cart addPlanterToCart(Integer planterId, String key) throws CustomerException, LoginException,PlanterException;
	    public Cart addSeedsToCart(Integer seedsId,String key) throws CustomerException, LoginException,SeedException;
	    
	    public Cart removeSeedsFromCart(Integer seedsId,String key) throws CustomerException, LoginException,SeedException;
	    public Cart removePlantFromCart(Integer plantId,String key) throws CustomerException, LoginException,PlantException;
	    public Cart removePlanterFromCart(Integer planterId,String key) throws CustomerException, LoginException,PlanterException;


	}


