package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping(value="/getmsg")
	public String getmessage()
	{
		String msg="Welcome to Kundan IT";
		System.out.println(msg.toString());
		return msg;
	}

}
