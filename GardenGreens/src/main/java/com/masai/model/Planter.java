package com.masai.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@Data
public class Planter {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int planterId;
	
	private float planterHeight;
	
	private int planterCapacity;
	
	@Min(value = 0)
	private int drinageHoles;
	
	private String planterColor;
	
	private String planterShape;
	
	@Min(value = 0)
	private int planterStock;
	
	@Min(value = 0)
	private int planterCost;
	
//	@ManyToMany
//	private List<Plants> plants;
//	
//	@ManyToMany
//	private List<Seeds> seeds;
	
	
	

}
