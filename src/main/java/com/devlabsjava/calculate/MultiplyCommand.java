package com.devlabsjava.cleancode.calculate;

public class MultiplyCommand implements MathCommand<Integer> {

	@Override
	public Integer execute(Integer operand1, Integer operand2) {
		return operand1 * operand2 ;
	}

}
