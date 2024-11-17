package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import console.Console;
import part01.Recipe;
import part01.RecipeBook;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * All Menu application class functionalities are controlled via this method. 
 * This is to help simplify the application class by reducing the congestion, increasing safety. 
 * Also by increasing understandability, due to a more simplified code representation. Modularity also is enabled.
 */
public class UtilityMenuForMedia extends RecipeBook {
	private static final Font f1 = new Font("Courier", Font.BOLD, 30);
	/**
	 * This is used to create a menu which can be viewed in duration of the program. 
	 * @param list --> The list of choices. 
	 * @param con --> The console to display the requirements. 
	 */
	private void createMenu(String list[],Console con) {
		int x = 1;
		if (list != null) {
			for (int index = 0; index < list.length; index++) {
				con.println(x+ "." + list[index]);
				x++;
			}
		}
	}
	/**
	 * Sets up the console, boots it up to allow changes to the interface if needed.
	 * @param con --> The console which is used.
	 */
	private static void consoleSetUp(Console con) {
		con.setSize(1000,1000);
		con.setFont(new Font("Courier",Font.BOLD,30));
		con.setColour(Color.blue);
		con.setVisible(true);	
	}
	/**
	 * To set up the console, by controlling all console visibility requirements. 
	 * @param width --> The width of the console. 
	 * @param height --> The height of the console. 
	 * @param xPos --> xCoordinate position of the console.
	 * @param yPos --> yCoordiante position of the console. 
	 * @param isInput --> A boolean condition to identify if input in the console is required. 
	 * @return --> returns the console. 
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
	
	private static MenuCollectionForMedia menuCollection = new MenuCollectionForMedia();
	
	Scanner input = new Scanner(System.in);
	/**
	 * This method is used to create a menu. 
	 * @param recipesAvailable --> The recipes available, are passed as a parameter to another method call.
	 */
	public void createMenuForMedia(ArrayList <Recipe> recipesAvailable) {
		MainMenuMedia newMenuForMedia = new MainMenuMedia();
		newMenuForMedia.createMenuMedia(recipesAvailable);
		menuCollection.addToCollection(newMenuForMedia);
	}
	
	
	/**
	 * To view the method, this functionality is initiated within this method. 
	 */
	public static void viewMenuForMedia() {
		menuCollection.viewMenu();
	
	}
	/**
	 * This method is to deal with the modification of the menu. 
	 */
	public void modifyMenuMedia(ArrayList <Recipe> recipesAvailable) {
		Console con =  setup1(600,600,100,100,true);
		con.println("Please enter the ID of the menu: ");
		int choice = Integer.valueOf(con.readLn());//The ID of the menu to be modified.

		menuCollection.modifyMenu(choice, recipesAvailable);//Modification made. 
	}
	/**
	 * This method is to deal with searching for a menu via the ID inputed. 
	 */
	public void searchForMenuMedia() {
		Console con = setup1(600,600,100,100,true);
		con.println("Please enter ID of Menu! ");
		int choice = Integer.valueOf(con.readLn());
		con.println(menuCollection.searchForMenuMedia(choice));
	}
	/**
	 * This method is to deal with deleting a menu.
	 */
	public void deleteMenuMedia() {
		Console con = setup1(600,600,100,100,true);
		con.println("Plese enter the ID of the Menu!");
		int choice = Integer.valueOf(con.readLn());
		menuCollection.deleteMenuMedia(choice);
		con.println("The Menu has been deleted");
	}

}
