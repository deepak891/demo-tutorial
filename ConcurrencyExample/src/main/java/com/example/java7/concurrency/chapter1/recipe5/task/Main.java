package com.example.java7.concurrency.chapter1.recipe5.task;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe5.core.FileClock;

public class Main {

	public static void main(String[] args) {
		FileClock fileClock = new FileClock();
		Thread thread = new Thread(fileClock);

		thread.start();
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		};
		
		thread.interrupt();
	}

}
