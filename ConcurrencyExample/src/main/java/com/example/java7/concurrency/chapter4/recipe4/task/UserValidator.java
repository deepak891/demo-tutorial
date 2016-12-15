package com.example.java7.concurrency.chapter4.recipe4.task;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	
	private String name;
	
	public UserValidator(String name) {
		this.name = name;
	}
	
	public boolean validate(String name, String password) {
		Random random = new Random();
		
		try{
			Long duration = (long) (Math.random() * 10);
			System.out.printf("Validator %s: Validating a user during %d seconds. \n", Thread.currentThread().getName(), duration);
			TimeUnit.SECONDS.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		
		return random.nextBoolean();
	}
	
	public String getName() {
		return name;
	}
}
