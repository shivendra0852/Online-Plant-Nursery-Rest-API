package com.greenhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.greenhood.service.PlantService;

@RestController
public class PlantController {
	
	@Autowired
	private PlantService pService;
	
}
