package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;



public interface CustomerService {

	public Customer addCustomer(CustomerDTO customer) throws CustomerException;
	
	public Customer upDateCustomer(CustomerDTO customer,String key) throws CustomerException;
	
	public Customer deleteCustomer(String username,String key) throws CustomerException;
	
	
	
}
