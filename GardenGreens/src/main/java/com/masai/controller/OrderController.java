package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders")
	public Orders addOrder(@RequestBody Orders order) {
		
		return oService.addOrder(order);
		
	}
	
	
	
}
