package com.practice.SpringBootExceptionHandling.service;

import org.springframework.stereotype.Service;

import com.practice.SpringBootExceptionHandling.exception.NoBookFoundException;

@Service
public class BookServiceImpl implements BookService
{
	@Override
	public double findPriceById(String bookId) 
	{
		if(bookId.equals("B101"))
		{
			return 500.00;
		}
		else
		{
			throw new NoBookFoundException("No Book Found with givenId");			
		}		
		
	}

}
