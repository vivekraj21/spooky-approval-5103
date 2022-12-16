package com.masai.controller;



import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.service.AdminService;
import java.util.List;


@RestController
@RequestMapping("/adminservice")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin)throws AdminException{
		
		Admin a = adminService.registerAdmin(admin);
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
		
	}
	
//-----------------------------------------------------------------------------------------------------------	
	
	@DeleteMapping("/customer/{customerId}/{key}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId,@PathVariable("key") String key) throws CustomerException
	{
		Customer user = adminService.deleteCustomer(customerId,key);
		
		return new ResponseEntity<Customer>(user,HttpStatus.OK);
	}
	
//-----------------------------------------------------------------------------------------------------------
	
	@GetMapping("/customers/{key}")
	public ResponseEntity<List<Customer> > viewAllCustomer(@PathVariable("key") String key) throws LogInException, CustomerException
	{
		List<Customer> customer = adminService.viewAllCustomers(key);
		
		return new ResponseEntity<List<Customer> >(customer,HttpStatus.ACCEPTED);
	}
	
//------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/customers/{customerId}/{key}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("customerId") Integer id,@PathVariable("key") String key) throws LoginException, CustomerException
	{
		Customer customer = adminService.viewCustomer(id, key);
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
}
