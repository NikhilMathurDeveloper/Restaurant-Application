package part01;

/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * The purpose of this class is to create a blue print for ingredients to be instantiated and created when needed. To allow all details to be added when required. 
 */
public class Ingredient {
	
	
	private int id; //ID used to uniquely identify the ingredient.
	private String name; //Name used to identify the ingredient via a sequence of alphabetical characters. 
	private FoodGroup foodGroup; //Food Group used to dictate which category the ingredient falls into. 
	private double calories; // Calories describes the calorific intakes of the ingredient. 
	
	private static int nextNumberInSequence = 1; //This static variable is to help with allocating the ID to the ingredient. 
	
	
	/**
	 * 
	 * @param name - The name of the ingredient is passed. 
	 * @param foodGroup - The food group of the ingredient is passed. 
	 * @param calories - The calories of the ingredient is passed. 
	 */
	public Ingredient(String name, FoodGroup foodGroup, double calories) {
		if (name == null || foodGroup == null || calories== -1) {
			throw new IllegalArgumentException("Invalid data");
		}else {
			this.id = this.nextNumberInSequence;
			this.nextNumberInSequence++;
			this.name = name;
			this.foodGroup= foodGroup;
			this.calories = calories;
		}	
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public String getFoodGroup() {
		if (foodGroup == FoodGroup.FRUIT_VEG) {
			return FoodGroup.FRUIT_VEG.toString();
		} else if (foodGroup == FoodGroup.COMPOSITE_FOOD) {
			return FoodGroup.COMPOSITE_FOOD.toString();
		} else if(foodGroup == FoodGroup.DAIRY) {
			return FoodGroup.DAIRY.toString();
		}else if (foodGroup == FoodGroup.CEREAL) {
			return FoodGroup.CEREAL.toString();
		}else if (foodGroup == FoodGroup.PROTEIN) {
			return FoodGroup.PROTEIN.toString();
		}else if (foodGroup == FoodGroup.SUGAR) {
			return FoodGroup.SUGAR.toString();
		}else if(foodGroup == FoodGroup.FAT) {
			return FoodGroup.FAT.toString();
		}else if (foodGroup == FoodGroup.SPICE_HERB) {
			return FoodGroup.SPICE_HERB.toString();
		}else if(foodGroup == FoodGroup.ESSENTIAL_NUTRIENT) {
			return FoodGroup.ESSENTIAL_NUTRIENT.toString();
		}
		return FoodGroup.UNDEFINED.toString();
			
	}
	
	
	
	
	/*
	 * Simply returns the food group as an Enum value.
	 */
	public FoodGroup getFoodGroup2() {
		return this.foodGroup;
	}
	

	
	public double getCalories() {
		return this.calories;
	}
	
	/**
	 * This set method is to change the instance data of the name to the new one set by the user. 
	 * @param newName -> New name passed as a parameter, where appropriately changed. 
	 */
	public boolean setName(String newName) {
		if (newName != null) {
			this.name = newName;
			return true;
		}
		return false;
	}
	/**
	 * This set method is to change the instance data of the food group to the new one set by the user. 
	 * @param newFoodGroup foodGroup --> New food group passed as a parameter, where appropriately changed. 
	 */
	public boolean setFoodGroup(FoodGroup newFoodGroup) {
		if (newFoodGroup != null) {
			this.foodGroup = newFoodGroup;
			return true;
		}
		return false;
	}
	
	/**
	 * This set method is to change the instance data of the calories to the new one set by the user. 
	 * @param newCalories --> New calories passed as a argument, where appropriately changed. 
	 */
	public boolean setCalories(double newCalories) {
		if (newCalories > 0) {
			this.calories = newCalories;
			return true;
		}
		return false;
	}
	
	/*
	 * A toString method which takes the getters and forms a valid information feed. 
	 */
	public String toString() {
		String sentence = "ID: " + getId()+ "\n" + "Name: " + getName() + "\n" + "Food Group: " + getFoodGroup() + "\n" + "Calories: " + getCalories();
		return sentence;
	}
	
	
	
}
