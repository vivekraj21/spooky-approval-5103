package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.SeedsExceptions;
import com.masai.model.CurrentUserSession;
import com.masai.model.Plants;
import com.masai.model.Seeds;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.SeedsDao;

@Service
public class SeedsServiceImpl implements SeedsServices{
	
	
	@Autowired
	private SeedsDao sDao;
	
	@Autowired
	private CurrentSessionRepo cDao;

	@Override
	public Seeds addPSeed(Seeds seeds, String key) throws SeedsExceptions {
		
		
        CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			
			Optional<Seeds> opt = sDao.findById(seeds.getSeedId());
			if(opt.isPresent()) {
				throw new  SeedsExceptions("Seeds already exits....");
			}else {
				return sDao.save(seeds);
			}
			
		}
	}

	@Override
	public Seeds updateSeed(Seeds seed,String key) throws SeedsExceptions {
		// TODO Auto-generated method stub
		
        CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			
			Optional<Seeds> opt = sDao.findById(seed.getSeedId());
			if(opt.isEmpty()) {
				throw new  SeedsExceptions("Seeds Does not exits....");
			}else {
				return sDao.save(seed);
			}
		}
		
		
	}

	@Override
	public Seeds deleteSeed(Integer seedId,String key) throws SeedsExceptions {
		// TODO Auto-generated method stub
		
         CurrentUserSession  loggedAdmin = cDao.findByUuid(key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}else {
			
			Optional<Seeds> opt = sDao.findById(seedId);
			Seeds sd = opt.get();
			if(opt.isPresent()) {
				sDao.delete(sd);
				return sd;
			}else {
				throw new  SeedsExceptions("Seeds does not exits....");
			}
		}
		
		
	}

	@Override
	public Seeds viewSeedById(Integer SeedId) throws SeedsExceptions {
		// TODO Auto-generated method stub
		
		Optional<Seeds> opt = sDao.findById(SeedId);
		Seeds sd = opt.get();
		if(opt.isPresent()) {
//			sDao.delete(sd);
			return sd;
		}else {
			throw new  SeedsExceptions("Seeds does not exits....");
		}
		
	}

	@Override
	public List<Seeds> viewSeedByCommonName(String commonName) throws SeedsExceptions {
		// TODO Auto-generated method stub
		
		List<Seeds> seedList = sDao.findBycommonName(commonName);
		
		if(seedList.isEmpty()) {
//			sDao.delete(sd);
			throw new  SeedsExceptions("Seeds does not exits....");
		}else {
			return seedList;
		}
		
	
	}

	@Override
	public List<Seeds> viewAllSeeds() throws SeedsExceptions {
		// TODO Auto-generated method stub
		
		List<Seeds> sdList = sDao.findAll();
	
		if(sdList.isEmpty()) {
			throw new  SeedsExceptions("Seeds does not exits....");
		}else {
			return sdList;
		}
		
	}

//	@Override
//	public List<Seeds> viewAllSeedsByType(String typeOfSeed) throws SeedsExceptions {
//		// TODO Auto-generated method stub
//		
//		
//		
//		
//		return null;
//	}


	
}
