package com.example.java7.concurrency.chapter2.recipe3.task;

public class Consumer implements Runnable{

	private EventStorage storage;
	
	public Consumer(EventStorage eventStorage) {
		this.storage = eventStorage;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100; i++) {
			storage.get();
		}
		
	}

}
