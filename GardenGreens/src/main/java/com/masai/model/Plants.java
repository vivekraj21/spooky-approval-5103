package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plants{
	
	@Id
	private Integer plantId;
	private Integer plantHeight;
	private String plantName;
	private String plantBloomTime;
	private Integer plantStock;
	private Integer plantCost;
	
	
	
	
}