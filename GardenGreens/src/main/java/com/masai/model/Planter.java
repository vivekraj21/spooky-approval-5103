package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
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
	

	
	
	

}
