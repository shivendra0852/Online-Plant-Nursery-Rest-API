package com.greenhood.controller;

import java.util.List;

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

import com.greenhood.model.Planter;
import com.greenhood.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;
	
	
	//================================================Planter addition=========================================================
	
	
	
	@PostMapping("/planters/{plantId}/{seedId}/{adminKey}")
	public ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter,@PathVariable("plantId") Integer plantId, @PathVariable("seedId") Integer seedId, @PathVariable("adminKey") String adminKey){
		
		Planter planter1 = planterService.addPlanter(planter,plantId,seedId,adminKey);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
	
	
	//=======================================================Update Planter==========================================================

	
	@PutMapping("/planters/{adminKey}")
	public ResponseEntity<Planter> updatePlanterHandler(@RequestBody Planter planter, @PathVariable("adminKey") String adminKey){
		
		Planter planter1 = planterService.updatePlanter(planter, adminKey);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
	
	
	
	//=================================Update Planter Height and Capacity========================================================
	
	
	
	@PutMapping("/planters/heightAndCapacity/{adminKey}")
	public ResponseEntity<Planter> updatePlanterHeightAndCapacityHandler(@RequestBody Planter planter, @PathVariable("adminKey") String adminKey){
		
		Planter planter1 = planterService.updatePlanterHeightAndCapacity(planter, adminKey);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
	
	
	
	//==============================================Update planter DrainageHoles And Color=========================================
	
	
	
	@PutMapping("/planters/drainageHolesAndColor/{adminKey}")
	public ResponseEntity<Planter> updatePlanterDrainageHolesAndColorHandler(@RequestBody Planter planter, @PathVariable("adminKey") String adminKey){
		
		Planter planter1 = planterService.updatePlanterDrainageHolesAndColor(planter, adminKey);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
	
	
	//=============================================Update Planter Stock and Cost====================================================
	
	
	
	@PutMapping("/planters/StockAndCost/{adminKey}")
	public ResponseEntity<Planter> updatePlanterStockAndCostHandler(@RequestBody Planter planter, @PathVariable("adminKey") String adminKey){
	
		Planter planter1 = planterService.updatePlanterStockAndCost(planter, adminKey);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
	
	
	//================================================Delete Planter By planter Id=================================================
	
	
	
	@DeleteMapping("/planters/{planterId}/{adminKey}")
	public ResponseEntity<String> removePlanterByPlanterIdHandler(@PathVariable("planterId") Integer planterId, @PathVariable("adminKey") String adminKey){
		
		String message = planterService.removePlanterByPlanterId(planterId, adminKey);
		
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
		
	}
	
	
	//===================================================View Planter By planter id==================================================

	
	
	@GetMapping("/planters/{adminKey}/{planterId}")
	public ResponseEntity<Planter> viewPlanterByPlanterIdHandler(@PathVariable("adminKey") String adminKey,@PathVariable("planterId") Integer planterId){
		
		Planter planter = planterService.viewPlanterByPlanterId(adminKey,planterId);
		
		return new ResponseEntity<>(planter, HttpStatus.OK);
		
	}
	
	
	//==========================================================View All Planters By Planter Shape================================
	
	
	
	
	@GetMapping("/planters/{planterShape}")
	public ResponseEntity<List<Planter>> viewAllPlanterByPlanterShapeHandler(@PathVariable("planterShape") String planterShape){
		
		List<Planter> planters = planterService.viewAllPlanterByPlanterShape(planterShape);
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	
	
	//========================================================View All Planters====================================================
	
	
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlantersHandler(){
		
		List<Planter> planters = planterService.viewAllPlanters();
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	
	
	//====================================View All Planters cost Between===========================================================

	
	
	@GetMapping("/plantersByCost/{minCost}/{maxCost}")
	public ResponseEntity<List<Planter>> viewAllPlantersBetweenTwoCostRangeHandler(@PathVariable("minCost") Integer minCost, @PathVariable("maxCost") Integer maxCost){
		
		List<Planter> planters = planterService.viewAllPlantersBetweenTwoCostRange(minCost, maxCost);
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	
}
