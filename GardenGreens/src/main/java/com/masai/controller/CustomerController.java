package com.masai.controller;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		
		
		
		Customer c = cService.addCustomer(customer);
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
		
	}
	
	
	@PostMapping("/customer/order/{name}")
	public ResponseEntity<String> addOrderToCustomer(@PathVariable("username") String username, @RequestBody Orders order) {
		
		
		order.setOrderDate(LocalDate.now());
		cService.addOrderToCustomer(username, order);
		
		return new ResponseEntity<String>("Order Placed...",HttpStatus.OK);
		
	}
	
	@GetMapping("/customer/order/{id}")
	public ResponseEntity<Set<Orders>> viewAllOrders(@PathVariable("id") int id){
		
		Set<Orders> o = cService.viewAllOrders(id);
		
		return new ResponseEntity<Set<Orders>>(o,HttpStatus.OK);
		
	}
	
	
	
}
