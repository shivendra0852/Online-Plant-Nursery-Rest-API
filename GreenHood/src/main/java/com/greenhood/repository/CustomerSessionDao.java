package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenhood.model.CustomerCurrentSession;

@Repository
public interface CustomerSessionDao extends JpaRepository<CustomerCurrentSession,Integer>{
	
	public CustomerCurrentSession findByUniqueId(String uId);
	
}
