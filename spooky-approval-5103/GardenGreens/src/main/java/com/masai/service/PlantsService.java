package com.masai.service;

import java.util.List;

import com.masai.exception.PlantsException;
import com.masai.model.Plants;

public interface PlantsService {

	public Plants addPlant(Plants plant)throws PlantsException;
	
	public Plants updatePlants(Plants plant)throws PlantsException;
	
	public Plants deletePlantsbyId(Integer plantId)throws PlantsException;

	public Plants ViewPlantById(Integer plantId)throws PlantsException;

 	public Plants ViewPlantByName(String plantName)throws PlantsException;
	
	public List<Plants> ViewAllPlants()throws PlantsException;
	
	public List<Plants> ViewAllPlantsByType(String plantType)throws PlantsException;
	
}
