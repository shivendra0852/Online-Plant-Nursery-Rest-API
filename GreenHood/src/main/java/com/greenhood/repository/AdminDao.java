package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenhood.model.Admin;

public interface AdminDao extends JpaRepository<Admin,Integer>{
	
	public Admin findByMobileNo(String mobileNo);
}
