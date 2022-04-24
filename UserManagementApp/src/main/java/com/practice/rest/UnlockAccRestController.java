package com.practice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.binding.UnlockAccForm;
import com.practice.service.UserService;

@RestController
public class UnlockAccRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/unlockAccount")
	public String unlockAcc(@RequestBody UnlockAccForm unlockAccForm)
	{
		boolean unlockAccount = userService.unlockAccount(unlockAccForm);
		if(unlockAccount)
		{
			return "Account Unlocked";			
		}		
		return "Failed To Unlock Account";
	}

}
