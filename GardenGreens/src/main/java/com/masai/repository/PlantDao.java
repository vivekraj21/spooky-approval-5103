package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Plants;

@Repository
public interface PlantDao extends JpaRepository<Plants, Integer> {
	
	public Optional<Plants> findByPlantName(String plantName);
	
	

}
