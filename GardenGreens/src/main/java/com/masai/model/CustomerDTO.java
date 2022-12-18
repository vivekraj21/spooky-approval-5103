package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO{

	private Integer customerId;
	
	private String customerName;
	
	private String customerEmail;
	
	private String username;
	
	private String password;
	
	private Integer balance;
	
	private Address address;
	
	
}
