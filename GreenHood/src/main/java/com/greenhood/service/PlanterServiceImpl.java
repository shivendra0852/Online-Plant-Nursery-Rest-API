package com.greenhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;
import com.greenhood.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService{

	@Autowired
	private PlanterDao planterDao;
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter deletePlanterByPlanterId(Integer planterId) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter deletePlanterByPlanterName(String planterName) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter viewPlanterByPlanterId(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlantersBetweenTwoCastRange(double minCost, double maxCost) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(int numberOfDrainageHoles) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

}
