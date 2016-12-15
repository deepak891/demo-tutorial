package com.example.java7.concurrency.chapter1.recipe6.core;

import java.util.Date;

import com.example.java7.concurrency.chapter1.recipe6.task.DataSourceLoader;
import com.example.java7.concurrency.chapter1.recipe6.task.NetworkConnectionsLoader;

public class Main {

	public static void main(String[] args) {

		DataSourceLoader dsLoader = new DataSourceLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceLoader");
		thread1.start();
		
		NetworkConnectionsLoader nsLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(nsLoader, "NetworkConnectionsLoader");
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main : Configuration has been loaded %s \n", new Date());
	}

}
