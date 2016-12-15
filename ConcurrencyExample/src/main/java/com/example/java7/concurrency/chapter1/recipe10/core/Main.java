package com.example.java7.concurrency.chapter1.recipe10.core;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe10.task.Result;
import com.example.java7.concurrency.chapter1.recipe10.task.SearchTask;

public class Main {

	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		
		SearchTask searchTask = new SearchTask(result);
		for(int i = 0 ; i < 10 ; i++) {
			Thread thread = new Thread(searchTask);
			thread.start();
			try{
				TimeUnit.MILLISECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of Threads : %d \n", threadGroup.activeCount());
		System.out.printf("Information about thread group  \n");
		threadGroup.list();
		
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		
		for(int i = 0 ; i < threadGroup.activeCount() ; i++) {
			System.out.printf("Thread %s : %s \n", threads[i].getName(), threads[i].getState());
		}
		
		waitFinish(threadGroup);
		
		threadGroup.interrupt();
		
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while(threadGroup.activeCount() > 9) {
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
