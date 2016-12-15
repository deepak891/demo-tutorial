package com.example.java7.concurrency.chapter3.recipe3.core;

import com.example.java7.concurrency.chapter3.recipe3.task.Participants;
import com.example.java7.concurrency.chapter3.recipe3.task.VideoConference;

public class Main {

	public static void main(String[] args) {
		VideoConference videoConference = new VideoConference(10);
		
		Thread thread = new Thread(videoConference);
		thread.start();
		
		//creating participants
		for(int i = 0 ; i < 10 ; i++) {
			Participants p = new Participants(videoConference, "Participant-"+i);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
