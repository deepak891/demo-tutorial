package com.devlabsjava;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacterJava8 {

	public static Character logic(String input) {
		Character result = input.chars()
				.mapToObj(i -> Character.toLowerCase(Character.valueOf((char)i)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new, Collectors.counting()))
				.entrySet().stream()
				.filter(entry -> entry.getValue() == 1L)
				.map(entry -> entry.getKey())
				.findFirst().get();
		
		return result;
	}
}
