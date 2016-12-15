package com.example.java7.concurrency.chapter4.recipe7.core;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter4.recipe7.task.Task;

public class Main {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
		System.out.printf("%s: Starting at %s", Thread.currentThread().getName(), new Date());
		
		Task task = new Task("Task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		
		for(int i = 0 ; i < 10; i++) {
			System.out.printf("Main: Delay : %d\n", result.getDelay(TimeUnit.MILLISECONDS));
			try{
				TimeUnit.MILLISECONDS.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		System.out.printf("Main : no more task at %s \n", new Date());
		
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Finished at %s", new Date());
 		
	}

}
