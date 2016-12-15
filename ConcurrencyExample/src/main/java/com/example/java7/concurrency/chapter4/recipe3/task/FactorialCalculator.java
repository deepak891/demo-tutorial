package com.example.java7.concurrency.chapter4.recipe3.task;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {

	private Integer number;
	
	public FactorialCalculator(Integer number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		int num, result;
		
		num = number.intValue();
		result =1;
		if(num == 0 || num == 1) {
			return 1;
		} else {
			for (int i = 1; i < num; i++) {
				result*=i;
				Thread.sleep(20);
			}
		}
		System.out.printf("%s : %d \n", Thread.currentThread().getName(), result);
		return result;
	}

}
