package com.example.java7.concurrency.chapter3.recipe7.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import com.example.java7.concurrency.chapter3.recipe7.task.Consumer;
import com.example.java7.concurrency.chapter3.recipe7.task.Producer;

public class Main {

	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		
		Exchanger<List<String>> exchanger = new Exchanger<>();
		
		Producer producer = new Producer(buffer1, exchanger);
		
		Consumer consumer = new Consumer(buffer2, exchanger);
		
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		
		threadProducer.start();
		threadConsumer.start();
	}

}
