package com.masai.controller;

import java.time.LocalDate;
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
import com.masai.service.OrderService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired 
	private OrderService oService;
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		
		return cService.addCustomer(customer);
		
		
	}
	
	
	@PostMapping("/customer/order/{id}")
	public String addOrderToCustomer(@PathVariable String username, @RequestBody Orders order) {
		
		
		order.setOrderDate(LocalDate.now());
		cService.addOrderToCustomer(username, order);
		
		return "Order Placed";
		
	}
	
	@GetMapping("/customer/order/{id}")
	public Set<Orders> viewAllOrders(@PathVariable("id") int id){
		
		return cService.viewAllOrders(id);
		
	}
	
	
	
}
