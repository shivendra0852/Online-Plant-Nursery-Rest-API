package com.greenhood.repository;

import com.greenhood.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

	public Customer findByEmail(String email);
    public Customer findByEmailAndPassword(String username ,String Password);

}
