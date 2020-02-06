package com.revature.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
	
	private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	// Format Date
	public String dateFormat(LocalDateTime date) {
		return date.format(dateFormat);
	}
	
	// Return current system date
	public LocalDateTime dateNow() {
		return LocalDateTime.now();
	}
	
	//Return a date object based on date parameters
	public LocalDateTime dateGetObjectFromParameters(int year, int month, int day, int hour, int minutes) {
		return LocalDateTime.of(year, month, day, hour, minutes);
	}
	
	//Return a date object based on a string date
	public LocalDateTime dateGetObjectFromString(String dateString) {
		return LocalDateTime.parse(dateString, dateFormat);
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		
		/** Now **/
		System.out.println(date.dateFormat(date.dateNow()));
		
		/** Date Parameters **/
		System.out.println(date.dateFormat(date.dateGetObjectFromParameters(2012, 5, 31, 4, 45)));
		
		/** Date Parsing **/
		System.out.println(date.dateFormat(date.dateGetObjectFromString("15-03-1982 02:35")));
	}
}
