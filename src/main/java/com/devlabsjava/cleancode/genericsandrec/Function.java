package com.devlabsjava.cleancode.genericsandrec;

public interface Function<R, N> {
	R apply(R r, N n);
}
