package part02;

import java.util.ArrayList;

import part01.FoodGroup;
import part01.Ingredient;
import part01.Recipe;
import part01.RecipeBook;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: To test if the recipe section of the program is functional, and whether the features implemented are adequate and up to date/requirement.
 * Test cases were explained in copyOfTestingTemplate.xls 
 * Outcomes of test cases were put into Testing.DOC.
 */
public class TesterRecipe {
	
	
	static RecipeBook recipeBook = new RecipeBook();
	static RecipeBook checkEmpty = new RecipeBook();
	public static void main(String[] args) {
		data2();
		ART1();
		ART2();
	
		SBI1();
		SBN();
		SBP();
		DBID();
		DBN();
		DBPN();
		CTC();
		AET();
		AET2();
		
		
	}
	
	public static void display(ArrayList <Recipe> collectionOfRecipes) {
		if(collectionOfRecipes.size() == 0 || collectionOfRecipes == null) { 
			System.out.println("There are no ingredients to be shown! ");
		}else{
			try {
				System.out.println("This is the list of Ingredients");
				for (int index = 0; index < collectionOfRecipes.size(); index++) {
					System.out.println("\t" + collectionOfRecipes.get(index).getName());
				}
			}catch(Exception e) {
				System.out.println("There has been an error! ");
			}
			
		}
	}
	
	public static void testCreateRelevantMethod(ArrayList <Recipe> collectionOfRecipes) {
		if(collectionOfRecipes.size() == 0 || collectionOfRecipes == null) { 
			checkEmpty.getRecipes();
		}
			
			recipeBook.viewRecipes();
	}
	
	
	public static void testSearchByIdDisplay(ArrayList <Recipe> collectionOfRecipe, int id) {
		try {
			if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
				System.out.println(checkEmpty.searchById(id).getName());
			}
			System.out.println(recipeBook.searchById(id).getName());
						
		}catch(Exception e) {
			System.out.println("This is not valid!");
		}
		
	}
	
	public static void testSearchByNameDisplay(ArrayList <Recipe> collectionOfRecipe, String name) {
		try {
			if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 

				System.out.println(checkEmpty.searchByName(name).getName());
			}
			
				
				System.out.println(recipeBook.searchByName(name).getName());
			}catch(Exception e) {	
				System.out.println("This is not valid");
			}
	}
		

	
	public static void testSearchByPartName(ArrayList <Recipe> collectionOfRecipe, String name) {
		
		if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
			try {
				for (Recipe i:checkEmpty.searchByPart(name)) {
					System.out.println(i.getName());
				}	
			}catch(Exception e) {
				System.out.println("This is not valid! ");
			}
		}

		for (Recipe i:recipeBook.searchByPart(name)) {
			System.out.println(i.getName());
		}

			

		
	}
	
	
	
	public static void testDeleteById(ArrayList <Recipe> collectionOfRecipe, int id) {

			if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
				try {
					checkEmpty.deleteById(id);
					
				}catch(Exception e) {
					System.out.println("This is not valid! ");
				}
				
			}else {
				
				System.out.println("Before: ");
				System.out.println(recipeBook.getRecipes() + "\n");
				recipeBook.deleteById(id);
				System.out.println("After: ");
				System.out.println("\n");
				System.out.println(recipeBook.getRecipes() + "\n");
			}
			
	
		
	}
	
	public static void testDeleteByName(ArrayList <Recipe> collectionOfRecipe, String name) {
		if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
			try {
				checkEmpty.deleteByName(name);
			}catch(Exception e) {
				System.out.println("This is not valid!");
			}
			
		}else {
		System.out.println("Before: ");
		System.out.println(recipeBook.getRecipes() + "\n");
		recipeBook.deleteByName(name);
		System.out.println("After: ");
		System.out.println("\n");
		System.out.println(recipeBook.getRecipes() + "\n");
		}
	}
	
	public static void testDeleteByPartName(ArrayList <Recipe> collectionOfRecipe, String name) {
		if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
			try {
				checkEmpty.deleteByPartName(name);
			}catch(Exception e) {
				System.out.println("This is not valid!");
			}
			
		}else {
		System.out.println("Before: ");
		System.out.println(recipeBook.getRecipes() + "\n");
		recipeBook.deleteByPartName(name);
		System.out.println("After: ");
		System.out.println("\n");
		System.out.println(recipeBook.getRecipes() + "\n");
		}
	}
	
	public static void testCalcalculateTotalCalories(ArrayList <Recipe> collectionOfRecipe, int id) {
		if(collectionOfRecipe.size() == 0 || collectionOfRecipe == null) { 
			try {
				checkEmpty.calculateTotalCalories(id);
			}catch(Exception e) {
				System.out.println("This is not valid!");
			}
			
		}else {
		System.out.println(recipeBook.calculateTotalCalories(id));
		}
		
	}
	
	public static boolean testAlreadyExists(String name) {
		if (recipeBook.alreadyExists(name) == true) {
			return true;
		}
		return false;
		
	}

	
	
	
	public static void ART1() {
		/*
		 * Identifying if we can add a recipe outline to the collection of Recipes. 
		 * We will mention the Name of the recipe, the ingredients used within, and the number of portions its used to serve. 
		 * Identify whether the array list is able to cope with numerous recipe outlines. 
		 */
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("ART.1 - Adding a new recipe");
		System.out.println("Initial Data :");
		display(collectionOfRecipe);
		System.out.println("Inital data after new recipe has been added: ");
		display(recipeBook.getRecipes());
		System.out.println("Inital data after adding two new recipes: ");
		
		display(recipeBook.getRecipes());
		System.out.println("END ART.1-------\n");
		
	}
	
	public static void ART2() {
		/*
		 * Identifying if we can add a recipe outline to the collection of Recipes. 
		 * We will mention the Name of the recipe, the ingredients used within, and the number of portions its used to serve. 
		 * Identify whether the array list is able to cope with numerous recipe outlines. 
		 */
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("ART.2 - Adding a new recipe (Invalid data)");
		System.out.println("Initial Data :");
		display(collectionOfRecipe);
		System.out.println("Inital data after new recipe has been added: ");
		collectionOfRecipe.add(null);
		display(collectionOfRecipe);
		System.out.println("Inital data after adding two new recipes: ");
		collectionOfRecipe.add(null);
		display(collectionOfRecipe);
		System.out.println("End ART.2-------\n");
		
	}
	

	public static void SBI1() {
		
		

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("SBI.1 - Searcing a recipe by ID");
		System.out.println("Initial Data :");
		testSearchByIdDisplay(collectionOfRecipe,1);
		System.out.println("Inital data after search by ID has been made (First item): ");
		testSearchByIdDisplay(recipeBook.getRecipes(),1);
		System.out.println("Inital data after search by ID has been made (Middle item): ");
		testSearchByIdDisplay(recipeBook.getRecipes(),2);
		System.out.println("Inital data after search by ID has been made (Last item): ");
		testSearchByIdDisplay(recipeBook.getRecipes(),3);
		System.out.println("Inital data after search by ID has been made for undefined item ");
		testSearchByIdDisplay(recipeBook.getRecipes(),4);
		System.out.println("End SBI.1-------\n");
	}
	
	
	public static void SBN() {
		/*
		 *Identifying if a search can be conducted, using the Recipe's Name.
		 *We are to identify the recipe, and its contents.  
		 */
		Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
		Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("SBN- Searcing a recipe by name");
		System.out.println("Initial Data :");
		testSearchByNameDisplay(collectionOfRecipe, "Empty");
		System.out.println("Inital data after search by name has been made (First item): ");
		
		testSearchByNameDisplay(recipeBook.getRecipes(),"Bolognese Paste");
		System.out.println("Inital data after search by name has been made (Middle item): ");
		testSearchByNameDisplay(recipeBook.getRecipes(),"Apple Crumble");
		System.out.println("Inital data after search by name has been made (Last item): ");
		testSearchByNameDisplay(recipeBook.getRecipes(),"Apple Banana");
		System.out.println("Inital data after search by name has been made for undefined item ");
		testSearchByNameDisplay(recipeBook.getRecipes(),"Unexistent recipe");
		System.out.println("End SBN-------\n");
	}
	
	public static void SBP() {
		/*
		 *Identifying if a search can be conducted, using the Recipe's part name.
		 *We are to identify the recipe, and its contents.  
		 */
		

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		System.out.println("SBP - Searcing a recipe by part name");
		System.out.println("Initial Data :");
		testSearchByPartName(collectionOfRecipe, "Em");
		System.out.println("Inital data after search by name has been made (First item): ");
		
		testSearchByPartName(recipeBook.getRecipes(),"Bol");
		System.out.println("Inital data after search by name has been made (numerous recipes): ");
		testSearchByPartName(recipeBook.getRecipes(),"App");
		System.out.println("Inital data after search by name has been made for undefined item ");
		testSearchByPartName(recipeBook.getRecipes(),"Un");
		System.out.println("End SBP-------\n");
	}


	public static void DBID() {
		/*
		 *Identifying if a deletion can be conducted using the Recipe's ID.
		 *We are to remove the contents of the Recipe from the system.
		 */
		

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("DBID - Deleting a Recipe By ID");
		System.out.println("Initial Data :");
		testDeleteById(collectionOfRecipe,1);
		System.out.println("Inital data after first item has been deleted (First item): ");
		
		testDeleteById(recipeBook.getRecipes(),1);
		System.out.println("Inital data after delete by ID has been made (Middle item): ");
		testDeleteById(recipeBook.getRecipes(),2);
		System.out.println("Inital data delete by ID has been made (Last item): ");
		testDeleteById(recipeBook.getRecipes(),3);
		System.out.println("Inital data after delete by ID has been made for undefined item ");
		testDeleteById(recipeBook.getRecipes(),4);
		System.out.println("End DBIB-------\n");
	}

	
	
	public static void DBN() {
		data2();
		/*
		 *Identifying if a search can be conducted, using the Recipe's name.
		 *We are to identify the recipe, and its contents.  
		 */
		

		ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("DBN- Deleting a Recipe By Name");
		System.out.println("Initial Data :");
		testDeleteByName(collectionOfRecipe,"NonExistent");
		System.out.println("Inital data after first item has been deleted (First item): ");
		
		testDeleteByName(recipeBook.getRecipes(),"Bolognese Paste");
		System.out.println("Inital data after search by name has been made (Middle item): ");
		testDeleteByName(recipeBook.getRecipes(),"Apple Crumble");
		System.out.println("Inital data after search by name has been made (Last item): ");
		testDeleteByName(recipeBook.getRecipes(),"Apple Banana");
		System.out.println("Inital data after search by name has been made for undefined item ");
		testDeleteByName(recipeBook.getRecipes(),"NonExistent");
		System.out.println("End DBN-------\n");
	}

	
	public static void DBPN() {
		data2();
		/*
		 *Identifying if a search can be conducted, using the Recipe's part name.
		 *We are to identify the recipe, and its contents.  
		 */
		
		
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("DBPN - Deleting a Recipe By part Name");
		System.out.println("Initial Data :");
		testDeleteByPartName(collectionOfRecipe,"Non");
		System.out.println("Inital data after first item has been deleted (First item): ");
		
		testDeleteByPartName(recipeBook.getRecipes(),"Bolog");
		System.out.println("Inital data after search by part name has been made (Numerous items): ");
		testDeleteByPartName(recipeBook.getRecipes(),"App");
		System.out.println("Inital data after search by part name has been made for undefined item ");
		testDeleteByPartName(recipeBook.getRecipes(),"NonExistent");
		System.out.println("End DBPN-------\n");
	}


	public static void CTC() {
		data2();
		/*
		 * This test case will test if the total calories can be calculated based on the calories of each ingredient used and the number of portions. 
		 */
		
		ArrayList <Recipe>collectionOfRecipe = new ArrayList<Recipe>();
		
		
		System.out.println("CTC - Calculating total calories");
		System.out.println("Initial Data :");
		testCalcalculateTotalCalories(collectionOfRecipe, 1);
		System.out.println("Calories for first item(First item): ");
		

		testCalcalculateTotalCalories(recipeBook.getRecipes(),1);
		System.out.println("Calories for  middle item (Middle): ");
		testCalcalculateTotalCalories(recipeBook.getRecipes(),2);
		System.out.println("Calories for last item(Last item): ");
		testCalcalculateTotalCalories(recipeBook.getRecipes(),3);
		System.out.println("Calories for item that does not exist ");
		testCalcalculateTotalCalories(recipeBook.getRecipes(),4);
		System.out.println("End CTC-------\n");
	}
	
	
	public static void AET() {
		data2();
		System.out.println("AET - Checking if the system can check for values that already exist: ");
		
		if (testAlreadyExists("Apple Banana") == false) {
			System.out.println("Yes the item exists");
		}else {
			System.out.println("The item does not exist");
		}
		System.out.println("End AET------\n");
	}
	
	public static void AET2() {
		data2();
		System.out.println("AET.2 - Checking if the system can check for values that already exist: ");
		
		if (testAlreadyExists("Apple") == false) {
			System.out.println("Yes the item exists");
		}else {
			System.out.println("The item does not exist");
		}
		System.out.println("End AET.2------\n");
	}


	
	


	
private static void data2() {
		
	Ingredient ingredient = new Ingredient("Chicken", FoodGroup.PROTEIN, 400);
	Ingredient ingredient2 = new Ingredient("Apple", FoodGroup.FRUIT_VEG, 20);

	ArrayList <Ingredient>collectionOfIngredients = new ArrayList<Ingredient>();

	collectionOfIngredients.add(ingredient);
	collectionOfIngredients.add(ingredient2);
	Recipe recipe = new Recipe("Bolognese Paste", collectionOfIngredients,2);
	Recipe recipe2 = new Recipe("Apple Crumble", collectionOfIngredients,1);
	Recipe recipe3 = new Recipe("Apple Banana", collectionOfIngredients,2);
	recipeBook.addRecipe(recipe);
	recipeBook.addRecipe(recipe2);
	recipeBook.addRecipe(recipe3);

	}




	//Add test code for modifying Recipe

}


	
	

