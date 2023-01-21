package com.greenhood.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.SeedException;
import com.greenhood.model.PlantType;
import com.greenhood.model.Seed;

import com.greenhood.service.SeedService;
@RestController
public class SeedController {
	@Autowired
	private SeedService sService;
	
	
	//-------------- Register New Seed ----------------------------
	@PostMapping("/seeds/{key}")
	public ResponseEntity<Seed> saveSeedHandler(@Valid @RequestBody Seed seed,@PathVariable("key") String key) throws SeedException, AuthorizationException{
		Seed savedSeed = sService.registerSeed(seed, key);
		return new ResponseEntity<Seed>(savedSeed, HttpStatus.CREATED);
	}
	
	
	
	//------------------ Update New Seed -----------------------------------
	@PutMapping("/seeds/{key}")
	public ResponseEntity<Seed> updateSeedHandler( @Valid @RequestBody Seed seed, @PathVariable("key") String key) throws SeedException, AuthorizationException{
		Seed updateSeed = sService.updateSeed(seed,key);
		return  new ResponseEntity<Seed>(updateSeed, HttpStatus.OK);
	}
	
	
	//------------------ Delete New Seed -----------------------------------
	@DeleteMapping("/seeds/{seedId}/{key}")
	public ResponseEntity<Seed> deleteSeedHandler(@PathVariable("seedId")Integer seedId, @PathVariable("key") String key) throws SeedException, AuthorizationException{
		Seed deleteSeed = sService.deleteSeed(seedId,key);
		return  new ResponseEntity<Seed>(deleteSeed, HttpStatus.OK);
	}
	
	
	//------------------ Get all List of Seed -----------------------------------
	@GetMapping("/seeds/{key}")
	public ResponseEntity<List<Seed>> listOfAllSeedHandler( @PathVariable("key") String key) throws SeedException, AuthorizationException{
		List<Seed> list = sService.getAllSeed(key);
		return  new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	
	//------------------ Get Seed By Seed Id -----------------------------------
	@GetMapping("/seeds/{seedId}/{key}")
	public ResponseEntity<Seed> getSeedByIdHandler(@PathVariable("seedId")Integer seedId, @PathVariable("key") String key) throws SeedException, AuthorizationException{
		Seed seed = sService.getSeedById(seedId, key);
		return  new ResponseEntity<Seed>(seed, HttpStatus.OK);
	}
	
	
	////------------------ Get Seed By Seed Type -----------------------------------
	@GetMapping("/seeds/{seedType}/{key}")
	public ResponseEntity<List<Seed>> getSeedBySeedTypeHandler(@PathVariable("seedType")PlantType seedType, @PathVariable("key") String key) throws SeedException, AuthorizationException{
		List<Seed> list = sService.getSeedBySeedType(seedType, key);
		return  new ResponseEntity<List<Seed>>(list, HttpStatus.OK);
	}
}
