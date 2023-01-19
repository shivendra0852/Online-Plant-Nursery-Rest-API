package com.greenhood.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.model.Customer;
import com.greenhood.model.CustomerCurrentSession;
import com.greenhood.model.LogInDTO;
import com.greenhood.repository.CustomerDao;
import com.greenhood.repository.CustomerSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLogInServiceImpl implements LogInService{
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CustomerSessionDao cSDao;

	@Override
	public String logIn(LogInDTO dto) throws AuthorizationException {
		
		Customer existingCustomer = cDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCustomer == null) {
			throw new AuthorizationException("Please register your self first!");
		}
		
		Optional<CustomerCurrentSession> validCustomer = cSDao.findById(existingCustomer.getCustomerId());
		
		if(validCustomer.isPresent()) {
			throw new AuthorizationException("Customer already logged in!");
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			
			CustomerCurrentSession customerCurrentSession = new CustomerCurrentSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			cSDao.save(customerCurrentSession);
			
			return customerCurrentSession.toString();
		}
		else {
			throw new AuthorizationException("Please enter a valid password!");
		}
	}

	
	
	
	@Override
	public String logOut(String uId) throws AuthorizationException {
		
		CustomerCurrentSession validCustomer = cSDao.findByUniqueId(uId);
		
		if(validCustomer==null) {
			throw new AuthorizationException("Customer haven't logged in with this number!");
		}
		
		cSDao.delete(validCustomer);
		
		return "Logged out successfully!";
	}

}
