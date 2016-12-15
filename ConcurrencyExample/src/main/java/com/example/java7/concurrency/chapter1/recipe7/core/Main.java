package com.example.java7.concurrency.chapter1.recipe7.core;

import java.util.ArrayDeque;
import java.util.Deque;

import com.example.java7.concurrency.chapter1.recipe7.event.Event;
import com.example.java7.concurrency.chapter1.recipe7.task.CleanerTask;
import com.example.java7.concurrency.chapter1.recipe7.task.WriterTask;

public class Main {

	public static void main(String[] args) {
		
		Deque<Event> deque = new ArrayDeque<>();
		
		WriterTask writerTask = new WriterTask(deque);
		
		for(int i = 0 ; i < 3 ; i++) {
			Thread thread = new Thread(writerTask);
			thread.start();
		}
		
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();
	}
}
