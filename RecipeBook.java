package part01;

import java.util.ArrayList;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * The purpose of this class is to hold the different recipe instantiations. This is to simplify down the application class,
 * by ensuring that all storage requirements are conducted in a more safer and structured manner. 
 */

public class RecipeBook {
	
	protected ArrayList<Recipe> collectionOfRecipes; //An array list to hold all the different recipe instantiations. 

	/**
	 * An array list for storing recipes has been declared in the constructor where now recipes can instantiations can be added.
	 */
	public RecipeBook() {
		this.collectionOfRecipes = new ArrayList<Recipe>();

	}
	
	/**
	 * This method focuses on adding new recipe object references to the array list. 
	 * @param newRecipe --> This declares a new recipe object reference which is to be added to the collection.
	 * @return --> returns true or false depending on whether the processes have occurred smoothly. 
	 */
	public boolean addRecipe(Recipe newRecipe) {
		if (newRecipe != null) {
			collectionOfRecipes.add(newRecipe);
			return true;
		}
		return false;
	}

	/**
	 * This method is to perform a search with a relevant ID to identify a associated recipe. 
	 * @param id --> The ID of a recipe which is to be searched for. 
	 * @return --> Returns the relevant recipe. 
	 */
	
	public Recipe searchById(int id) {
		if (id > 0 || collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				for (int index = 0; index < collectionOfRecipes.size(); index++) {//The recipes are iterated through.
					Recipe recipe = collectionOfRecipes.get(index);
					if (recipe.getId() == id) {//The recipes id's are checked against the one declared in the parameters. 
						return recipe;//If successful the recipe is returned. 
					}
				}
			}catch(Exception e) {
				System.out.println("The ID is inadequate.");
			}
			
		}
		return null;
	}
	/**
	 * This method is to perform a search with a relevant name to identify a associated recipe. 
	 * @param name --> The Name of a recipe which is to be searched for. 
	 * @return --> Returns the relevant recipe if found. 
	 */

	public Recipe searchByName(String name) {
		if (name != null|| collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				for (int index = 0; index < collectionOfRecipes.size(); index++) {//Iterates through all recipes. 
					Recipe recipe = collectionOfRecipes.get(index);
					if (recipe.getName().equals(name)) { //Identifies if the name equals to one of the recipes name.
						return recipe;//if Successful then the recipe is returned.
					}
				}	
			}catch(Exception e) {
				System.out.println("The name is inadequate!");			}
				
		}
		return null;
	}
	/**
	 * This method is to perform a search with a relevant part name to identify a associated recipe. 
	 * @param name --> This is the part name which is to be searched for.
	 * @return --> Returns the recipe's associated with the part name. 
	 */
	
	public ArrayList <Recipe> searchByPart(String name) {
		if (name != null||collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				ArrayList <Recipe> result = new ArrayList<Recipe>();//A array list used to store the recipes associated with the part name. 
				for (int index = 0; index < collectionOfRecipes.size(); index++) {//An iteration through the collection of recipes. 
					Recipe recipe = collectionOfRecipes.get(index);
					if (recipe.getName().contains(name)) {//Identifies if the name contains the part name specified. 
						result.add(recipe);	//If yes the array list is appended to/
					}
				}
				return result; //Array list returned. 	
			}catch(Exception e) {
				System.out.println("This is not valid!");
			}
			
		}
		return null;
	}
	
	
	/**
	 * This method is to perform a deletion based on a recipes ID. 
	 * @param id --> The recipes ID which is to be deleted. 
	 * @return --> Returns true or false depending on whether the process has gone down smoothly. 
	 */
	public boolean deleteById(int id) {
		if (id > 0||collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				Recipe recipe = searchById(id); //Recipe is searched for via its ID.
				if (recipe != null) { //If the recipe exists remove the recipe.
					collectionOfRecipes.remove(recipe);
					return true;
				}
			}catch(Exception e) {
				System.out.println("This is not valid! ");
			}
		}
		return false;
	}
	/**
	 * This method is to perform a deletion based on a recipes name.
	 * @param name --> The recipes name which is to be deleted. 
	 * @return --> Returns true or false depending on whether the process has gone smoothly. 
	 */
	public boolean deleteByName(String name) {
		if (name != null||collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				Recipe recipe = searchByName(name); //Recipe searched for via its name.
				if (recipe != null) {//if the recipe exists remove the recipe.
					collectionOfRecipes.remove(recipe); 
					return true;
				}	
			}catch(Exception e) {
				System.out.println("This is not valid !");
			}
			
		}
		return false;
	}
	
	/**
	 * This method is to perform a deletion via a recipes part name.
	 * @param name
	 * @return
	 */
	public boolean deleteByPartName(String name) {
		if (name != null||collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			try {
				ArrayList <Recipe>recipes = searchByPart(name); //An array list used to store all recipes related to a particular part name.
				if (recipes != null && recipes.size() != 0) {
					for (int index = 0; index < recipes.size(); index++) {
						collectionOfRecipes.remove(recipes.get(index)); //Removes all recipes which are stored within the array list. 
						return true;
					}
				}
			}catch(Exception e) {
				System.out.println("This is not valid!");
			}
			
		}
		return false;
	}
	
	/**
	 * This method is to calculate a recipes calories, based on the recipes ID.
	 * @param id --> The recipes ID 
	 * @return
	 */
	
	public double calculateTotalCalories(int id) {
		if (id != 0||collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			Recipe recipe = searchById(id); //The recipe is searched for. 
			if (recipe != null) {//if the recipe exists, the recipe total calories is returned. 
				
				return recipe.calculateAllCalories(); //The total calories are returned. 
			}
		}
		return 0;
	
	}
	
	
	
	/**
	 * This method is used to view all recipes within the recipes collection. 
	 * The Recipes name is identified, and its associated method is also show-cased.
	 */

	public void viewRecipes() {
		if (collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			for (int index = 0; index < collectionOfRecipes.size() ; index++) {//An iteration through the collection of recipes. 
				System.out.println(collectionOfRecipes.get(index).toString()); //The collection of recipes name is displayed.
				collectionOfRecipes.get(index).viewMethod(); //The recipes "method for recipe" is displayed. 
			}
		}
	}
	/**
	 * This method identifies if the recipe already exists within the collection. This is to avoid any duplications.
	 * @param name --> The name of the recipe to identify if the recipe already exists. 
	 * @return --> Return true or false depending on whether exists or not. 
	 */
	
	public boolean alreadyExists(String name) {
		if (collectionOfRecipes != null || collectionOfRecipes.size() != 0) {
			Recipe recipe = searchByName(name); //A search for the recipe by name is conducted. 
			if (recipe == null) { //If null that means that the recipe does not exist. 
				return true;
			}
		}
		return false; //However, if false then the recipe does exist. 
	}	
	
	public ArrayList<Recipe>getRecipes(){
		return collectionOfRecipes;
	}
	
	
}
