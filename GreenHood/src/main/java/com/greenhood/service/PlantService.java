package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.Plant;
import com.greenhood.model.PlantType;

public interface PlantService {
	
	
	
	//-------------- Register New Plant ----------------------------
	public Plant registerPlant(Plant plant,String key) throws PlantException, AuthorizationException;
	
	//-------------- Update New Plant ----------------------------
	
	public Plant updatePlant(Plant plant,String key) throws PlantException, AuthorizationException;
	
	//------------- Delete Plant ----------------------------------
	public Plant deletePlant(Integer plantId, String key) throws PlantException, AuthorizationException;
	
	
	//-------------- List of Plant ---------------------------------
	public List<Plant> getAllPlant(String key) throws PlantException, AuthorizationException;
	
	//-------------------Get Plant By Plant Id ---------------------------
	public Plant getPlantById(Integer plantId,String key)throws PlantException, AuthorizationException;
	
	//------------------- Get Plant By Plant PlantType --------------------------------- 
	public List<Plant> getPlantByPlantType(PlantType plantType,String key)throws PlantException, AuthorizationException;
}
