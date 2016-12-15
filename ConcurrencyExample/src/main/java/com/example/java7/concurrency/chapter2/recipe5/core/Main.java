package com.example.java7.concurrency.chapter2.recipe5.core;

import com.example.java7.concurrency.chapter2.recipe5.task.PricesInfo;
import com.example.java7.concurrency.chapter2.recipe5.task.Reader;
import com.example.java7.concurrency.chapter2.recipe5.task.Writer;

public class Main {

	public static void main(String[] args) {
		PricesInfo priceInfo = new PricesInfo();
		
		Reader readers[] = new Reader[5];
		Thread threadReader[] = new Thread[5];
		
		for(int i = 0 ; i < 5 ; i++) {
			readers[i] = new Reader(priceInfo);
			threadReader[i] = new Thread(readers[i]);
		} 
		
		Writer writer = new Writer(priceInfo);
		Thread threadWriter = new Thread(writer);
		
		for(int i = 0 ; i < 5 ; i++) {
			threadReader[i].start();
		}
		threadWriter.start();
	}
}
