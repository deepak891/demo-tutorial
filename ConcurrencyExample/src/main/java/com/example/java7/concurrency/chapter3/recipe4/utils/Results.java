package com.example.java7.concurrency.chapter3.recipe4.utils;

public class Results {
	
	private int data[];
	
	public Results(int size) {
		data = new int[size];
	}

	public int[] getData() {
		return data;
	}

	public void setData(int position, int value) {
		data[position]=value;
	}
	
	
}
