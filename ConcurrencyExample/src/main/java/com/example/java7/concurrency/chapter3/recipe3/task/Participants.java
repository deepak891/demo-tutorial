package com.example.java7.concurrency.chapter3.recipe3.task;

import java.util.concurrent.TimeUnit;

public class Participants implements Runnable{

	private VideoConference conference;
	
	private String name;
	
	public Participants(VideoConference conference, String name) {
		this.conference = conference;
		this.name = name;
	}

	@Override
	public void run() {
		Long duration = (long) (Math.random()*10);
		try{
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		conference.arrive(name);
	}
	
	
}
