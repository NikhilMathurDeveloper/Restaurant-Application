package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Ingredient;
import part01.MainMenu;
import part01.MenuCollection;
import part01.Recipe;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * To test if the functionalities of the Menu are accurate, and whether necessary requirements are functional or not.
 * The Test cases were explained in copyOfTestingTemplate.xls
 * Outcomes of test cases were recorded in Testing.DOC.
 */
public class TesterMenu {
	
	public static void main(String args[]) {
		data2();
		CT();
		CM1();
		VM1();
		MM1();
		CM2();
	
		VM2();
	}
	static ArrayList<Recipe>collectionOfRecipe = new ArrayList<Recipe>();
	
	
	public static void display(ArrayList <MenuCollection> menuCollection) {
		if(menuCollection.size() == 0 || menuCollection == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else{
			System.out.println("This is the list of Ingredients");
			for (int index = 0; index < menuCollection.size(); index++) {
				System.out.println("\t" +menuCollection);
			}
		}
	}
	static MainMenu newMenu = new MainMenu();
	
	
	public static void CT() {
		System.out.println("CT.1 - Testing if we can instantiate a Main Menu object");
		MainMenu newMenu = new MainMenu();
		if (newMenu != null) {
			System.out.println("The object was created sucessfully! ");
		}else {
			System.out.println("There has been an error with creating the object");
		}
		System.out.println("END CT.1-------\n");
	}
	
	public static void CM1() {
		System.out.println("CM.1 - Testing if we can create a valid menu with user entered data! ");
		newMenu.createMenu(collectionOfRecipe);
		//newMenu.viewMenu();
		System.out.println("END CM.1-------\n");
	}
	
	public static void VM1() {
		System.out.println("VM.1 - Testing if we can view the valid menu! ");
		newMenu.viewMenu();
		System.out.println("END VM.1-------\n");
	}
	
	public static void MM1() {
		System.out.println("MM.1 - Testing if we can modify the valid menu! ");
		newMenu.modifyMenu(collectionOfRecipe);
		newMenu.viewMenu();
		System.out.println("END MM.1 ----\n");
	}
	public static void CM2() {
		System.out.println("CM.2 - Testing if we can create a valid menu with user entered data! ");
		newMenu.createMenu(null);
		//newMenu.viewMenu();
		System.out.println("END CM.2-------\n");
	}
	public static void VM2() {
		System.out.println("VM.2 - Testing if we can view the invalid menu! ");
		newMenu.viewMenu();
		System.out.println("END VM.2-------\n");
	}
	
	
	
	
	private static void data2() {
		
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
	

		collectionOfIngredients.add(ingredient);
		collectionOfIngredients.add(ingredient2);
		Recipe recipe = new Recipe("Bolognese Paste", collectionOfIngredients,2);
		Recipe recipe2 = new Recipe("Apple Crumble", collectionOfIngredients,1);
		Recipe recipe3 = new Recipe("Apple Banana", collectionOfIngredients,2);
		collectionOfRecipe.add(recipe);
		collectionOfRecipe.add(recipe2);
		collectionOfRecipe.add(recipe3);

	}
	
	
}
