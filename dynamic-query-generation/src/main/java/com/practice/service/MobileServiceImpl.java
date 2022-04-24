package com.practice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.practice.binding.MobileSearchRequest;
import com.practice.entity.Mobile;
import com.practice.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {
	
	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public List<Mobile> findMobiles(MobileSearchRequest searchRequest) {
		Mobile mobile=new Mobile();
		
		if(searchRequest == null)
		{
			List<Mobile> findAllMobile = mobileRepository.findAll();
			return findAllMobile;
		}     
		
		if(null != searchRequest.getBrandName() && ! "".equals(searchRequest.getBrandName()))
		{
			mobile.setMobileBrand(searchRequest.getBrandName());
		}
		if(null != searchRequest.getRam() && ! "".equals(searchRequest.getRam()))
		{
		 mobile.setMobileRam(searchRequest.getRam());
		}	
		
		Example<Mobile> example= Example.of(mobile);		
		List<Mobile> mobiles = mobileRepository.findAll(example);	
		
		if(null != searchRequest.getPrice())
		{			
			List<Mobile> priceFilterList = mobiles.stream().filter(m->m.getMobilePrice() <= searchRequest.getPrice())
                    .collect(Collectors.toList());		
                   return priceFilterList;		
		}		
		return mobiles;
	}	
	

}
