package com.example.java7.concurrency.chapter1.recipe8.core;

import com.example.java7.concurrency.chapter1.recipe8.handler.ExceptionHandler;
import com.example.java7.concurrency.chapter1.recipe8.task.Task;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		
		thread.start();
		
		try{
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("Thread has finished\n");
	}

}
