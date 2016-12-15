package com.example.java7.concurrency.chapter2.recipe4.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private final Lock queueLock = new ReentrantLock(false);
	
	public void printJob(Object document) {
		queueLock.lock();
		
		try{
			Long duration = (long) (Math.random()*1000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds \n", Thread.currentThread().getName(), (duration/100));
			Thread.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}
		
		queueLock.lock();
		
		try{
			Long duration = (long) (Math.random()*1000);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds \n", Thread.currentThread().getName(), (duration/100));
			Thread.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}

	}

}
