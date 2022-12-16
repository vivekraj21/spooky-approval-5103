package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
