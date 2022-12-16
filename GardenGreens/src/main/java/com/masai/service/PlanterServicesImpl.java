package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterExceptions;
import com.masai.model.CurrentUserSession;
import com.masai.model.Planter;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.PlanterDao;

@Service
public class PlanterServicesImpl implements PlanterServices{
	
	@Autowired
	private PlanterDao ptdao;
	
	@Autowired
	private CurrentSessionRepo cDao ;
	
	

	@Override
	@JsonIgnore
	public Planter addPlanter(Planter planter,String key) throws PlanterExceptions{
		// TODO Auto-generated method stub
		
		CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			Optional<Planter> opt  = ptdao.findById(planter.getPlanterId());
		    if(opt.isEmpty()) {
		     return ptdao.save(planter);
		    }else
		    	throw new PlanterExceptions("planter already exits..");
		}
		
	    
	   
		
	}

	@Override
	public Planter updatePlanter(Planter planter,String key) throws PlanterExceptions {
		// TODO Auto-generated method stub
        CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			
			Optional<Planter> opt  = ptdao.findById(planter.getPlanterId());
			Planter p = opt.get();
			
			if(opt.isPresent()) {
				return ptdao.save(planter);
			}else
				throw new PlanterExceptions("Planters does not exits with Id ");
		}
		
	    	
	}

	@Override
	public Planter deletePlanter(Planter planter,String key) throws PlanterExceptions {
		// TODO Auto-generated method stub
		
         CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			
			Optional<Planter> opt  = ptdao.findById(planter.getPlanterId());
			Planter p = opt.get();
			if(opt.isPresent()) {
				ptdao.delete(planter);
				return p;
			}else {
				throw new PlanterExceptions("Planters does not exits....");
			}
		}
		
	}

	@Override
	public Planter viewPlanter(Integer planterId) throws PlanterExceptions {
		// TODO Auto-generated method stub
		Optional<Planter> opt  = ptdao.findById(planterId);
	    if(opt.isPresent()) {
	    	return opt.get();
	    }else
	    	throw new PlanterExceptions("Planters does not exits with planterId :"+planterId);
		
	}

	@Override
	public List<Planter> viewPlantersByShape(String planterShape) throws PlanterExceptions {
		// TODO Auto-generated method stub
		
		List<Planter> pList = ptdao.findByplanterShape(planterShape);
		if(pList.isEmpty()) {
			throw new PlanterExceptions("Planters does not exits with shape :"+planterShape);
		}else {
			return pList;
		}
		
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterExceptions {
		// TODO Auto-generated method stub
		List<Planter> pList = ptdao.findAll();
		if(pList.isEmpty()) {
			throw new PlanterExceptions("Planters does not exits...");
		}else {
			return pList;
		}
		
	
	}

	@Override
	public List<Planter> viewAllPlantersByCostRange(double minCost, double maxCost) throws PlanterExceptions {
		// TODO Auto-generated method stub
		
		List<Planter> pList = ptdao.findByplanterCostBetween(minCost, maxCost);
		if(pList.isEmpty()) {
			throw new PlanterExceptions("Planters does not exits...");
		}else {
			return pList;
		}
		
	
	}
	
	

}
