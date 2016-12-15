package com.example.java7.concurrency.chapter1.recipe9.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread: %s :%s\n", Thread.currentThread().getId(),startDate);
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s :%s\n", Thread.currentThread().getId(),startDate);
	}

}
