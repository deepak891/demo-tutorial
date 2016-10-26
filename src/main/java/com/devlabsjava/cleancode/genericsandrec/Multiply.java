package com.devlabsjava.cleancode.genericsandrec;

import java.math.BigDecimal;

public class Multiply<R, N> implements Function<R, N> {

	@SuppressWarnings("unchecked")
	@Override
	public R apply(R r, N n) {
		Number number = Double.valueOf(1);
		Number result = Double.valueOf(1);
		
		if(n != null){
			number = (Number)n;
		}
		if(r != null){
			result = (Double)r;
		}

		//big decimal is better for rounding values
		BigDecimal addedValue = new BigDecimal(result.doubleValue()).multiply(new BigDecimal(number.doubleValue())) ;
		return (R) (Number) Double.valueOf(addedValue.toPlainString());
	}

}
