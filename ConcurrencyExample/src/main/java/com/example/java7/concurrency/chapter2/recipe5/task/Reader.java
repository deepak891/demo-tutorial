package com.example.java7.concurrency.chapter2.recipe5.task;

public class Reader implements Runnable {

	private PricesInfo priceInfo;
	
	public Reader(PricesInfo priceInfo) {
		this.priceInfo = priceInfo;
	}
	@Override
	public void run() {

		for(int i = 0 ; i < 10 ; i ++) {
			System.out.printf("%s : Price 1 : %f \n", Thread.currentThread().getName(), priceInfo.getPrice1());
			System.out.printf("%s : Price 2 : %f \n", Thread.currentThread().getName(), priceInfo.getPrice2());
		}
	}

}
