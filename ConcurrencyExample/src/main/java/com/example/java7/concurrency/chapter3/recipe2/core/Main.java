package com.example.java7.concurrency.chapter3.recipe2.core;

import com.example.java7.concurrency.chapter3.recipe2.task.PrintQueue;
import com.example.java7.concurrency.chapter3.recipe2.task.Job;

public class Main {

	public static void main(String[] args) {
		
		PrintQueue printQueue = new PrintQueue();
		
		Thread thread[] = new Thread[10];
		for(int i = 0 ; i < 10 ; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread-"+i);
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			thread[i].start();
		}
	}

}
