package com.devlabsjava.cleancode.calculate;

public class CalculatorTest {

	public static void main(String[] args) {
		MathCommand<Integer> command = new AddCommand();
		Integer result = command.execute(5,6);
		command = new SubstractCommand();
		result = command.execute(result,4);
		command = new MultiplyCommand();
		result = command.execute(result,2);
		command = new DivideCommand();
		result = command.execute(result , 2);
		System.out.println("Result : " + result);
		
	}

}
