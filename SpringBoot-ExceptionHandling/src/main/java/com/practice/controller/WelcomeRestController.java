package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping(value="/getmsg")
	public String welcomeMsg()
	{			
		int num=10/0;
		String msg="welcome to KundanIT";
		return msg;		
	}
	
	@GetMapping(value="/length")
	public Integer getLength()
	{			
		String str=null;
		int length = str.length();
	      return length;
	}

}
