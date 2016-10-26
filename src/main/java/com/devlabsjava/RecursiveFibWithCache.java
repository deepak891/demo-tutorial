package com.devlabsjava;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RecursiveFibWithCache {

	private Map<Integer, Integer> cache = new ConcurrentHashMap<>();
	
	public int fibonacci(int n) {
		if(n == 0 || n == 1){
			return 1;
		}
		return cache.computeIfAbsent(n, (key) -> {
			return fibonacci(n-2) + fibonacci(n-1);
		});
	}
	
	public static void main(String[] args) {
		int nthFabonacciNo = new RecursiveFibWithCache().fibonacci(5);
		System.out.println(nthFabonacciNo);
	}
}
