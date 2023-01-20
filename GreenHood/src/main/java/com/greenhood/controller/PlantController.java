package com.greenhood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.greenhood.model.Plant;
import com.greenhood.service.PlantService;

@RestController
public class PlantController {
	@Autowired
	private PlantService pService;
	
	
	//-------------- Register New Plant ----------------------------
	@PostMapping("/plants/{key}")
	public ResponseEntity<Plant> savePlantHandler(@Valid @RequestBody Plant plant,@PathVariable("key") String key){
		Plant savedPlant = pService.registerPlant(plant, key);
		return new ResponseEntity<Plant>(savedPlant, HttpStatus.CREATED);
	}
	
	//------------------ Update New Plant -----------------------------------
	@PutMapping("/plants/{key}")
	public ResponseEntity<Plant> updatePlantHandler(Plant plant, @PathVariable("key") String key) {
		Plant updatePlant = pService.updatePlant(plant,key);
		return  new ResponseEntity<Plant>(updatePlant, HttpStatus.OK);
	}
}
