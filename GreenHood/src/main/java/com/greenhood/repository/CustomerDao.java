package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenhood.model.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer>{
	
	public Customer findByMobileNo(String mobileNo);
}
