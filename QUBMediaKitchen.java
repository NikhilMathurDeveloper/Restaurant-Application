package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import part01.FoodGroup;
import part01.Ingredient;


import console.Console;

/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * The main application class for QUBMediaKitchen. THis is to provide functionality, and user GUI requirements. 
 * This class is to combine all the utility classes and show-case the final product. 
 */
public class QUBMediaKitchen {

	static Scanner input = new Scanner(System.in);
	static UtilityIngredientForMedia ingredientFunctionality = new UtilityIngredientForMedia();//Utility for ingredient management.
	static UtilityRecipeForMedia recipeFunctionality = new UtilityRecipeForMedia();//Utility for recipe management. 
	static UtilityMenuForMedia menuFunctionality = new UtilityMenuForMedia();//Utility for menu management. 
	private static final Font f1 = new Font("Courier", Font.BOLD, 30);//The fonts which are used. 
	/**
	 * This method is used to create menu's, which are show-cased in duration of the program. 
	 * @param list --> Take's a array of options, which are iterated through and displayed to the user. 
	 * @param con --> The console which is responsible for displaying. 
	 */
	private static void createMenu(String list[],Console con) {
		int x = 1;//The counter used to contribute to the display/
		if (list != null) {
			for (int index = 0; index < list.length; index++) {
				con.println(x+ ". " + list[index]);//Pritnln showcasing details. 
				x++;
			}
		}
	}
	/**
	 * This method is used to set up the console, by organizing the necessary interface requirements.
	 * @param width --> The width of the console. 
	 * @param height --> The height of the console. 
	 * @param xPos --> The xCoordinate position of the requirements. 
	 * @param yPos --> the yCoordinate position of the requirements. 
	 * @param isInput --> A boolean value to indicate whether the console allows for user interaction.
	 * @return --> Returns the con set up. 
	 */
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
	/**
	 * This console is used to boot up the console by creating the interface. This is called in every instance when the console needs to be updated in any way.
	 * @param con --> The console to be set up 
	 */
	private static void consoleSetUp(Console con) {
		con.setSize(1000,1000);
		con.setVisible(true);
		
		con.setFont(f1);
		con.setColour(Color.WHITE);
		con.setBgColour(Color.BLACK);
	}
	
	/**
	 * This method is used to create/produce images 
	 * @param nameOfImage --> The name of the image is taken as a parameter. 
	 * @return --> Retunrs the image.
	 */
	private static ImageIcon produceImage(String nameOfImage) {
		String userdir = System.getProperty("user.dir");//Connects to user directory. 
		String path = userdir+"/Images/";
		String nameOfImage2 = path + nameOfImage+".png"; //gains access to the image based on the name passed. 
		ImageIcon im = new ImageIcon(nameOfImage2);
		return im;
	}

	public static void main(String[] args) {
		ingredientFunctionality.addDefaultMedia();//Adding default ingredients.
		recipeFunctionality.createDefaultRecipesInMedia();//Adding default recipes. 
		
	
		boolean flag = false;
		while (flag != true) {
			Console con = setup1(600,600,100,100,true); //Sets up the console. 
			con.setTitle("Menu");
			con.println("QUB Menu");
			String options[] = {"Ingredient", "Recipe", "Menu", "Quit"};
			createMenu(options,con);//Menu created to display all requirements. 
			con.println(produceImage("apples"));//Images produced. 
			con.println("Please enter the choice!");
			int choiceSelected = Integer.valueOf(con.readLn());//Choice from user is obtained. 
			
			
			
			//int choice = newMenu.getChoice();

			if (choiceSelected == 1) {
				con.clear();
				
				String options2[] = {"Add Ingredients", "View Ingredients", "View Specific Ingredient","Delete Ingredient", "ModifyIngredient"};
				createMenu(options2,con);//Menu Created
				con.println(produceImage("eggs"));
				con.println("Please enter choice: ");
				int choiceSelected2 = Integer.valueOf(con.readLn());//User choice taken down.
				
				Console consoleIngredient = setup1(600,600,100,100,true);
				switch (choiceSelected2) {
				case 1:
					ingredientFunctionality.addIngredientsInMedia();//User able to add ingredients.
					break;
				case 2:
					consoleSetUp(consoleIngredient);
					consoleIngredient.println(ingredientFunctionality.viewIngredientsInWarehouseInMedia());//All ingredients show-cased to the user. 
					break;
				case 3:
					consoleSetUp(consoleIngredient);

					consoleIngredient.setTitle("Ingredients");
					String choicesForSearching[] = {"Search By Name", "Search By ID", "Part Name", "Search By Calories" ,"FoodGroup"};//Provides the user ability to search for recipes. 
					createMenu(choicesForSearching,consoleIngredient);
				
					int choiceSelectingForSearching = Integer.valueOf(consoleIngredient.readLn());//According to choice specific search is completed. 
					//int choice3 = newMenu3.getChoice();
					switch(choiceSelectingForSearching) {
					case 1:
						consoleSetUp(consoleIngredient);
						consoleIngredient.clear();//Search by name.
						
						consoleIngredient.setTitle("Ingredients");
						
						consoleIngredient.println("Please enter the name of the ingredient");
						String nameOfIngredientToBeSearched = consoleIngredient.readLn();
						consoleIngredient.println("Ingredient details: ");
						consoleIngredient.println(ingredientFunctionality.searchNameInMedia(nameOfIngredientToBeSearched).toString());
						
						break;
					case 2:
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						consoleIngredient.println("Please enter the ID of the ingredient");//Search by ID.
						int id = Integer.valueOf(consoleIngredient.readLn());
						consoleIngredient.println("Ingredient details: ");
						consoleIngredient.println(ingredientFunctionality.searchByIdInMedia(id).toString());
						break;
					case 3:
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.println("Please enter the part name of the ingredient");
						String nameOfIngredientPart = consoleIngredient.readLn();//Search by part name.
						
						for (int index = 0; index <ingredientFunctionality.searchByPartInMedia(nameOfIngredientPart).size(); index++ ) {
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByPartInMedia(nameOfIngredientPart).get(index).toString());
						}
						
						break;
					case 4:
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.println("Please enter the calories of the ingredient");//Search by calories.
						double caloriesForIngredient = Double.valueOf(consoleIngredient.readLn());
						for (int index = 0; index < ingredientFunctionality.searchByCaloriesInMedia(caloriesForIngredient).size(); index++) {
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByCaloriesInMedia(caloriesForIngredient).get(index).toString());
						}
						
						break;
					case 5:
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.println("Please enter the food group of the ingredient");//Search by food group.
						String foodGroupSelectionForSearching[] = {"Fruit&Veg", "Composite-Food", "Dairy", "Cereal" ,"Protein", "Sugar", "Fat","Spice-Herb","Essential-Nutrient"};
						createMenu(foodGroupSelectionForSearching,consoleIngredient);
						
						int choiceForFoodGroup = Integer.valueOf(consoleIngredient.readLn());
						switch(choiceForFoodGroup) {
						//Depending on the food group the appropriate search is made. 
						case 1:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.FRUIT_VEG));
							
							break;
						case 2:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.COMPOSITE_FOOD));
							break;
						case 3:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.DAIRY));
							
							break;
						case 4:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.CEREAL));
							
							break;
						case 5:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.PROTEIN));
							
							break;
						case 6:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.SUGAR));
							
							break;
						case 7:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.FAT));
							
							break;
						case 8:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");	consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.SPICE_HERB));
							
							break;
						case 9:
							consoleIngredient.clear();
							consoleSetUp(consoleIngredient);
							consoleIngredient.setTitle("Ingredients");
							consoleIngredient.println("Ingredient details: ");
							consoleIngredient.println(ingredientFunctionality.searchByFoodGroupInMedia(FoodGroup.ESSENTIAL_NUTRIENT));
							
							break;
						}
						break;
					}
					break;
				case 4:
					consoleIngredient.clear();
					consoleSetUp(consoleIngredient);
					consoleIngredient.setTitle("Ingredients");
					consoleIngredient.println("This is the delete Menu");//The deleting requirements are shown to the user. 
					String optionsForDeletion[] = {"Delete By ID", "Delete By Name", "Delete By Calories", "Delete By Food Group"};
					createMenu(optionsForDeletion, consoleIngredient);//Show-cases the different delete options.
					int choice4 = Integer.valueOf(consoleIngredient.readLn());
					switch(choice4) {
					case 1://Delete by ID
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);//The console is re botted to update the interfac.e 
						consoleIngredient.setTitle("Ingredients");
						consoleIngredient.println("Please enter the ID of the ingredient you would like to delete");
						int id = Integer.valueOf(consoleIngredient.readLn());
						consoleIngredient.println("Ingredient deleted");
						ingredientFunctionality.deleteByIdInMedia(id);
						break;
					case 2://Delete by name. 
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						consoleIngredient.println("Please enter the name of the ingredient you would like to delete");
						String name = consoleIngredient.readLn();
						consoleIngredient.println("Ingredient deleted");
						ingredientFunctionality.deleteByNameInMedia(name);
						break;
					case 3://Delete by calories. 
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						consoleIngredient.println("Please enter the calories of the ingredient you would like to delete");
						double calories = Double.valueOf(consoleIngredient.readLn());
						consoleIngredient.println("Ingredient deleted");
						ingredientFunctionality.deleteByCaloriesInMedia(calories);
						break;
					case 4://Delete by food group. 
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						consoleIngredient.println("Please enter the food group of the ingredient you would like to delete");
						int foodGroupSelection = Integer.valueOf(consoleIngredient.readLn());//Gets choice from the user. 
						consoleIngredient.println("Ingredient deleted");
						if (foodGroupSelection ==1) {//According to the choice the deletion is made. 
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.FRUIT_VEG);
						}else if (foodGroupSelection ==2) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.COMPOSITE_FOOD);
						}else if (foodGroupSelection==3) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.DAIRY);
						}else if (foodGroupSelection==4) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.CEREAL);
						}else if (foodGroupSelection==5) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.PROTEIN);
						}else if(foodGroupSelection==6) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.SUGAR);
						}else if(foodGroupSelection==7) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.FAT);
						}else if(foodGroupSelection==8) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.SPICE_HERB);
						}else if(foodGroupSelection==9) {
							ingredientFunctionality.deleteByFoodGroupInMedia(FoodGroup.ESSENTIAL_NUTRIENT);
						}
						
						break;
					}
					break;
				case 5:
					consoleIngredient.clear();
					consoleSetUp(consoleIngredient);
					consoleIngredient.setTitle("Ingredients");
					consoleIngredient.println("This is to modify the Menu");//This section is to modify the ingredients. 
					
					String optionsForModification[] = {"Name","Food Group" ,"Calories"};
					createMenu(optionsForModification,consoleIngredient);//The different choices are show-cased. 
					
					int choiceForModification = Integer.valueOf(consoleIngredient.readLn());
					
					switch(choiceForModification) {
					case 1://The first case which is to modify the name of the ingredient. 
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						int id = Integer.valueOf(consoleIngredient.readLn());//The ID of the ingredient to be modified. 
						consoleIngredient.println("Please enter new name for ingredient");//The new name of the ingredient. 
						String newName = consoleIngredient.readLn();
						
						ingredientFunctionality.modifyByNameOfIngredientInMedia(id, newName);
						break;
					case 2://The second case is to modify the food group of the ingredient. 
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						int id2 = Integer.valueOf(consoleIngredient.readLn());//The ID of the ingredient to be modified. 
						String foodGroupChoices = "1-Fruit&Veg" + "\n" + "2-Composite-Food" + "\n" + "3-Dairy" + "\n"+ "4-Cereal"  + "\n" + "5-Protein" + "\n" + "6-Sugar" + "\n" + "7-Fat" + "\n" + "8-Spice-Herb" + "\n" + "Essential-Nutrient";
						consoleIngredient.println("Please enter new food group for ingredient");// the new food group of the ingredient. 
						consoleIngredient.println(foodGroupChoices);
						int choiceForFoodGroup = Integer.valueOf(consoleIngredient.readLn());
						if (choiceForFoodGroup==1) {//According to the choice, the appropriate food group is used to replace the old one.
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.FRUIT_VEG);
						}else if (choiceForFoodGroup==2) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.COMPOSITE_FOOD);
						}else if (choiceForFoodGroup ==3) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.DAIRY);
						}else if(choiceForFoodGroup==4) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.CEREAL);
						}else if(choiceForFoodGroup==5) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.PROTEIN);
						}else if (choiceForFoodGroup==6) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.SUGAR);
						}else if (choiceForFoodGroup==7) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.FAT);
						}else if (choiceForFoodGroup==8) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.SPICE_HERB);
						}else if (choiceForFoodGroup==9) {
							ingredientFunctionality.modifyByFoodGroupOfIngredientInMedia(id2, FoodGroup.ESSENTIAL_NUTRIENT);
						}
						break;
					case 3://This case is to modify the calories of the ingredient.
						consoleIngredient.clear();
						consoleSetUp(consoleIngredient);
						consoleIngredient.setTitle("Ingredients");
						int id3 = Integer.valueOf(consoleIngredient.readLn());//The ID of the ingredient to be modified. 
						consoleIngredient.println("Modify the calories of an ingredient: ");
						double caloriesRequired = Double.valueOf(consoleIngredient.readLn());//The new calories. 
						consoleIngredient.println("The ingredient has been modified!");
						ingredientFunctionality.modifyByCaloriesInMedia(id3, caloriesRequired);
						break;
					}
					
					
					break;
				}
			}
			else if (choiceSelected == 2){
				String options5[]= {"Add Recipes", "View All recipes", "Search Specific Recipe", "Delete Recipe", "Calculate total Calories", "Modify Recipe"};
				Console con2 = setup1(600,600,100,100,true);//A new console is set up from the recipe section of the application.
				consoleSetUp(con2);
				con2.setTitle("Menu");
				con2.println("Recipes");
			
				createMenu(options5, con2);//The relevant choices are show-cased to the user. 
				con2.println(produceImage("Soup"));//An image is show-cased to the user. 
				con2.println("Please select the relevant choice!");
				int choice5 = Integer.valueOf(con2.readLn());
				switch(choice5) {
				case 1:
					recipeFunctionality.createRecipe2InMedia();//Functionality which allows recipes to be added when needed.
					break;
				case 2:
					con2.clear();
					consoleSetUp(con2);//New console set up to allow for console to be updated visually when needed.
					recipeFunctionality.viewRecipesInMedia2(con2);//Allows recipes to viewed when needed.
					break;
				case 3:
					con2.clear();
					consoleSetUp(con2);
					con2.setTitle("Menu");
					con2.println("Searching for a Recipe");
					//Case used to deal with any searches of an recipe which needs to be conducted .
					String choicesOfMenu[] = {"Search By ID", "Search By name", "Search by Part"};
					createMenu(choicesOfMenu,con2);//Different choices showc-ased to the user. 
					
					
					int choice6 = Integer.valueOf(con2.readLn());
					switch(choice6) {//According to the users choice, the appropriate search is conducted. 
					case 1:
						con2.clear();
						consoleSetUp(con2);
						con2.setTitle("Menu");
						
						con2.println("Please enter the recipe ID: ");
						int value = Integer.valueOf(con2.readLn());//The ID of the recipe which is to be searched for.
					
						con2.println(recipeFunctionality.searchByIdRecipeInMedia(value));//The search is conducted. 
						break;
					case 2:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
			
						con2.println("Please enter the name of the Recipe: ");
						String name = con2.readLn();//The name of the recipe which is to be searched for. 
						con2.println(recipeFunctionality.searchByNameRecipeInMedia(name));//The search is conducted. 
						break;
					case 3:
						con2.println("Please enter the name part name of the recipe: ");
						//The part name of the recipe which is to be searched for. 
						String name2 = con2.readLn();
						con2.println(recipeFunctionality.searchByPartRecipeInMedia(name2));
						break;
					}
					break;
				case 4:
					con2.setSize(200,200);
					consoleSetUp(con2);//Console set up to ensure that updates can be made. 
					con2.println("Deleting a Recipe");
					String choicesDelete[] = {"Delete by ID", "Delete by Name", "Delete by Part"};
					createMenu(choicesDelete, con2);//Different choices showcased to the user. 
					con2.println("Please enter relevant choice: ");
					int choiceDelete = Integer.valueOf(con2.readLn());//The user's choice is recorded. 
		
					switch (choiceDelete) {
					case 1:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
						
						con2.println("Please enter the recipe ID: ");//The ID of the recipe to be deleted is recorded.
						int value = Integer.valueOf(con2.readLn());
					
						recipeFunctionality.deleteByIdRecipeInMedia(value);//The ID is deleted. 
						con2.println("Recipe has been deleted!");
						break;
					case 2:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
						con2.println("Please enter the recipe name: ");//The name of the recipe to be deleted is recorded. 
						String name = con2.readLn();
						recipeFunctionality.deleteByNameRecipeInMedia(name); //the recipe is deleted according to the name. 
						con2.println("The recipe has been deleted!");
						break;
					case 3:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
						con2.println("Please enter the part name of the recipe: ");//The part name of the recipe to be deleted. 
						
						String name1 = con2.readLn();
						recipeFunctionality.deleteByPartNameRecipeInMedia(name1);//The recipe is deleted according to the part name.
						con2.println("The recipe has been deleted!");
						break;
					}
					break;
				case 5:
					String choices2[] = {"Search By ID", "Search By name", "Search by Part"};
					consoleSetUp(con2);//This section is used to calculate the total calories of the recipe. 
					con2.setVisible(true);
					con2.setTitle("Menu");
			
					createMenu(choices2,con2);
					
					con2.println("Please enter the number of the relevant choice! ");
					
					int choice7 = Integer.valueOf(con2.readLn());
					switch(choice7) {
					case 1://According to the iD of the recipe, the appropriate calories calculation is made. 
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
						con2.println("Please enter the recipe ID: ");//The ID of the recipe, for which the calories is to be calculated. 
						int value =  Integer.valueOf(con2.readLn());
	
						con2.println(recipeFunctionality.calculateIdRecipeInMedia(value));//The calories is calculated. 
						break;
					case 2:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
				
						con2.println("Please enter the name of the Recipe: ");//The name of the recipe for which the calories to be calculated. 
						String name = con2.readLn();
						con2.println(recipeFunctionality.calculateByNameRecipeInMedia(name));//The calories is calculated according to the name. 
						break;
					case 3:
						con2.setSize(200,200);
						consoleSetUp(con2);
						con2.setTitle("Menu");
						con2.println("Please enter the part name of the Recipe: ");//The part name is entered by the user.
						String name2 = con2.readLn();
						con2.println(recipeFunctionality.calculateByPartRecipeInMedia(name2));// The calories is calculated according to the part name. 
						break;
					}
					break;
				case 6:
					recipeFunctionality.modifyRecipeInMedia();//The modification of the recipe is controlled via this functionality. 
					break;
				}
			}
			else if (choiceSelected == 3) {//This section is responsible for dealing with menu requirements. 
				String options3[] = {"Create Menu", "View Menu", "Modify Menu","Search for Menu","Delete Menu"};
				Console con3 = setup1(600,600,100,100,true);//The console is set up, for the menu part of the section.
				consoleSetUp(con3);
				
				con3.setTitle("Main Menu");
				createMenu(options3, con3);//The different choices are displayed to the user. 
				con3.println(produceImage("days"));//The image is showcased to the user. 
				con3.println("Select choice: ");
				
				
				int value = Integer.valueOf(con3.readLn());
				switch(value) {
				case 1:
					menuFunctionality.createMenuForMedia(recipeFunctionality.getRecipesInBook());//This allows for recipes to be created. 
					break;
				case 2:
					menuFunctionality.viewMenuForMedia();//This allows for menu's to be viewed. 
					break;
				case 3:
					menuFunctionality.modifyMenuMedia(recipeFunctionality.getRecipesInBook());//This allows for menu's to be modified when needed.
					break;
				case 4:
					menuFunctionality.searchForMenuMedia();//This allows for a menu to be searched for. 
					break;
				case 5:
					menuFunctionality.deleteMenuMedia();//This allows for a menu to be deleted. 
					break;
				}
			}
		}
	}
}
