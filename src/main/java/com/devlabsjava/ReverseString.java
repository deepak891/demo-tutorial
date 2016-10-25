package com.devlabsjava;

public class ReverseString {

	public static String reverseWithApi(String input) {
		if(input == null || input.length() == 0){
			return input;
		}
		return new StringBuilder(input).reverse().toString();
	}

	public static String reverseRecursion(String str) {
		if(str == null || str.length() == 0){
			return str;
		}
		return reverseRecursion(str.substring(1)) + str.charAt(0);
	}

	public static String reverseIteration(String str) {
		if(str == null || str.length() == 0){
			return str;
		}

		char[] chars = str.toCharArray();
		int rhsIdx = chars.length - 1;
		
		for(int lhsIdx = 0 ; lhsIdx < rhsIdx ; lhsIdx++) {
			char temp = chars[lhsIdx];
			chars[lhsIdx] = chars[rhsIdx];
			chars[rhsIdx--] = temp;
		}
		
		return new String(chars);
	}

}
