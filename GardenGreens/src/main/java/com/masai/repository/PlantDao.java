package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Plants;

@Repository
public interface PlantDao extends JpaRepository<Plants, Integer> {


}
