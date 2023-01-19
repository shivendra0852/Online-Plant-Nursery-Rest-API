package com.greenhood.service;

import com.greenhood.exception.PlanterException;
import com.greenhood.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter)throws PlanterException;
}
