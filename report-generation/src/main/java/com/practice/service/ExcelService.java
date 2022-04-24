package com.practice.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.files.ExcelHelper;
import com.practice.model.PlanEntity;
import com.practice.repository.PlanRepository;

@Service
public class ExcelService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public List<PlanEntity> getData()
	{
		List<PlanEntity> viewAllPlans = planRepository.findAll();
		System.out.println(viewAllPlans);
		return viewAllPlans;
	}
	
	public ByteArrayInputStream load() 
	{
		
		List<PlanEntity> allPlans = planRepository.findAll();
		ByteArrayInputStream exportedToExcel = ExcelHelper.plansToExcel(allPlans);
		System.out.println(allPlans);
		return exportedToExcel;		
	}
}
