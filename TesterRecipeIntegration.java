package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Ingredient;
import part01.MethodForRecipe;
import part01.Recipe;
import part01.Time;
import part01.UnitOfMeasurement;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose:
 * To Perform integration testing on the recipe part of the system. Ensure that all requirements are up to date and are functional. 
 * All test cases are explained on copyOfTestingTemplate.xls.
 * The outcomes of test cases were explained in Testing.DOC.
 */
public class TesterRecipeIntegration {
	static ArrayList <Ingredient> collection = addIngredinets();
	static ArrayList <Ingredient> collection2 = addIngredinets2();
	
	public static void main(String[] args) {

		CT1();
		CT2();
		SN1();
		SN2();
		SI1();
		SI2();
		SNP1();
		SNP2();
		AI1();
		AI2();
		CM1();
		CM2();
		VMT1();
		VMT2();
		MMFIPS1();
		MMFIPS2();
		MIT1();
		MIT2();
		AIFS();
		AIFS2();
		SNAFES1();
		SNAFES2();
		//SNINF1();
		//SNINF2();
		SNUFA1();
		SNUFA2();
		SNUFA3();
		SNTFES();
		SNTFES2();
		SNTFES3();
		SNUFT1();
		SNUFT2();
		
	}
	public static void CT1() {
		System.out.println("CT.1 - Testing if we can create a recipe object");
		String name = "Chicken Sandwich";
		
		int numberOfPortions = 2;
		try {
			Recipe newRecipe = new Recipe(name, collection, numberOfPortions);
			if (newRecipe != null) {
				System.out.println("Object created");
			}
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object");
		}	
		System.out.println("End CT.1------\n");
		
	}
	
	public static void CT2() {
		System.out.println("CT.2 - Testing if we can create a recipe object (with invalid data)");
		String name = null;
	
		int numberOfPortions = 2;
		try {
			Recipe newRecipe = new Recipe(name, collection2, numberOfPortions);
			if (newRecipe != null) {
				System.out.println("Object created");
			}
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object (Expected case)");
		}	
		System.out.println("End CT.2------\n");
	}
	
	public static void SN1() {
		System.out.println("SN.1 - Testing if we can set the name of a recipe object");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New name supplied");
			String newName = "Pasta Bolgneses";
			newRecipe.setName(newName);	
			System.out.println("New Name: " + newRecipe.getName());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the name");
		}
		System.out.println("End SN.1 ------\n");
		
	}
	
	public static void SN2() {
		System.out.println("SN.2 - Testing if we can set the name of a recipe object can be set with invalid data");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New name supplied");
			String newName = null;
			newRecipe.setName(newName);	
			System.out.println("New Name: " + newRecipe.getName());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the name (Exepcted case)");
		}
		System.out.println("End SN.2 ------\n");
	}
	
	public static void SI1() {
		System.out.println("SI.1 - Testing if we can set the ingredients of a recipe with valid data");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New Ingredients supplied");
			Ingredient newIngredient = new Ingredient("New Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient newIngredient2 = new Ingredient("New Ingredient 2", FoodGroup.CEREAL, 500);
			Ingredient newIngredient3 = new Ingredient("New Ingredient 3", FoodGroup.DAIRY, 300);
			newRecipe.clearIngredients();
			newRecipe.setIngredients(newIngredient);
			newRecipe.setIngredients(newIngredient2);
			newRecipe.setIngredients(newIngredient3);
		
			System.out.println("New Ingredients: " + newRecipe.getCollectionOfIngredients());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the ingredients");
		}
		System.out.println("End SI.1 ------\n");
	}
	
	public static void SI2() {
		System.out.println("SI.2 - Testing if we can set the ingredients of a recipe with invalid data");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New Ingredients supplied");
			Ingredient newIngredient = null;
			Ingredient newIngredient2 = null;
			Ingredient newIngredient3 = null;
			newRecipe.clearIngredients();
			newRecipe.setIngredients(newIngredient);
			newRecipe.setIngredients(newIngredient2);
			newRecipe.setIngredients(newIngredient3);
		
			System.out.println("New Ingredients: " + newRecipe.getCollectionOfIngredients());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the ingredients (Exepcted case)");
		}
		System.out.println("End SI.2 ------\n");
	}
	
	public static void SNP1() {
		System.out.println("SNP.1 - Testing if we can set the number of portions for the recipe object. ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New numer of portions supplied");
			int numberOfPortions = 3;
			newRecipe.setNumberOfPortions(numberOfPortions);;	
			System.out.println("New number of portions: " + newRecipe.getNumberOfPortions());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the number of portions");
		}
		System.out.println("End SNP.1 ------\n");
	}
	
	public static void SNP2() {
		System.out.println("SNP.2 - Testing if we can set the number of portions for the recipe object. (With invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("New number of portions supplied");
			int numberOfPortions = -1;
			newRecipe.setNumberOfPortions(numberOfPortions);;	
			System.out.println("New number of portions: " + newRecipe.getNumberOfPortions());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the number of portions (Expected case)");
		}
		System.out.println("End SNP.2 ------\n");
	}
	
	public static void AI1() {
		System.out.println("AI.1 - Testing if we can add ingredients to the collection needed for the recipe.  ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Adding new ingredients");
			Ingredient newIngredient = new Ingredient("New Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient newIngredient2 = new Ingredient("New Ingredient 2", FoodGroup.CEREAL, 500);
			Ingredient newIngredient3 = new Ingredient("New Ingredient 3", FoodGroup.DAIRY, 300);
			newRecipe.addIngredients(newIngredient);
			newRecipe.addIngredients(newIngredient2);
			newRecipe.addIngredients(newIngredient3);
			System.out.println("New Ingredients: " + newRecipe.getCollectionOfIngredients());
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding new ingredients");
		}
		System.out.println("End AI.1 ------\n");
	}
	
	public static void AI2() {
		System.out.println("AI.2 - Testing if we can add ingredients to the collection needed for the recipe.(Invalid data)  ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Adding new ingredients");
			Ingredient newIngredient = null;
			Ingredient newIngredient2 = null;
			Ingredient newIngredient3 = null;
			newRecipe.addIngredients(newIngredient);
			newRecipe.addIngredients(newIngredient2);
			newRecipe.addIngredients(newIngredient3);
			System.out.println("New Ingredients: " + newRecipe.getCollectionOfIngredients());
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding new ingredients (Expected case)");
		}
		System.out.println("End AI.2 ------\n");
	}
	
	public static void CM1() {
		System.out.println("CM.1 - Testing if we can create a method for the recipe  ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Creating a method");
			MethodForRecipe newMethod = newRecipe.createMethod(2);
			if (newMethod != null) {
				System.out.println("Successful creation!");
			}
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with creating a method");
		}
		System.out.println("End CM.1 ------\n");
	}
	
	public static void CM2() {
		System.out.println("CM.2 - Testing if we can create a method for the recipe (Invalid data)  ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Creating a method");
			MethodForRecipe newMethod = newRecipe.createMethod(-1);
			if (newMethod != null) {
				System.out.println("Successful creation!");
			}
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with creating a method (Expected case)");
		}
		System.out.println("End CM.2 ------\n");
	}
	
	public static void VMT1() {
		System.out.println("VMT.1 - Testing if we can view a method for the recipe ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Creating a method");
			newRecipe.createMethod(2);
			newRecipe.viewMethod();
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with viewing a method for a recipe");
		}
		System.out.println("End VMT.1 ------\n");
	}
	
	public static void VMT2() {
		System.out.println("VMT.2 - Testing if we can view a method for the recipe (Invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Creating a method");
			newRecipe.createMethod(-1);
			newRecipe.viewMethod();
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding creating and viewing the method (Expected case)");
		}
		System.out.println("End VMT.2 ------\n");
	}
	
	public static void MMFIPS1() {
		System.out.println("MMFIPS.1 - Testing if we can change the ingredients per step ");
		
		Recipe newRecipe = new Recipe("Bolognese", addIngredinets(), 2);
		
		try {
			
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			
			Ingredient oldIngredient = new Ingredient("Old Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient oldIngredient2 = new Ingredient("Old Ingredient 2", FoodGroup.CEREAL, 500);
			newRecipe.addNewIngredientsForStep(1,oldIngredient,5);
			newRecipe.addNewIngredientsForStep(1,oldIngredient2,5);
			System.out.println(newRecipe.getPerStep());	
			
			Ingredient newIngredient = new Ingredient("New Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient newIngredient2 = new Ingredient("New Ingredient 2", FoodGroup.CEREAL, 500);
			newRecipe.setNewIngredientsPerStep(1,1,newIngredient);
			newRecipe.setNewIngredientsPerStep(2,1,newIngredient2);
			System.out.println(newRecipe.getPerStep());	
			
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with changing the ingredients per step");
		}
		System.out.println("End MMFIPS.1 ------\n");
	}
	
	public static void MMFIPS2() {
		System.out.println("MMFIPS.2 - Testing if we can change the ingredients per step (Invalid data) ");
		Recipe newRecipe = new Recipe("Bolognese", addIngredinets(), 2);
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			
			Ingredient oldIngredient = new Ingredient("Old Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient oldIngredient2 = new Ingredient("Old Ingredient 2", FoodGroup.CEREAL, 500);
			newRecipe.addNewIngredientsForStep(1,oldIngredient,5);
			newRecipe.addNewIngredientsForStep(1,oldIngredient2,5);
			System.out.println(newRecipe.getPerStep());	
			
			Ingredient newIngredientInvalid = null;
			Ingredient newIngredientInvalid2 = null;
			newRecipe.setNewIngredientsPerStep(1,1,null);
			newRecipe.setNewIngredientsPerStep(2,1,null);
			
			System.out.println(newRecipe.getPerStep());	
		
			
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with modidyfing the ingredients per step (Expected case)");
		}
		System.out.println("End MMFIPS.2 ------\n");
	}
	
	public static void MIT1() {
		System.out.println("MIT.1 - Testing if we can change the instructions per step ");
		Recipe newRecipe = new Recipe("Bologonese", addIngredinets(), 4);
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			String beforeInfo = "Step 1 - This is step 1" + "\n" + "This is step 2";
			newRecipe.modifyInformation(beforeInfo);
			newRecipe.viewMethod();
			String moreInfo = "Step 3 : This is within step 3";
			newRecipe.modifyInformation(moreInfo);
			newRecipe.viewMethod();
		}catch (Exception Ex) {
			System.out.println("There has been an error with changing the instructions per step");
		}
		System.out.println("End MIT.1 ------\n");
	}
	

	public static void MIT2() {
		System.out.println("MIT.2 - Testing if we can change the instructions per step (Invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			String beforeInfo = "Step 1 - This is step 1" + "\n" + "This is step 2";
			newRecipe.modifyInformation(beforeInfo);
			newRecipe.viewMethod();
			String moreInfo = null;
			newRecipe.modifyInformation(moreInfo);
			newRecipe.viewMethod();
		}catch (Exception Ex) {
			System.out.println("There has been an error with changing the instructions per step (Expected case)");
		}
		System.out.println("End MIT.2 ------\n");
	}
	
	public static void AIFS() {
		System.out.println("AIFS.1 - Testing if we can add ingredients for a recipe ");
		Recipe newRecipe = new Recipe("Bologonese", addIngredinets(), 4);
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			System.out.println("Before");
			System.out.println(newRecipe.getCollectionOfIngredients());
			Ingredient newIngredient = new Ingredient("New Ingredient 1", FoodGroup.PROTEIN, 400);
			System.out.println("After");
			newRecipe.setIngredients(newIngredient);
			System.out.println(newRecipe.getCollectionOfIngredients());
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding a new ingredeint for a specific step");
		}
		System.out.println("End AIFS.1 ------\n");
	}
	
	public static void AIFS2() {
		System.out.println("AIFS.2 - Testing if we can add ingredients for a recipe  (Invalid data)");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			System.out.println("Before");
			System.out.println(newRecipe.getCollectionOfIngredients());
			Ingredient newIngredient = null;
			System.out.println("After");
			newRecipe.setIngredients(newIngredient);
			System.out.println(newRecipe.getCollectionOfIngredients());
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding a new ingredeint for a specific step (Expected case)");
		}
		System.out.println("End AIFS.2 ------\n");
	}
	
	public static void SNAFES1() {
		System.out.println("SNAFES.1 - Testing if we can add a new amount of a ingredient for a step ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			
			Ingredient oldIngredient = new Ingredient("Old Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient oldIngredient2 = new Ingredient("Old Ingredient 2", FoodGroup.CEREAL, 500);
			newRecipe.addNewIngredientsForStep(1,oldIngredient,5);
			newRecipe.addNewIngredientsForStep(1,oldIngredient2,5);
			System.out.println(newRecipe.getAmount());	
			
			newRecipe.setNewAmountForEachStep(1,1,6);
			newRecipe.setNewAmountForEachStep(2,1,7);
			
			System.out.println(newRecipe.getAmount());	
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding a new amount for a specific step");
		}
		System.out.println("End SNAFES.1 ------\n");
	}
	
	public static void SNAFES2() {
		System.out.println("SNAFES.2 - Testing if we can add a new amount of a ingredient for a step (Invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);
			
			Ingredient oldIngredient = new Ingredient("Old Ingredient 1", FoodGroup.PROTEIN, 400);
			Ingredient oldIngredient2 = new Ingredient("Old Ingredient 2", FoodGroup.CEREAL, 500);
			newRecipe.addNewIngredientsForStep(1,oldIngredient,5);
			newRecipe.addNewIngredientsForStep(1,oldIngredient2,5);
			System.out.println(newRecipe.getAmount());	
			
			newRecipe.setNewAmountForEachStep(1,1,-1);
			newRecipe.setNewAmountForEachStep(2,1,-1);
			
			System.out.println(newRecipe.getAmount());
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding a new amount for a specific step (Expected case)");
		}
		System.out.println("End SNAFES.2 ------\n");
	}
	
	public static void SNUFA1() {
		System.out.println("SNUFA.1 - Testing if we can add a new unit of a ingredient for a step ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the Unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setUnitForAmount(createUnits());
			System.out.println(newRecipe.getUnitsForAmount());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewUnitForAmount(1,1,UnitOfMeasurement.CUPS);
			System.out.println(newRecipe.getUnitsForAmount());
			
		}catch (Exception Ex) {
			System.out.println("There has been an error with modifying a unit of a ingredient for a step");
		}
		System.out.println("End SNUFA.1 ------\n");
	}
	
	public static void SNUFA2() {
		System.out.println("SNUFA.2 - Testing if we can add a new unit of a ingredient for a step (Invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setUnitForAmount(createUnits());
			System.out.println(newRecipe.getUnitsForAmount());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewUnitForAmount(1,1,null);
			System.out.println(newRecipe.getUnitsForAmount());
		}catch (Exception Ex) {
			System.out.println("There has been an error with modifying a unit for a specific step (Expected case)");
		}
		System.out.println("End SNUFA.2 ------\n");
	}
	
	public static void SNUFA3() {
		System.out.println("SNUFA.3 - Testing if we can add a new unit of a ingredient for a step (Invalid data) ");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setUnitForAmount(createUnits());
			System.out.println(newRecipe.getUnitsForAmount());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewUnitForAmount(-1,-1,UnitOfMeasurement.MILLILIETER);
			System.out.println(newRecipe.getUnitsForAmount());
		}catch (Exception Ex) {
			System.out.println("There has been an error with modifyin ghe unit of amount per step. (Expected case)");
		}
		System.out.println("End SNUFA.3 ------\n");
	}
	
	public static void SNTFES() {
		System.out.println("SNTFES.1 - Testing if we can set the time for a specific step");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setTimeForStep(1);
			newRecipe.setTimeForStep(2);
			
			System.out.println(newRecipe.getTimeForEach());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewTimeForEachStep(1, 1, 3);
			newRecipe.setNewTimeForEachStep(1, 2, 100);
			System.out.println(newRecipe.getTimeForEach());

	
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the time for a specific step");
		}
		System.out.println("End SNTFES.2 ------\n");
	}
	
	public static void SNTFES2() {
		System.out.println("SNTFES.2 - Testing if we can set the time for a specific step (Invalid data)");
		Recipe newRecipe = createRecipe();
		try {
			System.out.println("Change the unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setTimeForStep(1);
			newRecipe.setTimeForStep(2);
			
			System.out.println(newRecipe.getTimeForEach());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewTimeForEachStep(1, 1, -1);
			newRecipe.setNewTimeForEachStep(1, 2, -1);
			System.out.println(newRecipe.getTimeForEach());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting a time for a specific step (Expected case)");
		}
		System.out.println("End SNTFES.2------\n");
	}
	
	public static void SNTFES3() {
		System.out.println("SNTFES.3 - Testing if we can set the time for a specific step (Step that doesnt exist)");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of amount per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setTimeForStep(1);
			newRecipe.setTimeForStep(2);
			
			System.out.println(newRecipe.getTimeForEach());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewTimeForEachStep(-1, -1, -1);
			newRecipe.setNewTimeForEachStep(-1, -2, -1);
			System.out.println(newRecipe.getTimeForEach());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the time for a specific step (Expected case)");
		}
		System.out.println("End SNTFES.3------\n");
	}
	
	public static void SNUFT1() {
		System.out.println("SNUFT.1 - Testing if we can set a new unit for the time");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of time per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setTimeUnitForStep(Time.SECOND);
			newRecipe.setTimeUnitForStep(Time.MINUTE);
			
			System.out.println(newRecipe.getUnitForTime());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewUnitForTimeEachStep(1,1,Time.MINUTE);
			newRecipe.setNewUnitForTimeEachStep(1,2, Time.YEAR);
			System.out.println(newRecipe.getUnitForTime());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the unit for time for a specific step");
		}
		System.out.println("End SNUFT.1-----\n");
	}
	
	public static void SNUFT2() {
		System.out.println("SNUFT.2 - Testing if we can set a new unit for time (Invalid data)");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the unit of time per step. ");
			newRecipe.createMethod(2);
			System.out.println("Orignal");
		
			newRecipe.setTimeUnitForStep(Time.SECOND);
			newRecipe.setTimeUnitForStep(Time.MINUTE);
			
			System.out.println(newRecipe.getUnitForTime());
			
			System.out.println("Afer modification: ");
			newRecipe.setNewUnitForTimeEachStep(1,1,null);
			newRecipe.setNewUnitForTimeEachStep(1,2, null);
			System.out.println(newRecipe.getUnitForTime());
		}catch (Exception Ex) {
			System.out.println("There has been an error with setting the unit for time for a specific step (Expected case)");
		}
		System.out.println("End SNUFT.2-----\n");
	}
	
	public static void SNUFT3() {
		System.out.println("SNUFT.3 - Testing if we can set a new unit for an Time (Invalid data)");
		Recipe newRecipe = createRecipe();
		
		try {
			System.out.println("Change the ingredients per step. ");
			newRecipe.createMethod(2);

			newRecipe.setNewUnitForTimeEachStep(1, -1, Time.DAY);
		}catch (Exception Ex) {
			System.out.println("There has been an error with adding a new unit for time for a specific step (Expected case)");
		}
		System.out.println("End SNUFT.3-----\n");
	}
	
	
	
	
	private static ArrayList<Ingredient> addIngredinets() {
		ArrayList <Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		ingredients.add(ingredient);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		return ingredients;
	}
	
	private static ArrayList<Ingredient> addIngredinets2() {
		ArrayList <Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = null;
		Ingredient ingredient2 = null;
		Ingredient ingredient3 = null;
		ingredients.add(ingredient);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		return ingredients;
	}
	
	private static Recipe createRecipe() {
		String name = "Chicken Sandwich";
		ArrayList <Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		ingredients.add(ingredient);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);

		int numberOfPortions = 2;

		Recipe newRecipe = new Recipe(name, ingredients, numberOfPortions);
		return newRecipe;
	}
	
	private static ArrayList<UnitOfMeasurement> createUnits(){
		ArrayList<UnitOfMeasurement> units = new ArrayList<UnitOfMeasurement>();
		units.add(UnitOfMeasurement.CUPS);
		units.add(UnitOfMeasurement.GRAMS);
		units.add(UnitOfMeasurement.LITRE);
		return units;
	}
	private static ArrayList<Double> createTimes(){
		ArrayList<Double> times = new ArrayList<Double>();
		times.add(1.0);
		times.add(2.0);
		times.add(3.0);
		return times;
	}
	
	
	

}
