package com.practice._junit4_Test_App;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.practice._junit4_App.Calculator;

public class CalculatorTest
{
	
	//Every time we need to create the object of calculator class
	
	/*@Test
	public void testAdd() {		
		Calculator calculator=new Calculator();
		Integer actualResult=calculator.add(10,20);
		Integer expectedResult=30;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	public void testMultiply() {		
		Calculator calculator=new Calculator();
		Integer actualResult=calculator.multiply(10,20);
		Integer expectedResult=200;
		assertEquals(expectedResult,actualResult);
	} */
	
	
	private static Calculator calc = null;

	@BeforeClass
	public static void init() {
		calc = new Calculator();
	}

	@AfterClass
	public static void destroy() {
		calc = null;
	}

	@Test
	public void testAdd() {
		Integer actualResult = calc.add(10, 20);
		Integer expectedResult = 30;
		assertEquals(expectedResult, actualResult);
	}
	

	@Test
	public void testMultiply() {
		Integer actualResult = calc.multiply(2, 3);
		Integer expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	
	
}
