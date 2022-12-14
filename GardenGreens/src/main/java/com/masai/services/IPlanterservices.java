package com.masai.services;

import java.util.List;

import com.masai.model.Planter;



public interface IPlanterservices {
	
	public Planter addPlanter(Planter planter);
	

	public Planter updatePlanter(Planter planter);
	
	
	public Planter deletePlanter(Planter planter);
	
	
	public Planter viewPlanter(Integer planterId);
	
	
	public List<Planter> viewPlantersByShape(String planterShape);
	
	
	public List<Planter> viewAllPlanters();
	
	
	public List<Planter> viewAllPlantersByCostRange( double minCost, double maxCost);
	
	
	
}
