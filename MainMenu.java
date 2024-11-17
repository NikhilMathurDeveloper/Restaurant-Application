package part01;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * The purpose of this class is to provide a blue print in regards to creating a weekly menu. This means 7 days of the week
 */
public class MainMenu {
	
	private Day dayOfTheWeek; //Day of the week to specify which day the specific menu day accommodates. 
	private Scanner input; //Scanner to receive input from the user.
	private Day choices[] = {Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY}; //Array holding all days possible (Specified via enum access). 
	private String choices2[] = {Day.MONDAY.toString(), Day.TUESDAY.toString(), Day.WEDNESDAY.toString(), Day.THURSDAY.toString(), Day.FRIDAY.toString(), Day.SATURDAY.toString(), Day.SUNDAY.toString()}; //A string version of the array holding all Day of the week enumerations . 
	ArrayList <ArrayList <Recipe>> collectionOfRecipe; //A 2D array list, which holds separate collection of recipes. 
	private int id; //ID used to uniquely identify each Menu created, 
	private static int nextNumberinSequence = 1; //Used to initialize ID. 
	
	/**
	 * Constructor used to initialize the ID, the input, and 2D array list. 
	 */
	public MainMenu() {
		this.id = this.nextNumberinSequence;
		this.nextNumberinSequence++;
		this.input = new Scanner(System.in);
		this.collectionOfRecipe = new ArrayList<ArrayList <Recipe>>();
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList <ArrayList <Recipe>> getCollectionOfRecipe() {
		return this.collectionOfRecipe;
	}
	
	
	/**
	 * The purpose of this method is to create a menu containing 3 recipes per day.
	 * @param recipes --> Takes the collection of recipes already existent within the system as a parameter. 
	 * --> This is used to provide the user with a selection of recipes which they could select as one of their 3 choices in a specific day.
	 */
	public void createMenu(ArrayList <Recipe> recipes ) {
		if (recipes != null && recipes.size() != 0) {
			int flag = 0;//Flag initialized, and used for while loop condition. 
			int length = Day.values().length;//The loop condition, this equates to the number of days in a week. 
			while (flag!= length) { //Loop which checks against flag and length.  (Run 7 times)
				for (int index = 0; index < choices.length; index++) {
					ArrayList <Recipe> collectionOfrecipesForday = new ArrayList<Recipe>(); //Used to store the recipes chosen by the user. 
					System.out.println("Please enter the Recipe ID for: " + " " + choices[index].toString());
					int flag2= 0; //Flag used within while loop.
					while (flag2 != 3) { //Loop iterates 3 times. 
						System.out.println("Choice: " + (flag2+1));
						int value3 = input.nextInt(); //User enters the ID of the recipe.
						for (int index2 = 0; index2 < recipes.size(); index2++) {
							
							if (recipes.get(index2).getId() == value3) { //The recipes parameter is iterated through where each recipes ID is received and checked against the users entered data.
								//arrayOfRecipes[y] = recipes.get(index2);
								collectionOfrecipesForday.add(recipes.get(index2));	 //If the ID is existent (associated ingredient) the array list will store the recipes address reference. 
							}
						}
						
						flag2++;
					}
				
					collectionOfRecipe.add(index,collectionOfrecipesForday);//The 2D array list will store the new array list, with the three recipes associated with the day. 
					flag++;	
				}
			}
			
		}else {
			
			System.out.println("This is not valid!");
		}
		
		
	}
	
	/**
	 * This view menu method will display the Menu of a specific week, where all 7 days are shown and their associated 3 recipes per day.
	 */
	
	public void viewMenu() {
		if (collectionOfRecipe.size() != 0 || collectionOfRecipe != null) {
			for (int index = 0; index < choices2.length; index++) { //Iterates through the the number of days
				System.out.println("Day: " + choices2[index]);
				for (int index2 = 0; index2 < collectionOfRecipe.size(); index2++) { //Iterates through the 2D array list
					if (index2 == index) { //Identifies the relevant recipes for the specific day in the week.
						for (int j = 0; j < collectionOfRecipe.get(index2).size(); j++) {//Iterates through that days specific recipes selected.
							System.out.println(collectionOfRecipe.get(index2).get(j).getName());//Displays the recipes to the user. 
						}
					}
				}
			}
		}	
	}
	
	/**
	 * The purpose of this method is to allow users to modify the menu, by selecting a day and replacing one the three choices with a new recipe. 
	 * @param recipesAvailable --> This method takes the recipes already available within the system
	 * Allowing the user to replace choices if needed. 
	 */
	public void modifyMenu(ArrayList <Recipe> recipesAvailable) {
		System.out.println("Please enter the day of you would like to change: ");
		Menu newMenu = new Menu("Day", choices2);
		int choice = newMenu.getChoice(); //The user selects the day they are interested in modifying. 
		
		for (int index = 0; index < collectionOfRecipe.size(); index++) {//The 2D array list is iterated through.
			if ((index) == (choice-1)) {
				System.out.println("Please enter the option of the Day: ");
				int choice2 = input.nextInt(); //For that day they select which recipe they would like to replace. 
				input.nextLine();
				for (int index2 = 0; index2 < collectionOfRecipe.get(index).size(); index2++) {//The specific array list within the 2D array list is iterated through.
					
					if ((index2) == (choice2-1)) { //Checks if the recipe selection is equal to the users selection.
						
						System.out.println("Please enter id of new recipe: ");
						int id = input.nextInt(); //The new recipe is selected.
						input.nextLine();
						ArrayList <Recipe> collectionOfChoice = collectionOfRecipe.get(index);
						
						
						Recipe recipeToChange = collectionOfChoice.get(index2);
						collectionOfChoice.remove(index2);
						 //The system removes the current recipe in place
						
						for (int index3 = 0; index3 < recipesAvailable.size(); index3++) {
							if ((id) == (recipesAvailable.get(index3).getId())) {
								
								//Locates the new recipe indented to be added
								collectionOfChoice.add(index2, recipesAvailable.get(index3));
								//Adds the new recipe into the correct position. 
							}
						}
						collectionOfRecipe.add(index, collectionOfChoice);//Re adds the collection into the 2D array list. 	
					}
					
					
				}
				
			}
			
		}
	}

}
