package com.practice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.service.UserService;

@RestController
public class ForgotPwdRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/forgetpwd/{email}")
	public String forgotPwd(@PathVariable("email") String email)
	{		
		String Status = userService.forgotPwd(email);	
		return Status;
	}

}
