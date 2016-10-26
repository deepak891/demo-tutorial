package com.devlabsjava.cleancode.genericsandrec;

import java.util.Queue;

public class Recursion<R, N> implements Compute<R, N> {

	@Override
	public R compute(R r, Queue<N> q, Function<R, N> function) {

		if(q.size() == 0){
			return r;
		}
		r = compute(function.apply(r, q.poll()), q, function);
		return r;
	}

}
