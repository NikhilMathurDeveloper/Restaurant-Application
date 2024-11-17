package part01;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * This class is used to manage the menu part of the application class. It's purpose is to help simplify the main application class. 
 * The usage of this class also promotes modularity as this can be re-used in other parts if needed.
 * Safety is increased and congestion is reduced. 
 * Inheriting from recipe book, so that certain functionalities from recipe book can be used if needed.
 */
public class UtilityMenuManager extends RecipeBook{
	private static MenuCollection menuCollection = new MenuCollection();//Instantiated Menu collection object.
	
	Scanner input = new Scanner(System.in);//Input allowing user put in requirements.
	/**
	 * Be able to create a menu. Parameters are passed, which subsequently is used within another method call. 
	 * @param recipesAvailable --> The recipes available is the parameter passed. 
	 */
	public void createMenu(ArrayList <Recipe> recipesAvailable) {
		MainMenu newMenu = new MainMenu();//A main menu instantiation. 
		newMenu.createMenu(recipesAvailable);//Parameter passed. 
		menuCollection.addToCollection(newMenu);//New menu put into the collection of menu's
	}

	
	/**
	 * Be able to view the menu accordingly. 
	 */
	public static void viewMenu() {
		menuCollection.viewMenu();//View menu functionality called.
	}
	/**
	 * Modify menu functionality.
	 */
	public void modifyMenu(ArrayList <Recipe> recipesAvailable) {
		System.out.println("Enter the ID of the Menu");
		int choice = input.nextInt();
		input.nextLine();//The ID of the menu is selected.
		menuCollection.modifyMenu(choice,recipesAvailable);//According to the ID of the menu, the specific menu is able to be modified. 
	}
	/**
	 * This method is used to search for a menu via its ID. 
	 */
	public void searchForMenu() {
		System.out.println("Enter the ID of the Menu");
		int choice = input.nextInt();
		input.nextLine();
		menuCollection.searchForMenu(choice).viewMenu();
		
	}
	/**
	 * This method is used to delete a menu via its ID. 
	 */
	public void deleteMenu() {
		System.out.println("Enter the ID of the Menu");
		int choice = input.nextInt();
		input.nextLine();
		menuCollection.deleteMenu(choice);
		System.out.println("Menu deleted! ");
	}

}
