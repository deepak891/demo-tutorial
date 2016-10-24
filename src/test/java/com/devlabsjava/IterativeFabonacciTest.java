package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


public class IterativeFabonacciTest {

	@Test
	public void testFabonacci(){
		Assert.assertEquals(5, IterativeFabonacci.fabonacci(5));
	}
	
	@Test
	public void testFabonacciFor10(){
		Assert.assertEquals(55, IterativeFabonacci.fabonacci(10));
	}
	
	@Test
	public void testFabonacciFor0(){
		Assert.assertEquals(0, IterativeFabonacci.fabonacci(0));
	}

	@Test
	public void testFabonacciFor1(){
		Assert.assertEquals(1, IterativeFabonacci.fabonacci(1));
	}

}
