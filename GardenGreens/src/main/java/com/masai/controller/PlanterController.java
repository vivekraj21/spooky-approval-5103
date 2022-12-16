package com.masai.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PlanterExceptions;
import com.masai.model.Planter;
import com.masai.model.Plants;
import com.masai.service.PlanterServices;

import jakarta.validation.Valid;

@RestController
public class PlanterController {
	
	@Autowired
	private PlanterServices pServices;
	
	
	@PostMapping("/planters/{key}")
	public ResponseEntity<Planter> addPlanter(@Valid  @RequestBody Planter planter, @PathVariable("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = pServices.addPlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
	}
	
	
	@PostMapping("/planters")
	public ResponseEntity<Planter> updatePlanter(@Valid  @RequestBody Planter planter, @RequestParam("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = pServices.updatePlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@DeleteMapping("/planters/{key}")
	public ResponseEntity<Planter> deletePlanter(@Valid  @RequestBody Planter planter, @PathVariable("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = pServices.deletePlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> viewByPlanterId(@Valid @PathVariable("planterId") Integer planterId) throws PlanterExceptions {
		
		Planter newPlanter = pServices.viewPlanter(planterId);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/planters/{planterShape}")
	public ResponseEntity<List<Planter>> viewPlanterByShape(@Valid @PathVariable("planterShape") String planterShape) throws PlanterExceptions {
		
		List<Planter> planterList = pServices.viewPlantersByShape(planterShape);

		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlanters() throws PlanterExceptions {
		
		List<Planter> planterList = pServices.viewAllPlanters();

		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/planters/{minCost}/{maxCost}")
	public ResponseEntity<List<Planter>>viewAllPlantersByCostRange(@Valid @PathVariable("minCost") Double minCost,@PathVariable("maxCost") Double maxCost) throws PlanterExceptions {
		
		List<Planter> planterList = pServices.viewAllPlantersByCostRange(minCost,maxCost);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	

}
