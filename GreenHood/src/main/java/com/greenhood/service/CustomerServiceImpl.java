package com.greenhood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.greenhood.exception.CustomerException;
import com.greenhood.exception.LoginException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.model.CustomerCurrentSession;
import com.greenhood.model.LogInDTO;
import com.greenhood.model.Plant;
import com.greenhood.model.Planter;
import com.greenhood.repository.CartDao;
import com.greenhood.repository.CustomerDao;
import com.greenhood.repository.CustomerSessionDao;
import com.greenhood.repository.PlantDao;
import com.greenhood.repository.PlanterDao;

public class CustomerServiceImpl implements CustomerService{
	   @Autowired
	    private CustomerDao customerDao;
	   
	   @Autowired
	   private CustomerSessionDao sessionDao;
	
	    @Autowired
	    private PlanterDao planterDao;
	    @Autowired
	    private PlantDao plantDao;
//	    @Autowired
//	    private SeedDao seedDao;
	    @Autowired
	    private CartDao cartDao;
	    
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer = customerDao.findByMobileNo(customer.getMobileNo());
		
		if(existingCustomer==null) {
			Customer registeredCustomer = customerDao.save(customer);
			
			return registeredCustomer;
		}else {
			throw new CustomerException("Email already exists. Please try with another email address.");
		}
	}
	

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException, LoginException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
	
		if(loggedInUser.getCustomerId() == customer.getCustomerId()) {
			
			return customerDao.save(customer);
		}else {
			throw new CustomerException("Invalid details.");
		}
	}

	@Override
	public Customer deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key); 
		
		if(loggedInUser==null)
			throw new LoginException("Please provide a valid key to update your details.");
		
		

			if(loggedInUser.getCustomerId()==customerId) {
				
				Optional<Customer> opt =  customerDao.findById(customerId);
				Customer customer=opt.get();
				
				customerDao.deleteById(customerId);
				
				sessionDao.delete(loggedInUser);
				
				return customer;
			}
			else{
				throw new CustomerException("Invalid customer Id.");
			   }
			
	}

	@Override
	public Customer getCustomerById(Integer customerId,String key) throws CustomerException, LoginException{
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
	
		
			if(loggedInUser.getCustomerId()==customerId) {
				
				Optional<Customer> opt =  customerDao.findById(customerId);
				Customer customer=opt.get();
				
				return customer;
			}
			else {
				throw new CustomerException("Invalid details. Please login first to update your details.");
			}
		
	}
	

	@Override
	public Cart addPlantToCart(Integer plantId, String key) throws CustomerException, LoginException,PlantException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
		
		 Optional<Plant> optionalPlant = plantDao.findById(plantId);
		 Plant plant= optionalPlant.get();
		 
		if(plant==null)
		{
			throw new PlantException("No plant found for given plantId");
		}
		else {
			Cart cart=new Cart();
			
			cart.setTotalPrice(cart.getTotalPrice()+plant.getPlantCost());
			cart.setTotalItems(cart.getTotalItems()+1);
			
			cart.getPlantsList().add(plant);
			
			return cartDao.save(cart);
		}
	}


	@Override
	public Cart addPlanterToCart(Integer planterId, String key) throws CustomerException, LoginException,PlanterException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
		
		 Optional<Planter> optionalPlanter = planterDao.findById(planterId);
		 Planter planter= optionalPlanter.get();
		 
		if(planter==null)
		{
			throw new PlanterException("No planter found for given plantId");
		}
		else {
			Cart cart=new Cart();
			
			cart.setTotalPrice(cart.getTotalPrice()+planter.getPlanterCost());
			cart.setTotalItems(cart.getTotalItems()+1);
			
			cart.getPlantersList().add(planter);
			
			return cartDao.save(cart);
		}
	}


	@Override
	public Cart addSeedsToCart(Integer seedsId, String key) throws CustomerException, LoginException,SeedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cart removeSeedsFromCart(Integer seedsId, String key) throws CustomerException, LoginException,SeedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cart removePlantFromCart(Integer plantId, String key) throws CustomerException, LoginException,PlantException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
		
		 Optional<Plant> optionalPlant = plantDao.findById(plantId);
		 Plant plant= optionalPlant.get();
		 
		if(plant==null)
		{
			throw new PlantException("No planter found for given plantId");
		}
		else {
			Cart cart=new Cart();
			
			cart.setTotalPrice(cart.getTotalPrice()-plant.getPlantCost());
			cart.setTotalItems(cart.getTotalItems()-1);
			
			cart.getPlantsList().remove(plant);
			
			cartDao.delete(cart);
			return cart;
		}
	}


	@Override
	public Cart removePlanterFromCart(Integer planterId, String key) throws CustomerException, LoginException,PlanterException{
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new LoginException("Please provide a valid key to update your details.");
		}
		
		 Optional<Planter> optionalPlanter = planterDao.findById(planterId);
		 Planter planter= optionalPlanter.get();
		 
		if(planter==null)
		{
			throw new PlanterException("No planter found for given plantId");
		}
		else {
			Cart cart=new Cart();
			
			cart.setTotalPrice(cart.getTotalPrice()-planter.getPlanterCost());
			cart.setTotalItems(cart.getTotalItems()-1);
			
			cart.getPlantersList().remove(planter);
			
			cartDao.delete(cart);
			return cart;
		}
	}


	

}
