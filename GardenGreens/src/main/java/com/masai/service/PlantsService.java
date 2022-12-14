package com.masai.service;

import com.masai.exception.PlantsException;
import com.masai.model.Plants;

public interface PlantsService {

	public Plants addPlant(Plants plant)throws PlantsException;
}
