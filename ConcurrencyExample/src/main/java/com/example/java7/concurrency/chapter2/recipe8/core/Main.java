package com.example.java7.concurrency.chapter2.recipe8.core;

import java.util.Date;

import com.example.java7.concurrency.chapter2.recipe8.task.BuildStats;
import com.example.java7.concurrency.chapter2.recipe8.task.Sensor1;
import com.example.java7.concurrency.chapter2.recipe8.task.Sensor2;

public class Main {

	public static void main(String[] args) {

		BuildStats stats = new BuildStats();
		
		Sensor1 sensor1 = new Sensor1(stats);
		Thread threadSensor1 = new Thread(sensor1);
		
		Sensor2 sensor2 = new Sensor2(stats);
		Thread threadSensor2 = new Thread(sensor2);
		
		Date date = new Date();
		
		threadSensor1.start();
		threadSensor2.start();
		
		try{
			threadSensor1.join();
			threadSensor2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Date date2 = new Date();
		stats.printStats();
		System.out.printf("Execution Time: " +(date2.getTime() -date.getTime()));
				
	}

}
