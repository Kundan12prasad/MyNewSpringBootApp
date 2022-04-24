package com.practice.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.binding.UserForm;
import com.practice.service.UserService;

@RestController
public class UserRegRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/countries")
	public Map<Integer,String> countries()
	{
		Map<Integer, String> countries = userService.getCountries();
		return countries;
	
	}
	
	@GetMapping(value="/state/{countryId}")
	public Map<Integer,String> states(@PathVariable("countryId") Integer cId)
	{
		Map<Integer, String> states = userService.getStates(cId);
		return states;	
	}	
	
	@GetMapping(value="/cities/{stateId}")
	public Map<Integer,String> cities(@PathVariable("stateId") Integer sId)
	{
		Map<Integer, String> cities = userService.getCities(sId);
		return cities;	
	}
	
	@GetMapping(value="/emailcheck/{email}")
	public String emailCheck(@PathVariable("email") String email)
	{		
		boolean emailUnique = userService.emailUnique(email);
		if(emailUnique)
		{
			return "UNIQUE";
		}		
		return "DUPLICATE";
	}
	
	@PostMapping(value="/saveUser")
	public String saveUser(@RequestBody UserForm userForm)
	{
		boolean saveUser = userService.saveUser(userForm);
		if(saveUser)
		{
			return "SUCCESS";
		}
		return  "FAIL";
	}
	
	
	
	
	

}
