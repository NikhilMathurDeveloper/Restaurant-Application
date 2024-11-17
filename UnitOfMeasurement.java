package part01;

public enum UnitOfMeasurement {
	/**
	 * Author: Nikhil Mathur
	 * Student Number: 40404282
	 * Purpose: To declare different unit of measurements for amount. This is to ensure a level of consistency. These are most commonly used metrics. 
	 */
	
	GRAMS("Grams"), 
	LITRE("Litre"), 
	POUNDS("Pounds"), 
	OUNCE("Ounce"), 
	MILLILIETER("Millileter"), 
	CUPS("Cups"), 
	TABLE_SPOON("Table Spoon"),
	UNDEFINED("Undefined");
	
	
	private String measurementType;
	
	/**
	 * Constructor used to assign the enums value to a private value to ensure that it can be returned when needed.
	 * @param type --> The Strind holding enum value.
	 */
	private UnitOfMeasurement(String type) {
		this.measurementType = type;
	}
	
	/**
	 * To return the enum's string.
	 */
	public String toString() {
		return this.measurementType;
	}

}
