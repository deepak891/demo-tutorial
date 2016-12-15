package com.example.java7.concurrency.chapter2.recipe7.task;

import com.example.java7.concurrency.chapter2.recipe7.utils.FileMock;

public class Producer implements Runnable {

	private FileMock mock;
	
	private Buffer buffer;
	
	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}
	@Override
	public void run() {
		buffer.setPendingLines(true);
		while(mock.hasMoreLines()){
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}

}
