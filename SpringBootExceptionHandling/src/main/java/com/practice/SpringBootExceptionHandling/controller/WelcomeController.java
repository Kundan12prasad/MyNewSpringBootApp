package com.practice.SpringBootExceptionHandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController 
{
	@RequestMapping(value="/welcome")
	public String welcome(Model model)
	{
	model.addAttribute("msg","Welocome to AshokIt");	
	/*String name=null;
	name.length(); */
	
	return "welcome";
	}
	
	//controller based exception
	//applicable to only WelcomeController
	
	 /*@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model)
	{
		model.addAttribute("errmsg", "Some problem Occured Please try after some time");
		return "error";
		
	} */
	

}
