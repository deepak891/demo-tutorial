package com.example.java7.concurrency.chapter4.recipe10.task;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable{

	private String name;
	
	private CompletionService<String> service;
	
	public ReportRequest(CompletionService<String> service, String name) {
		this.name = name;
		this.service = service;
	}
	@Override
	public void run() {
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		service.submit(reportGenerator);
	}

}
