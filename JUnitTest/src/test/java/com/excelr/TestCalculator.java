package com.excelr;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class TestCalculator {
	
	public static Calculator calc=null;
	
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
		Calculator calc = new Calculator();
		Integer actualResult = calc.add(10,5);
		Integer expectedResult=15;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		Integer actualResult = calc.sub(10,5);
		Integer expectedResult=5;
		assertEquals(expectedResult,actualResult);
	}
}
