package com.practice.bankservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.practice.bankservice.app.UserPaymentService;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/practice/bankservice/config/application-context.xml");

		UserPaymentService service = context.getBean(UserPaymentService.class);
		System.out.println(service.paymentProcess());
	}
    
}
