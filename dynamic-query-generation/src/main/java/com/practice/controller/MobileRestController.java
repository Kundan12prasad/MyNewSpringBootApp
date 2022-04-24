package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.binding.MobileSearchRequest;
import com.practice.entity.Mobile;
import com.practice.service.MobileService;

@RestController
public class MobileRestController {
	
	@Autowired
	private MobileService  mobileService;	
	
	@PostMapping(value="/getmobiles", consumes="application/json")
	public List<Mobile> getMobiles(@RequestBody MobileSearchRequest request)	
	{
		List<Mobile> findMobiles = mobileService.findMobiles(request);		
		return findMobiles;		
	}

}
