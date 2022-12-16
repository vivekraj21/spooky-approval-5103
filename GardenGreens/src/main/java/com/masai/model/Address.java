package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    
	//hello
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String houseNo;
	private String colony;
	private String city;
	private String state;
	private String pincode;
	
	
}
