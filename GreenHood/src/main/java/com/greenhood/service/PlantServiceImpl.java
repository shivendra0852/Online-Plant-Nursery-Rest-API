package com.greenhood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.repository.PlantDao;

@Service
public class PlantServiceImpl implements PlantService{
		
	@Autowired
	private PlantDao pDao;
	
}
