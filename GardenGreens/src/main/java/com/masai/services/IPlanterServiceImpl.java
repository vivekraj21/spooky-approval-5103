package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Planter;
import com.masai.repository.planterDAO;

public class IPlanterServiceImpl implements IPlanterservices{

	@Autowired
	public planterDAO pdao;
	
	
	
	@Override
	public Planter addPlanter(Planter planter) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter viewPlanter(Integer planterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewPlantersByShape(String planterShape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlantersByCostRange(double minCost, double maxCost) {
		// TODO Auto-generated method stub
		return null;
	}

}
