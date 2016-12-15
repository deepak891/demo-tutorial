package com.example.java7.concurrency.chapter4.recipe11.task;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.printf("Task %s: Starting \n", name);
		
		try{
			Long during = (long)(Math.random() * 10);
			System.out.printf("Task %s: ReportGenerator : Generating a report during %d second \n", name, during);
			TimeUnit.SECONDS.sleep(during);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Task %s: Ending \n ", name);
	}

	public String toString(){
		return name;
	}
}
