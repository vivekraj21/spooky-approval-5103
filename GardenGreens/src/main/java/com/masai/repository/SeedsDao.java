package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.SeedsExceptions;
import com.masai.model.Seeds;

public interface SeedsDao extends JpaRepository<Seeds, Integer>{

	
	public Seeds findByCommonName(String commonName) throws SeedsExceptions;
	
	public Seeds findBy(String commonName) throws SeedsExceptions;
	
	
	
}
