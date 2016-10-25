package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


public class RecursiveFabonacciTest {

	@Test
	public void testRecursiveFabonacci() {
		Assert.assertEquals(5, RecursiveFabonacci.fabonacci(5));
	}
	
	@Test
	public void testFabonacciFor10(){
		Assert.assertEquals(55, RecursiveFabonacci.fabonacci(10));
	}
	
	@Test
	public void testFabonacciFor0(){
		Assert.assertEquals(0, RecursiveFabonacci.fabonacci(0));
	}

	@Test
	public void testFabonacciFor1(){
		Assert.assertEquals(1, RecursiveFabonacci.fabonacci(1));
	}

}
