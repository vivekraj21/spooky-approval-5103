package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class OrdersDTO {

	private String customerEmail;
	
	private Integer planterId;
	
	private Integer plantId;
	
	private Integer quantityPlanter;
	
	private Integer quantityPlant;
	
	private String transactionMode;
	
}
