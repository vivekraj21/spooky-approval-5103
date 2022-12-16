package com.masai.service;

import java.util.List;

import com.masai.exception.PlanterExceptions;
import com.masai.model.Planter;

public interface PlanterServices {
	
	
    public Planter addPlanter(Planter planter,String key) throws PlanterExceptions;
	

	public Planter updatePlanter(Planter planter,String key)throws PlanterExceptions;
	
	
	public Planter deletePlanter(Planter planter,String key) throws PlanterExceptions;
	
	
	public Planter viewPlanter(Integer planterId) throws PlanterExceptions;
	
	
	public List<Planter> viewPlantersByShape(String planterShape) throws PlanterExceptions;
	
	
	public List<Planter> viewAllPlanters() throws PlanterExceptions;
	
	
	public List<Planter> viewAllPlantersByCostRange( double minCost, double maxCost)throws PlanterExceptions;

}
