package com.practice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ExceptionMessage> handleArithmaticException(ArithmeticException ae)
	{
		ExceptionMessage message=new ExceptionMessage();
		message.setCode("EXP001");
		message.setMsg(ae.getMessage());
		message.setDate(new Date());		
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionMessage> handleNullPointerException(NullPointerException ne)
	{
		ExceptionMessage message=new ExceptionMessage();
		message.setCode("EXP002");
		message.setMsg(ne.getMessage());
		message.setDate(new Date());		
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);			
		
	}
	
	//handle custom exception
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ExceptionMessage> handleNoDataFoundException(NoDataFoundException ndfe)
	{
		ExceptionMessage message=new ExceptionMessage();
		message.setCode("EXP003");
		message.setMsg(ndfe.getMessage());
		message.setDate(new Date());		
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);			
		
	}
	
	

}
