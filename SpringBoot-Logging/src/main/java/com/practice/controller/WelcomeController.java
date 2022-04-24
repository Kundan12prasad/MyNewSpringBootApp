package com.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{	
	private Logger logger=LoggerFactory.getLogger(WelcomeController.class);
	@GetMapping(value="/getmsg")
	public String welcomeMsg()
	{	
		logger.debug("Welcome method() Started");		
		String msg="Welcome To KundanIT";
		logger.debug("Welcome method() ended");
		logger.info("welcomeMsg() executed successfully ");
		return msg;
		
	}
	
}
