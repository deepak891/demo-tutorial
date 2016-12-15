package com.example.java7.concurrency.chapter2.recipe7.task;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private LinkedList<String> buffer;
	
	private int maxSize;
	
	private ReentrantLock lock;
	
	private Condition lines;
	private Condition spaces;
	
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		spaces = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		
		try{
			while(buffer.size() == maxSize) {
				spaces.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Lines: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public String get() {
		String line=null;
		lock.lock();
		try{
			while((buffer.size() == 0) && (hasPendingLines())){
				lines.await();;
			}
			if(hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed %d \n", Thread.currentThread().getName(), buffer.size());
				spaces.signalAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return line;
	}

	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
	
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
} 
