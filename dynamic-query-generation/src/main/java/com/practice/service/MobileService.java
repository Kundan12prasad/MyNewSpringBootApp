package com.practice.service;

import java.util.List;

import com.practice.binding.MobileSearchRequest;
import com.practice.entity.Mobile;

public interface MobileService {
	   public List<Mobile> findMobiles(MobileSearchRequest  searchRequest);
	
}
