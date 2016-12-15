package com.example.java7.concurrency.chapter4.recipe10.task;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {

	private String sender;
	
	private String title;
	
	public ReportGenerator(String sender, String title) {
		this.sender = sender;
		this.title = title;
	}
	
	@Override
	public String call() throws Exception {
		try{
			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s_%s: ReportGenerator : Generating a report during %d seconds \n", sender, title, duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		String ret = sender + " " + title;
		return ret;
	}

}
