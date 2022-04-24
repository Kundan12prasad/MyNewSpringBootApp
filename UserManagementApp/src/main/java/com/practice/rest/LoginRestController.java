package com.practice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.binding.LoginForm;
import com.practice.service.UserService;

@RestController
public class LoginRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/login")
    public String login(@RequestBody LoginForm loginForm )
    {		
		String loginCheck = userService.loginCheck(loginForm);		
		return loginCheck;
    }   
    
}
