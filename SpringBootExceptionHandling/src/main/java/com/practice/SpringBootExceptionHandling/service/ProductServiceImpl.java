package com.practice.SpringBootExceptionHandling.service;

import org.springframework.stereotype.Service;

import com.practice.SpringBootExceptionHandling.exception.NoProductFoundException;
import com.practice.SpringBootExceptionHandling.model.Product;

@Service
public class ProductServiceImpl implements ProductService
{
    @Override
	public Product productFindById(Integer pid) 
	{
		if(pid==101)
		{
			return new Product("101","keyboard",900.00);
		}
		
		else
		{			//throw custom exception
			
			throw new NoProductFoundException("product not found with given Id");
		}
	}
	

}
