package com.masai.service;

import java.util.List;
import java.util.Set;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.Orders;



public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer upDateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Integer id) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;
	
	public String addOrderToCustomer(String id, Orders order) throws CustomerException,OrderException;
	
	public Set<Orders> viewAllOrders(int id) throws CustomerException,OrderException;
	
	
}
