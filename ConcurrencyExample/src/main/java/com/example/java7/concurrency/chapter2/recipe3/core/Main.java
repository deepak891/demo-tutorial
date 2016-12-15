package com.example.java7.concurrency.chapter2.recipe3.core;

import com.example.java7.concurrency.chapter2.recipe3.task.Consumer;
import com.example.java7.concurrency.chapter2.recipe3.task.EventStorage;
import com.example.java7.concurrency.chapter2.recipe3.task.Producer;

public class Main {

	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		
		thread2.start();
		thread1.start();
		
	}

}
