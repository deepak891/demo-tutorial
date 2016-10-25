package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;


public class PalindromeTest {

	@Test
	public void testPalindrome() {
		Assert.assertEquals(true, Palindrome.logic("madam"));
	}
	
	@Test
	public void testPalindromeReverseLogic() {
		Assert.assertEquals(true, Palindrome.reverseLogic("madam"));
	}
	
}
