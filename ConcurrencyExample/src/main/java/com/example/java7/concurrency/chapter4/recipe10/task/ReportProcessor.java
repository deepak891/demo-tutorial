package com.example.java7.concurrency.chapter4.recipe10.task;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ReportProcessor implements Runnable {

	private CompletionService<String> service;
	
	private boolean end;
	
	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		this.end =false;
	}
	@Override
	public void run() {
		while(!end){
			try{
				Future<String> result = service.poll();
				if(result != null){
					String report = result.get();
					System.out.printf("ReportService: Report received %s\n", report);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("ReportService: End \n");
	}
	
	public void setEnd(boolean end) {
		this.end = end;
	}

}
