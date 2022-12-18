package com.masai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.service.CustomerService;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired 
	private OrderService oService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customer) {
		Customer c = cService.addCustomer(customer);
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/customerdel/{username}/{key}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("username") String username,@PathVariable("key") String key) throws CustomerException
	{
		Customer user = cService.deleteCustomer(username,key);
		
		return new ResponseEntity<Customer>(user,HttpStatus.OK);
	}
	

	@PutMapping("/customerup/{key}")
	public ResponseEntity<Customer> updatecustomerHandler(@RequestBody CustomerDTO customer,@PathVariable("key") String key){
		Customer c = cService.upDateCustomer(customer,key);
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}
