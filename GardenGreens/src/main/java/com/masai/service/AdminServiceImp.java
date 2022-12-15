package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.AdminRepo;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.CustomerDao;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	public AdminRepo adminRepo; 
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		
		List<Admin> list = adminRepo.findAdminById(admin.getAdminId());
        if(!list.isEmpty()) throw new AdminException("This Id is already registered...");
		
		else  {		
			Admin a = new Admin();
			a.setAdminId(admin.getAdminId());
			a.setAdminUsername(admin.getAdminUsername());
			a.setAdminPassword(admin.getAdminPassword());
			return adminRepo.save(a);
			
		}
	}
//------------------------------------------------------------------------------------------------------------	
	@Override
	public Customer deleteCustomer(Integer customerId, String Key) throws CustomerException {
		
		CurrentUserSession  loggedAdmin = currentSessionRepo.findByUuid(Key);
		
		if(loggedAdmin==null)
		{
			throw new CustomerException("Admin not login , Please Enter a Valid Key....");
		}
			
		Optional<Customer> customer = customerDao.findById(customerId);
		
		Customer existingCustomer = customer.get();
		
			if(existingCustomer!=null)
			{
				 customerDao.delete(existingCustomer);

				 return existingCustomer;
				
			}
			
			throw new CustomerException("Invalid Customer details.. ");

	}
	
//----------------------------------------------------------------------------------------------------------	

	@Override
	public Customer viewCustomer(Integer customerId, String key) throws CustomerException {
		
		CurrentUserSession  loggedAdmin = currentSessionRepo.findByUuid(key);
	
	        if(loggedAdmin==null)
	          {
		        throw new CustomerException("Admin not login , Please Enter a Valid Key....");
	          }
				
			Optional<Customer> opt = customerDao.findById(customerId);
			
				if(opt.isPresent())
				{
					 
					 return opt.get();
					
				}
				
				throw new CustomerException("Invalid Customer Id details ");
	}
	
//------------------------------------------------------------------------------------------------------------
	
	@Override
	public List<Customer> viewAllCustomers(String key) throws CustomerException {
		 
	CurrentUserSession  loggedAdmin = currentSessionRepo.findByUuid(key);
	
	        if(loggedAdmin==null)
	          {
		        throw new CustomerException("Admin not login , Please Enter a Valid Key....");
	          }
				
			List<Customer> opt = customerDao.findAll();
			
				if(opt.size()!=0)
				{
					 
					 return opt;
					
				}
				
				throw new CustomerException("No Customer  details found.");
	}
	
//-------------------------------------------------------------------------------------------------------------	
}
