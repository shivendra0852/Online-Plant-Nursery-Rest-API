package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.SeedException;
import com.greenhood.model.PlantType;
import com.greenhood.model.Seed;

public interface SeedService {
	
	//-------------- Register New Seed ----------------------------
		public Seed registerSeed(Seed seed,String key) throws SeedException, AuthorizationException;
		
		//-------------- Update New Seed ----------------------------
		
		public Seed updateSeed(Seed seed,String key) throws SeedException, AuthorizationException;
		
		//------------- Delete Plant ----------------------------------
		public Seed deleteSeed(Integer seedId, String key) throws SeedException, AuthorizationException;
		
		
		//-------------- List of seed ---------------------------------
		public List<Seed> getAllSeed() throws SeedException;
		
		//-------------------Get Seed By seed Id ---------------------------
		public Seed getSeedById(Integer seedId,String key)throws SeedException, AuthorizationException;
		
		//------------------- Get Seed By seed SeedType --------------------------------- 
		public List<Seed> getSeedBySeedType(PlantType seedType)throws SeedException;

}
