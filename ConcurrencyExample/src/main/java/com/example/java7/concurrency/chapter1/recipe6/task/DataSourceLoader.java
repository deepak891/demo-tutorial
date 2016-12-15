package com.example.java7.concurrency.chapter1.recipe6.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Begining data source loading : %s \n", new Date());
		
		try{
			TimeUnit.SECONDS.sleep(4);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Date source Loading has finished %s \n", new Date());
	}

}
