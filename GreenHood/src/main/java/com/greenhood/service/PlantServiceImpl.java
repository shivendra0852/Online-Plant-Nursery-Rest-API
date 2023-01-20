package com.greenhood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.AdminCurrentSession;
import com.greenhood.model.Plant;
import com.greenhood.repository.AdminSessionDao;
import com.greenhood.repository.PlantDao;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantDao pDao;
	
	private AdminSessionDao aSDao;
	
	//------------------ Register New Plant -----------------------------------
	@Override
	public Plant registerPlant(Plant plant,String key) throws PlantException, AuthorizationException {
			AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
			if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to register a Plant...!");
			else {
				Plant registerdPlant = pDao.save(plant);
				if(registerdPlant!=null) {
					return registerdPlant;
				}else {
					throw new PlantException("Plant Not Registered Succesfully......!");
				}
			}
		
	}

	//------------------ Update New Plant -----------------------------------
	@Override
	public Plant updatePlant(Plant plant,String key) throws PlantException, AuthorizationException {
		
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to register a Plant...!");
		else {
		Optional<Plant> opt = pDao.findById(plant.getPlantId());
		if(opt.isPresent()) {
			return pDao.save(plant);
		}else throw new PlantException("No Plant Found....! ");
		}
	}

}
