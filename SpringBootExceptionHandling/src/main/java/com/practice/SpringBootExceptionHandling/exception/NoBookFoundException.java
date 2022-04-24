package com.practice.SpringBootExceptionHandling.exception;

public class NoBookFoundException extends RuntimeException
{
	public NoBookFoundException(String message) 
	{
		super(message);		
	}

}
