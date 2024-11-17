package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import console.Console;
import part01.FoodGroup;
import part01.Ingredient;
import part01.Menu;
import part01.Utility;
import part01.Warehouse;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * Responsible for dealing with the application class for the ingredient section. 
 * All functionalities associated with the ingredients is associated within this class. 
 * This is to help simplify the application class by reducing congestion, increasing safety by partially hiding source code.
 * Also by simplifying the representation of the class and increase understandability. 
 */
public class UtilityIngredientForMedia {
	private static Scanner input;  //Scanner for user input requirements.
	protected static Warehouse warehouse; //Baseline warehouse instantiation.
	static Utility newUtility = new Utility(); //New utility object instantiated.
	private static final Font f1 = new Font("Courier", Font.BOLD, 30);
	/**
	 * Within this constructor the scanner is instantiated.
	 * A warehouse object is also instantiated. 
	 */
	public UtilityIngredientForMedia() {
		this.input = new Scanner(System.in);
		this.warehouse = new Warehouse();
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
	
	private static void createMenu(String list[],Console con) {
		int x = 1;
		if (list != null) {
			for (int index = 0; index < list.length; index++) {
				con.println(x+ ". " + list[index]);
				x++;
			}
			
		}
		
	}
	private static void consoleSetUp(Console con) {
		con.setSize(1000,1000);
		con.setFont(new Font("Courier",Font.BOLD,30));
		con.setColour(Color.blue);
		con.setVisible(true);	
	}
	public static void addDefaultMedia() {
		warehouse.addIngredientsDefault();
	}
	
	
	/**
	 * This method is used to add ingredients into the warehouse collection.
	 */
	public void addIngredientsInMedia() {
		Console con = setup1(600,600,100,100,true);
		consoleSetUp(con);
		con.println("Please enter the name of the Ingredient: ");
		
		String name = con.readLn(); //The name of the ingredient is inputed by the end user. 
		if (warehouse.alreadyExists(name) == true) {
			consoleSetUp(con);//The name is checked if it already exists. 
			con.println("Please enter the food group: "); //The food group is selected by the user. 
			String options[] = {FoodGroup.FRUIT_VEG.toString(), FoodGroup.COMPOSITE_FOOD.toString(), FoodGroup.DAIRY.toString(), FoodGroup.CEREAL.toString(), FoodGroup.PROTEIN.toString(), FoodGroup.SUGAR.toString(), FoodGroup.FAT.toString(), FoodGroup.SPICE_HERB.toString(), FoodGroup.ESSENTIAL_NUTRIENT.toString()};
			createMenu(options,con); //A menu object is instantiated and used to display options.
			int choice = Integer.valueOf(con.readLn());
			FoodGroup foodGroupSelected = FoodGroup.ESSENTIAL_NUTRIENT;
			switch(choice) {//According to the selection the food group for the ingredient is decided accordingly.
			case 1:
				foodGroupSelected = FoodGroup.FRUIT_VEG; 
				break;
			case 2:
				foodGroupSelected = FoodGroup.COMPOSITE_FOOD;
				break;
			case 3:
				foodGroupSelected = FoodGroup.DAIRY;
				break;
			case 4:
				foodGroupSelected = FoodGroup.CEREAL;
				break;
			case 5:
				foodGroupSelected = FoodGroup.PROTEIN;
				break;
			case 6:
				foodGroupSelected = FoodGroup.SUGAR;
				break;
			case 7:
				foodGroupSelected = FoodGroup.FAT;
				break;
			case 8:
				foodGroupSelected = FoodGroup.SPICE_HERB;
				break;
			case 9:
				foodGroupSelected = FoodGroup.ESSENTIAL_NUTRIENT;
				break;
			case 10:
				foodGroupSelected = FoodGroup.UNDEFINED;
				break;
			}
			
			con.println("Enter the amount of calories: ");
			double calories = Double.valueOf(con.readLn()); //The amount of calories is specified by the user. 
		
			
			Ingredient newIngredient = new Ingredient(name,foodGroupSelected,calories ); //A new ingredient object is instantiated with the relevant instance data.
			warehouse.addIngredients(newIngredient);//The new ingredient is added into the warehouse.
		}else {
			consoleSetUp(con);
			con.println("This item already exists! ");
		}
	}
	
	public void addIngredient2InMedia(Ingredient ingredient) {
		if (ingredient != null) {
			warehouse.addIngredients(ingredient);
		}
	}
	
	/**
	 * This method views all ingredients in the warehouse. 
	 * @return --> The ingredients retrieved from the warehouse is to be returned. 
	 */
	public static ArrayList <Ingredient> viewIngredientsInWarehouseInMedia() {
		if (warehouse != null) {
			ArrayList<Ingredient> ingredients = warehouse.getIngredients(); //All ingredients are retrieved from the warehouse.
			ArrayList <Ingredient> sorted = newUtility.sort(ingredients);//The .sort method is called, where applied to the ingredients retrieved from the warehouse.
			return sorted;
		}
		return null;
	}
	/**
	 * This method focuses on searching for ingredients within the warehouse via its name.
	 * @param name --> The name of the ingredient being searched for. 
	 * @return --> Returns the ingredient if it has been found.
	 */
	public static Ingredient searchNameInMedia(String name) {
		if (name != null) {
			return warehouse.searchByName(name);//The ingredient being searched for is returned. 
		}
		return null;
	}
	
	
	/**
	 * This method focuses on searching for a ingredient within the warehouse via its id.
	 * @param id --> The ingredient is identified and is returned to the user. 
	 * @return --> returns the ingredient if identified. 
	 */
	public static Ingredient searchByIdInMedia(int id) {
		if (id >0 ) {
			Ingredient ingredient = warehouse.searchById(id);//returns the ingredient if found.
			return ingredient;
		}
		return null;
	}
	/**
	 * This method focuses on searching for a ingredient within the warehouse via its part name;
	 * @param name --> The ingredient with the appropriate part name is searched for.
	 * @return --> If identified the ingredient is returned to the user. 
	 */
	public static ArrayList <Ingredient> searchByPartInMedia(String name) {
		if (name != null) {
			return warehouse.searchByPart(name);//returns the ingredient if found. 
		}
		return null;
	}
	/**
	 * This method focuses on searching for a ingredient within the warehouse via its calories. 
	 * @param calories --> the ingredient with the appropriate calories is searched for. 
	 * @return --> the Ingredient is returned to the user.
	 */
	public static ArrayList<Ingredient> searchByCaloriesInMedia(double calories) {
		if (calories != 0) {
			return warehouse.searchByCalories(calories);//returns the ingredient if found.
		}
		return null;
	}
	/**
	 * This method focuses on searching for a ingredient within the warehouse via its food group.
	 * @param foodGroup --> the ingredient with the appropriate food group is searched for. 
	 * @return --> the ingredient is returned to the user. 
	 */
	public static ArrayList<Ingredient> searchByFoodGroupInMedia(FoodGroup foodGroup) {
		if (foodGroup != null) {
			return warehouse.searchByFoodGroup(foodGroup);//returns the ingredient found.
		}
		return null;
	}
	/**
	 * This method is perform a deletion on a ingredient in warehouse based on the ID.
	 * @param id --> The ID of the ingredient which is to be deleted. 
	 */
	
	public static void deleteByIdInMedia(int id) {
		if (id != 0) {
			warehouse.deleteIngredientByID(id);
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);
			con.println("The ingredient has been removed! ");
		}
	}
	/**
	 * This method is to perform a deletion on a ingredient based on the name. 
	 * @param name --> The name of the ingredient which is to be deleted. 
	 */
	public static void deleteByNameInMedia(String name) {
		if (name != null) {
			warehouse.deleteIngredientByName(name);
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);
			con.println("The ingredient has been removed! ");
		}
	}
	/**
	 * This method is to perform a deletion on a ingredient based on the calories. 
	 * @param calories --> The calories of the ingredient which is to be deleted. 
	 */
	public static void deleteByCaloriesInMedia(double calories) {
		if (calories != 0) {
			warehouse.deleteByCalories(calories);
			Console con = new Console(true);
			consoleSetUp(con);
			con.println("The ingredient has been removed! ");
		}
	}
	
	public static void deleteByFoodGroupInMedia(FoodGroup foodGroup) {
		if (foodGroup != null) {
			warehouse.deleteByFoodGroup(foodGroup);
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);
			con.println("The ingredient has been removed! ");
		}
	}
	
	/**
	 * This method is to perform the modification of the ingredients name. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param newName --> The new name which is to be supplied. 
	 */
	public static void modifyByNameOfIngredientInMedia(int id, String newName) {
		warehouse.modifyNameOfIngredient(id, newName);
	}
	/**
	 * This method is to perform the modification on the ingredients food group. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param foodGroup --> The new food group which is to be supplied. 
	 */
	public static void modifyByFoodGroupOfIngredientInMedia(int id, FoodGroup foodGroup) {
		warehouse.modifyFoodGroup(id, foodGroup);
	}
	/**
	 * This method is to perform the modification on the ingredients calories. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param calories --> The new calories which is to be supplied. 
	 */
	public static void modifyByCaloriesInMedia(int id, double calories) {
		warehouse.modifyCalories(id, calories);
	}
	/**
	 * This method calls the modify ingredient method, and supplies an input parameter.
	 */
	public static void modifyIngredientInMedia() {
		warehouse.modifyIngredient(input);
	}
	
	public ArrayList <Ingredient> getIngredientsInMedia(){
		return warehouse.getIngredients();
	}

}

