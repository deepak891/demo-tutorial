package com.example.java7.concurrency.chapter1.recipe3.task;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe3.core.PrimeGenerator;

public class Main {

	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		task.interrupt();
	}

}
