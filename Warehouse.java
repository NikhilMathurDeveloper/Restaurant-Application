package part01;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * The purpose of this class is to store and manage all ingredient instantiations. 
 * This class essentially simplifies down the application class, by segregating the storage requirements into a more applicable file.
 */
public class Warehouse {
	private ArrayList<Ingredient> collectionOfIngredients;//The Array list which is used to store ingredient instantiations.
	
	/**
	 * The constructor is defined and used to create an instance of array list type ingredient. 
	 */
	public Warehouse() {
		this.collectionOfIngredients = new ArrayList<Ingredient>();
	}
	/**
	 * To add defualt ingredients
	 */
	public void addIngredientsDefault() {
		String names[] = {"Apple", "Baked Beans", "Bell Peppers", "Butter", "Celery","Cheese","Eggs","Flour", "Garlic", "Ground beef","Jam", "Leeks","Lettuce","Milk" };
		FoodGroup foodGroupes[] = {FoodGroup.FRUIT_VEG, FoodGroup.COMPOSITE_FOOD, FoodGroup.FRUIT_VEG, FoodGroup.DAIRY, FoodGroup.FRUIT_VEG, FoodGroup.DAIRY, FoodGroup.DAIRY,FoodGroup.CEREAL,FoodGroup.FRUIT_VEG,FoodGroup.PROTEIN,FoodGroup.SUGAR, FoodGroup.FRUIT_VEG, FoodGroup.FRUIT_VEG, FoodGroup.DAIRY };
		double calories[] = {52,155,20,717,8,402,155,364,111,332,278,61,15,42};
		Ingredient ingredient1 = new Ingredient(names[0], foodGroupes[0], calories[0]);
		Ingredient ingredient2 = new Ingredient(names[1], foodGroupes[1], calories[1]);
		Ingredient ingredient3 = new Ingredient(names[2], foodGroupes[2], calories[2]);
		Ingredient ingredient4= new Ingredient(names[3], foodGroupes[3], calories[3]);
		Ingredient ingredient5= new Ingredient(names[4], foodGroupes[4], calories[4]);
		Ingredient ingredient6= new Ingredient(names[5], foodGroupes[5], calories[5]);
		Ingredient ingredient7= new Ingredient(names[6], foodGroupes[6], calories[6]);
		Ingredient ingredient8= new Ingredient(names[7], foodGroupes[7], calories[7]);
		Ingredient ingredient9= new Ingredient(names[8], foodGroupes[8], calories[8]);
		Ingredient ingredient10= new Ingredient(names[9], foodGroupes[9], calories[9]);
		Ingredient ingredient11= new Ingredient(names[10], foodGroupes[10], calories[10]);
		Ingredient ingredient13= new Ingredient(names[11], foodGroupes[11], calories[11]);
		Ingredient ingredient14= new Ingredient(names[12], foodGroupes[12], calories[12]);
		Ingredient ingredient15= new Ingredient(names[13], foodGroupes[13], calories[13]);
		collectionOfIngredients.add(ingredient1);
		collectionOfIngredients.add(ingredient2);
		collectionOfIngredients.add(ingredient3);
		collectionOfIngredients.add(ingredient4);
		collectionOfIngredients.add(ingredient5);
		collectionOfIngredients.add(ingredient6);
		collectionOfIngredients.add(ingredient7);
		collectionOfIngredients.add(ingredient8);
		collectionOfIngredients.add(ingredient9);
		collectionOfIngredients.add(ingredient10);
		collectionOfIngredients.add(ingredient11);
		collectionOfIngredients.add(ingredient13);
		collectionOfIngredients.add(ingredient14);
		collectionOfIngredients.add(ingredient15);	
		
	}
	
	
	/**
	 * This method will focus on adding new ingredient references to the ingredient collection. 
	 * @param newIngredient --> This is the new object reference of the new ingredient which is to be added. 
	 * @return --> Will return true or false depending on whether the process has gone smoothly. 
	 */
	public boolean addIngredients(Ingredient newIngredient) {
		if (newIngredient != null && alreadyExists(newIngredient.getName()) == true) {
			//We need to also check if the ingredient already is in the list. 
			collectionOfIngredients.add(newIngredient); //Will add the ingredient into the collection.
			return true;
		}
		return false;
	}
	/**
	 * This method will perform a search on a ingredient based on a ingredient ID.
	 * @param id --> The ID of the ingredient which is to be searched for. 
	 * @return --> Will return the ingredient if found. 
	 */
	public Ingredient searchById(int id) {
		if (id > 0&collectionOfIngredients.size() != 0) {
			try {
				for (int index = 0; index < collectionOfIngredients.size(); index++) {
					Ingredient ingredient = collectionOfIngredients.get(index);
					if (ingredient.getId() == id) {//Will identify if the ID exists.
						return ingredient;
					}
				}	
			}catch(Exception e) {
				System.out.println("There may be no elements in your array");
			}
		}	
		return null;
	}
	/**
	 * Will perform a search on a ingredient based on a ingredients name. 
	 * @param name --> The name of the ingredient which is to be searched for. 
	 * @return --> Will return the ingredient if it has been found. 
	 */
	public Ingredient searchByName(String name) {
		
		if (name != null&&collectionOfIngredients.size() != 0) {
			try {
				for (int index = 0; index < collectionOfIngredients.size(); index++) {
					Ingredient ingredient = collectionOfIngredients.get(index);
					if (ingredient.getName().equals(name)) {//Will identify if a recipe with the specific name defined in parameters exists.
						return ingredient;
					}
				}	
			}catch(Exception e) {
				System.out.print("There may be no elements in the array");
			}
			
		}
		return null;
	}
	/**
	 * This method will perform a search on a ingredient based on ingredients part name. 
	 * @param name --> The part name of the ingredient which is to be searched for. 
	 * @return --> Will return the different ingredients which contain the part name.
	 */
	public ArrayList <Ingredient> searchByPart(String name) {
		
		if (name != null&&collectionOfIngredients.size() != 0) {
			try {
				ArrayList <Ingredient> result = new ArrayList<Ingredient>();
				for (int index = 0; index < collectionOfIngredients.size(); index++) {
					Ingredient ingredient = collectionOfIngredients.get(index);
					if (ingredient.getName().contains(name)) { //Will check if the ingredients name contains the particular string passed as a parameter.
						result.add(ingredient);//Will add to a array list, as there could be many recipes which contain a particular sequence of characters.
					}
				}
				return result; //Will return the result.
			}catch(Exception e) {
				System.out.println("The data may not exist, or the your data set may be empty. ");
			}
			
		}
		return null;
	}
	
	/**
	 * This method will perform a search on a ingredient based on a ingredients calories. 
	 * @param calories --> The calories of the ingredient which is to be searched for.
	 * @return --> Will return the different ingredients which contain the part name.
	 */
	public ArrayList <Ingredient> searchByCalories(double calories) {
		if (calories != 0 && collectionOfIngredients.size() != 0) {
			ArrayList <Ingredient> result = new ArrayList<Ingredient>();
			for (int index = 0; index < collectionOfIngredients.size(); index++) {
				Ingredient ingredient = collectionOfIngredients.get(index);
				if (ingredient.getCalories() == calories) { //Will check if the ingredients calories passed in the parameter matches a ingredients calories defined. 
					result.add(ingredient);	
				}	
			}
			return result;	
		}
		return null;
	}
	/**
	 * Will perform a search on a ingredient based on a ingredients food group.
	 * @param foodGroup --> The ingredients food group which is to be searched for. 
	 * @return --> Will return the collection of ingredients which are associated to that food group.
	 */
	public ArrayList <Ingredient> searchByFoodGroup(FoodGroup foodGroup){
		if(foodGroup != null && collectionOfIngredients.size() != 0 && collectionOfIngredients != null) {
			try {
				ArrayList <Ingredient> result = new ArrayList<Ingredient>();
				for (int index = 0; index < collectionOfIngredients.size(); index++) {
					Ingredient ingredient = collectionOfIngredients.get(index);
					if (ingredient.getFoodGroup2() == foodGroup) {//Will check if a particular ingredients food group matches the food group passed in the parameters.
						result.add(ingredient);//Will add to the collection.
					}
				}
				return result;//Will return the result.	
			}catch(Exception e) {
				System.out.println("There may be an error with the array available, as it may be empty or the element may be invalid");
			}
			
		}
		return null;
	}
	
	/**
	 * This method is to display all the ingredients within the collection.
	 */
	
	public void viewIngredients() {
		if (collectionOfIngredients.size() != 0 || collectionOfIngredients != null) {
			for (int index = 0; index < collectionOfIngredients.size(); index++) {
				System.out.println(collectionOfIngredients.get(index).toString());//Represents all ingredients details and contents. 
			}
		}
	}
	public ArrayList <Ingredient> getIngredients() {
		if (collectionOfIngredients != null || collectionOfIngredients.size() != 0) {
			return collectionOfIngredients;
		}
		return null;	
	}
	
	/**
	 * This method is to delete a ingredient via it's associated id. 
	 * @param id --> The ID of the ingredient which is to be deleted. 
	 * @return --> Will return true or false depending on whether the process has gone smoothly. 
	 */
	public boolean deleteIngredientByID(int id) {
		if (id > 0 && collectionOfIngredients.size() != 0 && collectionOfIngredients != null) {
			try {
				Ingredient ingredient = searchById(id); //Searches for the ingredient. 
				collectionOfIngredients.remove(ingredient);//Removes the ingredient in turn.
				return true;
			}catch(Exception E) {
				System.out.println("This operation is not possible!");
			}
			
		}
		return false;
	}
	/**
	 * This method is to delete a ingredient via it's associated Name.
	 * @param name --> The name of the ingredient which is to be deleted.
	 * @return --> Will return true or false depending on whether the deletion was done successfully. 
	 */
	
	public boolean deleteIngredientByName(String name) {
		if (name != null && collectionOfIngredients.size() != 0 && collectionOfIngredients != null) {
			try {
				Ingredient ingredient = searchByName(name); //Searches for the ingredient via it's name.
				collectionOfIngredients.remove(ingredient);//Removes the ingredient from the collection.
				return true;
			}catch(Exception e) {
				System.out.println("This operation is not possible");
			}
			
		}
		return false;
	}
	/**
	 * This method will delete ingredients via its calories. If numerous ingredients match a specific calorie then they will be removed from the collection.
	 * @param calories --> the ingredients of a specific calorie which is to be removed.
	 * @return --> Will return true or false depending on whether the process has gone smoothly or not. 
	 */
	public boolean deleteByCalories(double calories) {
		if (calories > 0 && collectionOfIngredients.size() != 0 && collectionOfIngredients != null) {
			try {
				ArrayList <Ingredient> ingredient = searchByCalories(calories);//Searches for the ingredients via the calories. 
				for (int index = 0; index < ingredient.size(); index++) {
					 collectionOfIngredients.remove(ingredient.get(index)); //Removes all ingredients associated with those amount of calories. 
				}
				return true;
			}catch(Exception E) {
				System.out.println("This operation is not possible!");
			}
			
		}
		return false;
	}
	/**
	 * This method will delete ingredients via its food group. If numerous ingredients match a specific food group, then they will be removed from the collection.
	 * @param foodGroup --> The ingredients of a specific calorie which is to be removed. 
	 * @return --> Will return true or false depending on whether the process has gone smoothly. 
	 */
	public boolean deleteByFoodGroup(FoodGroup foodGroup) {
		if (foodGroup != null && collectionOfIngredients.size() != 0 && collectionOfIngredients != null) {
			ArrayList <Ingredient> ingredient = searchByFoodGroup(foodGroup);
			for (int index = 0; index < ingredient.size(); index++) {
				 collectionOfIngredients.remove(ingredient.get(index));
			}
			return true;
		}
		return false;
	}
	/**
	 * This method is used to check if the ingredient in the collection already exists via its name. 
	 * @param name --> The name of the ingredient, used to check against all other ingredient names. 
	 * @return --> Return true or false depending on whether the process has gone smoothly. 
	 */
	public boolean alreadyExists(String name) {
		if (collectionOfIngredients != null || collectionOfIngredients.size() != 0) {
			Ingredient ingredient = searchByName(name); //Will search for the ingredient.
			if (ingredient == null) {
				return true;//If it exists it will return true.
			}
		}
		return false;// Otherwise false.
	}
	/**
	 * This method is to modify the name of the ingredient via the ingredient being selected by its ID. 
	 * @param id --> The ID of the ingredient which is to be modified.
	 * @param newName --> The new name which is to be assigned to the ingredient.
	 */
	public void modifyNameOfIngredient(int id, String newName) {
		Ingredient ingredient = searchById(id);//The ingredient being searched for via its ID.
		
		if (ingredient != null && newName != null) {
			ingredient.setName(newName); //The ingredients name being set to the new name if the ingredient exists.
		}
	}
	/**
	 * This method is to modify the food group of the ingredient via the ingredient being selected by its ID
	 * @param id --> The ID of the ingredient which is to be modified. 
	 * @param newFoodGroup --> The new food group which is to be assigned to the ingredient.
	 */
	public void modifyFoodGroup(int id, FoodGroup newFoodGroup) {
		if (id > 0 && newFoodGroup != null) {
			Ingredient ingredient = searchById(id);
			if (ingredient != null) {
				ingredient.setFoodGroup(newFoodGroup);
			}
		}
	}
	/**
	 * This method is used to modify the calories associated with an ingredient.
	 * @param id --> The ID of the ingredient which is to be modified.
	 * @param calories --> The new calories which is to be supplied.
	 */
	public void modifyCalories(int id, double calories)
	{	
		if (id > 0 && calories > 0) {
			Ingredient ingredient = searchById(id);
			if (ingredient != null) {
				ingredient.setCalories(calories);
			}
		}
	}
	
	public ArrayList<ArrayList<Ingredient>> getIngredientsPerStepInRecipe(Recipe recipe) {
		return recipe.getPerStep();
	
	}
	public ArrayList<ArrayList<Double>>getAmountForSpecificIngredientInRecipe(Recipe recipe){
		return recipe.getAmount();
	}
	
	public ArrayList<ArrayList<UnitOfMeasurement>>getUnitForAmountForSpecificIngredientInRecipe(Recipe recipe){
		return recipe.getUnitsForAmount();
	}
	
	public ArrayList<Double>getTimeForEachStep(Recipe recipe){
		return recipe.getTimeForEach();
	}
	
	public ArrayList<Time>getUnitOfTimeForEachStep(Recipe recipe){
		return recipe.getUnitForTime();
	}

	/**
	 * All the modification requirements are combined here, into one method so that code re-usability and modularity is promoted.
	 * @param input
	 */
	public void modifyIngredient(Scanner input){
		System.out.println("Please enter the ID of ingredient you would like to modify: ");
		int id = input.nextInt();
		input.nextLine();
		
		String choices[] = {"Name", "Food Group", "Calories"};
		Menu newMenu = new Menu("Options", choices);
		int choice = newMenu.getChoice();
		
		switch(choice) {
		case 1:
			//This modification changes the name
			System.out.println("Please enter new name: ");
			String newName = input.nextLine();//New name entered.
			modifyNameOfIngredient(id, newName);
			break;
		case 2:
			//This modification changes the food group of the ingredient.
			System.out.println("Please enter the new food group: ");
			String choicesOfFoodGroup[] = {FoodGroup.FRUIT_VEG.toString(), FoodGroup.COMPOSITE_FOOD.toString(), FoodGroup.DAIRY.toString(),FoodGroup.CEREAL.toString(), FoodGroup.PROTEIN.toString(), FoodGroup.SUGAR.toString(), FoodGroup.FAT.toString(),FoodGroup.SPICE_HERB.toString(), FoodGroup.ESSENTIAL_NUTRIENT.toString()};
			Menu menuForFoodGroup = new Menu("Food Groups", choicesOfFoodGroup);
			int choiceForFoodGroup = menuForFoodGroup.getChoice();
			//Modification made according to users choice.
			switch(choiceForFoodGroup) {
			case 1:
				modifyFoodGroup(id,FoodGroup.FRUIT_VEG);
				break;
			case 2:
				modifyFoodGroup(id, FoodGroup.COMPOSITE_FOOD);
				break;
			case 3:
				modifyFoodGroup(id,FoodGroup.DAIRY);
				break;
			case 4:
				modifyFoodGroup(id,FoodGroup.CEREAL);
				break;
			case 5:
				modifyFoodGroup(id,FoodGroup.PROTEIN);
				break;
			case 6:
				modifyFoodGroup(id,FoodGroup.SUGAR);
				break;
			case 7:
				modifyFoodGroup(id,FoodGroup.FAT);
				break;
			case 8:
				modifyFoodGroup(id,FoodGroup.SPICE_HERB);
				break;
			case 9:
				modifyFoodGroup(id,FoodGroup.ESSENTIAL_NUTRIENT);
				break;
			}
			break;
		case 3:
			//The calories is modified. 
			System.out.println("Please enter the new numebr of calories: ");
			double newCalories = input.nextDouble();//The new calories is entered by the user.
			input.nextLine();
			modifyCalories(id, newCalories);
			break;	
		}
	}
	
	
	
	
}
