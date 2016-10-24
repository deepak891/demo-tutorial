package com.devlabsjava;

public class CloseTo100 {

	public static int calculate(int input1, int input2) {
		int input1Diff = Math.abs(100 - input1);
		int input2Diff = Math.abs(100 - input2);

		if(input1Diff > input2Diff){
			return input2;
		}else if(input2Diff < input1Diff) {
			return input1;
		}else {
			return input1;
		}
	}

}
