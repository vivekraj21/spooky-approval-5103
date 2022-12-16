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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PlanterExceptions;
import com.masai.model.Planter;
import com.masai.model.Plants;
import com.masai.service.PlanterServices;



@RestController
@RequestMapping("/planterservice")
public class PlanterController {
	
	@Autowired
	private PlanterServices ptServices;
	
	
	@PostMapping("/planters/{key}")
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter, @PathVariable("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = ptServices.addPlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
	}
	
	
	@PostMapping("/planters")
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter, @RequestParam("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = ptServices.updatePlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@DeleteMapping("/planters/{key}")
	public ResponseEntity<Planter> deletePlanter(@RequestBody Planter planter, @PathVariable("key") String key) throws PlanterExceptions {
		
		Planter newPlanter = ptServices.deletePlanter(planter, key);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> viewByPlanterId(@PathVariable("planterId") Integer planterId) throws PlanterExceptions {
		
		Planter newPlanter = ptServices.viewPlanter(planterId);

		return new ResponseEntity<Planter>(newPlanter, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/planters/{planterShape}")
	public ResponseEntity<List<Planter>> viewPlanterByShape(@PathVariable("planterShape") String planterShape) throws PlanterExceptions {
		
		List<Planter> planterList = ptServices.viewPlantersByShape(planterShape);

		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlanters() throws PlanterExceptions {
		
		List<Planter> planterList = ptServices.viewAllPlanters();

		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	@GetMapping("/planters/{minCost}/{maxCost}")
	public ResponseEntity<List<Planter>>viewAllPlantersByCostRange(@PathVariable("minCost") Double minCost,@PathVariable("maxCost") Double maxCost) throws PlanterExceptions {
		
		List<Planter> planterList = ptServices.viewAllPlantersByCostRange(minCost,maxCost);
		
		return new ResponseEntity<List<Planter>>(planterList, HttpStatus.ACCEPTED);
		
		
		
	}
	
	

}
