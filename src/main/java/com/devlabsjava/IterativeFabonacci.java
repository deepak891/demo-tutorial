package com.devlabsjava;

public class IterativeFabonacci {

	public static Object fabonacci(int n) {

		if(n < 0){
			throw new IllegalArgumentException("Input parameter is invalid " + n);
		}
		
		int num1 = 0, num2 = 1;
		//fabonacci for 0 is 0
		if(n == 0) {
			return 0;
		}
		
		if(n == 1 || n==2) {
			return 1;
		}
		
		
		int current = num1 + num2;   //0, 1, 1, 2, 3, 5
		
		for(int i = 3 ; i <= n ; i++){
			num1 = num2;
			num2 = current;
			current = num1 + num2;
		}
		return current;
	}

}
