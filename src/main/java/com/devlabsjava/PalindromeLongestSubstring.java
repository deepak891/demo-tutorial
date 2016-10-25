package com.devlabsjava;

public class PalindromeLongestSubstring {

	public static String findLongestPalindrome(String s) {
		if (s == null || s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0, 1);
		
		for(int i = 0; i < s.length() ; i++) {
			//Once center, odd number of character(12321)
			String result = findPalindromeForGivenCenter(s, i , i);
			longest = result.length() > longest.length()?result:longest;
			//two center, even number of character(123321)
			result = findPalindromeForGivenCenter(s, i , i+1);
			longest = result.length() > longest.length()?result:longest;
			
		}
		return longest;
	}

	private static String findPalindromeForGivenCenter(final String s, int leftCenter, int rightCenter) {
		int length = s.length();
		
		while(leftCenter >= 0 && rightCenter <= length -1 && s.charAt(leftCenter) == s.charAt(rightCenter)){
			leftCenter--;
			rightCenter++;
		}
		
		return s.substring(leftCenter+1, rightCenter);
	}

}
