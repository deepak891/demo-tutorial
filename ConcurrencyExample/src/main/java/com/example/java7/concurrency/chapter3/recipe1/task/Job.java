package com.example.java7.concurrency.chapter3.recipe1.task;

public class Job implements Runnable {

	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The doucment has been printed\n", Thread.currentThread().getName());
	}

}
