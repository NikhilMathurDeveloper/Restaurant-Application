package part02;
import java.util.ArrayList;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * This class is to test the utility classes implementation. Mostly make sure that the alphabetical sorting is accurate. 
 * The test cases are detailed on the copyOfTestingTemplate.xls
 * The outcomes of the test cases are detailed on Testing.doc
 */

import part01.FoodGroup;
import part01.Ingredient;
import part01.Recipe;
import part01.Utility;
public class TestUtilityUnit {
	
	static Utility usageUtility = new Utility();
	
	static ArrayList<Recipe>recipeCollection = creatingRecipeCollection();
	static ArrayList<Recipe>nullCollection = creatingRecipeCollectionNull();
	static ArrayList<Ingredient>ingredientCollection = createIngredients();
	static ArrayList<Ingredient>ingredientNullCollection = createIngredientCollectionNull();
	public static void main(String args[]) {
		SRT1();
		SRT2();
		SRT3();
		SIT1();
		SIT2();
		SIT3();
	}
	public static void SRT1() {
		System.out.println("SRT.1 Testing if we can sort recipes.");
		System.out.println("Normal data: ");
		getNamesOfRecipesinCollection(recipeCollection);
		System.out.println("Sorted data: ");
		getNamesOfRecipesinCollection(usageUtility.sort2(creatingRecipeCollection()));
	
		System.out.println("End SRT.1 -------\n");
	}
	
	public static void SRT2() {
		System.out.println("SRT.2 Testing if we can sort recipes which are null.");
		System.out.println("Normal data: ");
		getNamesOfRecipesinCollection(recipeCollection);
		System.out.println("Sorted data: ");
		getNamesOfRecipesinCollection(usageUtility.sort2(nullCollection));
		System.out.println("End SRT.2 -------\n");
	}
	
	public static void SRT3() {
		System.out.println("SRT.3 Testing if we can sort recipes which are Empty.");
		System.out.println("Normal data: ");
		getNamesOfRecipesinCollection(recipeCollection);
		System.out.println("Sorted data: ");
		ArrayList <Recipe> empty = new ArrayList<Recipe>();
		getNamesOfRecipesinCollection(usageUtility.sort2(empty));
		System.out.println("End SRT.3 -------\n");
	}
	
	public static void SIT1() {
		System.out.println("SIT.1 Testing if we can sort ingredients.");
		System.out.println("Normal data: ");
		getNamesOfingredients(ingredientCollection);
		System.out.println("Sorted data: ");
		getNamesOfingredients(usageUtility.sort(ingredientCollection));
		System.out.println("END SIT.1 --------\n");
		
	}
	
	public static void SIT2() {
		System.out.println("SIT.2 Testing if we can sort ingredients which are null.");
		System.out.println("Normal data: ");
		getNamesOfingredients(ingredientCollection);
		System.out.println("Sorted data: ");
		getNamesOfingredients(usageUtility.sort(ingredientNullCollection));
		System.out.println("END SIT.2 --------\n");
	}
	
	public static void SIT3() {
		System.out.println("SIT.3 Testing if we can sort ingredients which are empty.");
		System.out.println("Normal data: ");
		getNamesOfingredients(ingredientCollection);
		System.out.println("Sorted data: ");
		ArrayList<Ingredient>emptyCollection = new ArrayList<Ingredient>();
		getNamesOfingredients(usageUtility.sort(emptyCollection));
		System.out.println("END SIT.3 --------\n");
	}
	
	
	private static void getNamesOfRecipesinCollection(ArrayList<Recipe>collectionOfRecipes){
		if (collectionOfRecipes != null && collectionOfRecipes.size() != 0) {
			for (int index = 0; index < collectionOfRecipes.size(); index++) {
				if (collectionOfRecipes.get(index) == null) {
					//System.out.println(collectionOfRecipes.get(index).getName());
				}else {
					System.out.println(collectionOfRecipes.get(index).getName());
					
				}
				
			}
		}else {
			System.out.println("Data isn't valid!");
		}
	}
	private static void getNamesOfingredients(ArrayList<Ingredient>collectionOfIngredients) {
		if (collectionOfIngredients != null && collectionOfIngredients.size() != 0) {
			for (int index = 0; index < collectionOfIngredients.size(); index++) {
				if (collectionOfIngredients.get(index) == null) {
					
				}else {
					System.out.println(collectionOfIngredients.get(index).getName());
				}
			}
		}else {
			System.out.println("Data isnt valid! ");
		}
	}
	private static ArrayList<Recipe> creatingRecipeCollection() {
		ArrayList<Recipe> collectionOfRecipes  = new ArrayList<Recipe>();
		Recipe recipeOne = new Recipe("Deep Dish Pizza", createIngredients(), 2);
		Recipe recipeTwo = new Recipe("Cupcake", createIngredients(), 1);
		Recipe recipeThree = new Recipe("ButterScoth", createIngredients(), 2);
		Recipe recipeFour = new Recipe("Apple pie", createIngredients(), 2);
		collectionOfRecipes.add(recipeOne);
		collectionOfRecipes.add(recipeTwo);
		collectionOfRecipes.add(recipeThree);
		collectionOfRecipes.add(recipeFour);
		return collectionOfRecipes;
	}
	private static ArrayList<Recipe> creatingRecipeCollectionNull(){
		ArrayList<Recipe> collectionOfRecipes  = new ArrayList<Recipe>();
		Recipe recipeOne = null;
		Recipe recipeTwo = null;
		Recipe recipeThree = null;
		Recipe recipeFour = null;
		collectionOfRecipes.add(recipeOne);
		collectionOfRecipes.add(recipeTwo);
		collectionOfRecipes.add(recipeThree);
		collectionOfRecipes.add(recipeFour);
		return collectionOfRecipes;
	}
	
	private static ArrayList<Ingredient> createIngredientCollectionNull(){
		ArrayList<Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient3 = null;
		Ingredient ingredient2 = null;
		Ingredient ingredient1 = null;
		collectionOfIngredients.add(ingredient3);
		collectionOfIngredients.add(ingredient2);
		collectionOfIngredients.add(ingredient1);
		return collectionOfIngredients;
	}
	
	private static ArrayList<Ingredient> createIngredients() {
		ArrayList<Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient3 = new Ingredient("Chicken", FoodGroup.PROTEIN, 200);
		Ingredient ingredient2 = new Ingredient("Bread", FoodGroup.SUGAR, 100);
		Ingredient ingredient1 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 42);
		collectionOfIngredients.add(ingredient3);
		collectionOfIngredients.add(ingredient2);
		collectionOfIngredients.add(ingredient1);
		return collectionOfIngredients;
		
		
	
	}
}
