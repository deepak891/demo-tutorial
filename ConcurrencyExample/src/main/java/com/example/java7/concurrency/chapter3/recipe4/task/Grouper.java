package com.example.java7.concurrency.chapter3.recipe4.task;

import com.example.java7.concurrency.chapter3.recipe4.utils.Results;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}
	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper: Processing results ...\n");
		int data[] = results.getData();
		for(int number : data){
			finalResult += number;
		}
		System.out.printf("Grouper: Total Result : %d.\n", finalResult);
	}

}
