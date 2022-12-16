package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.exception.SeedsExceptions;
import com.masai.model.Seeds;

public interface SeedsDao extends JpaRepository<Seeds, Integer>{

	
	public List<Seeds> findBycommonName(String commonName) throws SeedsExceptions;
	
//	public Seeds findBycommonName(String commonName) throws SeedsExceptions;
	
	
	
}
