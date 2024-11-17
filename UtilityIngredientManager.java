package part01;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: This class is to manage the functionality of the ingredient section of the application.
 * This class helps manage the application class, by simplifying down the amount of code in the application class ensuring safety, general modular usage and less congestion.
 * All functionalities are store within this class, which can be instantiated for usage.
 */
public class UtilityIngredientManager {
	private static Scanner input;  //Scanner for user input requirements.
	protected static Warehouse warehouse; //Baseline warehouse instantiation.
	static Utility newUtility = new Utility(); //New utility object instantiated.
	
	
	/**
	 * Within this constructor the scanner is instantiated.
	 * A warehouse object is also instantiated. 
	 */
	public UtilityIngredientManager() {
		this.input = new Scanner(System.in);
		this.warehouse = new Warehouse();
	}
	public void addDefault() {
		this.warehouse.addIngredientsDefault();
	}

	
	
	/**
	 * This method is used to add ingredients into the warehouse collection.
	 */
	public void addIngredients() {
		System.out.println("Please enter the name of the Ingredient: ");
		
		String name = input.nextLine(); //The name of the ingredient is inputed by the end user. 
		if (warehouse.alreadyExists(name) == true) { //The name is checked if it already exists. 
			System.out.println("Please enter the food group: "); //The food group is selected by the user. 
			String options[] = {FoodGroup.FRUIT_VEG.toString(), FoodGroup.COMPOSITE_FOOD.toString(), FoodGroup.DAIRY.toString(), FoodGroup.CEREAL.toString(), FoodGroup.PROTEIN.toString(), FoodGroup.SUGAR.toString(), FoodGroup.FAT.toString(), FoodGroup.SPICE_HERB.toString(), FoodGroup.ESSENTIAL_NUTRIENT.toString()};
			Menu newMenu = new Menu("Food Groups", options); //A menu object is instantiated and used to display options.
			int choice = newMenu.getChoice();
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
			
			System.out.println("Enter the amount of calories: ");
			double calories = input.nextDouble(); //The amount of calories is specified by the user. 
		
			input.nextLine();
			
			Ingredient newIngredient = new Ingredient(name,foodGroupSelected,calories ); //A new ingredient object is instantiated with the relevant instance data.
			warehouse.addIngredients(newIngredient);//The new ingredient is added into the warehouse.
		}else {
			System.out.println("This item already exists! ");
		}
	}
	
	public void addIngredient2(Ingredient ingredient) {
		if (ingredient != null) {
			warehouse.addIngredients(ingredient);
		}
	}
	
	/**
	 * This method views all ingredients in the warehouse. 
	 * @return --> The ingredients retrieved from the warehouse is to be returned. 
	 */
	public static ArrayList <Ingredient> viewIngredientsInWarehouse() {
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
	public static Ingredient searchName(String name) {
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
	public static Ingredient searchById(int id) {
		if (id != 0) {
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
	public static ArrayList <Ingredient> searchByPart(String name) {
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
	public static ArrayList<Ingredient> searchByCalories(double calories) {
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
	public static ArrayList<Ingredient> searchByFoodGroup(FoodGroup foodGroup) {
		if (foodGroup != null) {
			return warehouse.searchByFoodGroup(foodGroup);//returns the ingredient found.
		}
		return null;
	}
	/**
	 * This method is perform a deletion on a ingredient in warehouse based on the ID.
	 * @param id --> The ID of the ingredient which is to be deleted. 
	 */
	
	public static void deleteById(int id) {
		if (id != 0) {
			warehouse.deleteIngredientByID(id);
			System.out.println("The ingredient has been removed! ");
		}
	}
	/**
	 * This method is to perform a deletion on a ingredient based on the name. 
	 * @param name --> The name of the ingredient which is to be deleted. 
	 */
	public static void deleteByName(String name) {
		if (name != null) {
			warehouse.deleteIngredientByName(name);
			System.out.println("The ingredient has been removed! ");
		}
	}
	/**
	 * This method is to perform a deletion on a ingredient based on the calories. 
	 * @param calories --> The calories of the ingredient which is to be deleted. 
	 */
	public static void deleteByCalories(double calories) {
		if (calories != 0) {
			warehouse.deleteByCalories(calories);
			System.out.println("The ingredient has been removed! ");
		}
	}
	
	public static void deleteByFoodGroup(FoodGroup foodGroup) {
		if (foodGroup != null) {
			warehouse.deleteByFoodGroup(foodGroup);
			System.out.println("The ingredient has been removed! ");
		}
	}
	
	/**
	 * This method is to perform the modification of the ingredients name. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param newName --> The new name which is to be supplied. 
	 */
	public static void modifyByNameOfIngredient(int id, String newName) {
		warehouse.modifyNameOfIngredient(id, newName);
	}
	/**
	 * This method is to perform the modification on the ingredients food group. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param foodGroup --> The new food group which is to be supplied. 
	 */
	public static void modifyByFoodGroupOfIngredient(int id, FoodGroup foodGroup) {
		warehouse.modifyFoodGroup(id, foodGroup);
	}
	/**
	 * This method is to perform the modification on the ingredients calories. 
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param calories --> The new calories which is to be supplied. 
	 */
	public static void modifyByCalories(int id, double calories) {
		warehouse.modifyCalories(id, calories);
	}
	/**
	 * This method calls the modify ingredient method, and supplies an input parameter.
	 */
	public static void modifyIngredient() {
		warehouse.modifyIngredient(input);
	}
	
	public ArrayList <Ingredient> getIngredients(){
		return warehouse.getIngredients();
	}

}
