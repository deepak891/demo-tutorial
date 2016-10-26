package com.devlabsjava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//anonymous innter class. Each thread will have its own copy of the SimpleDateFormat
	private final static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd/mm/yyyy");
		}
	};
	
	public String format(Date input){
		if(input == null){
			return null;
		}
		
		return tl.get().format(input);
	}
	
}
