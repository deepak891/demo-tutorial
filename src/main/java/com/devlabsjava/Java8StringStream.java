package com.devlabsjava;

import java.util.stream.Collectors;
import java.util.function.*;

public class Java8StringStream {

	public static void main(String[] args) {
		"Cactus".chars().forEach(c -> System.out.println((char)c));
		System.out.println("===============");
		"Cactus".chars().mapToObj(c -> Character.valueOf((char)c))
		.findFirst()
		.ifPresent(System.out::println);
		
		System.out.println("===============");
		"stress".chars()
		.mapToObj(c -> Character.valueOf((char)c))
		.collect(Collectors.toSet())
		.forEach(s -> System.out.println(s));
		
		System.out.println("===============");
		"stress".chars()
		.mapToObj(c -> Character.valueOf((char)c))
		.collect(Collectors.groupingBy(Function.identity()))
		.entrySet()
		.stream()
		.forEach(s -> System.out.println(s));
		
		System.out.println("===============");
		"stress".chars()
		.mapToObj( c -> Character.valueOf((char)c))
		.sorted((s1,s2) -> {
			System.out.printf("sort: %s ; %s \n", s1, s2);
			return s1.compareTo(s2);
		})
		.forEach(s -> System.out.println(s));
		}
	

}
