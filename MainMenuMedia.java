package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import console.Console;
import part01.Day;
import part01.Menu;
import part01.Recipe;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * To deal with the creation of the menu, the viewing of the menu and the modification of the Menu. 
 * All functionality is controlled via the methods defined in this class. 
 */
public class MainMenuMedia {
	
	private static final Font f1 = new Font("Courier", Font.BOLD, 30);
	private void createMenu(String list[],Console con) {
		int x = 1;
		if (list != null) {
			for (int index = 0; index < list.length; index++) {
				con.println(x+ "." + list[index]);
				x++;
			}
		}
	}
	
	private static Console setup1(int width, int height, int xPos, int yPos, boolean isInput) {
		Console con = new Console(isInput);
		con.setSize(width, height);
		con.setVisible(true);
		con.setLocation(xPos, yPos);
		con.setFont(f1);
		con.setColour(Color.WHITE);
		con.setBgColour(Color.BLACK);
		return con;
		//Console c1 = setup1(600,600,100,100,true);
	}
	
	private static void consoleSetUp(Console con) {
		con.setSize(1000,1000);
		con.setFont(new Font("Courier",Font.BOLD,30));
		con.setColour(Color.blue);
		con.setVisible(true);	
	}
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
	public MainMenuMedia() {
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
	public void createMenuMedia(ArrayList <Recipe> recipes ) {
		Console con = setup1(600,600,100,100,true);
		if (recipes != null && recipes.size() != 0) {
			
			int flag = 0;//Flag initialized, and used for while loop condition. 
			int length = Day.values().length;//The loop condition, this equates to the number of days in a week. 
			while (flag!= length) { //Loop which checks against flag and length.  (Run 7 times)
				for (int index = 0; index < choices.length; index++) {
					
					consoleSetUp(con);
					ArrayList <Recipe> collectionOfrecipesForday = new ArrayList<Recipe>(); //Used to store the recipes chosen by the user. 
					con.println("Please enter the Recipe ID for: " + " " + choices[index].toString());
					int flag2= 0; //Flag used within while loop.
					while (flag2 != 3) { //Loop iterates 3 times. 
						consoleSetUp(con);
						con.println("Choice: " + (flag2+1));
						int value3 = Integer.valueOf(con.readLn()); //User enters the ID of the recipe.
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
			consoleSetUp(con);
			con.println("This is not valid!");
		}
		
		
	}
	
	/**
	 * This view menu method will display the Menu of a specific week, where all 7 days are shown and their associated 3 recipes per day.
	 */
	
	public void viewMenuMedia() {
		Console con = setup1(600,600,100,100,true);
		if (collectionOfRecipe.size() != 0 || collectionOfRecipe != null) {
			for (int index = 0; index < choices2.length; index++) { //Iterates through the the number of days
				consoleSetUp(con);
				con.setTitle("Menu" + getId());
				con.println("ID Menu: " + getId());
				con.println("Day: " + choices2[index]);
				for (int index2 = 0; index2 < collectionOfRecipe.size(); index2++) { //Iterates through the 2D array list
					if (index2 == index) { //Identifies the relevant recipes for the specific day in the week.
						for (int j = 0; j < collectionOfRecipe.get(index2).size(); j++) {//Iterates through that days specific recipes selected.
							con.println(collectionOfRecipe.get(index2).get(j).getName());//Displays the recipes to the user. 
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
	public void modifyMenuMedia(ArrayList <Recipe> recipesAvailable) {
		Console con = setup1(600,600,100,100,true);
		con.println("Please enter the day of you would like to change: ");
		Menu newMenu = new Menu("Day", choices2);
		int choice = Integer.valueOf(con.readLn()); //The user selects the day they are interested in modifying. 
		int newChoice = choice-1;
		for (int index = 0; index < collectionOfRecipe.size(); index++) {//The 2D array list is iterated through.
			if ((index) == newChoice) {
				consoleSetUp(con);
				con.println("Please enter the option of the Day: ");
				int choice2 = Integer.valueOf(con.readLn()); //For that day they select which recipe they would like to replace. 
	
				for (int index2 = 0; index2 < collectionOfRecipe.get(index).size(); index2++) {//The specific array list within the 2D array list is iterated through.
					int newChoice2 = choice2-1;
					if (index2 == (newChoice2)) { //Checks if the recipe selection is equal to the users selection.
						consoleSetUp(con);
						con.println("Please enter id of new recipe: ");
						int id = Integer.valueOf(con.readLn()); //The new recipe is selected.
			
						ArrayList <Recipe> collectionOfChoice = collectionOfRecipe.get(index);
						
						
						Recipe recipeToChange = collectionOfChoice.get(index2);
						 //The system removes the current recipe in place
						for (int index3 = 0; index3 < recipesAvailable.size(); index3++) {
							if (id == recipesAvailable.get(index3).getId()) {
								collectionOfChoice.remove(index2);//Locates the new recipe indented to be added
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
