package com.masai.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.masai.exception.LogInException;
import com.masai.model.CurrentUserSession;
import com.masai.model.LogInDTO;
import com.masai.repository.CurrentSessionRepo;
//import com.masai.model.Customer;
//import com.masai.repository.CustomerRepository;



@Service
public class LogInServiceImp {

//	@Autowired
//	private CustomerRepository cDao;
	
//	@Autowired
//	private CurrentSessionRepo sDao;
//
//	@Override
//	public String logInService(LogInDTO logdto) throws LogInException {
//		
//         
//		List<Customer> customer= cDao.findCustomerByMobile(logdto.getMobileNumber());
//		
//		Customer existingCustomer = customer.get(0);
//		
//		if(existingCustomer == null) {
//			throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
//		}
//		
//		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findByUserId(existingCustomer.getCustomerId());
//		
//		if(validCustomerSessionOpt.isPresent()) {
//			
//			throw new LogInException("Already Logged In...");
//			
//		}
//		
//		if(existingCustomer.getPassword().equals(logdto.getPassword())) {
//			
//			String key= RandomString.make(6);
//			
//			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
//			
//			sDao.save(currentUserSession);
//
//			return currentUserSession.toString();
//		}
//		else
//			throw new LogInException("Please Enter a valid password");
//		
//		
//	}
	
//-------------------------------------------------------------------------------------------------------------
	
//	
//	@Override
//	public String logOutService(String key) throws LogInException {
//
//		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
//		
//		if(validCustomerSession == null) {
//			throw new LogInException("Wrong Unique User Id !! Try again..");
//			
//		}
//		
//		sDao.delete(validCustomerSession);
//		
//		return "You are Logged Out !";
//	}
	
	
}
