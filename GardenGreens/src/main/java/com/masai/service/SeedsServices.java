package com.masai.service;

import java.util.List;

import com.masai.exception.PlantsException;
import com.masai.exception.SeedsExceptions;
import com.masai.model.Plants;
import com.masai.model.Seeds;

public interface SeedsServices {
	
    public Plants addPSeed(Seeds seeds)throws SeedsExceptions;
	
	public Plants updateSeed(Seeds seed)throws SeedsExceptions;
	
	public Plants deleteSeed(Seeds seed)throws SeedsExceptions;

	public Plants viewSeedById(Integer SeedId)throws SeedsExceptions;

 	public Plants viewSeedByCommonName(String commonName)throws SeedsExceptions;
	
	public List<Plants> viewAllSeeds()throws SeedsExceptions;
	
	public List<Plants> viewAllSeedsByType(String typeOfSeed)throws SeedsExceptions;

}
