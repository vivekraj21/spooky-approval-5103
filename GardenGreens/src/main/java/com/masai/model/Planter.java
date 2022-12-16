package com.masai.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "planterId")
	private List<Plants> plants;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "planterId")
	private List<Seeds> seeds;
	
	
	

}
