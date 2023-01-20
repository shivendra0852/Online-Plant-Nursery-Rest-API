package com.greenhood.service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.Plant;

public interface PlantService {
	
	
	
	//-------------- Register New Plant ----------------------------
	public Plant registerPlant(Plant plant,String key) throws PlantException, AuthorizationException;
	
	//-------------- Update New Plant ----------------------------
	
	public Plant updatePlant(Plant plant,String key) throws PlantException, AuthorizationException;
}
