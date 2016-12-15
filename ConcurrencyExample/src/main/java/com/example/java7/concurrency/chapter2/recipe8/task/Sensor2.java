package com.example.java7.concurrency.chapter2.recipe8.task;

public class Sensor2 implements Runnable{

	private BuildStats stats;
	
	public Sensor2(BuildStats stats) {
		this.stats = stats;
	}
	@Override
	public void run() {
		stats.comeIn();
		stats.comeIn();
		stats.goOut();
		stats.goOut();
		stats.goOut();
		
	}

}
