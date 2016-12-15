package com.example.java7.concurrency.chapter4.recipe1.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private ThreadPoolExecutor executor;
	
	public Server() {
		//executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task task) {
		System.out.printf("Server : A new task has arrived \n");
		
		executor.execute(task);
		System.out.printf("Server : Pool size %d \n", executor.getPoolSize());
		System.out.printf("Server : Active count %d \n", executor.getActiveCount());
		System.out.printf("Server : Completed Tasks %d \n", executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}
