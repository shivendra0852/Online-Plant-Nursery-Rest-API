package com.greenhood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.CustomerException;
import com.greenhood.exception.PlantException;
import com.greenhood.exception.PlanterException;
import com.greenhood.exception.SeedException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.model.CustomerCurrentSession;
import com.greenhood.model.Plant;
import com.greenhood.model.Planter;
import com.greenhood.model.Seed;
import com.greenhood.repository.CartDao;
import com.greenhood.repository.CustomerDao;
import com.greenhood.repository.CustomerSessionDao;
import com.greenhood.repository.PlantDao;
import com.greenhood.repository.PlanterDao;
import com.greenhood.repository.SeedDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	   @Autowired
	    private CustomerDao customerDao;
	   
	   @Autowired
	   private CustomerSessionDao sessionDao;
	
	    @Autowired
	    private PlanterDao planterDao;
	    @Autowired
	    private PlantDao plantDao;
	    @Autowired
	    private SeedDao seedDao;
	    @Autowired
	    private CartDao cartDao;
	    
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		Customer existingCustomer = customerDao.findByMobileNo(customer.getMobileNo());
		
		if(existingCustomer!=null) {
			throw new CustomerException("Customer already registered with this mobile No!");
		}
		
		Customer registeredCustomer = customerDao.save(customer);
		
		Cart cart = new Cart();
		cart.setCustomer(registeredCustomer);
		cart.setTotalItems(0);
		cart.setTotalPrice(0);
		cartDao.save(cart);
		
		return registeredCustomer;
		
	}
	

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException, AuthorizationException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
	
		if(loggedInUser.getCustomerId() == customer.getCustomerId()) {
			
			return customerDao.save(customer);
		}else {
			throw new CustomerException("Invalid details.");
		}
	}

	@Override
	public Customer deleteCustomer(Integer customerId, String key) throws CustomerException, AuthorizationException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key); 
		
		if(loggedInUser==null)
			throw new AuthorizationException("Please provide a valid key to update your details.");
		
		

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
	public Customer getCustomerById(Integer customerId,String key) throws CustomerException, AuthorizationException{
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
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
	
//	====================================================================================================

	@Override
	public Cart addPlantToCart(Integer cartId, Integer plantId, String key) throws CustomerException, AuthorizationException,PlantException {
		
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
		
		Optional<Cart> getCart = cartDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(loggedInUser.getCustomerId()==cart.getCustomer().getCustomerId())
		{
			Optional<Plant> optionalPlant = plantDao.findById(plantId);
			Plant plant= optionalPlant.get();
			 
			if(plant == null) {
				throw new PlantException("No plants available with this id");
			}
			
				cart.setTotalPrice(cart.getTotalPrice()+plant.getPlantCost());
				cart.setTotalItems(cart.getTotalItems()+1);
				cart.getPlantsList().add(plant);
				
				return cartDao.save(cart);
			
		}
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
	}


	@Override
	public Cart addPlanterToCart(Integer cartId,Integer planterId, String key) throws CustomerException, AuthorizationException,PlanterException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
		
		Optional<Cart> getCart = cartDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(loggedInUser.getCustomerId()==cart.getCustomer().getCustomerId())
		{
			Optional<Planter> optionalPlanter = planterDao.findById(planterId);
			Planter planter= optionalPlanter.get();
			 
			if(planter == null) {
				throw new PlanterException("No planters available with this id");
			}
			
				cart.setTotalPrice(cart.getTotalPrice()+planter.getPlanterCost());
				cart.setTotalItems(cart.getTotalItems()+1);
				cart.getPlantersList().add(planter);
				
				return cartDao.save(cart);
			
		}
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
	}


	@Override
	public Cart addSeedsToCart(Integer cartId,Integer seedsId, String key) throws CustomerException, AuthorizationException,SeedException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
		
		Optional<Cart> getCart = cartDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(loggedInUser.getCustomerId()==cart.getCustomer().getCustomerId())
		{
			Optional<Seed> optionalSeeds = seedDao.findById(seedsId);
			Seed seed= optionalSeeds.get();
			 
			if(seed == null) {
				throw new PlanterException("No seeds available with this id");
			}
			
				cart.setTotalPrice(cart.getTotalPrice()+seed.getSeedCost());
				cart.setTotalItems(cart.getTotalItems()+1);
				cart.getSeedsList().add(seed);
				
				return cartDao.save(cart);
			
		}
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
	}


	@Override
	public Cart removeSeedsFromCart(Integer cartId, Integer seedsId, String key) throws CustomerException, AuthorizationException,SeedException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
		
		Optional<Cart> getCart = cartDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(loggedInUser.getCustomerId()==cart.getCustomer().getCustomerId()) {
			
			List<Seed> seeds = cart.getSeedsList();
			Seed existingSeed = null;
			
			for(Seed s : seeds) {
				if(s.getSeedId()==seedsId) {
					existingSeed = s;
				}
			}
			
			if(existingSeed==null) {
				throw new SeedException("Seed is not available in the cart!");
			}
			
			seeds.remove(existingSeed);
			cart.setTotalPrice(cart.getTotalPrice()-existingSeed.getSeedCost());
			cart.setTotalItems(cart.getTotalItems()-1);
			
			return cartDao.save(cart);
		}
		
		 
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
	}


	@Override
	public Cart removePlantFromCart(Integer cartId, Integer plantId, String key) throws CustomerException, AuthorizationException,PlantException {
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
		}
		
		Optional<Cart> getCart = cartDao.findById(cartId);
		Cart cart = getCart.get();
		
		if(loggedInUser.getCustomerId()==cart.getCustomer().getCustomerId()) {
			
			List<Plant> plants = cart.getPlantsList();
			Plant existingPlant = null;
			
			for(Plant p : plants) {
				if(p.getPlantId()==plantId) {
					existingPlant = p;
				}
			}
			
			if(existingPlant==null) {
				throw new PlantException("Plant is not available in the cart!");
			}
			
			plants.remove(existingPlant);
			cart.setTotalPrice(cart.getTotalPrice()-existingPlant.getPlantCost());
			cart.setTotalItems(cart.getTotalItems()-1);
			
			return cartDao.save(cart);
		}
		
		 
		else {
			throw new AuthorizationException("Customer and cart mismatch");
		}
	}


	@Override
	public Cart removePlanterFromCart(Integer cartId, Integer planterId, String key) throws CustomerException, AuthorizationException,PlanterException{
		CustomerCurrentSession loggedInUser = sessionDao.findByUniqueId(key);
		
		if(loggedInUser==null) {
			throw new AuthorizationException("Please provide a valid key to update your details.");
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
