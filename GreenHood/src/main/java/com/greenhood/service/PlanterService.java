package com.greenhood.service;

import java.util.List;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter)throws PlanterException;
	
	public Planter updatePlanter(Planter planter)throws PlanterException;
	
	public Planter deletePlanterByPlanterId(Integer planterId)throws PlanterException;
	
	public Planter deletePlanterByPlanterName(String planterName)throws PlanterException;
	
	public Planter viewPlanterByPlanterId(Planter planter)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape)throws PlanterException;
	
	public List<Planter> viewAllPlanters()throws PlanterException;
	
	public List<Planter> viewAllPlantersBetweenTwoCastRange(double minCost, double maxCost)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(int numberOfDrainageHoles)throws PlanterException;
}
