package com.example.java7.concurrency.chapter3.recipe6.core;

import com.example.java7.concurrency.chapter3.recipe6.task.MyPhaser;
import com.example.java7.concurrency.chapter3.recipe6.task.Student;

public class Main {

	public static void main(String[] args) {

		MyPhaser phaser = new MyPhaser();
		
		Student students[] = new Student[5];
		for(int i = 0 ; i < students.length ; i++){
			students[i] = new Student(phaser);
			phaser.register();
		}

		Thread threads[] = new Thread[5];
		for (int i = 0; i < students.length; i++) {
			threads[i] = new Thread(students[i], "Student-"+i);
			threads[i].start();
		}
		
		for(int i = 0 ; i < threads.length ; i++) {
			try{
				threads[i].join();	
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main : The Phaser has finished : %s\n", phaser.isTerminated() );
	}

}
