package com.devlabsjava;

public class RecursiveFabonacci {

	public static int fabonacci(int n) {
		if(n < 0){
			throw new IllegalArgumentException("Input parameter is invalid" + n);
		}
		
		if(n == 0){
			return 0;
		}
		
		if(n <= 2){
			return 1;
		}else{
			return fabonacci(n-2) + fabonacci(n-1);
		}
	}

	
}
