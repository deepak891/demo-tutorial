package com.example.java7.concurrency.chapter4.recipe1.core;

import com.example.java7.concurrency.chapter4.recipe1.task.Server;
import com.example.java7.concurrency.chapter4.recipe1.task.Task;

public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task - "+i);
			server.executeTask(task);
		}
		
		server.endServer();
	}

}
