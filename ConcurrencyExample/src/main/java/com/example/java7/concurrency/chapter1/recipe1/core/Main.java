package com.example.java7.concurrency.chapter1.recipe1.core;

import com.example.java7.concurrency.chapter1.recipe1.task.Calculator;

public class Main {

	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i ++) {
			Calculator calc = new Calculator(i);
			Thread thread = new Thread(calc);
			thread.start();
		}
	}

}
