package com.example.java7.concurrency.chapter1.recipe9.core;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe9.task.UnsafeTask;

public class Main {

	public static void main(String[] args) {
		UnsafeTask task = new UnsafeTask();
		
		for(int i = 0 ; i < 10 ; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
