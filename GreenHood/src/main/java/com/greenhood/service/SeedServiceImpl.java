package com.greenhood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;

import com.greenhood.exception.SeedException;
import com.greenhood.model.AdminCurrentSession;

import com.greenhood.model.PlantType;
import com.greenhood.model.Seed;
import com.greenhood.repository.AdminSessionDao;
import com.greenhood.repository.SeedDao;


@Service
public class SeedServiceImpl implements SeedService{
	@Autowired
	private SeedDao sDao;
	
	@Autowired
	private AdminSessionDao aSDao;	
	
	@Override
	public Seed registerSeed(Seed seed, String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to register a Seed...!");
		else {
			Seed registerdSeed = sDao.save(seed);
			if(registerdSeed!=null) {
				return registerdSeed;
			}else {
				throw new SeedException("Seed Not Registered Succesfully......!");
			}
		}
	}

	@Override
	public Seed updateSeed(Seed seed, String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to register a Seed...!");
		else {
		Optional<Seed> opt = sDao.findById(seed.getSeedId());
		if(opt.isPresent()) {
			return sDao.save(seed);
		}else throw new SeedException("No Seed Found....! ");
		}
	}

	@Override
	public Seed deleteSeed(Integer seedId, String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Seed...!");
		else {
			Optional<Seed> deleteSeed= sDao.findById(seedId);
			if(deleteSeed.isPresent()) {
			Seed dSeed =  deleteSeed.get();
			sDao.delete(dSeed);
			return dSeed;
				
			}else throw new SeedException("Seed not found by this Id: ..........! "+seedId);
			
		}
	}

	@Override
	public List<Seed> getAllSeed(String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Seed...!");
		else {
			List<Seed> list = sDao.findAll();
			if(list.size()!=0)return list;
			else throw new SeedException("Seed not found ..........! ");
		}
	}

	@Override
	public Seed getSeedById(Integer seedId, String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Seed...!");
		else {
			Optional<Seed> seed= sDao.findById(seedId);
			if(seed.isPresent()) {
			Seed dSeed=  seed.get();
			
			return dSeed;
				
			}else throw new SeedException("Seed not found by this Id: ..........! "+seedId);
			
		}
	}

	@Override
	public List<Seed> getSeedBySeedType(PlantType seedType, String key) throws SeedException, AuthorizationException {
		AdminCurrentSession adminCurrentSession = (AdminCurrentSession) aSDao.findByUniqueId(key);
		
		if(adminCurrentSession==null)throw new AuthorizationException("Please provide a valid customer key to Delete a Seed...!");
		else {
			List<Seed> list = sDao.findBySeedType(seedType);
			if(list.size()!=0) {
			
			
			return list;
				
			}else throw new SeedException("Seed not found by this Seed Type: ..........! "+seedType);
			
		}
	}

}
