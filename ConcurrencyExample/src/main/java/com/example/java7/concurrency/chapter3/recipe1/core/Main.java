package com.example.java7.concurrency.chapter3.recipe1.core;

import com.example.java7.concurrency.chapter3.recipe1.task.Job;
import com.example.java7.concurrency.chapter3.recipe1.task.PrintQueue;

public class Main {

	public static void main(String[] args) {

		PrintQueue printQueue = new PrintQueue();
		
		Thread thread[] = new Thread[10];
		
		for(int i = 0; i < 10 ; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread-"+i);
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			thread[i].start();
		}
		
	}

}
