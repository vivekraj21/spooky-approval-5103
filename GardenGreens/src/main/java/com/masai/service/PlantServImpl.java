package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.PlantsException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Plants;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.PlantDao;

@Service
public class PlantServImpl implements PlantsService {
	@Autowired
	private PlantDao pdao;
	
	@Autowired
	private CurrentSessionRepo cDao ;
	
	@Override
	public Plants addPlant(Plants plant,String key)throws PlantsException{
		CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
	
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
		Plants newPlant = pdao.save(plant);
		return newPlant;}
	}	
	
	@Override
	public Plants updatePlants(Plants plant,String key)throws PlantsException{
		CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
		Optional<Plants> opt= pdao.findById(plant.getPlantId());
		if(opt.isPresent()) {
		Plants updatedPlants = pdao.save(plant);
			return updatedPlants;
		}else
			throw new PlantsException("Invalid Plant details");}
	}
	
	@Override
	public Plants deletePlantsbyId(Integer plantId,String key) throws PlantsException {
		CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
		Optional<Plants> opt = pdao.findById(plantId);
		if (opt.isPresent()) {
			Plants existingPlants = opt.get();
			pdao.delete(existingPlants);
			return existingPlants;
		} else
			throw new PlantsException("Plant does not exist with Id :" + plantId);}
	}
	
	@Override
	public Plants ViewPlantById(Integer plantId)throws PlantsException{
		Optional<Plants> opt= pdao.findById(plantId);
		 if(opt.isPresent()) {
			 Plants plant = opt.get();
			 return plant;
		 }else
			 throw new PlantsException("Plant does not exist with plantId :" + plantId);
	}
	
	@Override
	public Plants ViewPlantByName(String plantName)throws PlantsException{
		Optional<Plants> opt= pdao.findByPlantName(plantName);
		 if(opt.isPresent()) {
			 Plants plant = opt.get();
			 return plant;
		 }else
			 throw new PlantsException(plantName + " plant does not exist");
	}
	
	@Override
	public List<Plants> ViewAllPlants()throws PlantsException{
		List<Plants> plants = pdao.findAll();
		if (plants.size() == 0)
			throw new PlantsException("No plants found..");
		else
			return plants;
	}
	
		

	
}
