package com.greenhood.service;

import org.springframework.stereotype.Service;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;
import com.greenhood.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService{

	private PlanterDao planterDao;
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

}
