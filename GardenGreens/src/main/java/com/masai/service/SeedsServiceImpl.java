package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.SeedsExceptions;
import com.masai.model.Plants;
import com.masai.model.Seeds;

@Service
public class SeedsServiceImpl implements SeedsServices{

	@Override
	public Plants addPSeed(Seeds seeds) throws SeedsExceptions {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Plants updateSeed(Seeds seed) throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants deleteSeed(Seeds seed) throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants viewSeedById(Integer SeedId) throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plants viewSeedByCommonName(String commonName) throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plants> viewAllSeeds() throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plants> viewAllSeedsByType(String typeOfSeed) throws SeedsExceptions {
		// TODO Auto-generated method stub
		return null;
	}


	
}
