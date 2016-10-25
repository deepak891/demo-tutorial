package com.devlabsjava;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeLongestSubstringTest {

	@Test
	public void findLongestPalindrome() {
		Assert.assertEquals("3", PalindromeLongestSubstring.findLongestPalindrome("12321"));
	}
}
