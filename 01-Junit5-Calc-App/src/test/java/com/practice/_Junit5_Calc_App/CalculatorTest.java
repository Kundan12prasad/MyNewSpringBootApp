package com.practice._Junit5_Calc_App;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.practice._Junit5_Calc_App.Calculator;

public class CalculatorTest
{	
	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		Integer add = c.add(10, 20);
		assertEquals(30, add);
	}
}
