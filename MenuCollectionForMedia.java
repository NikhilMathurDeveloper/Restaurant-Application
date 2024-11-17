package part03;

import java.util.ArrayList;


import part01.Recipe;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * This class is used to manage the menu instantiations, by storing into a collection. The other behaviors also enable modifications and visuals to be initialized. 
 */
public class MenuCollectionForMedia {
private ArrayList <MainMenuMedia> collectionOfMenu;
	
	/**
	 * This constructor initializes an array list which stores the different Main menu's created.
	 */
	public MenuCollectionForMedia() {
		this.collectionOfMenu = new ArrayList<MainMenuMedia>();
	}
	
	/**
	 * This method is to add the Main Menu object to the valid Array list (storage) defined in the constructor. 
	 * @param newMenu --> a Main Menu object is supplied as a parameter
	 * @return --> Returns true or false to simply indicate if all processes has occurred swiftly. 
	 */
	public boolean addToCollection(MainMenuMedia newMenu) {
		if (newMenu != null) {
			collectionOfMenu.add(newMenu); //Adds new MainMenu object reference to array list. 
			return true;
		}
		return false;
	}
	
	
	/**
	 * Iterates through the different Main Menu's situated within the array list, and displays the contents to the user. 
	 */
	
	public void viewMenu() {
		if (collectionOfMenu != null || collectionOfMenu.size() != 0) {
			for (int index = 0; index < collectionOfMenu.size(); index++) {
				collectionOfMenu.get(index).viewMenuMedia();
			}
		}
	}
	
	
	/**
	 * This method is responsible for searching a menu within the collection.
	 * @param id --> The ID of the menu to be searched for
	 * @return --> Returns the menu if found. 
	 */
	public MainMenuMedia searchForMenuMedia(int id) {
		if (id > 0 && collectionOfMenu != null || collectionOfMenu.size() != 0) {
			for (int index = 0; index < collectionOfMenu.size(); index++) {
				if (collectionOfMenu.get(index).getId() == id) {
					return collectionOfMenu.get(index);
				}
			}
		}
		return null;
	}
	/**
	 * This method is responsible for deleting a menu via it the recipe's ID.
	 * @param id --> The ID of the menu to be deleted. 
	 * @return --> Returns true if the deletion was successful.
	 */
	public boolean deleteMenuMedia(int id) {
		if (id > 0 && collectionOfMenu != null || collectionOfMenu.size() != 0) {
			MainMenuMedia toDelete = searchForMenuMedia(id);
			collectionOfMenu.remove(toDelete);
			return true;
		}
		return false;	
	}
	/**
	 * This method is responsible for modifying a specific menu. 
	 * @param id --> The menu to be modified is uniquely identified via its ID. 
	 * @param recipes --> The array list recipes is passed as a parameter, as its used within another method call.
	 */
	public void modifyMenu(int id, ArrayList <Recipe> recipes) {
		if (collectionOfMenu != null || collectionOfMenu.size() != 0) {
			for (int index = 0; index < collectionOfMenu.size(); index++) {//Iterates through the Main Menu's within the collection.
				if (collectionOfMenu.get(index).getId() == id) { //Checks if the ID in the parameters match the ones retrieved during the iteration.
					collectionOfMenu.get(index).modifyMenuMedia(recipes);//Modify menu method called. 
				}
			}
		}
	}
	
	public ArrayList<MainMenuMedia> getCollectionOfMainMenu() {
		if (collectionOfMenu != null || collectionOfMenu.size() != 0) {
			return this.collectionOfMenu;
		}
		return null;
	}

}
