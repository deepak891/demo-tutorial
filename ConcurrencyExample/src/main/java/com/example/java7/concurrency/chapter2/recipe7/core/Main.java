package com.example.java7.concurrency.chapter2.recipe7.core;

import com.example.java7.concurrency.chapter2.recipe7.task.Buffer;
import com.example.java7.concurrency.chapter2.recipe7.task.Consumer;
import com.example.java7.concurrency.chapter2.recipe7.task.Producer;
import com.example.java7.concurrency.chapter2.recipe7.utils.FileMock;

public class Main {

	public static void main(String[] args) {
		FileMock mock = new FileMock(101, 10);
		
		Buffer buffer = new Buffer(20);
		
		Producer producer = new Producer(mock, buffer);
		Thread threadProducer = new Thread(producer);
		
		Consumer consumer[] = new Consumer[3];
		Thread threadConsumer[] = new Thread[3];
		
		for(int i = 0 ; i < 3 ; i++) {
			consumer[i] = new Consumer(buffer);
			threadConsumer[i] = new Thread(consumer[i]);
		}
		
		threadProducer.start();
		for(int i = 0 ; i < 3 ; i++) {
			threadConsumer[i].start();
		}
	}

}
