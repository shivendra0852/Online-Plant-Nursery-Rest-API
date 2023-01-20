package com.greenhood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.PlantException;
import com.greenhood.model.AdminCurrentSession;
import com.greenhood.model.Plant;
import com.greenhood.model.PlantType;
import com.greenhood.repository.AdminSessionDao;
import com.greenhood.repository.PlantDao;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantDao pDao;
	
	@Autowired
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
	
	//-------------Delete A Plant -------------------------------------------------
	@Override
	public Plant deletePlant(Integer plantId, String key) throws PlantException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Plant...!");
		else {
			Optional<Plant> deletePlant = pDao.findById(plantId);
			if(deletePlant.isPresent()) {
			Plant dPlant =  deletePlant.get();
			pDao.delete(dPlant);
			return dPlant;
				
			}else throw new PlantException("Plant not found by this Id: ..........! "+plantId);
			
		}
	}
	//------------- GEt List Of All Plant -------------------------------------------------
	@Override
	public List<Plant> getAllPlant(String key) throws PlantException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Plant...!");
		else {
			List<Plant> list = pDao.findAll();
			if(list.size()!=0)return list;
			else throw new PlantException("Plants not found ..........! ");
		}
		
	}
	
	
	//------------- GEt Plant By Plant Id -------------------------------------------------
	@Override
	public Plant getPlantById(Integer plantId, String key) throws PlantException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Plant...!");
		else {
			Optional<Plant> plant = pDao.findById(plantId);
			if(plant.isPresent()) {
			Plant dPlant =  plant.get();
			
			return dPlant;
				
			}else throw new PlantException("Plant not found by this Id: ..........! "+plantId);
			
		}
	}
	//------------- Get Plant By Plant Type -------------------------------------------------
	@Override
	public List<Plant> getPlantByPlantType(PlantType plantType, String key) throws PlantException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Plant...!");
		else {
			List<Plant> list = pDao.findByPlantType(plantType);
			if(list.size()!=0) {
			
			
			return list;
				
			}else throw new PlantException("Plant not found by this Plant Type: ..........! "+plantType);
			
		}
	}
	
	
	

}
