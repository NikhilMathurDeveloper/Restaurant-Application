package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Ingredient;
import part01.MainMenu;
import part01.Recipe;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * To testing if the Menu part of the system is adequate, and whether the necessary requirements are functional or not. 
 * Test cases are explained on CopyOfTestingTemplate.xls
 * Outcomes were recorded on Testing.DOC.
 */
public class TesterMainMenuIntegration {
	
	public static void CT1() {
		System.out.println("CT.1 - Testing if we can create a main menu object");
		try {
			MainMenu mainMenu = new MainMenu();
			if (mainMenu != null) {
				System.out.println("Object created");
			}
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object");
		}	
		System.out.println("End CT.1------\n");
	}
	public static void CM1() {
		System.out.println("CM.1 - Testing if we can create a main menu object");

		try {
			MainMenu mainMenu = new MainMenu();
			mainMenu.createMenu(createRecipes());
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object");
		}	
		System.out.println("End CM.1------\n");
	}
	public static void CM2() {
		System.out.println("CM.2 - Testing if we can create a main menu object");

		try {
			MainMenu mainMenu = new MainMenu();
			mainMenu.createMenu(createRecipes2());
		}catch (Exception Ex){
			System.out.println("There has been an error with creating the object");
		}	
		System.out.println("End CM.2------\n");
	}
	
	public static void VM1() {
		System.out.println("VM.1 - Testing if we can view all main menu's");

		try {
			MainMenu mainMenu = new MainMenu();
			mainMenu.viewMenu();
		}catch (Exception Ex){
			System.out.println("There has been an error viewing the menu's");
		}	
		System.out.println("End VM.1------\n");
	}
	
	public static void VM2() {
		System.out.println("VM.2 - Testing if we can view all main menu's");
		try {
			MainMenu mainMenu = new MainMenu();
			mainMenu.viewMenu();
		}catch (Exception Ex){
			System.out.println("There has been an error with viewing the menu's");
		}	
		System.out.println("End VM.2------\n");
	}
	
	
	


	
	private static ArrayList <Recipe> createRecipes() {
		ArrayList<Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList<Recipe>recipesAvailable = new ArrayList<Recipe>();
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		collectionOfIngredients.add(ingredient);
		collectionOfIngredients.add(ingredient2);
		collectionOfIngredients.add(ingredient3);
		Recipe newRecipe1 = new Recipe("Recipe1", collectionOfIngredients, 4);
		Recipe newRecipe2 = new Recipe("Recipe2", collectionOfIngredients, 5);
		Recipe newRecipe3 = new Recipe("Recipe3", collectionOfIngredients, 6);
		recipesAvailable.add(newRecipe1);
		recipesAvailable.add(newRecipe2);
		recipesAvailable.add(newRecipe3);
		return recipesAvailable;
	
	}
	
	private static ArrayList <Recipe> createRecipes2() {
		ArrayList<Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList<Recipe>recipesAvailable = new ArrayList<Recipe>();
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);
		Ingredient ingredient3 = new Ingredient("Banana",FoodGroup.FRUIT_VEG,20);
		collectionOfIngredients.add(ingredient);
		collectionOfIngredients.add(ingredient2);
		collectionOfIngredients.add(ingredient3);
		Recipe newRecipe1 = null;
		Recipe newRecipe2 = null;
		Recipe newRecipe3 = null;
		recipesAvailable.add(newRecipe1);
		recipesAvailable.add(newRecipe2);
		recipesAvailable.add(newRecipe3);
		return recipesAvailable;
	
	}
}
