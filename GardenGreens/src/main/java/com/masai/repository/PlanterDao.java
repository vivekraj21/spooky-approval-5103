package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.PlanterExceptions;
import com.masai.model.Planter;

public interface PlanterDao extends JpaRepository<Planter, Integer>{
	
	
	public List<Planter> findByShape(String shape) throws PlanterExceptions;
	
	public List<Planter>  findByplanterCostBetween(double minCost ,double maxCost) throws PlanterExceptions;

}
