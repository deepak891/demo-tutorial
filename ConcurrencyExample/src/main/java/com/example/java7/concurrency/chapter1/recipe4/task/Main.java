package com.example.java7.concurrency.chapter1.recipe4.task;

import java.util.concurrent.TimeUnit;

import com.example.java7.concurrency.chapter1.recipe4.core.FileSearch;

public class Main {

	public static void main(String[] args) {
		FileSearch fileSearch = new FileSearch("c:\\", "autoexec.bat");
		Thread thread = new Thread(fileSearch);
		
		thread.start();
		
		try{
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
