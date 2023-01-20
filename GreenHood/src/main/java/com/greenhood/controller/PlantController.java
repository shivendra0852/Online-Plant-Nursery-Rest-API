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


import com.greenhood.model.Plant;
import com.greenhood.model.PlantType;
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
	public ResponseEntity<Plant> updatePlantHandler( @Valid @RequestBody Plant plant, @PathVariable("key") String key) {
		Plant updatePlant = pService.updatePlant(plant,key);
		return  new ResponseEntity<Plant>(updatePlant, HttpStatus.OK);
	}
	//------------------ Delete New Plant -----------------------------------
	@DeleteMapping("/plants/{plantId}/{key}")
	public ResponseEntity<Plant> deletePlantHandler(@PathVariable("plantId")Integer plantId, @PathVariable("key") String key) {
		Plant deletePlant = pService.deletePlant(plantId,key);
		return  new ResponseEntity<Plant>(deletePlant, HttpStatus.OK);
	}
	//------------------ Get all List of Plant -----------------------------------
	@GetMapping("/plants/{key}")
	public ResponseEntity<List<Plant>> listOfAllPlantHandler( @PathVariable("key") String key) {
		List<Plant> list = pService.getAllPlant(key);
		return  new ResponseEntity<>(list, HttpStatus.OK);
	}
	//------------------ Get Plant By Plant Id -----------------------------------
	@GetMapping("/plants/{plantId}/{key}")
	public ResponseEntity<Plant> getPlantByIdHandler(@PathVariable("plantId")Integer plantId, @PathVariable("key") String key){
		Plant plant = pService.getPlantById(plantId, key);
		return  new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
	
	////------------------ Get Plant By Plant Type -----------------------------------
	@GetMapping("/plants/{plantType}/{key}")
	public ResponseEntity<List<Plant>> getPlantByPlantTypeHandler(@PathVariable("plantType")PlantType plantType, @PathVariable("key") String key){
		List<Plant> list = pService.getPlantByPlantType(plantType, key);
		return  new ResponseEntity<List<Plant>>(list, HttpStatus.OK);
	}
}
