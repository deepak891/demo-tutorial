package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


public class ReverseStringTest {

	@Test
	public void reverseWithApi(){
		Assert.assertEquals("xof nworb gib", ReverseString.reverseWithApi("big brown fox"));
	}
	
	@Test
	public void reverseRecursion(){
		Assert.assertEquals("xof nworb gib", ReverseString.reverseRecursion("big brown fox"));
	}
	
	@Test
	public void reverseIteration() {
		Assert.assertEquals("xof nworb gib", ReverseString.reverseIteration("big brown fox"));
	}
}
