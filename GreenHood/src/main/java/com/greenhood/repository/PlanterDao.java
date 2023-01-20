package com.greenhood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer> {

	public List<Planter> findByPlanterShape(String planterShape) throws PlanterException;
	
	public List<Planter> findByPlanterBetween(double minCost, double maxCost) throws PlanterException;
	
	public List<Planter> findByDrainageHoles(Integer numberOfDrainageHoles) throws PlanterException;
}
