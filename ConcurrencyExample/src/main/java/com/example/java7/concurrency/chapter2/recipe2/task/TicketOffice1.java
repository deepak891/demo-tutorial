package com.example.java7.concurrency.chapter2.recipe2.task;

public class TicketOffice1 implements Runnable {

	private Cinema cinema;
	
	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets1(2);
		cinema.returnTickets1(3);
		cinema.sellTickets1(5);
		cinema.sellTickets1(2);
		cinema.sellTickets1(2);
		cinema.sellTickets1(2);
	}

}
