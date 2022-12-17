package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.PlanterExceptions;
import com.masai.model.Planter;

public interface PlanterDao extends JpaRepository<Planter, Integer>{
	
	
//	public List<Planter> findByplanterShape(String planterShape) throws PlanterExceptions;
	
	public List<Planter>  findByplanterCostBetween(Integer minCost ,Integer maxCost) throws PlanterExceptions;

	public List<Planter> findByplanterShape(String planterShape)throws PlanterExceptions;

}
