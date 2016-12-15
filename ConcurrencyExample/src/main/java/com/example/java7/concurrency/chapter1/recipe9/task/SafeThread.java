package com.example.java7.concurrency.chapter1.recipe9.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeThread implements Runnable {
	
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue(){
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.printf("Starting Thread: %s :%s\n", Thread.currentThread().getId(),startDate.get());
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s :%s\n", Thread.currentThread().getId(),startDate.get());
		
	}

}
