package com.greenhood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greenhood.exception.AuthorizationException;
import com.greenhood.exception.PlanterException;
import com.greenhood.model.AdminCurrentSession;
import com.greenhood.model.Planter;
import com.greenhood.repository.AdminSessionDao;
import com.greenhood.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService{

	@Autowired
	private PlanterDao planterDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	
	//================================================Planter addition=========================================================
	
	@Override
	public Planter addPlanter(Planter planter, String adminKey) throws PlanterException {
		
		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
//		if(planter==null) {
//			throw new PlanterException("please Enter  valid data");
//		}
		
		return planterDao.save(planter);
	}

//=======================================================Update Planter==========================================================
	
	@Override
	public Planter updatePlanter(Planter planter, String adminKey) throws PlanterException {
		
		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
		if(planter==null) {
			throw new PlanterException("please Enter  valid data");
		}
		
		Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			return planterDao.save(planter);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
		
	}
	
	//=================================Update Planter Height and Capacity========================================================
	
	
	@Override
	public Planter updatePlanterHeightAndCapacity(Planter planter, String adminKey) throws PlanterException {
		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
		if(planter.getPlanterHeight()<=0 || planter.getPlanterCapacity()<=0) {
			throw new PlanterException("please Enter valid data");
		}
		
		Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			
			Planter p = pltr.get();
			p.setPlanterHeight(planter.getPlanterHeight());
			p.setPlanterCapacity(planter.getPlanterCapacity());
			
			return planterDao.save(p);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}
	
	
	//==============================================Update planter DrainageHoles And Color=========================================
	
	
	
	@Override
	public Planter updatePlanterDrainageHolesAndColor(Planter planter, String adminKey) throws PlanterException {

		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
		
		if(planter.getDrainageHoles()<=0 || planter.getPlanterColor()==null) {
			
			throw new PlanterException("please Enter valid data");
		}
		
		Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			
			Planter p = pltr.get();
			
			p.setDrainageHoles(planter.getDrainageHoles());
			p.setPlanterColor(planter.getPlanterColor());
			
			return planterDao.save(p);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}
	
	
	//=============================================Update Planter Stock and Cost====================================================
	
	
	@Override
	public Planter updatePlanterStockAndCost(Planter planter, String adminKey) throws PlanterException {
		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
		
		if(planter.getPlanterStock()<=0 || planter.getPlanterCost()<50) {
			
			throw new PlanterException("please Enter valid data");
		}
		
		Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			
			Planter p = pltr.get();
			
			p.setPlanterStock(planter.getPlanterStock());
			p.setPlanterCost(planter.getPlanterCost());
			
			return planterDao.save(p);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}
	
	
	//================================================Delete Planter By planter Id=================================================
	
	
	

	@Override
	public String removePlanterByPlanterId(Integer planterId, String adminKey) throws PlanterException {
		
		AdminCurrentSession admin = adminSessionDao.findByUniqueId(adminKey);
		
		if(admin==null) {
			throw new AuthorizationException("Faild.. Admin must be loged in");
		}
		
		
		Optional<Planter> pltr = planterDao.findById(planterId);
		
		if(pltr.isPresent()) {
			
			Planter p = pltr.get();
			
			planterDao.delete(p);
			
			return "Planter Deleted Successfully "+p.toString();
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}

	
	
	//===================================================View Planter By planter id==================================================

	
	
	@Override
	public Planter viewPlanterByPlanterId(int planterId) throws PlanterException {
		
		Optional<Planter> planter = planterDao.findById(planterId);
		
		if(planter.isPresent()) {
			return planter.get();
		}else {
			throw new PlanterException("planter does not exist for this planter id: "+planterId);
		}
	}

	
	
	//==========================================================View All Planters By Planter Shape================================
	
	
	
	@Override
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape) throws PlanterException {
		
		List<Planter> planters = planterDao.findByPlanterShape(planterShape);
		
		if(planters.isEmpty()) {
			throw new PlanterException("Not found any Planter for this planter shape: "+planterShape);
		}
		
		return planters;
	}

	
	//========================================================View All Planters====================================================
	
	
	
	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
		List<Planter> planters = planterDao.findAll();
		if(planters.isEmpty()) {
			throw new PlanterException("Empty planter list..");
		}
		return planters;
	}
	
	
	//====================================View All Planters cost Between===========================================================

	
	@Override
	public List<Planter> viewAllPlantersBetweenTwoCostRange(double minCost, double maxCost) throws PlanterException {

		if(minCost>maxCost) {
			throw new PlanterException("Plaese Enter Valid cost");
		}
		
		List<Planter> planters = planterDao.findByPlanterBetween(minCost, maxCost);
		
		if(planters.isEmpty()) {
			throw new PlanterException("Planters not fount cost between: "+minCost+" and "+maxCost);
		}
		
		return planters;
		
	}

	
	//===========================================view All Planter By Planter Drainage Holse=======================================
	
	
	@Override
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(Integer numberOfDrainageHoles) throws PlanterException {
		
		if(numberOfDrainageHoles<=0) {
			throw new PlanterException("Please Enter valid Drainage Holes");
		}
		
		List<Planter> planters = planterDao.findByDrainageHoles(numberOfDrainageHoles);
		
		if(planters.isEmpty()) {
			throw new PlanterException("Empty planter list..");
		}
		return planters;
	}

	
	
	
	
	
	





}
