package com.devlabsjava.cleancode.genericsandrec;

import java.util.Queue;

public interface Compute<R, N> {
	R compute(R r, Queue<N> q, Function<R, N> function);
}
