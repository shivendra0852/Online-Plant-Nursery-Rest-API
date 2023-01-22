package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter,Integer plantId, Integer seedId, String adminKey)throws PlanterException;
	
	public Planter updatePlanter(Planter planter, String adminKey)throws PlanterException;
	
	public Planter updatePlanterHeightAndCapacity(Planter planter, String adminKey)throws PlanterException;
	
	public Planter updatePlanterDrainageHolesAndColor(Planter planter, String adminKey)throws PlanterException;
	
	public Planter updatePlanterStockAndCost(Planter planter, String adminKey)throws PlanterException;
	
	public String removePlanterByPlanterId(Integer planterId, String adminKey)throws PlanterException;
	
	public Planter viewPlanterByPlanterId(String adminKey,Integer planterId)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape)throws PlanterException;
	
	public List<Planter> viewAllPlanters()throws PlanterException;
	
	public List<Planter> viewAllPlantersBetweenTwoCostRange(Integer minCost, Integer maxCost)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(Integer numberOfDrainageHoles)throws PlanterException;
}
