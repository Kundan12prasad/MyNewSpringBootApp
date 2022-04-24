package com.practice._Junit5_Exception_Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.practice._Junit5_Exception.StringUtils;

public class StringUtilsTest 
{

	@Test
	public void testConvertToInt() {
		String st = null;
		assertThrows(IllegalArgumentException.class, () -> StringUtils.convertToInt(st));
	}
}
