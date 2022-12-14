package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plants;
import com.masai.service.PlantsService;

@RestController
public class PlantsController {
	
	@Autowired
	private PlantsService aService;
	
	@PostMapping("/plants")
	public ResponseEntity<Plants> addPlantHandler(@RequestBody Plants plant){
		Plants newPlant= aService.addPlant(plant);
		return new ResponseEntity<Plants>(newPlant, HttpStatus.CREATED);
	}
}
