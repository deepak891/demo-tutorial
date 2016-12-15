package com.example.java7.concurrency.chapter4.recipe4.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.java7.concurrency.chapter4.recipe4.task.TaskValidator;
import com.example.java7.concurrency.chapter4.recipe4.task.UserValidator;

public class Main {

	public static void main(String[] args) {
		String userName = "test";
		String password = "test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("Database");
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator, userName, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, userName, password);
		
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		String result;
		
		try{
			result = executor.invokeAny(taskList);
			System.out.printf("Main : Result %s\n", result);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		System.out.printf("Main : End of execution \n");
 	}

}
