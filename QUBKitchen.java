package part01;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: This is the main application class, which combines all aspects of the ingredients, recipes and menu's.
 * This class utilizes the utility classes for ingredient, recipe, and menu, in order to make this main application simpler and less congested.
 */
public class QUBKitchen{
	static Scanner input = new Scanner(System.in);//Scanner for input requirements.
	static UtilityIngredientManager ingredientFunctionality = new UtilityIngredientManager();//Utility manager for ingredient.
	static UtilityRecipeManager recipeFunctionality = new UtilityRecipeManager();//Utility manager for recipe.
	static UtilityMenuManager menuFunctionality = new UtilityMenuManager();//Utility manager for menu.
	
	public static void main(String[] args) {
		ingredientFunctionality.addDefault();
		recipeFunctionality.createDefaultRecipes();

		
		String options[] = {"Ingredient", "Recipe", "Menu", "Quit"};//Choices within system shown to user.
		Menu newMenu = new Menu("QUB catering", options);
		boolean flag = false;
		while (flag != true) {
			int choice = newMenu.getChoice();
			if (choice == 1) {//According to choice specific section is targeted. 
				String options2[] = {"Add Ingredients", "View Ingredients", "View Specific Ingredient", "Delete Ingredient", "Modify Ingredient"};
				Menu newMenu2 = new Menu("Ingredients Section", options2);//Different sections within ingredient shown.
				int choice2 = newMenu2.getChoice();
				switch (choice2) {
				case 1:
					ingredientFunctionality.addIngredients();//Add ingrediebts.
					break;
				case 2:
					System.out.println(ingredientFunctionality.viewIngredientsInWarehouse());//View ingredients.
					
					break;
				case 3:
					String options1[] = {"Search By name", "Search by ID", "Search By part name", "Search by calories", "Search By FoodGroup"};
					Menu newMenu3 = new Menu("Different Search Options", options1);//Searching for ingredients via different mediums.
					int choice3 = newMenu3.getChoice();
					switch(choice3) {
					case 1:
						System.out.println("Plese enter the name: ");
						String name = input.nextLine();
						System.out.println(ingredientFunctionality.searchName(name));//Searching via name.
						
						break;
					case 2:
						System.out.println("Please enter the id: ");
						int id = input.nextInt();
						input.nextLine();
						System.out.println(ingredientFunctionality.searchById(id));//Searching via ID.
						break;
					case 3:
						System.out.println("Please enter the name: ");
						String name2 = input.nextLine();
						System.out.println(ingredientFunctionality.searchByPart(name2));//Searching via part.
						break;
					case 4:
						System.out.println("Plese enter calories: ");//Searching via calories.
						double calories = input.nextDouble();
						input.nextLine();
						System.out.println(ingredientFunctionality.searchByCalories(calories));
						break;
					case 5:
						System.out.println("Enter the food Group: ");
						String choices[] = {FoodGroup.FRUIT_VEG.toString(), FoodGroup.COMPOSITE_FOOD.toString(), FoodGroup.DAIRY.toString(),FoodGroup.CEREAL.toString(), FoodGroup.PROTEIN.toString(), FoodGroup.SUGAR.toString(), FoodGroup.FAT.toString(),FoodGroup.SPICE_HERB.toString(), FoodGroup.ESSENTIAL_NUTRIENT.toString()};
						Menu menuForFoodGroup = new Menu("Food Groups", choices);//Search via the food group the user selected.
						int choiceForFoodGroup = menuForFoodGroup.getChoice();
						switch(choiceForFoodGroup) {//According to the food group a specific search is made.
						case 1:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.FRUIT_VEG));
							break;
						case 2:
							System.out.println(	ingredientFunctionality.searchByFoodGroup(FoodGroup.COMPOSITE_FOOD));
							break;
						case 3:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.DAIRY));
							break;
						case 4:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.CEREAL));
							break;
						case 5:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.PROTEIN));
							break;
						case 6:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.SUGAR));
							break;
						case 7:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.FAT));
							break;
						case 8:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.SPICE_HERB));
							break;
						case 9:
							System.out.println(ingredientFunctionality.searchByFoodGroup(FoodGroup.ESSENTIAL_NUTRIENT));
							break;
						}
						break;
					}
					break;
				case 4:
					String options3[] = {"Delete by ID", "Delete by Name", "Delete by calories", "Delete by food Group"};
					Menu newMenu4 = new Menu("Select delete option", options3);//Deleting an ingredient.
					int choice4 = newMenu4.getChoice();
					switch(choice4) {
					case 1:
						System.out.println("Please enter the ID of the Ingredient: ");
						int id = input.nextInt();
						input.nextLine();
						ingredientFunctionality.deleteById(id);//Deleting an ingredient by ID.
						break;
					case 2:
						System.out.println("Please enter the name of the Ingredient: ");
						String name = input.nextLine();
						ingredientFunctionality.deleteByName(name);//Deleting an ingredient by name.
						break;
					case 3:
						System.out.println("Please enter the calories of the ingredient: ");
						double calories = input.nextDouble();
						input.nextLine();
						ingredientFunctionality.deleteByCalories(calories);//Deleting an ingredient by calories.
						break;
					case 4:
						System.out.println("Please enter the food group: ");
			
						System.out.println("Enter the food Group: ");
						String choices[] = {FoodGroup.FRUIT_VEG.toString(), FoodGroup.COMPOSITE_FOOD.toString(), FoodGroup.DAIRY.toString(),FoodGroup.CEREAL.toString(), FoodGroup.PROTEIN.toString(), FoodGroup.SUGAR.toString(), FoodGroup.FAT.toString(),FoodGroup.SPICE_HERB.toString(), FoodGroup.ESSENTIAL_NUTRIENT.toString()};
						Menu menuForFoodGroup = new Menu("Food Groups", choices);
						int choiceForFoodGroup = menuForFoodGroup.getChoice();//Deleting an ingredient by food group.
						switch(choiceForFoodGroup) {
						case 1:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.FRUIT_VEG);
							break;
						case 2:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.COMPOSITE_FOOD);
							break;
						case 3:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.DAIRY);
							break;
						case 4:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.CEREAL);
							break;
						case 5:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.PROTEIN);
							break;
						case 6:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.SUGAR);
							break;
						case 7:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.FAT);
							break;
						case 8:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.SPICE_HERB);
							break;
						case 9:
							ingredientFunctionality.deleteByFoodGroup(FoodGroup.ESSENTIAL_NUTRIENT);
							break;
						}
						break;
					}
					break;
				case 5:
					ingredientFunctionality.modifyIngredient();//Modifying an ingredient functionality called here.
					break;
				}
			}
			else if (choice == 2){//The recipes section.
				String options5[]= {"Add Recipes", "View All recipes", "Search Specific Recipe", "Delete Recipe", "Calculate total Calories", "Modify Recipe"};
				Menu newMenu5 = new Menu("Recipes", options5);
				int choice5 = newMenu5.getChoice();//All different options are displayed here.
				switch(choice5) {
				case 1:
					recipeFunctionality.createRecipe2();//Be able to create a recipe.
					break;
				case 2:
					
					recipeFunctionality.viewRecipes();//Be able to view the recipes.
					break;
				case 3:
					String choices[] = {"Search By ID", "Search By name", "Search by Part"};
					Menu newMenu2 = new Menu("Search Specific Recipe", choices);
					int choice6 = newMenu2.getChoice();
					switch(choice6) {
					case 1://Be able to search for a recipe, via different mediums.
						System.out.println("Please enter the recipe ID: ");
						int value = input.nextInt();
						input.nextLine();
						System.out.println(recipeFunctionality.searchByIdRecipe(value));//The recipe ID.
						break;
					case 2:
						System.out.println("Please enter the name of the Recipe: ");
						String name = input.nextLine();
						System.out.println(recipeFunctionality.searchByNameRecipe(name));//The recipe name.
						break;
					case 3:
						System.out.println("Please enter the name of the Recipe: ");
						String name2 = input.nextLine();
						System.out.println(recipeFunctionality.searchByPartRecipe(name2));//The recipe part name.
						break;
					}
					break;
				case 4:
					String choicesDelete[] = {"Delete by ID", "Delete by Name", "Delete by Part"};
					Menu newMenuDelete = new Menu("Delete recipe", choicesDelete);
					int choiceDelete = newMenuDelete.getChoice();//Delete the recipe via different mediums.
					switch (choiceDelete) {
					case 1:
						System.out.println("Please enter the recipe ID: ");
						int value = input.nextInt();
						input.nextLine();
						recipeFunctionality.deleteByIdRecipe(value);//Delete recipe via ID.
						System.out.println("Recipe deleted");
						break;
					case 2:
						System.out.println("Please enter the recipe name: ");
						String name = input.nextLine();
						recipeFunctionality.deleteByNameRecipe(name);//delete recipe via Name.
						System.out.println("Recipe deleted");
						break;
					case 3:
						System.out.println("Please enter the part name of the recipe: ");
						String name1 = input.nextLine();
						recipeFunctionality.deleteByPartNameRecipe(name1);//delete recipe via part name.
						System.out.println("Recipe/recipe's deleted");
						break;
					}
					//Delete
					break;
				case 5:
					String choices2[] = {"Search By ID", "Search By name", "Search by Part"};
					Menu newMenu3 = new Menu("Search Specific Recipe", choices2);
					int choice7 = newMenu3.getChoice();//Be able to calculate the total calories, according to a search for a specific ingredient.
					switch(choice7) {
					case 1:
						System.out.println("Please enter the recipe ID: ");
						int value = input.nextInt();//Search by ID.
						input.nextLine();
						System.out.println(recipeFunctionality.calculateIdRecipe(value));
						break;
					case 2:
						System.out.println("Please enter the name of the Recipe: ");
						String name = input.nextLine();//Search by name.
						System.out.println(recipeFunctionality.calculateByNameRecipe(name));
						break;
					case 3:
						System.out.println("Please enter the name of the Recipe: ");
						String name2 = input.nextLine();//Search by part name.
						System.out.println(recipeFunctionality.calculateByPartRecipe(name2));
						break;
					}
					break;
				case 6:
					recipeFunctionality.modifyRecipe();//Be able to modify the recipes if required.
					break;
				}
			}
			else if (choice == 3) {//To access menu functionalities.
				String options3[] = {"Create Menu", "View Menu", "Modify Menu", "Search For Menu","Delete Menu"};//Different options within the Menu.
				Menu newMenu4 = new Menu("QUB menu", options3);
				int value = newMenu4.getChoice();
				switch(value) {
				case 1:
					menuFunctionality.createMenu(recipeFunctionality.getRecipesInBook());//Create menu functionality. 
					break;
				case 2:
					menuFunctionality.viewMenu();//View menu functionality.
					break;
				case 3:
					menuFunctionality.modifyMenu(recipeFunctionality.getRecipesInBook());//Modify menu functionality.
					break;
				case 4:
					menuFunctionality.searchForMenu();//Search for a menu.
					break;
				case 5:
					menuFunctionality.deleteMenu();//Delete a menu.
					break;
				}
			}else {//Allows the user to exit anytime.
				System.out.println("You have selected to Exit! ");
				flag = true;
			}
		}
	}
}
