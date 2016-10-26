package com.devlabsjava;

public class FizBuzzDry {

	
	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder(500);
		for(int i = 1 ; i <=30 ; i++){
			boolean processed = false;
			if( i % 15 == 0){
				builder.append("FizzBiZZ");
			}
			else if( i % 3 == 0 ){
				builder.append("Bizz");
			}
			else if( i % 5 == 0){
				builder.append("Fizz");
			}else{
				builder.append(i);
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}

}
