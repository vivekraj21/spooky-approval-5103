package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {

	public Admin registerAdmin(Admin admin) throws AdminException;
	
//	public Customer deleteCustomer(Integer customerId,String Key) throws CustomerException;
//	
//	public Customer viewCustomer(Integer customerId,String key) throws CustomerException;
//	
//	public List<Customer> viewAllCustomers(String key) throws CustomerException;
}
