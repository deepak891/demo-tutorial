package com.example.java7.concurrency.chapter4.recipe8.core;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter4.recipe8.task.Task;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Task task = new Task();
		
		Future<String> result = executor.submit(task);
				 
		System.out.printf("Main : Executing the task");
		
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.printf("Main : cancelling the Task\n");
		result.cancel(true);
		
		System.out.printf("Main : cancelled :%s \n ", result.isCancelled());
		System.out.printf("Main : Done :%s \n ", result.isDone());
		
		executor.shutdown();
		System.out.printf("Main : the executor has finished\n");

	}

}
