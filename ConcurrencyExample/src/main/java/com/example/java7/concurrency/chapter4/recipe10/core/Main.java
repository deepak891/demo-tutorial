package com.example.java7.concurrency.chapter4.recipe10.core;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter4.recipe10.task.ReportProcessor;
import com.example.java7.concurrency.chapter4.recipe10.task.ReportRequest;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		CompletionService<String> service = new ExecutorCompletionService<>(executor);
		
		ReportRequest faceRequest = new ReportRequest(service, "Face");
		ReportRequest onlineRequest = new ReportRequest(service, "Online");
		
		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);
		
		ReportProcessor processor = new ReportProcessor(service);
		Thread senderThread = new Thread(processor);
		
		System.out.printf("Main: Starting the thread");
		faceThread.start();
		onlineThread.start();
		senderThread.start();
		
		try{
			System.out.printf("Main: Waiting for the report generators\n");
			faceThread.join();
			onlineThread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Shutting down the executor \n");
		executor.shutdown();
		
		try{
			executor.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		processor.setEnd(true);
		System.out.printf("Main : End\n");
	}

}
