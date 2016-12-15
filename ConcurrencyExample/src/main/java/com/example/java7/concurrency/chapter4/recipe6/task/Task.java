package com.example.java7.concurrency.chapter4.recipe6.task;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	private String name;
	
	public Task(String name) {
		this.name=name;
	}
	
	@Override
	public String call() throws Exception {
		System.out.printf("%s: Starting at %s \n", Thread.currentThread().getName(), new Date());
		return "Hello World";
	}

}
