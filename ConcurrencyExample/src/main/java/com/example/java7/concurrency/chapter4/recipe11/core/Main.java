package com.example.java7.concurrency.chapter4.recipe11.core;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.example.java7.concurrency.chapter4.recipe11.task.Task;
import com.example.java7.concurrency.chapter4.recipe11.task.RejectedTaskController;

public class Main {

	public static void main(String[] args) {
		RejectedTaskController controller = new RejectedTaskController();
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setRejectedExecutionHandler(controller);
		
		System.out.printf("Main: Starting. \n");
		for (int i = 0; i < 3; i++) {
			Task task = new Task("Task"+i);
			executor.execute(task);
		}
		
		System.out.printf("Main: Shuting down the Executor.\n");
		executor.shutdown();
		
		System.out.printf("Main: Sending another Task.\n");
		Task task = new Task("RejectedTask");
		executor.submit(task);
		
		System.out.printf("Main: End.\n");
	}

}
