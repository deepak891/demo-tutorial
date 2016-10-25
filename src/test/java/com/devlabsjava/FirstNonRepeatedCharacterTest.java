package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatedCharacterTest {

	@Test
	public void logicTest(){
		Assert.assertEquals("t", FirstNonRepeatedCharacter.logic("stress"));
	}
}
