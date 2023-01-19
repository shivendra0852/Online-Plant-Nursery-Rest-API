package com.greenhood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.greenhood.exception.CustomerException;
import com.greenhood.model.Cart;
import com.greenhood.model.Customer;
import com.greenhood.repository.CustomerDao;

public class CustomerServiceImpl implements CustomerService{
	   @Autowired
	    private CustomerDao customerDao;
	
//	    @Autowired
//	    private PlanterDao planterDao;
//	    @Autowired
//	    private PlantDao plantDao;
//	    @Autowired
//	    private SeedDao seedDao;
//	    @Autowired
//	    private CartDao cartDao;
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		if(customer==null)
		{
			throw new CustomerException("Enter valid Customer info");
		}
		else {
			return customerDao.save(customer);
		}
	}
	

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		Optional<Customer> opt=customerDao.findById(customer.getCustomerId());
		if(opt.isPresent())
		{
			Customer savedCustomer=customerDao.save(customer);
			return savedCustomer;
		}
		else {
			throw new CustomerException("No Customer found");
		}
	}

	@Override
	public Customer deleteCustomer(Integer id, String key) throws CustomerException {
		Optional<Customer> opt=customerDao.findById(id);
		if(opt.isPresent())
		{
			customerDao.deleteById(id);
			return opt.get();
		}
		else {
			throw new CustomerException("No Customer found");
		}
	}

	@Override
	public Customer getCustomerById(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Cart addPlantToCart(Integer plantId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart addPlanterToCart(Integer planterId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart addSeedsToCart(Integer seedsId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart decreaseQuantityOfSeeds(Integer seedsId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart decreaseQuantityOfPlant(Integer plantId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart decreaseQuantityOfPlanter(Integer planterId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
