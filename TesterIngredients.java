package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Ingredient;
import part01.Warehouse;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * To test the ingredients section of the application class. 
 * Test cases were created and explained on CopyOfTestingTemplate.xls. 
 * Outcome was put on Testing.doc
 */
public class TesterIngredients {
	
	public static void main(String[] args) {
		data2();
		AP1();
		AP2();
		VI1();
		SIN();
		SIID();
		SIPN();
		SIC();
		SIFG();
		DIID();
		DIN();
		//DIPN();
		DIC();
		DIFG();
		
	}
	static Warehouse warehouse = new Warehouse();
	static Warehouse emptyChecker = new Warehouse();



	public static void display(ArrayList <Ingredient> collectionOfIngredients) {
		if(collectionOfIngredients.size() == 0 || collectionOfIngredients == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else{
			System.out.println("This is the list of Ingredients");
			for (int index = 0; index < collectionOfIngredients.size(); index++) {
				System.out.println("\t" + collectionOfIngredients.get(index).getName());
			}
		}
	}
	
	
	public static Ingredient testSearchByNameDisplay(ArrayList <Ingredient> collectionOfIngredients, String name) {
		if (collectionOfIngredients.size() == 0) {
			return emptyChecker.searchByName(name);
		}
		return warehouse.searchByName(name);		
	}
	
	
	
	public static Ingredient testSearchByIdDisplay(ArrayList <Ingredient> collectionOfIngredients, int id) {

		if (collectionOfIngredients.size() == 0) {
			return emptyChecker.searchById(id);
		}
		return warehouse.searchById(id);	
	}
	
	
	public static ArrayList <Ingredient> testSearchByPartName(ArrayList <Ingredient> collectionOfIngredients, String name) {
		if (collectionOfIngredients.size() == 0) {
			return emptyChecker.searchByPart(name);
		}
		return warehouse.searchByPart(name);	
	}
	
	public static ArrayList <Ingredient> testSearchByCalories(ArrayList <Ingredient> collectionOfIngredients, double calories) {
		if (collectionOfIngredients.size() == 0) {
			return emptyChecker.searchByCalories(calories);
		}
		return warehouse.searchByCalories(calories);
	}
	
	public static ArrayList <Ingredient> testSearchByFoodGroup(ArrayList <Ingredient> collectionOfIngredients, FoodGroup foodGroup) {
		if (collectionOfIngredients.size() == 0) {
			return emptyChecker.searchByFoodGroup(foodGroup);
		}
		return warehouse.searchByFoodGroup(foodGroup);
	}
	
	public static void testDeleteById(ArrayList <Ingredient> collectionOfIngredients, int id) {
		if(collectionOfIngredients.size() == 0 || collectionOfIngredients == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else {
			System.out.println("Before: ");
			System.out.println(warehouse.getIngredients() + "\n");
			warehouse.deleteIngredientByID(id);
			System.out.println("After: ");
			System.out.println("\n");
			System.out.println(warehouse.getIngredients() + "\n");
		}	
	}
	
	public static void testDeleteByName(ArrayList <Ingredient> collectionOfIngredients, String name) {
		if(collectionOfIngredients.size() == 0 || collectionOfIngredients == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else {
		System.out.println("Before: ");
		System.out.println(warehouse.getIngredients() + "\n");
		warehouse.deleteIngredientByName(name);
		System.out.println("After: ");
		System.out.println("\n");
		System.out.println(warehouse.getIngredients() + "\n");
		}
	}
	
	public static void testDeleteByCalories(ArrayList <Ingredient> collectionOfIngredients, double calories) {
		if(collectionOfIngredients.size() == 0 || collectionOfIngredients == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else {
		System.out.println("Before: ");
		System.out.println(warehouse.getIngredients() + "\n");
		warehouse.deleteByCalories(calories);
		System.out.println("After: ");
		System.out.println("\n");
		System.out.println(warehouse.getIngredients() + "\n");
		}
	}
	
	public static void testDeleteByFoodGroup(ArrayList <Ingredient> collectionOfIngredients, FoodGroup foodGroup) {
		if(collectionOfIngredients.size() == 0 || collectionOfIngredients == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else {
		System.out.println("Before: ");
		System.out.println(warehouse.getIngredients() + "\n");
		warehouse.deleteByFoodGroup(foodGroup);
		System.out.println("After: ");
		System.out.println("\n");
		System.out.println(warehouse.getIngredients() + "\n");
		}
	}
	/*
	 * Test cases testing the ingredient part of the section. 
	 * ADD, VIEW, VIEW SPECIFIC, REMOVE, MODIFY --> All these have been checked. 
	 */
	
	public static void AP1() {
		/*
		 * Identifying if we can add ingredients to the collection. 
		 * Identify whether the array list is able to cope with numerous ingredients. 
		 */
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		System.out.println("AP.1 - Testing if a new ingredient can  be added with valid data");
		
		System.out.println("Test Case 1 - Adding a new Ingredient");
		ArrayList <Ingredient> collectionOfIngredients = new ArrayList <Ingredient>();
		
		try {
			System.out.println("Initial Data :");
			display(collectionOfIngredients);
		}catch(Exception ex) {
			System.out.println("No ingrdients");
		}
		
		
		System.out.println("Inital data after new ingredient has been added: ");
		collectionOfIngredients.add(ingredient2);
		
		display(collectionOfIngredients);
		System.out.println("Inital data after adding two new Ingredients: ");
		collectionOfIngredients.add(ingredient3);
		display(collectionOfIngredients);
		System.out.println("End AP.1------\n");
	}
	
	public static void AP2() {
		/*
		 * Identifying if we can add ingredients to the collection. 
		 * Identify whether the array list is able to cope with numerous ingredients. 
		 */
		
		Ingredient ingredient = null;
		Ingredient ingredient2 = null;
		ArrayList <Ingredient>collection = new ArrayList<Ingredient>();
		collection.add(ingredient);
		collection.add(ingredient2);
		System.out.println("AP.2 - Testing if a new ingredient can  be added with invalid data");
	
		//ArrayList <Ingredient> collectionOfIngredients = new ArrayList<Ingredient>();
		try {
			System.out.println("AP.2 Initial Data :");
			display(collection);
		}catch (Exception e) {
			System.out.println("Cannot do this. ");
		}
		System.out.println("End AP.2------\n");
	
	}
	
	
	
	public static void VI1() {
		/*
		 * Identify, when viewing ingredients whether the data is shown in alphabetical order. 
		 * This partially tests the Insertion sort we have implemented. 
		 * The insertion sort testing has been done in utility Tester. 
		 */
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		ArrayList <Ingredient>collection = new ArrayList<Ingredient>();

		System.out.println("VI.1 - Viewing Collection of ingredients");
		
		//ArrayList <Ingredient> collectionOfIngredients = new ArrayList<Ingredient>();
		
		System.out.println("Initial Data :");
		display(collection);
		System.out.println("No ingredients");
		System.out.println("Viewing data after new ingredient has been added: ");
		collection.add(ingredient);
		
		display(collection);
		System.out.println("Viewing data after adding two new Ingredients: ");
		collection.add(ingredient2);
		display(collection);
		System.out.println("Viewing data after adding three new Ingredients: ");
		collection.add(ingredient3);
		
		display(collection);
	
		System.out.println("VI-------\n");
		
	}
	
	public static void SIN() {
		/*
		 * Will test the View specific ingredient section, where the search by name is evaluated. 
		 * Will identify whether the specific ingredient is able to be identified via it's name.
		 * Will add ingredients to the collection, and identify whether the Search for all ingredients are accurate
		 */
		
		//ArrayList<Ingredient> collectionOfIngredientToSelectFrom = data();
	
		System.out.println("SIN - Searching by name");

		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		System.out.println("SIN.1 Searching for name in Empty Collection: ");
		System.out.println(testSearchByNameDisplay(collection,"Apple") + "\n");
		System.out.println("SIN.2 Searching for name in Non Empty collection (First item): ");
		System.out.println(testSearchByNameDisplay(warehouse.getIngredients(), "Chicken") + "\n");
		System.out.println("SIN.2 Searching for name in Non Empty collection (Middle item): ");
		System.out.println(testSearchByNameDisplay(warehouse.getIngredients(), "Apple").toString() + "\n");
		System.out.println("SIN.2 Searching for name in Non Empty collection (Last item): ");
		System.out.println(testSearchByNameDisplay(warehouse.getIngredients(), "Banana").toString() + "\n");
		try {
			System.out.println("SIN.3 Searching for non exitent name in Non Empty collection: ");
			System.out.println(testSearchByNameDisplay(warehouse.getIngredients(), "NonExistent").toString() + "\n");
		}catch(Exception ex) {
			System.out.println("The data does not exist");
		}
		
		

		System.out.println("End SIN(1-3)-------\n");			
	}
	
	public static void SIID() {
		/*
		 * Will test the view Specific ingredient section, where the search by ID evaluated. 
		 * Will identify whether the specific ingredient is able to be identified via its ID.
		 */
		System.out.println("SIID - Searching by ID");

		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		System.out.println("SIID.1 Searching for ID in Empty Collection: ");
		System.out.println(testSearchByIdDisplay(collection, 1));
	
		System.out.println("SIID.2 Searching for ID in Non Empty collection (First item): ");
		
		System.out.println(testSearchByIdDisplay(warehouse.getIngredients(), 1) + "\n");
		System.out.println("SIID.2 Searching for ID in Non Empty collection (Middle item): ");
		System.out.println(testSearchByIdDisplay(warehouse.getIngredients(), 2) + "\n");
		System.out.println("SIID.2 Searching for ID in Non Empty collection (Last item): ");
		System.out.println(testSearchByIdDisplay(warehouse.getIngredients(), 3) + "\n");
		try {
			System.out.println("SIID.3 Searching for non exitent ID in Non Empty collection: ");
			System.out.println(testSearchByIdDisplay(warehouse.getIngredients(), 4) + "\n");
		}catch(Exception ex) {
			System.out.println("The data does not exist");
		}
		
		System.out.println("End SIID(1-3)-------\n");	
	}
	
	public static void SIPN() {
		/*
		 * Will test the view Specific ingredient section, where the search by part name is evaluated. 
		 * Will identify whether the specific ingredient is able to be identified via its part name.
		 */
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		System.out.println("SIPN - Searching by Part name");
		System.out.println("SIPN.1 Searching for part name in Empty Collection: ");
		System.out.println(testSearchByPartName(collection, "Ap") + "\n");

		System.out.println(" SIPN.2 Searching for part name Ap: ");
		System.out.println(testSearchByPartName(warehouse.getIngredients(), "Ap") + "\n");
		System.out.println("SIPN.2 Searching for part name Ch : ");
		
		System.out.println(testSearchByPartName(warehouse.getIngredients(), "Ch") + "\n");
		try {
			System.out.println("SIPN.3 Searching for non exitent part name: ");
			System.out.println(testSearchByPartName(warehouse.getIngredients(), "Io") + "\n");
		}catch(Exception ex) {
			System.out.println("The data does not exist");
		}
		
		System.out.println("End SIPM (1-3)-------\n");	
	}
	
	public static void SIC() {
		/*
		 * Will test the view Specific ingredient section, where the search by calories is evaluated. 
		 * Will identify whether the specific ingredient is able to be identified via its calories.
		 */
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		
		System.out.println("SIC - Searching by Calories");
		System.out.println("SIC.1 Searching for Ingredient with calories in Empty Collection: ");
		System.out.println(	testSearchByCalories(collection, 400) + "\n");	
		System.out.println("SIC.2 Searching for Ingredient with calories (First item): ");
		
		System.out.println(	testSearchByCalories(warehouse.getIngredients(), 400));
		System.out.println("SIC. 2 Searching for ingredients with similar calories : ");
		
		System.out.println(testSearchByCalories(warehouse.getIngredients(), 20) + "\n");
		try {
			System.out.println("SIC.3 Searching for non eixtent ingredient with specific calories: " + "\n");
			
			System.out.println(testSearchByCalories(warehouse.getIngredients(), 900) + "\n");
		}catch(Exception ex) {
			System.out.println("The data does not exist");
		}
		
		System.out.println("End SIC (1-3)-------\n");	
	}
	
	public static void SIFG() {
		/*
		 * Will test the view Specific ingredient section, where the search by food group is evaluated. 
		 * Will identify whether the specific ingredient is able to be identified via its food group.
		 */
		
		
		System.out.println("SIFG - Searching by Food Group");
		System.out.println("SIFG.1 Searching for Ingredient with Food Group in Empty Collection: ");
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		System.out.println(testSearchByFoodGroup(collection, FoodGroup.PROTEIN));

		System.out.println("No data!");

		
		System.out.println("SIFG.2 Searching for Ingredient with FoodGroup (First item): ");
		
		System.out.println(testSearchByFoodGroup(warehouse.getIngredients(), FoodGroup.PROTEIN) + "\n");
		System.out.println("SIFG.2 Searching for ingredients with similar Food Group : ");
		System.out.println(testSearchByFoodGroup(warehouse.getIngredients(), FoodGroup.FRUIT_VEG) + "\n");
		try {
			System.out.println("SIFG. 3Searching for non eixtent ingredient with specific Food Group: ");
			System.out.println(	testSearchByFoodGroup(warehouse.getIngredients(), FoodGroup.CEREAL) + "\n");
		}catch(Exception ex) {
			System.out.println("The data does not exist");
		}
		
		System.out.println("End SIFG(1-3)-------\n");	
	}
	
	public static void DIID() {
		/*
		 * Testing if we are able to delete by ID, and whether the ArrayList is able to respond to certain requirements.
		 * Test all possible scenarios and ensure that they all perform adequately.
		 */
		System.out.println("DIID - Deleting by ID");
		System.out.println("DIID.1 Deleting By ID in empty array: ");
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();
		testDeleteById(collection, 1);
		System.out.println("This is not valid as there is no data within");

		System.out.println("DIID.2 Deleting By ID (First item): ");
		
		testDeleteById(warehouse.getIngredients(), 1);
		System.out.println("DIID.2 Delete By ID (Second item) : ");
		testDeleteById(warehouse.getIngredients(), 2);
		System.out.println("DIID.2 Delete By ID (Third item) : ");
		testDeleteById(warehouse.getIngredients(), 3);
		System.out.println("DIID.3 Delete By ID non existent item: ");
		testDeleteById(warehouse.getIngredients(), 20);
		
		System.out.println("End DIID (1-3)-------\n");	
	}
	
	public static void DIN() {
		data2();
		/*
		 * Testing if we are able to delete by Name, and whether the ArrayList is able to respond to certain requirements.
		 * Test all possible scenarios and ensure that they all perform adequately.
		 */
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();

		System.out.println("DIN - Deleting by Name");
		System.out.println("DIN.1 Deleting By Name in empty array: ");
		testDeleteByName(collection, "Chicken");

		System.out.println("This is not valid");

		
		System.out.println("DIN.2 Deleting By Name (First item): ");
	
		testDeleteByName(warehouse.getIngredients(), "Chicken");
		System.out.println("DIN.2 Delete By Name (Second item) : ");
		testDeleteByName(warehouse.getIngredients(), "Apple");
		System.out.println("DIN.2 Delete By Name (Third item) : ");
		testDeleteByName(warehouse.getIngredients(), "Banana");
		System.out.println("DIN.3 Delete By Name non existent item: ");
		testDeleteByName(warehouse.getIngredients(), "Eggplant");
		
		System.out.println("End DIN(1-3)-------\n");	
	}

	public static void DIC() {
		data2();
		/*
		 * Testing if we are able to delete by calories, and whether the ArrayList is able to respond to certain requirements.
		 * Test all possible scenarios and ensure that they all perform adequately.
		 */
		
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();

		System.out.println("DIC - Deleting by Calories");
		System.out.println("DIC.1 Deleting By calories in empty array: ");
		testDeleteByCalories(collection, 400);

		System.out.println("This is not valid");

		System.out.println("DIC.2 Deleting By calories (First item): ");
		
		testDeleteByCalories(warehouse.getIngredients(), 400);
		System.out.println("DIC.2 Delete By calories (numerous items) : ");
		testDeleteByCalories(warehouse.getIngredients(), 20);
		System.out.println("DIC.3 Delete By Calories non existent item: ");
		testDeleteByCalories(warehouse.getIngredients(), 900);
		
		System.out.println("End DIC(1-3)-------\n");	
	}

	public static void DIFG() {
		data2();
		/*
		 * Testing if we are able to delete by food group, and whether the ArrayList is able to respond to certain requirements.
		 * Test all possible scenarios and ensure that they all perform adequately.
		 */
		ArrayList <Ingredient> collection = new ArrayList<Ingredient>();

		System.out.println("DIFG - Deleting by food group");
		System.out.println("DIFG.1 Deleting By food group in empty array: ");
		testDeleteByFoodGroup(collection, FoodGroup.PROTEIN);

		System.out.println("This is not valid");

		System.out.println("DIFG.2 Deleting By calories (First item): ");

		testDeleteByFoodGroup(warehouse.getIngredients(), FoodGroup.PROTEIN);
		System.out.println("DIFG.2 Delete By food group (numerous items) : ");
		testDeleteByFoodGroup(warehouse.getIngredients(), FoodGroup.FRUIT_VEG);
		System.out.println("DIFG. 3Delete By food group non existent item: ");
		testDeleteByFoodGroup(warehouse.getIngredients(), FoodGroup.CEREAL);
		
		System.out.println("End DIFG(1-3)-------\n");	
	}
	
	
	/**
	 * This method is to add ingredients into the collection. This is to enable necessary testing, and reduce code duplication.
	 * @return --> Returns the collection of ingredients.
	 */
	private static ArrayList<Ingredient> data() {
		
		ArrayList<Ingredient>collectionOfIngredient = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		collectionOfIngredient.add(ingredient);
		collectionOfIngredient.add(ingredient2);
		collectionOfIngredient.add(ingredient3);
		return collectionOfIngredient;
	}
	/**
	 * Adds the ingredients into the warehouse , this is necessary for testing requirements. 
	 */
	private static void data2() {
		
		
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		warehouse.addIngredients(ingredient);
		warehouse.addIngredients(ingredient2);
		warehouse.addIngredients(ingredient3);
	}
	
}


