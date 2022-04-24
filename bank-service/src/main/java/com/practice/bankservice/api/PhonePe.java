package com.practice.bankservice.api;

import org.springframework.stereotype.Service;

@Service
public class PhonePe implements Payment
{
	public String doTransaction() 
	{
		
		return "payment process using phonepe..!";
	}


}
