package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


//{25,65} {-25, -65}, {30,30}, {65,25}, {110, 145}
public class CloseTo100Test {
	
	@Test
	public void testPositiveNumber() {
		Assert.assertEquals(65, CloseTo100.calculate(25,65));
	}
	
	@Test
	public void testNegativeNumber() {
		Assert.assertEquals(-25, CloseTo100.calculate(-25,-65));
	}

	@Test
	public void testEqualNumber() {
		Assert.assertEquals(30, CloseTo100.calculate(30,30));
	}

	@Test
	public void testLessThenNumber() {
		Assert.assertEquals(65, CloseTo100.calculate(65,25));
	}

	@Test
	public void testGreaterThenNumber() {
		Assert.assertEquals(65, CloseTo100.calculate(65,25));
	}

}
