package com.greenhood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenhood.model.AdminCurrentSession;

@Repository
public interface AdminSessionDao extends JpaRepository<AdminCurrentSession,Integer>{
	
	public AdminSessionDao findByUniqueId(String uId);
	
}
