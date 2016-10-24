package com.devlabsjava;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static String logic(String input) {
		//pre-condition check
		if(input == null || input.trim().length() == 0) {
			new IllegalArgumentException("input is illegal " + input);
		}
		
		input = input.toLowerCase();
		
		char[] characters = input.toCharArray();
		
		Map<Character, Integer> mapChars = new HashMap<>(20);
		
		for(char c : characters) {
			if(mapChars.containsKey(c)){ //already exist increment count
				mapChars.put(c, mapChars.get(c) + 1); // autoboxing and unboxing take place
			}else{
				mapChars.put(c, 1);
			}
		}
		
		for(char c : characters){
			if(mapChars.get(c) == 1){
				return Character.toString(c);
			}
		}
		return null;
	}

	
}
