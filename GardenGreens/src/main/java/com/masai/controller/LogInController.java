package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LogInException;
import com.masai.model.LogInDTO;
import com.masai.service.LogInService;

@RestController
@RequestMapping("/loginservice")
public class LogInController {

	@Autowired
	private LogInService logService;
	
	@PostMapping("/logIn")
	public ResponseEntity<String> logInService(@RequestBody LogInDTO logdto,@RequestParam String adminORcustomer) throws LogInException{
		
		String output = logService.logInService(logdto,adminORcustomer);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
//--------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/logOut")
	public ResponseEntity<String> logOutService(@RequestParam String key) throws LogInException{
		
		String output = logService.logOutService(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}

}
