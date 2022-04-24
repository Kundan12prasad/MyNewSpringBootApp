package com.practice.bankservice.app;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.practice.bankservice.api.Payment;


@Component
@PropertySource(value= { "classpath:application.properties" })
public class UserPaymentService 
{
	 @Autowired
	//@Qualifier("paytm")
	//@Qualifier("phonePe")	
	 
	 @Qualifier("${beanName}")
	 @Resource(name="${beanName}")
	private Payment payment;
	
	public String paymentProcess()
	{
		return payment.doTransaction();
	}
	

}
