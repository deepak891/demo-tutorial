package com.example.java7.concurrency.chapter2.recipe1.task;

import java.util.concurrent.TimeUnit;

public class Account {

	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public synchronized void addAmount(double amount) {
		double tmp = balance;
		try{
			TimeUnit.MILLISECONDS.sleep(1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		tmp+=amount;
		balance = tmp;
	}
	
	public synchronized void subtractAmount(double amount) {
		double tmp = balance;
		try{
			TimeUnit.MILLISECONDS.sleep(1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		tmp-=amount;
		balance = tmp;
	}
}
