package com.example.java7.concurrency.chapter1.recipe7.task;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe7.event.Event;

public class WriterTask implements Runnable {

	Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}
	@Override
	public void run() {
		//Write 100 events
		for(int i = 1 ; i < 100; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event \n", Thread.currentThread().getId()));
		
			deque.addFirst(event);
			try{
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
