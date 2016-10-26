package com.devlabsjava.cleancode.genericsandrec;

import java.math.BigDecimal;

public class Sum<R , N> implements Function<R, N> {

	@SuppressWarnings("unchecked")
	@Override
	public R apply(R r, N n) {
		Number result = Double.valueOf(0);
		Number number = Double.valueOf(0);
		
		if(n != null){
			number = (Number)n;
		}
		if(r != null){
			result = (Double)r;
		}

		//big decimal is better for rounding values
		BigDecimal addedValue = new BigDecimal(result.doubleValue()).add(new BigDecimal(number.doubleValue())) ;
		return (R) (Number) Double.valueOf(addedValue.toPlainString());
	}}
