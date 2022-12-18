package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plants;
import com.masai.service.PlantsService;

@RestController
@RequestMapping("/plantservice")
public class PlantsController {
	
	@Autowired
	private PlantsService pService;
	
	@PostMapping("/plants/{key}")
	public ResponseEntity<Plants> addPlantHandler(@RequestBody Plants plant,@PathVariable("key") String key){
		Plants newPlant= pService.addPlant(plant,key);
		return new ResponseEntity<Plants>(newPlant, HttpStatus.CREATED);
	}
	
	@PutMapping("/plants/{key}")
	public ResponseEntity<Plants> updatePlantsHandler(@RequestBody Plants plant,@PathVariable("key") String key){
		Plants updatedPlant = pService.updatePlants(plant,key);
		return new ResponseEntity<Plants>(updatedPlant, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/plants/{plantId}/{key}")
	public ResponseEntity<Plants> deletePlantsbyIdHandler(@PathVariable("plantId") Integer plantId,@PathVariable("key") String key){
		Plants deletedPlant = pService.deletePlantsbyId(plantId,key);
		return new ResponseEntity<Plants>(deletedPlant, HttpStatus.OK);
	}
	
	@GetMapping("/plantsId/{plantId}")
	public ResponseEntity<Plants> ViewPlantByIdHandler(@PathVariable("plantId") Integer plantId){
		Plants plant = pService.ViewPlantById(plantId);
		return new ResponseEntity<Plants>(plant,HttpStatus.OK);
	}
	
	@GetMapping("/plants/{plantName}")
	public ResponseEntity<Plants> ViewPlantByNameHandler(@PathVariable("plantName") String plantName){
		Plants plant = pService.ViewPlantByName(plantName);
		return new ResponseEntity<Plants>(plant, HttpStatus.OK);
	}

	@GetMapping("/plants")
	public ResponseEntity<List<Plants>> getAllViewAllPlantsHandler(){
		List<Plants> plants = pService.ViewAllPlants();
		return new ResponseEntity<List<Plants>>(plants,HttpStatus.OK);
	}
	
	
	
	
	
}
