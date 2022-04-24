package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.exception.NoDataFoundException;

@RestController
public class CustomerRestController {
	
	@GetMapping(value="customer/{customerId}")
	public ResponseEntity<String> getCustomer(@PathVariable("customerId") Integer customerId )
	{
		String phoneNo=null;
		if(customerId >=100)
		{
			phoneNo="9078564523";		
		return new ResponseEntity<String>(phoneNo,HttpStatus.OK);
		
		}		
		else
		{
			throw new NoDataFoundException("Customer not Found with given Id");			
		}
	}

}
