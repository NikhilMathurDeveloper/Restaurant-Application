package part01;

public enum Time {
	/**
	 * Author: Nikhil Mathur
	 * Student Number: 40404282
	 * Purpose: To define Units of time which can be applied to arbitrary numbers specified. These are most commonly used metrics.
	 */
	SECOND("Second"), 
	MINUTE("Minute"), 
	HOUR("Hour"), 
	DAY("Day"), 
	MONTH("Month"), 
	YEAR("Year");
	
	private String timeType;
	
	/**
	 * This constructor is to assign a private variable, enabling it to be returned when needed. 
	 * @param time
	 */
	private Time(String time) {
		this.timeType = time;
	}
	/**
	 * toString() used to return the enum's string.
	 */
	public String toString() {
		return this.timeType;
	}

}
