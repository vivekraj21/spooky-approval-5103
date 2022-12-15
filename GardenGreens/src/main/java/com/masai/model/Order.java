package com.masai.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

	private Integer orderId;
	private LocalDate orderDate;
	private String transactionMode;
	private Integer quantity;
	private Double cost;
	
	
}
