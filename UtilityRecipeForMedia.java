package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import console.Console;
import part01.FoodGroup;
import part01.Ingredient;
import part01.Menu;
import part01.MethodForRecipe;
import part01.Recipe;
import part01.RecipeBook;
import part01.Time;
import part01.UnitOfMeasurement;
/**
* Author: Nikhil Mathur
* Student Number: 40404282
* Purpose:
* This class is used to simplify down the Application class, ensuring that congestion is avoided and safety is ensured.
* This class has also be created to promote modularity.
* Extending the ingredient manager to gain access to some required features.
*/
public class UtilityRecipeForMedia extends UtilityIngredientForMedia {

	static RecipeBook recipeBook = new RecipeBook();
	static Scanner input = new Scanner(System.in);
	private static final Font f1 = new Font("Courier", Font.BOLD, 30);
	public UtilityRecipeForMedia() {
		super();
	}
	public ArrayList <Recipe> getRecipesInBook(){
		return recipeBook.getRecipes();
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
	public void createDefaultRecipesInMedia() {
		Ingredient newIngredient = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 52);
		Ingredient newIngredient2 = new Ingredient("Baked beans",FoodGroup.COMPOSITE_FOOD,155);
		ArrayList <Ingredient>collectionOfIngredientsRecipe1 = new ArrayList<Ingredient>();
		collectionOfIngredientsRecipe1.add(newIngredient);
		collectionOfIngredientsRecipe1.add(newIngredient2);
		
		Recipe newRecipe1 = new Recipe("Recipe 1", collectionOfIngredientsRecipe1,1);
		Recipe newRecipe2 = new Recipe("Recipe 2", collectionOfIngredientsRecipe1,2);
		MethodForRecipe newRecipeMethod = newRecipe1.createMethod(2);
		MethodForRecipe newRecipeMethod2 = newRecipe2.createMethod(1);
	
		newRecipeMethod.addAmountForEachStep(1);
		newRecipeMethod.addAmountForEachStep(2);
		newRecipeMethod2.addAmountForEachStep(3);
		ArrayList <UnitOfMeasurement> units = new ArrayList<UnitOfMeasurement>();
		units.add(UnitOfMeasurement.CUPS);
		units.add(UnitOfMeasurement.GRAMS);
		ArrayList <UnitOfMeasurement> units2 = new ArrayList<UnitOfMeasurement>();
		units2.add(UnitOfMeasurement.LITRE);
		newRecipeMethod.addCollectionOfIngredientsPerStep(newIngredient, 2);
		newRecipeMethod2.addCollectionOfIngredientsPerStep(newIngredient, 3);
		newRecipeMethod.addCollectionOfIngredientsPerStep(newIngredient2, 3);
		newRecipeMethod.createUnitsForEachAmount(units);
		newRecipeMethod2.createUnitsForEachAmount(units2);
		newRecipeMethod.addTimeForEachStep(4);
		newRecipeMethod.addTimeForEachStep(2);
		newRecipeMethod2.addTimeForEachStep(3);
		newRecipeMethod.addUnitForEachTime(Time.DAY);
		newRecipeMethod.addUnitForEachTime(Time.HOUR);
		newRecipeMethod2.addUnitForEachTime(Time.SECOND);
		newRecipeMethod.addExtraInformation("THIS IS THE STEPS");
		newRecipeMethod2.addExtraInformation("THIS IS THE STEPS");
		recipeBook.addRecipe(newRecipe1);
		recipeBook.addRecipe(newRecipe2);	
	}
	private void createMenu(String list[],Console con) {
		int x = 1;
		if (list != null) {
			for (int index = 0; index < list.length; index++) {
				con.println(x+ "." + list[index]);
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
	/**
	 * This method is used to create a recipe via the required parameters. 
	 * @return The recipe is returned when created.
	 */
	public Recipe createRecipeInMedia() {
		Console con = setup1(600,600,100,100,true);
		
		if (super.getIngredientsInMedia() != null ||super.getIngredientsInMedia().size() !=0 ) {
			ArrayList <Ingredient>collectionOfIngredientForRecipe = new ArrayList<Ingredient>();
			consoleSetUp(con);
			con.setTitle("Recipe outline");
	
			con.println("Enter the name of the recipe: ");
			String name = con.readLn();
			if (recipeBook.alreadyExists(name) == true) {
				boolean flag = false;
				while (flag != true) {
					//viewIngredientsInWarehouse();
					consoleSetUp(con);
					con.setTitle("Menu");
					con.println("Please enter the ID of the Ingredient you would like to utilize witin the Recipe");
					con.println(super.getIngredientsInMedia());
					con.println("Enter the ID of the ingredient! (-1 to stop) ");
					int id = Integer.valueOf(con.readLn());
					if (id == -1) {
						flag = true;
						break;
					}
					try {
						Ingredient ingredient = super.searchByIdInMedia(id);
						if (ingredient != null) {
							collectionOfIngredientForRecipe.add(ingredient);
						}	
					}catch(Exception e) {
						con.println("Item does not exist");
					}
					
				}
				consoleSetUp(con);
				con.setTitle("Recipe Outline");
				con.println("Please enter the number of portions for recipe: ");
				int numberOfPortions = Integer.valueOf(con.readLn());
				Recipe recipe = new Recipe(name,collectionOfIngredientForRecipe,numberOfPortions);
				recipeBook.addRecipe(recipe);
				return recipe;
			}
			consoleSetUp(con);
			con.setTitle("Recipe Outline");
			con.println("This recipe already exists!");
		}		
		return null;			
	}
	
	/**
	 * this method is used to instantiate or create a recipe. 
	 * @return
	 */
	public Recipe insantiate() {
		return createRecipeInMedia();
	}
	/**
	 * THis method is used to enter the number of ingredients needed for the recipe. 
	 * @param newMethod --> The method associated with the recipe.
	 * @param numberOfSteps --> The number of steps in the associated method for the recipe.
	 */
	
	public void addAmountForEachRecipeInMedia(MethodForRecipe newMethod,int numberOfSteps) {
		int flag = 0;
		Console con = setup1(600,600,100,100,true);
		consoleSetUp(con);
		con.setTitle("Recipe Outline");
	
		while (flag != numberOfSteps) {
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the number of ingredients needed for Step: " + (flag+1));
			int amountNeededPerIngredient = Integer.valueOf(con.readLn());
			newMethod.addAmountForEachStep(amountNeededPerIngredient);
			flag++;
		}
	
	}
	
	/**
	 * This method is used to add the ingredients needed for each step.
	 * @param newMethod --> The associated method for recipe is taken as a parameter.
	 */
	public void addCollectionOfIngredientsRequiredInMedia(MethodForRecipe newMethod) {
		for (int index = 0; index <newMethod.getAmountForEachIngredient().size();index++ ) {
			int flag2 = 0;
			System.out.println();
			while (flag2 != newMethod.getAmountForEachIngredient().get(index)) {
				Console con = setup1(600,600,100,100,true);
				consoleSetUp(con);
				con.setTitle("Buidling recipe");
				con.println(warehouse.getIngredients());
				con.println("Enter the ID of the ingredient for Step! " + (index+1));
				int id = Integer.valueOf(con.readLn());
	
				Ingredient ingredient = super.searchByIdInMedia(id);
				con.println("Please enter the amount needed: ");
				double amount = Double.valueOf(con.readLn());
				newMethod.addCollectionOfIngredientsPerStep(ingredient, amount);
				
				flag2 ++;	
			}
		}
	}
	
	
	/**
	 * The unit for the amount per ingredient is specified via this method. 
	 * @param newMethod --> The method associated with the recipe is passed as an argument. 
	 * @param numberOfSteps --> The number of steps is also passed. Allowing necessary iterations and loops to occur.
	 */
	
	public void addUnitOfMeasurementInMedia(MethodForRecipe newMethod, int numberOfSteps) {
		int flag3 = 0;
		while (flag3 != numberOfSteps) {
			for (int index = 0; index <newMethod.getAmountForEachIngredient().size();index++ ) {
				int flag2 = 0;
				System.out.println();
				ArrayList<UnitOfMeasurement> newArrayList = new ArrayList<UnitOfMeasurement>();
				while (flag2 != newMethod.getAmountForEachIngredient().get(index)) {
					Console con = setup1(600,600,100,100,true);
					consoleSetUp(con);
					con.setTitle("Buidling recipe");
					con.println(warehouse.getIngredients());
					String choices[] = {UnitOfMeasurement.GRAMS.toString(), UnitOfMeasurement.LITRE.toString(), UnitOfMeasurement.POUNDS.toString(), UnitOfMeasurement.OUNCE.toString(), UnitOfMeasurement.MILLILIETER.toString(), UnitOfMeasurement.CUPS.toString(),UnitOfMeasurement.TABLE_SPOON.toString()};
					createMenu(choices,con);
					
					int choice = Integer.valueOf(con.readLn());
					switch(choice) {
					case 1:
						//method.addUnitForEachAmount(UnitOfMeasurement.GRAMS);
						newArrayList.add(UnitOfMeasurement.GRAMS);
						break;
					case 2:
						//method.addUnitForEachAmount(UnitOfMeasurement.LITRE);
						newArrayList.add(UnitOfMeasurement.LITRE);
						break;
					case 3:
						//method.addUnitForEachAmount(UnitOfMeasurement.POUNDS);
						newArrayList.add(UnitOfMeasurement.POUNDS);
						break;
					case 4:
						//method.addUnitForEachAmount( UnitOfMeasurement.OUNCE);
						newArrayList.add(UnitOfMeasurement.OUNCE);
						break;
					case 5:
						//method.addUnitForEachAmount(UnitOfMeasurement.MILLILIETER);
						newArrayList.add(UnitOfMeasurement.MILLILIETER);
						break;
					case 6:
						//method.addUnitForEachAmount(UnitOfMeasurement.CUPS);
						newArrayList.add(UnitOfMeasurement.CUPS);
						break;
					case 7:
						//method.addUnitForEachAmount(UnitOfMeasurement.TABLE_SPOON);
						newArrayList.add(UnitOfMeasurement.TABLE_SPOON);
						break;
					}
					
					flag2++;	
				}
				newMethod.createUnitsForEachAmount(newArrayList);
				flag3++;	
			}	
		}
	}
	
	/**
	 * This method adds the time, and unit of time for each step. 
	 * @param newMethod --> The method associated with the recipe. 
	 * @param numberOfSteps --> The number of steps associated with the recipe. 
	 */
	public void addTimeInMedia(MethodForRecipe newMethod, int numberOfSteps) {
		int flag4 = 0;
		while (flag4 != numberOfSteps) {
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please input the time for step: " + (flag4+1));
			double time = Double.valueOf(con.readLn());
			newMethod.addTimeForEachStep(time);
			con.println("Please enter the unit for time: ");
			String choices2[] = {Time.SECOND.toString(), Time.MINUTE.toString(), Time.HOUR.toString(), Time.DAY.toString(), Time.MONTH.toString(), Time.YEAR.toString()};
			createMenu(choices2, con);
		
			int choice3 = Integer.valueOf(con.readLn());
			switch(choice3) {
			case 1:
				newMethod.addUnitForEachTime(Time.SECOND);
				break;
			case 2:
				newMethod.addUnitForEachTime(Time.MINUTE);
				break;
			case 3:
				newMethod.addUnitForEachTime(Time.HOUR);
				break;
			case 4:
				newMethod.addUnitForEachTime(Time.DAY);
				break;
			case 5:
				newMethod.addUnitForEachTime(Time.MONTH);
				break;
			case 6:
				newMethod.addUnitForEachTime(Time.YEAR);
				break;
			}
			flag4++;
		}
	}
	/**
	 * Any extra information is entered by the user. This includes the numerous steps associated with the recipe. 
	 * @param newMethod --> The method associated with the recipe.
	 * @param numberOfSteps --> The number of steps associated with the recipe. 
	 */
	
	public void addExtraInfoInMedia(MethodForRecipe newMethod,int numberOfSteps) {
		int flag5 = 0;
		while (flag5 != numberOfSteps) {
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter additonal steps for Step:  " + (flag5+1));
			String info = con.readLn();
			
			String information = info;
			newMethod.addExtraInformation("Step: " + (flag5+1) + ")"+ information);
			flag5++;
		}
	}
	
	/**
	 * All steps required to create a full recipe is combined together. 
	 * First the outline is created, then the core method (which includes the series of steps, and other core details). 
	 */
	public void createRecipe2InMedia() {
		Recipe recipe = insantiate();
		Console con = setup1(600,600,100,100,true);
		consoleSetUp(con);
		con.setTitle("Buidling recipe");
		con.println("Please enter the number of steps: ");
		int numberOfSteps = Integer.valueOf(con.readLn());

		MethodForRecipe newMethod = recipe.createMethod(numberOfSteps);

		addAmountForEachRecipeInMedia(newMethod, numberOfSteps);
		
		addCollectionOfIngredientsRequiredInMedia(newMethod);
		
		addUnitOfMeasurementInMedia(newMethod, numberOfSteps);
		
		addTimeInMedia(newMethod, numberOfSteps);
		
		addExtraInfoInMedia(newMethod, numberOfSteps);

	}
	
	/**
	 * Used to view the recipes within the recipe book.
	 */
	public void viewRecipesInMedia() {
		recipeBook.viewRecipes();
	
	}
	public void viewRecipesInMedia2(Console con) {
		if (recipeBook.getRecipes() != null ||recipeBook.getRecipes().size() != 0) {
			for (int index = 0; index <recipeBook.getRecipes().size(); index++ ) {
				con.println(recipeBook.getRecipes().get(index).toString());
				con.println(recipeBook.getRecipes().get(index).viewReturnableInfo());
			}
			
		}
	}
	
	/**
	 * To search for a recipe via a ID.
	 * @param id --> ID of the recipe.
	 * @return --> Returns the recipe if found, returns null if not. 
	 */
	public static Recipe searchByIdRecipeInMedia(int id) {
		if (id != 0) {
			return recipeBook.searchById(id);
		}
		return null;
	}
	/**
	 * Deletes the Recipe via the ID.
	 * @param id --> The ID of the recipe. 
	 * @return --> Returns true if recipe deleted. 
	 */
	public  boolean deleteByIdRecipeInMedia(int id) {
		if (id != 0) {
			recipeBook.deleteById(id);
			return true;
		}
		return false;
	}
	/**
	 * Deletes the recipe via the name
	 * @param name --> The name of the recipe to be deleted. 
	 * @return --> Return true if recipe is deleted. 
	 */
	public  boolean deleteByNameRecipeInMedia(String name) {
		if (name != null) {
			recipeBook.deleteByName(name);
			return true;
		}
		return false;
	}
	/**
	 * Deletes the recipe via the part name.
	 * @param name --> Name of the recipe which is to be deleted. 
	 * @return --> return true or false.
	 */
	public  boolean deleteByPartNameRecipeInMedia(String name) {
		if (name != null) {
			recipeBook.deleteByPartName(name);
			return true;
		}
		return false;
	}
	
	/**
	 * Searches for the recipe via the name
	 * @param name --> Name of the recipe.
	 * @return --> Returns the recipe if found
	 */
	public Recipe searchByNameRecipeInMedia(String name) {
		if (name != null) {
			return recipeBook.searchByName(name);
		}
		return null;
	}
	/**
	 * Searches for the recipe via its part name.
	 * @param name --> The part name of the recipe.
	 * @return --> retunrs the recipe if found.
	 */
	public ArrayList <Recipe> searchByPartRecipeInMedia(String name) {
		if (name != null) {
			return recipeBook.searchByPart(name);
		}
		return null;
	}
	
	/**
	 * Calculates the total calories of the Recipe via the ID.
	 * @param id --> id of the recipe
	 * @return --> Returns the calories of the recipe.
	 */
	public double calculateIdRecipeInMedia(int id) {
		if (id != 0) {
			return recipeBook.searchById(id).calculateAllCalories();
		}
		return 0;
	}
	/**
	 * Calculates the total calories of the recipe via its name.
	 * @param name --> name of the recipe.
	 * @return --> Returns the calories of the recipe.
	 */
	public double calculateByNameRecipeInMedia(String name) {
		if (name != null) {
			return recipeBook.searchByName(name).calculateAllCalories();
		}
		return 0;
	}
	/**
	 * Calculates the total calories of the recipe via its part name.
	 * @param name --> The part name of the associated recipe.
	 * @return --> Returns the associated calories. 
	 */
	public ArrayList<Double> calculateByPartRecipeInMedia(String name) {
		ArrayList <Double> caloriesCollection = new ArrayList<Double>();
		if (name != null) {
			Console con = setup1(600,600,100,100,true);
			consoleSetUp(con);;
			con.setTitle("Buidling recipe");
			con.println(recipeBook.searchByPart(name));
			for (int index = 0; index < recipeBook.getRecipes().size(); index++) {
				caloriesCollection.add(recipeBook.getRecipes().get(index).calculateAllCalories());
			}
			return caloriesCollection;
		}
		return null;
	}
	
	/**
	 * This method is change the name of the recipe.
	 * @param id --> The ID of the recipe, which is to be modified. 
	 * @param newName --> The new name of the recipe.
	 */
	public void modifyNameOfRecipeInMedia(int id, String newName) {
		if (id != 0 && newName != null) {
			Recipe recipe= searchByIdRecipeInMedia(id);
			if (recipe != null) {
				recipe.setName(newName);
			}
		}
	}
	/**
	 * This method is used to set the ingredients within.What ingredients are needed within the recipe.
	 * @param id --> The ID of the recipe which is to be searched for. 
	 * @param newIngredient --> The newIngredient which is to be added.
	 */
	public void modifyIngredientsUsedWithinInMedia(int id, Ingredient newIngredient) {
		if (id != 0 || newIngredient != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				recipe.setIngredients(newIngredient);
			}
		}
	}
	/**
	 * This method is used to modify the number of portions associated with the recipe.
	 * @param id --> The ID of the recipe which is to be changed. 
	 * @param numberOfPortions --> The new number of portions.
	 */
	public static void modifyNumberOfPortionsInMedia(int id, int numberOfPortions) {
		if (id!= 0) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				recipe.setNumberOfPortions(numberOfPortions);
			}
		}
	}
	/**
	 * This method is used to modify the steps included within the recipe. 
	 * @param id --> The ID of the recipe which is to be modified
	 * @param extraInfo --> The extra info which is to be added.
	 */
	public static void modifyTheStepsincludedInMedia(int id, String extraInfo) {
		if (id != 0 && extraInfo != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				int counter = recipe.getNumberOfSteps();
				recipe.setNumberOfSteps();
				recipe.modifyInformation("Step:" + (counter+1) + ")" + extraInfo);	
			}
		}
	}
	/**
	 * The ingredients per step is modified. According to the ID, step, a new ingredient can be added and the associated amount as well. 
	 * @param id --> The ID of the recipe.
	 * @param step --> The Step which is required to be modified. 
	 * @param ingredient --> The new ingredient which is to be added.
	 * @param amount --> The new associated amount.
	 */
	public static void modifyAddingTheIngredientsPerStepInMedia(int id, int step, Ingredient ingredient, double amount) {
		if (step != 0 && ingredient != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.addNewIngredientsForStep(step, ingredient,amount);
			}	
		}
	}
	/**
	 * The amount of a specific step, and the required position can also be modified via this method.
	 * @param id --> The ID of the recipe which is to be modified. 
	 * @param step --> The step which is to be modified. 
	 * @param position --> The position or ingredient which is to be modified. 
	 * @param amount --> The new amoubt.
	 */
	public static void modifyTheAmountPerStepInMedia(int id, int step,int position, double amount) {
		if (step != 0 && amount != 0) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.setNewAmountForEachStep(step, position, amount);
			}	
		}
	}
	/**
	 * The ingredients per step is modified. 
	 * @param id --> The ID of the recipe to be searched for. 
	 * @param step --> The step which is to be modified. 
	 * @param position --> the specific ingredient which is to be modified. 
	 * @param ingredient --> The new ingredient passed. 
	 */
	public static void modifyTheIngredientPerStepInMedia(int id, int step,int position, Ingredient ingredient) {
		if (step != 0 && ingredient != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.setNewIngredientsPerStep(step, position, ingredient);
			}	
		}
	}
	/**
	 * The Unit of amount can be modified via this method, where the step, position, and new unit of measurement defines the changed.
	 * @param id --> The ID of the recipe to be modified. 
	 * @param step --> The step to be modified. 
	 * @param position --> The ingredient to be modified.
	 * @param newMeasurement --> The new measurement to be added.
	 */
	public static void modifyTheUnitOfAmountPerstepInMedia(int id, int step,int position, UnitOfMeasurement newMeasurement) {
		if (step != 0 && newMeasurement != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.setNewUnitForAmount(step, position, newMeasurement);
			}	
		}
	}
	/**
	 * The time for each step can be modified via this method. 
	 * @param id --> The ID of the recipe to be modified. 
	 * @param step --> The Step of the recipe which is to be modified. 
	 * @param position --> The Ingredient to be modified. 
	 * @param time --> The new time supplied.
	 */
	public static void modifyTheTimeForEachStepInMedia(int id, int step,int position, double time) {
		if (step != 0 && time != 0) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.setNewTimeForEachStep(step, position, time);
			}	
		}
	}
	/**
	 * This method is used to set the new unit of time per step.
	 * @param id --> The ID of the recipe to be modified. 
	 * @param step --> The Step in the recipe which is to be modified. 
	 * @param position --> The ingredient which is to be modified.
	 * @param unitOfTime --> The unit of time.
	 */
	public static void modifyTheUnitOfTimeForEachStepInMedia(int id, int step,int position, Time unitOfTime) {
		if (step != 0 && unitOfTime != null) {
			Recipe recipe = searchByIdRecipeInMedia(id);
			if (recipe != null) {
				//System.out.println("Please enter step you want to change! ");
				recipe.setNewUnitForTimeEachStep(step, position, unitOfTime);
			}	
		}
	}
	
	/**
	 * This method combines all modification methods, into one where necessary modification actions can be made. 
	 * @return --> Returns true or false on whether the process has gone smoothly. 
	 */
	public boolean modifyRecipeInMedia() {
		Console con = setup1(600,600,100,100,true);
		consoleSetUp(con);
		con.setTitle("Modifying recipe");
		con.println("Please enter the ID of the recipe: ");
		int choice = input.nextInt();
		input.nextLine();
		Recipe recipe = searchByIdRecipeInMedia(choice);


		String options[] = {"Name", "Collection Of Ingredients", "Number of portions", "Steps included", "Adding Ingredients per step", "Ingredients Per step ", "Amount of the ingredient per step", "Unit for amount each step", "Time for each step", "Unit for time for each step"};
		createMenu(options, con);
		
		int choice2 = Integer.valueOf(con.readLn());

		switch(choice2) {
		case 1:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the new name: ");
			String newName = con.readLn();
			modifyNameOfRecipeInMedia(choice, newName);
			break;
		case 2:
	
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("All ingredients have been removed from recipe: ");
			boolean flag = false;
			ArrayList <Ingredient> newIngredients = new ArrayList<Ingredient>();
			while (flag != true) {
				con.println(warehouse.getIngredients());
				con.println("Please enter the ID of the Ingredient: ");

				con.println("Enter the ID of the ingredient! (-1 to stop) ");
				int id = Integer.valueOf(con.readLn());
				
				if (id == -1) {
					flag = true;
					break;
				}
				
				Ingredient ingredient = super.searchByIdInMedia(id);
				modifyIngredientsUsedWithinInMedia(choice, ingredient);
			}
			break;
		case 3:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Enter new number of portions: ");
			int newNumberOfPortions = Integer.valueOf(con.readLn());
			input.nextLine();
			modifyNumberOfPortionsInMedia(choice, newNumberOfPortions);
			break;
		case 4:
			
			boolean flag2 = false;
			while (flag2 != true) {
				
				consoleSetUp(con);
				con.setTitle("Buidling recipe");
				con.println("Please enter any extra steps: ");
				String newInfo = con.readLn();
				if (newInfo.equals("-1")) {
					flag = true;
					break;
				}
				modifyTheStepsincludedInMedia(choice, newInfo );
			}
			break;
		case 5:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the step you are interested in changing! ");
			con.println(warehouse.getIngredientsPerStepInRecipe(recipe));
			int step = Integer.valueOf(con.readLn());
	
			boolean flag3 = false;
			while (flag3 != true) {
				
				consoleSetUp(con);
				con.setTitle("Buidling recipe");
				con.println(warehouse.getIngredients());
				con.println("Please enter the ID of the Ingredient: ");

				con.println("Enter the ID of the ingredient! (-1 to stop) ");
				int id = Integer.valueOf(con.readLn());
			
				if (id == -1) {
					flag = true;
					break;
				}
				
				Ingredient ingredient = super.searchByIdInMedia(id);
				con.println("Enter the new amount of that ingredient!");
				double amount = Double.valueOf(con.readLn());
				modifyAddingTheIngredientsPerStepInMedia(step,choice,ingredient,amount);
			}	
			break;	
		case 6:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the Step you are interested in changing! ");
			con.println(warehouse.getIngredientsPerStepInRecipe(recipe));
			int step2 = Integer.valueOf(con.readLn());
			
			
			
			con.println("Please select the ingredient you would like to replace. ");
			int selection = Integer.valueOf(con.readLn());
		
			con.println("Please enter the id of an ingredient you would like to replace it with: ");
			int selection2 = Integer.valueOf(con.readLn());
			
			Ingredient ingredient = super.searchByIdInMedia(selection2);
			modifyTheIngredientPerStepInMedia(choice,step2,selection,ingredient);
			break;
		case 7:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the Step you are interested in changing! ");
			con.println(warehouse.getAmountForSpecificIngredientInRecipe(recipe));
			int step3 = Integer.valueOf(con.readLn());

			
			
			con.println("Please select the amount you would like to replace. ");
			int selectionAmount = Integer.valueOf(con.readLn());
	
			con.println("Please enter the new amount you would like to replace it with: ");
			double selectionNewAmount = Double.valueOf(con.readLn());
		
			
			modifyTheAmountPerStepInMedia(choice,step3,selectionAmount,selectionAmount);
			break;
		case 8 : 
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the Step you are interested in changing! ");
			con.println(warehouse.getUnitForAmountForSpecificIngredientInRecipe(recipe));
			int step4 = Integer.valueOf(con.readLn());
	
			
			
			con.println("Please select the unit you would like to replace. ");
			int selectionUnit = Integer.valueOf(con.readLn());
			
			con.println("Please enter the new unit you would like to replace it with: ");
			String choices[] = {UnitOfMeasurement.GRAMS.toString(), UnitOfMeasurement.LITRE.toString(), UnitOfMeasurement.POUNDS.toString(), UnitOfMeasurement.OUNCE.toString(), UnitOfMeasurement.MILLILIETER.toString(), UnitOfMeasurement.CUPS.toString(),UnitOfMeasurement.TABLE_SPOON.toString()};
			createMenu(choices, con);
			
			int choiceForUnits = Integer.valueOf(con.readLn());
			switch(choiceForUnits) {
			case 1:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.GRAMS);
				break;
			case 2:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.LITRE);
				break;
			case 3:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.POUNDS);
				break;
			case 4:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.OUNCE);
				break;
			case 5:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.MILLILIETER);
				break;
			case 6:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.CUPS);
				break;
			case 7:
				modifyTheUnitOfAmountPerstepInMedia(choice,step4,selectionUnit,UnitOfMeasurement.TABLE_SPOON);
				break;
			}
			break;
		case 9:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the Step you are interested in changing! ");
			con.println(warehouse.getTimeForEachStep(recipe));
			int step5 = Integer.valueOf(con.readLn());

			
			
			con.println("Please select the time you would like to replace. ");
			int selectionTime = Integer.valueOf(con.readLn());
			
			con.println("Please enter the new amount you would like to replace it with: ");
			double selectionNewTime = Double.valueOf(con.readLn());
		
			
			modifyTheTimeForEachStepInMedia(choice,step5,selectionTime,selectionNewTime);
			break;
		case 10:
			
			consoleSetUp(con);
			con.setTitle("Buidling recipe");
			con.println("Please enter the step you are interested in changing! ");
			con.println(warehouse.getUnitOfTimeForEachStep(recipe));
			int step6 = Integer.valueOf(con.readLn());
		
			con.println("Please select the Unit of time you would like to replace. ");
			int selectionUnitOfTime = Integer.valueOf(con.readLn());
			
			con.println("Please enter the new amount you would like to replace it with: ");
			String choices2[] = {Time.SECOND.toString(), Time.MINUTE.toString(), Time.HOUR.toString(), Time.DAY.toString(), Time.MONTH.toString(), Time.YEAR.toString()};
			createMenu(choices2, con);
			
			int choiceSelected = Integer.valueOf(con.readLn());
			
			switch(choiceSelected) {
			case 1:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.SECOND);
				break;
			case 2:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.MINUTE);
				break;
			case 3:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.HOUR);
				break;
			case 4:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.DAY);
				break;
			case 5:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.MONTH);
				break;
			case 6:
				modifyTheUnitOfTimeForEachStepInMedia(choice,step6,selectionUnitOfTime,Time.YEAR);
				break;
			}
			break;
			
		}
		return true;
	}

}
