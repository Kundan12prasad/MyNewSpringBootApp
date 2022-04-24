package com.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingApplication {

	public static void main(String[] args)
	{
	//private static final Logger logger=LoggerFactory.getLogger(SpringBootLoggingApplication.class);
		
		SpringApplication.run(SpringBootLoggingApplication.class, args);
	}

}
