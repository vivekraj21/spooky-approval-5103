package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Seeds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seedId;
	
	private String commonName; 
	
	private  String boomTime; 
	
	private String watering;
	
	private String difficutyLevel;
	
	private String temperature;
	
	private String seedDescription;
	
	private int seedStock;
	
	private double seedCosot;
	
	private int seedsPerPackte;
	
	

}
