package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PlantsException;
import com.masai.model.Plants;
import com.masai.repository.PlantDao;

@Service
public class PlantServImpl implements PlantsService {
	@Autowired
	private PlantDao cdao;
	
	@Override
	public Plants addPlant(Plants plant)throws PlantsException{
		Plants newPlant = cdao.save(plant);
		return newPlant;
	}	

}
