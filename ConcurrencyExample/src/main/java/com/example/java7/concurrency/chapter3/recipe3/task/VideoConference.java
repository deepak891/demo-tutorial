package com.example.java7.concurrency.chapter3.recipe3.task;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

	private CountDownLatch controller;
	
	public VideoConference(int number) {
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name) {
		System.out.printf("%s has arrived.\n", name);
		controller.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
	}
	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
		
		try{
			controller.await();
			
			System.out.println("Videoconference: All the participants have come.\n");
			System.out.println("Videoconference: Let's start.\n");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
