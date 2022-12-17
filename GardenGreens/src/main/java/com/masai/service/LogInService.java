package com.masai.service;

import com.masai.exception.LogInException;
import com.masai.model.LogInDTO;

public interface LogInService {

	 public String logInService (LogInDTO logdto,String adminORcustomer) throws LogInException;
		
	 public String logOutService (String Key) throws LogInException;
}
