package part01;

public enum FoodGroup {
	
	/**
	 * Author: Nikhil Mathur
	 * Student Number: 40404282
	 * Purpose:
	 * An Enumuration has been created to show case the food groups which an ingredient may belong to. 
	 * This is to avoid an arbitrary input, and ensure that ingredients can be easily categorized and identified when needed.
	 * There are 9 constants which define a food group, and a last constant which is to define uncertainty. 
	 */
	FRUIT_VEG("Fruit & Veg"),
	COMPOSITE_FOOD("Composite Food"),
	DAIRY("Dairy"),
	CEREAL("Cereal"),
	PROTEIN("Protein"),
	SUGAR("Sugar"),
	FAT("Fat"),
	SPICE_HERB("Spice & Herb"),
	ESSENTIAL_NUTRIENT("Essential Nutrients"), 
	UNDEFINED("Undefined");
	
	
	private String foodGroupType;
	/**
	 * 
	 * @param type - This constructor takes a string as a parameter, this is to enable the enum to be returned when needed.  
	 */
	private FoodGroup(String type) {
		this.foodGroupType = type;
		
	}
	/**
	 * This method returns the private variable foodGroupType, hence allowing it to be displayed to the user when needed. 
	 */
	public String toString() {
		return this.foodGroupType;
	}

}
