package com.devlabsjava.cleancode.genericsandrec;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Assert;
import org.junit.Test;


public class RecursionTest {

	@Test
	public void testRecursionMultiply(){
		Queue<Integer> q = new ArrayBlockingQueue<Integer>(5);
        q.add(5);
        q.add(10);
        q.add(12);
		Compute<Double, Integer> compute = new Recursion<Double, Integer>();
        Double result = compute.compute(null, q, new Multiply<Double, Integer>());
        System.out.println(result);
		Assert.assertEquals("600.0", result);
	}
}
