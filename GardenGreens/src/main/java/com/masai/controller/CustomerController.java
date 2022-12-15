package com.masai.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		
		return cService.addCustomer(customer);
		
		
	}
	
	
	@PostMapping("/customer/order/{id}")
	public String addOrderToCustomer(@PathVariable int id, @RequestBody Orders order) {
		
		cService.addOrderToCustomer(id, order);
		
		return "Order Placed";
		
	}
	
	@GetMapping("/customer/order/{id}")
	public Set<Orders> viewAllOrders(@PathVariable("id") int id){
		
		return cService.viewAllOrders(id);
		
	}
	
	
	
}
