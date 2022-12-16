package com.masai.service;

import java.util.List;

import com.masai.exception.PlantsException;
import com.masai.exception.SeedsExceptions;
import com.masai.model.Plants;
import com.masai.model.Seeds;

public interface SeedsServices {
	
    public Seeds addPSeed(Seeds seeds,String key)throws SeedsExceptions;
	
	public Seeds updateSeed(Seeds seed,String key)throws SeedsExceptions;
	
	public Seeds deleteSeed(Integer seedId,String key)throws SeedsExceptions;

	public Seeds viewSeedById(Integer SeedId)throws SeedsExceptions;

 	public List<Seeds> viewSeedByCommonName(String commonName)throws SeedsExceptions;
	
	public List<Seeds> viewAllSeeds()throws SeedsExceptions;
	
//	public List<Seeds> viewAllSeedsByType(String typeOfSeed)throws SeedsExceptions;

}
