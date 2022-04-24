package com.practice.SpringBootExceptionHandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.SpringBootExceptionHandling.exception.NoBookFoundException;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model)
	{
		model.addAttribute("errmsg", "Some problem Occured Please try after some time");
		return "error";

     }
	
	@ExceptionHandler(value=NoBookFoundException.class)
	public String handleBookNotFoundException()
	{
		
		return "customError";
	}
	
	

}