package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


public class FirstNonRepeatedCharacterJava8Test {

	@Test
	public void testLogic(){
		Character c = '2';
		Assert.assertEquals(c, FirstNonRepeatedCharacterJava8.logic("233443"));
	}
}
