package com.practice.SpringBootExceptionHandling.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestControllerHandler
{
	@ExceptionHandler(value=NoProductFoundException.class)
	public ResponseEntity<ApiError> handleNoProductFoundException()
	{
		ApiError error=new ApiError(400,"Product not found with Given Id",new Date());		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}

	
	
}
