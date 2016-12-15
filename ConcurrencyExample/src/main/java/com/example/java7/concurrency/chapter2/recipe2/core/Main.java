package com.example.java7.concurrency.chapter2.recipe2.core;

import com.example.java7.concurrency.chapter2.recipe2.task.Cinema;
import com.example.java7.concurrency.chapter2.recipe2.task.TicketOffice1;
import com.example.java7.concurrency.chapter2.recipe2.task.TicketOffice2;

public class Main {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1);
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2);

		thread1.start();
		thread2.start();

		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies : %d \n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies : %d \n", cinema.getVacanciesCinema2());
		
	}

}