package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication
{

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);		
	    System.out.println("Welcome to Spring Boot..");
	      
	}
	
	/*@Bean
    public Engine engine()
    {
    	//
    } */

}
