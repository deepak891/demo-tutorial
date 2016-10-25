package com.devlabsjava;

public class Palindrome {

	public static boolean logic(String input) {
		if(input == null || input.trim().length() == 1){
			throw new IllegalArgumentException("Invalid input :" + input);
		}
		
		for(int i = 0 ; i < input.length() - 1 ; i++) {
			if(input.charAt(i) != input.charAt(input.length() - 1 - i)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean reverseLogic(String input) {
		if(input == null || input.trim().length() == 1){
			throw new IllegalArgumentException("Invalid input :" + input);
		}

		String reverse="";
		for(int i = input.length() - 1 ; i >= 0 ; i--){
			reverse = reverse + input.charAt(i);
		}
		
		if(input.equals(reverse)) {
			return true;
		}else{
			return false;
		}
	}

	
}
