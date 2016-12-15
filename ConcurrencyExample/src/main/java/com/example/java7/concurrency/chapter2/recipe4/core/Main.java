package com.example.java7.concurrency.chapter2.recipe4.core;

import com.example.java7.concurrency.chapter2.recipe4.task.Job;
import com.example.java7.concurrency.chapter2.recipe4.task.PrintQueue;

public class Main {

	public static void main (String args[]){
		PrintQueue printQueue = new PrintQueue();
		
		Thread thread[] = new Thread[10];
		
		for(int i =0 ; i < 10 ; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread-"+i);
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			thread[i].start();
		}
	}
}
