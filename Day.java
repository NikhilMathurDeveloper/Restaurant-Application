package part01;

public enum Day {
	
	/**
	 * Author: Nikhil Mathur
	 * Student Number: 40404282
	 * Purpose:
	 * Enumuration Created to Display the days which are used within the Menu.
	 * This is to avoid any arbitrary input 
	 * All 7 days of the week are included
	 */
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday"),
	SUNDAY("Sunday");
	
	
	private String dayType;
	/**
	 * 
	 * @param value - Takes a string as a parameter, this is to set the Enum and allow the user to get a return type when needed. 
	 */
	private Day(String value) {
		this.dayType = value;
		
	}
	/**
	 * ToString() used to return the enum, and makes it accessible to the user, and developer when needed. 
	 */
	
	public String toString() {
		return this.dayType;
	}

}
