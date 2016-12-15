package com.example.java7.concurrency.chapter1.recipe3.core;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		
		while (true) {
			if(isPrime(number)){
				System.out.printf("Number %d is Prime\n", number);
			}
			
			if(isInterrupted()){
				System.out.println("The prime generator has been interrupted\n");
				return;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if(number <= 2){
			return true;
		}
		for(long i = 2; i < number ; i++){
			if((number % i) == 0){
				return false;
			}
		}
		return true;
	}
}
