package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String username;
	private String password;
	
	
	
	
}
