package com.example.java7.concurrency.chapter3.recipe5.core;

import java.util.concurrent.Phaser;

import com.example.java7.concurrency.chapter3.recipe5.task.FileSearch;

public class Main {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		
		FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch app = new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch document = new FileSearch("c:\\Documents And Settings", "log", phaser);
		
		Thread systemThread = new Thread(system,"System");
		systemThread.start();
		
		Thread appThread = new Thread(app, "App");
		appThread.start();
		
		Thread documentThread = new Thread(document, "Document");
		documentThread.start();
		try{
			systemThread.join();
			appThread.join();
			documentThread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Terminated: %s\n ", phaser.isTerminated());
	}

}
