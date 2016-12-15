package com.example.java7.concurrency.chapter2.recipe8.task;

public class Sensor1 implements Runnable {

	private BuildStats stats;
	
	public Sensor1(BuildStats stats) {
		this.stats = stats;
	}
	@Override
	public void run() {
		stats.comeIn();
		stats.comeIn();
		stats.comeIn();
		stats.goOut();
		stats.comeIn();
	}

}
