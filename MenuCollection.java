package part01;
import java.util.ArrayList;


/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: The purpose of this class is to store the Main Menu's created by the end user. 
 * The main intention of this class is to simplify down the application class,
 * Ensuring that all storage requirements are situated in a more appropriate file making it more accessible and safer.
 */
public class MenuCollection {
	
	private ArrayList <MainMenu> collectionOfMenu =new ArrayList<MainMenu>();
	

	

	/**
	 * This method is to add the Main Menu object to the valid Array list (storage) defined in the constructor. 
	 * @param newMenu --> a Main Menu object is supplied as a parameter
	 * @return --> Returns true or false to simply indicate if all processes has occurred swiftly. 
	 */
	public boolean addToCollection(MainMenu newMenu) {
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
				System.out.println("Id: " + collectionOfMenu.get(index).getId());
				collectionOfMenu.get(index).viewMenu();
			}
		}
	}
	/**
	 * Menu's can be searched for via the ID inputed. The Menu is to be located according to the ID inputed.
	 * @param id --> The ID of the menu which is to be selected.
	 * @return --> Returns the Menu if found.
	 */
	public MainMenu searchForMenu(int id) {
		if (id > 0 && collectionOfMenu != null && collectionOfMenu.size() != 0) {
			try {
				for (int index = 0; index < collectionOfMenu.size(); index++) {
					MainMenu menu = collectionOfMenu.get(index);
					if (menu.getId() == (id)) {
						return collectionOfMenu.get(index);
					}
				}	
			}catch(Exception e){
				System.out.println("Not valid");
			}
			
		}
		return null;
	}
	/**
	 * Menu's can be deleted via the ID inputed. The Menu is to be located according to the ID, and then deleted from the collection.
	 * @param id --> The ID of the menu to be deleted.
	 * @return --> Returns true or false depending on whether the process was sucessful. 
	 */
	public boolean deleteMenu(int id) {
		if (id > 0 && collectionOfMenu != null || collectionOfMenu.size() != 0) {
			MainMenu toDelete = searchForMenu(id);
			collectionOfMenu.remove(toDelete);
			return true;
		}
		return false;
	}
	/**
	 * This method is responsible for locating the menu which is to be modified. 
	 * @param id --> The menu to be modified is uniquely identified via its ID. 
	 * @param recipes --> The array list recipes is passed as a parameter, as its used within another method call.
	 */
	public void modifyMenu(int id, ArrayList <Recipe> recipes) {
		if (collectionOfMenu != null || collectionOfMenu.size() != 0) {
			for (int index = 0; index < collectionOfMenu.size(); index++) {//Iterates through the Main Menu's within the collection.
				if (collectionOfMenu.get(index).getId() == id) { //Checks if the ID in the parameters match the ones retrieved during the iteration.
					collectionOfMenu.get(index).modifyMenu(recipes);//Modify menu method called. 
				}
			}
		}
	}
	
	public ArrayList<MainMenu> getCollectionOfMainMenu() {
		if (collectionOfMenu != null || collectionOfMenu.size() != 0) {
			return this.collectionOfMenu;
		}
		return null;
	}

	

	
}
