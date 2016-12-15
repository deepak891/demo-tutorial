package com.example.java7.concurrency.chapter3.recipe1.task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {
	
	private final Semaphore semaphore;
	
	public PrintQueue() {
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object doucment){
		try{
			semaphore.acquire();
			
			Long duraction = (long) Math.random() * 10;
			System.out.printf("%s: PrintQueue : print a job during %d seconds \n", Thread.currentThread().getName(), duraction);
			Thread.sleep(duraction);
			TimeUnit.SECONDS.sleep(duraction);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
