package part01;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose:
 * This class is used to simplify down the Application class, ensuring that congestion is avoided and safety is ensured.
 * This class has also be created to promote modularity.
 * Extending the ingredient manager to gain access to some required features.
 */

public class UtilityRecipeManager extends UtilityIngredientManager {
	
	static RecipeBook recipeBook = new RecipeBook();//Recipe book used to store all recipe instantiations.
	static Scanner input = new Scanner(System.in); //Input allowing user to input requirements when needed.
	private ArrayList<Ingredient>collectionRequired;
	/**
	 * Constructor referencing the super class. 
	 */
	public UtilityRecipeManager() {
		super();
	}
	/**
	 * To hard code default recipes. 
	 */
	public void createDefaultRecipes() {
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
	/**
	 * Used to retrieve recipes contained with recipe book.
	 * @return returns the recipes contained within.
	 */
	public ArrayList <Recipe> getRecipesInBook(){
		return recipeBook.getRecipes();
	}
	
	/**
	 * This method is used to create a recipe via the required parameters. 
	 * @return The recipe is returned when created.
	 */
	public Recipe createRecipe() {
		if (super.getIngredients() != null ||super.getIngredients().size() !=0 ) {//Checks if the collection ingredients are null or empty. 
			ArrayList <Ingredient>collectionOfIngredientForRecipe = new ArrayList<Ingredient>();//ArrayList of ingredients needed for recipe. 
			System.out.println("Enter the name of the recipe: ");//The name of the recipe entered. 
			String name = input.nextLine();
			if (recipeBook.alreadyExists(name) == true) {//Checks if the recipe does not already exist. 
				boolean flag = false;
				while (flag != true) {
					//viewIngredientsInWarehouse();
					System.out.println("Please enter the ID of the Ingredient you would like to utilize witin the Recipe");//ID of ingredient required is entered accordingly by the user. 
					System.out.println(super.getIngredients()); //The ingredients are printed to the user, so that the user can make an informed decision.
					System.out.println("Enter the ID of the ingredient! (-1 to stop) "); //ID entered
					int id = input.nextInt();
					input.nextLine();
					if (id == -1) {//If -1 is entered this indicates that no more ingredients are needed.
						flag = true;
						break;
					}
				
					Ingredient ingredient = super.searchById(id);
					if (ingredient != null) {
						collectionOfIngredientForRecipe.add(ingredient);//Ensures that if null, the object reference isnt added.
					}
					System.out.println("Item does not exist, hence not added!");
					collectionRequired = collectionOfIngredientForRecipe;
					
				}
				System.out.println("Please enter the number of portions for recipe: ");
				int numberOfPortions = input.nextInt();//Number of portions entered. 
				input.nextLine();
				Recipe recipe = new Recipe(name,collectionOfIngredientForRecipe,numberOfPortions);//Recipe object reference is created.
				recipeBook.addRecipe(recipe);
				return recipe;
			}
			System.out.println("This recipe already exists!");
		}		
		return null;			
	}
	
	/**
	 * this method is used to instantiate or create a recipe. 
	 * @return
	 */
	public Recipe insantiate() {
		return createRecipe();//Instantiate a recipe. 
	}
	
	/**
	 * THis method is used to enter the number of ingredients needed for the recipe. 
	 * @param newMethod --> The method associated with the recipe.
	 * @param numberOfSteps --> The number of steps in the associated method for the recipe.
	 */
	
	public void addAmountForEachRecipe(MethodForRecipe newMethod,int numberOfSteps) {
		int flag = 0;
		
		while (flag != numberOfSteps) {//Loop carries on for the number of steps defined. 
			System.out.println("Please enter the number of ingredients needed for Step: " + (flag+1));
			int amountNeededPerIngredient = input.nextInt(); //User enters the number of ingredients needed for a specific step. 
			input.nextLine();
			newMethod.addAmountForEachStep(amountNeededPerIngredient);
			flag++;
		}
	
	}
	
	/**
	 * This method is used to add the ingredients needed for each step.
	 * @param newMethod --> The associated method for recipe is taken as a parameter.
	 */
	public void addCollectionOfIngredientsRequired(MethodForRecipe newMethod) {
		for (int index = 0; index <newMethod.getAmountForEachIngredient().size();index++ ) {//The number of ingredients needed per step is iterated through, where according to each value, the user enteres a proportional number of ingredients. 
			int flag2 = 0;
			System.out.println();
			while (flag2 != newMethod.getAmountForEachIngredient().get(index)) {
				System.out.println(collectionRequired);//The ingredients are shown.
				System.out.println("Enter the ID of the ingredient for Step! " + (index+1));
				int id = input.nextInt();//The ingredient is searched for, and added.
				input.nextLine();
				Ingredient ingredient = super.searchById(id);
				System.out.println("Please enter the amount needed: ");//The amount is entered by the user. 
				double amount = input.nextDouble();
				input.nextLine();
			
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
	
	public void addUnitOfMeasurement(MethodForRecipe newMethod, int numberOfSteps) {
		int flag3 = 0;
		while (flag3 != numberOfSteps) {//Loop continuted according to the number of steps.
			for (int index = 0; index <newMethod.getAmountForEachIngredient().size();index++ ) {
				int flag2 = 0;
				System.out.println("Please enter the Unit for the amount added : ");
				ArrayList<UnitOfMeasurement> newArrayList = new ArrayList<UnitOfMeasurement>();//Array list is used to store the unit of measurements for each amount.
				while (flag2 != newMethod.getAmountForEachIngredient().get(index)) {//The amount for each ingredient is iterated through. 
					System.out.println(collectionRequired);
					System.out.println("Step: " + (index+1) + "Ingredient Number: " + (flag2+1));
					String choices[] = {UnitOfMeasurement.GRAMS.toString(), UnitOfMeasurement.LITRE.toString(), UnitOfMeasurement.POUNDS.toString(), UnitOfMeasurement.OUNCE.toString(), UnitOfMeasurement.MILLILIETER.toString(), UnitOfMeasurement.CUPS.toString(),UnitOfMeasurement.TABLE_SPOON.toString()};
					Menu menu = new Menu("Add Unit for Step: " + (flag3+1), choices);
					int choice = menu.getChoice();
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
	public void addTime(MethodForRecipe newMethod, int numberOfSteps) {
		int flag4 = 0;
		while (flag4 != numberOfSteps) {
			System.out.println("Please input the time for step: " + (flag4+1));//The amount of time required for the step.
			double time = input.nextDouble();
			input.nextLine();
			newMethod.addTimeForEachStep(time);
			System.out.println("Please enter the unit for time: ");//The unit of time is entered, and selected.
			String choices2[] = {Time.SECOND.toString(), Time.MINUTE.toString(), Time.HOUR.toString(), Time.DAY.toString(), Time.MONTH.toString(), Time.YEAR.toString()};
			Menu menu = new Menu("Unit of Time", choices2);
			int choice3 = menu.getChoice();
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
	
	public void addExtraInfo(MethodForRecipe newMethod,int numberOfSteps) {
		int flag5 = 0;
		while (flag5 != numberOfSteps) {
			System.out.println("Please enter additonal steps for Step:  " + (flag5+1));
			String info = input.nextLine();//Additional info added.
			
			String information = info;
			newMethod.addExtraInformation("Step: " + (flag5+1) + ")"+ information);
			flag5++;
		}
	}
	
	/**
	 * All steps required to create a full recipe is combined together. 
	 * First the outline is created, then the core method (which includes the series of steps, and other core details). 
	 */
	public void createRecipe2() {
		Recipe recipe = insantiate();
		System.out.println("Please enter the number of steps: ");
		int numberOfSteps = input.nextInt();
		input.nextLine();
		MethodForRecipe newMethod = recipe.createMethod(numberOfSteps);//Method created.

		addAmountForEachRecipe(newMethod, numberOfSteps);//Required parts of the method are built accordingly via these functions.
		
		addCollectionOfIngredientsRequired(newMethod);
		
		addUnitOfMeasurement(newMethod, numberOfSteps);
		
		addTime(newMethod, numberOfSteps);
		
		addExtraInfo(newMethod, numberOfSteps);

	}
	
	/**
	 * Used to view the recipes within the recipe book.
	 */
	public void viewRecipes() {
		
		recipeBook.viewRecipes();
	
	}
	
	/**
	 * To search for a recipe via a ID.
	 * @param id --> ID of the recipe.
	 * @return --> Returns the recipe if found, returns null if not. 
	 */
	public static Recipe searchByIdRecipe(int id) {
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
	public  boolean deleteByIdRecipe(int id) {
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
	public  boolean deleteByNameRecipe(String name) {
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
	public  boolean deleteByPartNameRecipe(String name) {
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
	public Recipe searchByNameRecipe(String name) {
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
	public ArrayList <Recipe> searchByPartRecipe(String name) {
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
	public double calculateIdRecipe(int id) {
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
	public double calculateByNameRecipe(String name) {
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
	public ArrayList<Double> calculateByPartRecipe(String name) {
		ArrayList <Double> caloriesCollection = new ArrayList<Double>();//stores the calories associated with the recipe.
		if (name != null) {
			System.out.println(recipeBook.searchByPart(name));//The recipe is searched by part. 
			for (int index = 0; index < recipeBook.getRecipes().size(); index++) {
				caloriesCollection.add(recipeBook.getRecipes().get(index).calculateAllCalories());//If found the calories is calculated and stored in the array list.
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
	public void modifyNameOfRecipe(int id, String newName) {
		if (id != 0 && newName != null) {
			Recipe recipe= searchByIdRecipe(id); //The recipe is searched for. 
			if (recipe != null) {
				recipe.setName(newName); //If not null the name is modified via the set function.
			}
		}
	}
	/**
	 * This method is used to set the ingredients within.What ingredients are needed within the recipe.
	 * @param id --> The ID of the recipe which is to be searched for. 
	 * @param newIngredient --> The newIngredient which is to be added.
	 */
	public void modifyIngredientsUsedWithin(int id, Ingredient newIngredient) {
		if (id != 0 || newIngredient != null) {
			Recipe recipe = searchByIdRecipe(id);//The Recipe is searched for via it's ID.
			if (recipe != null) {
				recipe.setIngredients(newIngredient);//The appropriate ID is entered.
			}
		}
	}
	/**
	 * This method is used to modify the number of portions associated with the recipe.
	 * @param id --> The ID of the recipe which is to be changed. 
	 * @param numberOfPortions --> The new number of portions.
	 */
	public static void modifyNumberOfPortions(int id, int numberOfPortions) {
		if (id!= 0) {
			Recipe recipe = searchByIdRecipe(id);//The ID is searched for.
			if (recipe != null) {
				recipe.setNumberOfPortions(numberOfPortions);//The number of portions is changed to the new number of portions.
			}
		}
	}
	/**
	 * This method is used to modify the steps included within the recipe. 
	 * @param id --> The ID of the recipe which is to be modified
	 * @param extraInfo --> The extra info which is to be added.
	 */
	public static void modifyTheStepsincluded(int id, String extraInfo) {
		if (id != 0 && extraInfo != null) {
			Recipe recipe = searchByIdRecipe(id);//The ID is searched for according to the ID.
			if (recipe != null) {
				int counter = recipe.getNumberOfSteps();
				recipe.setNumberOfSteps();
				recipe.modifyInformation("Step:" + (counter+1) + ")" + extraInfo);	//The additional info is added on.
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
	public static void modifyAddingTheIngredientsPerStep(int id, int step, Ingredient ingredient, double amount) {
		if (step != 0 && ingredient != null) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				System.out.println("Please enter step you want to change! ");
				recipe.addNewIngredientsForStep(step, ingredient,amount);//The step, ingredient and amount is passed as paramaters.
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
	public static void modifyTheAmountPerStep(int id, int step,int position, double amount) {
		if (step != 0 && amount != 0) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				System.out.println("Please enter step you want to change! ");
				recipe.setNewAmountForEachStep(step, position, amount);//The necessary parameters are passed.
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
	public static void modifyTheIngredientPerStep(int id, int step,int position, Ingredient ingredient) {
		if (step != 0 && ingredient != null) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				
				recipe.setNewIngredientsPerStep(step, position, ingredient);//The necessary parameters are passed.
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
	public static void modifyTheUnitOfAmountPerstep(int id, int step,int position, UnitOfMeasurement newMeasurement) {
		if (step != 0 && newMeasurement != null) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				System.out.println("Please enter step you want to change! ");
				recipe.setNewUnitForAmount(step, position, newMeasurement);//The necessary parameters are passed.
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
	public static void modifyTheTimeForEachStep(int id, int step,int position, double time) {
		if (step != 0 && time != 0) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				System.out.println("Please enter step you want to change! ");
				recipe.setNewTimeForEachStep(step, position, time); //The necessary parameters are passed.
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
	public static void modifyTheUnitOfTimeForEachStep(int id, int step,int position, Time unitOfTime) {
		if (step != 0 && unitOfTime != null) {
			Recipe recipe = searchByIdRecipe(id);
			if (recipe != null) {
				System.out.println("Please enter step you want to change! ");
				recipe.setNewUnitForTimeEachStep(step, position, unitOfTime);//The necessary parameters are passed.
			}	
		}
	}
	
	/**
	 * This method combines all modification methods, into one where necessary modification actions can be made. 
	 * @return --> Returns true or false on whether the process has gone smoothly. 
	 */
	public boolean modifyRecipe() {
		System.out.println("Please enter the ID of the recipe: ");//The ID of the recipe is entered. 
		int choice = input.nextInt();
		input.nextLine();
		Recipe recipe = searchByIdRecipe(choice);

		String options[] = {"Name", "Collection Of Ingredients", "Number of portions", "Steps included", "Adding Ingredients per step", "Ingredients Per step ", "Amount of the ingredient per step", "Unit for amount each step", "Time for each step", "Unit for time for each step"};
		Menu newMenu = new Menu("Modification Menu", options);
		int choice2 = newMenu.getChoice();

		switch(choice2) {//According to the users choice a specific modification is made.
		case 1:
			//Modification of the name.
			System.out.println("Please enter the new name: ");
			String newName = input.nextLine();
			modifyNameOfRecipe(choice, newName);
			break;
		case 2:
			//Modification of the ingredients in the recipe. 
			System.out.println("All ingredients have been removed from recipe: ");
			boolean flag = false;
			ArrayList <Ingredient> newIngredients = new ArrayList<Ingredient>();
			while (flag != true) {
				System.out.println(warehouse.getIngredients());//Ingredients are shown/
				System.out.println("Please enter the ID of the Ingredient: ");

				System.out.println("Enter the ID of the ingredient! (-1 to stop) ");
				int id = input.nextInt();//New ID for ingredient is entered.
				input.nextLine();
				if (id == -1) {
					flag = true;
					break;
				}
				
				Ingredient ingredient = super.searchById(id);
				modifyIngredientsUsedWithin(choice, ingredient);//New Ingredient accordingly entered.
			}
			break;
		case 3:
			//Modification of the number of portion associated with the recipe.
			System.out.println("Enter new number of portions: ");
			int newNumberOfPortions = input.nextInt();
			input.nextLine();
			modifyNumberOfPortions(choice, newNumberOfPortions);
			break;
		case 4:
			//Modification of the steps included in the recipe.
			boolean flag2 = false;
			while (flag2 != true) {
				System.out.println("Please enter any extra steps (-1) to stop: ");
				String newInfo = input.nextLine();//Any additional steps are entered by the user
				if (newInfo.equals("-1")) {
					flag = true;
					break;
				}
				modifyTheStepsincluded(choice, newInfo );
			}
			break;
		case 5:
			//Any new ingredient which are to replace one in a particular step.
			System.out.println("Please enter the step you are interested in changing! ");
			System.out.println(warehouse.getIngredientsPerStepInRecipe(recipe));
			int step = input.nextInt();//Step to be modified. 
			input.nextLine();
			boolean flag3 = false;
			while (flag3 != true) {
				System.out.println(warehouse.getIngredients());
				System.out.println("Please enter the ID of the Ingredient: ");//The ID to replace the existing ingredient.

				System.out.println("Enter the ID of the ingredient! (-1 to stop) ");
				int id = input.nextInt();
				input.nextLine();
				if (id == -1) {
					flag = true;
					break;
				}
				
				Ingredient ingredient = super.searchById(id);
				System.out.println("Enter the new amount of that ingredient!");
				double amount = input.nextDouble();//New amount entered.
				modifyAddingTheIngredientsPerStep(step,choice,ingredient,amount);//Modify functionality called. 
			}	
			break;	
		case 6:
			//Will only change the ingredient per step.
			System.out.println("Please enter the Step you are interested in changing! ");
			System.out.println(warehouse.getIngredientsPerStepInRecipe(recipe));
			
			

			System.out.println(collectionRequired);//The step is entered.
			int step2 = input.nextInt();
			input.nextLine();
			
			
			System.out.println("Please select the ingredient you would like to replace.(The position in the step) ");
			int selection = input.nextInt();//The ingredient that is to be replaced is specified.
			input.nextLine();
			System.out.println(warehouse.getIngredients());
			System.out.println("Please enter the id of an ingredient you would like to replace it with: ");
			int selection2 = input.nextInt();//The new ID of the ingredient which is to replace the old is specified. 
			input.nextLine();
			
			Ingredient ingredient = super.searchById(selection2);
			System.out.println(ingredient.getName());
			modifyTheIngredientPerStep(choice,step2,selection,ingredient);//Searches are done and the parameters are passed to the modification functionality.
			break;
		case 7:
			//This step will replace the amounts associated with a particular step and ingredient.
			System.out.println("Please enter the Step you are interested in changing! ");
			System.out.println(warehouse.getAmountForSpecificIngredientInRecipe(recipe));
			
			int step3 = input.nextInt();//The step is selected. 
			input.nextLine();
			
			
			System.out.println("Please select the amount you would like to replace.(The position in the step) ");
			int selectionAmount = input.nextInt();//The existing amount is selected.
			input.nextLine();
			System.out.println("Please enter the new amount you would like to replace it with: ");//The new amount is entered.
			double selectionNewAmount = input.nextDouble();
			input.nextLine();
			
			modifyTheAmountPerStep(choice,step3,selectionAmount,selectionNewAmount);//The appropriate modification functionality is called where the new amount is supplied.
			break;
		case 8 : 
			//This is used to change the unit of a particular amount.
			System.out.println("Please enter the Step you are interested in changing! ");
			System.out.println(warehouse.getUnitForAmountForSpecificIngredientInRecipe(recipe));
			int step4 = input.nextInt();//The step interested in change is entered.
			input.nextLine();
			
			
			System.out.println("Please select the unit you would like to replace. (The position in the step) ");
			int selectionUnit = input.nextInt();//The unit which is to be replaced is entered.
			input.nextLine();
			System.out.println("Please enter the new unit you would like to replace it with: ");//the new unit is selected via the menu, and the necessary modifications are made. 
			String choices[] = {UnitOfMeasurement.GRAMS.toString(), UnitOfMeasurement.LITRE.toString(), UnitOfMeasurement.POUNDS.toString(), UnitOfMeasurement.OUNCE.toString(), UnitOfMeasurement.MILLILIETER.toString(), UnitOfMeasurement.CUPS.toString(),UnitOfMeasurement.TABLE_SPOON.toString()};
			Menu newMenuForUnits = new Menu("Units of Amount",choices);
			int choiceForUnits = newMenuForUnits.getChoice();
			switch(choiceForUnits) {
			case 1:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.GRAMS);
				break;
			case 2:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.LITRE);
				break;
			case 3:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.POUNDS);
				break;
			case 4:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.OUNCE);
				break;
			case 5:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.MILLILIETER);
				break;
			case 6:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.CUPS);
				break;
			case 7:
				modifyTheUnitOfAmountPerstep(choice,step4,selectionUnit,UnitOfMeasurement.TABLE_SPOON);
				break;
			}
			break;
		case 9:
			//This is used to change the particular time associated with a particular step.
			System.out.println("Please enter the Step you are interested in changing! ");
			System.out.println(warehouse.getTimeForEachStep(recipe));
			int step5 = input.nextInt();//The step interetsed in change is entered.
			input.nextLine();
			
			
			System.out.println("Please select the time you would like to replace. ");
			int selectionTime = input.nextInt();//The old time to be replaced is entered.
			input.nextLine();
			System.out.println("Please enter the new amount you would like to replace it with: ");
			double selectionNewTime = input.nextDouble();
			input.nextLine();//The new time to replace the old time is entered here.
			
			modifyTheTimeForEachStep(choice,step5,selectionTime,selectionNewTime);//The modification functionality is accordingly called.
			break;
		case 10:
			//The unit of time is changed via this condtion.
			System.out.println("Please enter the step you are interested in changing! ");
			System.out.println(warehouse.getUnitOfTimeForEachStep(recipe));
			int step6 = input.nextInt();//The step interested in change is entered. 
			input.nextLine();
			System.out.println("Please select the Unit of time you would like to replace. ");
			int selectionUnitOfTime = input.nextInt();//The unit of time to be replaced is identified. 
			input.nextLine();
			System.out.println("Please enter the new amount you would like to replace it with: ");//The new unit of time which is to replace the old unit of time is identified.
			String choices2[] = {Time.SECOND.toString(), Time.MINUTE.toString(), Time.HOUR.toString(), Time.DAY.toString(), Time.MONTH.toString(), Time.YEAR.toString()};
			Menu newMenu2 = new Menu("Unit of time", choices2);
			int choiceSelected = newMenu2.getChoice();
			//The appropriate modifications are made according to the unit of time.
			switch(choiceSelected) {
			case 1:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.SECOND);
				break;
			case 2:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.MINUTE);
				break;
			case 3:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.HOUR);
				break;
			case 4:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.DAY);
				break;
			case 5:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.MONTH);
				break;
			case 6:
				modifyTheUnitOfTimeForEachStep(choice,step6,selectionUnitOfTime,Time.YEAR);
				break;
			}
			break;
			
		}
		return true;
	}

}
