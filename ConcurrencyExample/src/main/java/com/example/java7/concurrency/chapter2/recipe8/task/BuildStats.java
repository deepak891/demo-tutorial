package com.example.java7.concurrency.chapter2.recipe8.task;

import java.util.concurrent.TimeUnit;

public class BuildStats {

	private int numPeople;
	
	public void comeIn() {
		System.out.printf("%s: A person enters: \n", Thread.currentThread().getName());
		synchronized (this) {
			numPeople++;
		}
		generateCard();
	}

	public void goOut(){
		System.out.printf("%s: A person leaves: \n", Thread.currentThread().getName());
		synchronized (this) {
			numPeople--;
		}
		generateReport();
	}
	private void generateReport() {
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	private void generateCard() {
		try{
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void printStats() {
		System.out.printf("%d persons in the building.\n ", numPeople);
	}
}
