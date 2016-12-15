package com.example.java7.concurrency.chapter2.recipe1.core;

import com.example.java7.concurrency.chapter2.recipe1.task.Account;
import com.example.java7.concurrency.chapter2.recipe1.task.Bank;
import com.example.java7.concurrency.chapter2.recipe1.task.Company;

public class Main {

	public static void main(String[] args) {

		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		
		companyThread.start();
		bankThread.start();
		
		try{
			companyThread.join();
			bankThread.join();
			
			System.out.printf("Account : Final Balance %s", account.getBalance());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
