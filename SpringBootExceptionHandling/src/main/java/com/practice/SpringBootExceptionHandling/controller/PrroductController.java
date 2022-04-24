package com.practice.SpringBootExceptionHandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootExceptionHandling.model.Product;
import com.practice.SpringBootExceptionHandling.service.ProductService;

@RestController
public class PrroductController 

{	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/getProductById", produces= {"application/json"})
	public Product getProductById(@RequestParam(value="pid") String pid)
	{		
		return productService.productFindById(Integer.parseInt(pid));		
	}

	
}
