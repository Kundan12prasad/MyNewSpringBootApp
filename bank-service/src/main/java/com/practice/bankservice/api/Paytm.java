package com.practice.bankservice.api;

import org.springframework.stereotype.Service;


@Service
public class Paytm implements Payment
{
	public String doTransaction() 
	{
		return "payment process using paytm..!";
	}
	

}
