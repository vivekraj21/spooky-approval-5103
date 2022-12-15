package com.masai.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.masai.exception.LogInException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.LogInDTO;
import com.masai.repository.AdminRepo;
import com.masai.repository.CurrentSessionRepo;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;



@Service
public class LogInServiceImp implements LogInService{

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AdminRepo aDao;
	
	@Autowired
	private CurrentSessionRepo sDao;

	@Override
	public String logInService(LogInDTO logdto) throws LogInException {
		
         
		Optional<Customer> customer= cDao.findByUsername(logdto.getUsername());
		
		Customer existingCustomer = customer.get();
		
		if(existingCustomer == null) {
			
			Optional<Admin> admin = aDao.findByUsername(logdto.getUsername());
			Admin existingAdmin = admin.get();
			
			if(existingAdmin == null) {
				
				throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
			}
			
			if(existingAdmin.getAdminPassword().equals(logdto.getPassword())) {
				
				String key= Integer.toString((int)(Math.random()*10000));
				
				CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
				
				sDao.save(currentUserSession);

				return currentUserSession.toString();
			}
			else
				throw new LogInException("Wrong credentials....");
			
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findByUserId(existingCustomer.getCustomerId());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LogInException("Already Logged In...");
			
		}
		
		if(existingCustomer.getPassword().equals(logdto.getPassword())) {
			
			String key= Integer.toString((int)(Math.random()*10000));
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LogInException("Please Enter a valid password");
		
		
	}


	
//-------------------------------------------------------------------------------------------------------------
	
	@Override
	public String logOutService(String Key) throws LogInException {
        CurrentUserSession validCustomerSession = sDao.findByUuid(Key);
		
		if(validCustomerSession == null) {
			throw new LogInException("Wrong Unique User Id !! Try again..");
			
		}
		
		sDao.delete(validCustomerSession);
		
		return "You are Logged Out !";
	}
	
	
	
}
