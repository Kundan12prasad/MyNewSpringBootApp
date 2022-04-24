package com.practice.SpringBootExceptionHandling.exception;

public class NoProductFoundException extends RuntimeException
{
	public NoProductFoundException(String message) 
	{
		super(message);
	
	}
	

}
