package com.example.java7.concurrency.chapter3.recipe4.core;

import java.util.concurrent.CyclicBarrier;

import com.example.java7.concurrency.chapter3.recipe4.task.Grouper;
import com.example.java7.concurrency.chapter3.recipe4.task.Searcher;
import com.example.java7.concurrency.chapter3.recipe4.utils.MatrixMock;
import com.example.java7.concurrency.chapter3.recipe4.utils.Results;

public class Main {

	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINE_PARTICIPANTS = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		
		Results results = new Results(ROWS);
		
		Grouper grouper = new Grouper(results);
		
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		
		Searcher searchers[] = new Searcher[PARTICIPANTS];
		
		for(int i = 0 ; i < PARTICIPANTS ; i++) {
			searchers[i] = new Searcher(i * LINE_PARTICIPANTS, (i*LINE_PARTICIPANTS) + LINE_PARTICIPANTS, mock, results, 5, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		} 
		
		System.out.printf("Main: The main thread has finished");
		
	}

}
