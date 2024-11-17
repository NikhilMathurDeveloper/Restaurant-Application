package part02;

import part01.FoodGroup;
import part01.Ingredient;

/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose:
 * The purpose of this class is to provide testing for the ingredient class. All public methods are to be tested and ensured adequate functionality.
 * Test cases were explained on copyOfTestingTempalte.xls
 * Outcomes of test cases were specified on Testing.DOC
 */
public class TesterIngredientUnit {
	public static void main(String[] args) {
		CT1();
		CT2();
		SN1();
		SN2();
		SFG1();
		SFG2();
		SC1();
		SC2();
		TS1();
		
	}
	
	
	public static void CT1() {
		System.out.println("CT.1 - Testing if we can create a ingredient object");
		String name = "Apple";
		FoodGroup foodGroup = FoodGroup.FRUIT_VEG;
		double calories = 20;
		try {
			Ingredient newIngredient = new Ingredient(name, foodGroup, calories);
			if (newIngredient != null) {
				System.out.println("Object created");
			}
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object");
		}	
		System.out.println("End CT.1------\n");
	}
	
	public static void CT2() {
		System.out.println("CT.2 - Testing if we can create a ingredient object with invalid data");
		String name = null;
		FoodGroup foodGroup = null;
		double calories= 90;
		try {
			Ingredient newIngredient = new Ingredient(name, foodGroup, calories);
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object (Expected case)");
		}
		System.out.println("End CT.2------\n");
	}
	
	public static void SN1() {
		System.out.println("SN.1 - Testing if we can set the name of a ingredient object with valid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New name supplied");
			String newName = "Banana";
			ingredient.setName(newName);	
			System.out.println("New Name: " + ingredient.getName());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the name");
		}
		System.out.println("End SN.1 ------\n");
	}
	public static void SN2() {
		System.out.println("SN.2 - Testing if we can set the name of a ingredient object with invalid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New name supplied");
			String newName = null;
			if (ingredient.setName(newName) == false) {
				throw new IllegalArgumentException("Incorrect argument passed");
			}
			System.out.println("New Name: " + ingredient.getName());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the name (Excepted case)");
		}
		System.out.println("End SN.2 ------\n");
	}
	
	public static void SFG1() {
		System.out.println("SFG.1 - Testing if we can set the food group of a ingredient object with valid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New food group supplied");
			FoodGroup newFoodGroup = FoodGroup.ESSENTIAL_NUTRIENT;
			if (ingredient.setFoodGroup(newFoodGroup) == false) {
				throw new IllegalArgumentException("Incorrect argument passed");
			}
			System.out.println("New Food Group: " + ingredient.getFoodGroup());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the food group");
		}
		System.out.println("End SFG.1 ------\n");
	}
	public static void SFG2() {
		System.out.println("SFG.2 - Testing if we can set the food group of a ingredient object with invalid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New food group supplied");
			FoodGroup newFoodGroup = null;
			if (ingredient.setFoodGroup(newFoodGroup) == false) {
				throw new IllegalArgumentException("Incorrect argument passed");
			}
			System.out.println("New Food Group: " + ingredient.getFoodGroup());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the food group (Expected case)");
		}
		System.out.println("End SFG.2 ------\n");
	}
	
	public static void SC1() {
		System.out.println("SC.1 - Testing if we can set the calories of a ingredient object with valid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New calories supplied");
			double calories = 20;
			if (ingredient.setCalories(calories) == false) {
				throw new IllegalArgumentException("Incorrect argument passed");
			}
			System.out.println("New calories: " + ingredient.getCalories());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the calories");
		}
		System.out.println("End SC.1 ------\n");
	}
	
	public static void SC2() {
		System.out.println("SC.2 - Testing if we can set the calories of a ingredient object with invalid data");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println("New calories supplied");
			double calories = -1;
			if (ingredient.setCalories(calories) == false) {
				throw new IllegalArgumentException("Incorrect argument passed");
			}	
			System.out.println("New calories: " + ingredient.getCalories());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the calories (Excpected case)");
		}
		System.out.println("End SC.2 ------\n");
	}
	
	public static void TS1() {
		System.out.println("TS.1 - Testing all details of the object are able to be displayed accordingly");
		Ingredient ingredient = objectCreated();
		try {
			System.out.println(ingredient.toString());
		}catch(Exception Ex) {
			System.out.println("Not possible");
		}
		System.out.println("End TS.1 ------\n");
	}
	
	
	private static Ingredient objectCreated() {
		String name = "Apple";
		FoodGroup foodGroup = FoodGroup.FRUIT_VEG;
		double calories = 20;
		Ingredient newIngredient = new Ingredient(name, foodGroup, calories);
		return newIngredient;
	}


}
