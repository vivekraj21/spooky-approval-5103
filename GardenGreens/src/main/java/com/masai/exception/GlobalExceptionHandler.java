package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PlantsException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(PlantsException ie, WebRequest req){

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(Exception ie,WebRequest req){

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {

	MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
	}	
	
	@ExceptionHandler(LogInException.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(LogInException ee,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(AdminException ee,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
}
