package com.greenhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;
}
