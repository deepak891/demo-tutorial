package com.example.java7.concurrency.chapter1.recipe9.core;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe9.task.SafeThread;

public class SafeMain {

	public static void main(String[] args) {
		
		SafeThread safeThread = new SafeThread();
		
		for(int i = 0 ; i < 5 ; i++) {
			Thread thread = new Thread(safeThread);
			thread.start();
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
