package part02;

import part01.MainMenu;
import part01.MenuCollection;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: Unit testing on the menu part of the system. Understand/identify if the collection of menu's and manipulating of the are doable. 
 * Test cases are explained in copyOfTestingTemplate.xls.
 * Outcomes of testing are put into Testing.DOC.
 * 
 */
public class TesterMenuUnit {
	
	
	static MenuCollection menuCollection = new MenuCollection();
	static MenuCollection newMenu = new MenuCollection();
	static MenuCollection empty = new MenuCollection();
	
	public static void main(String args[]) {
		CT();
		ATC1();
		VM1();
		SM1();
		SM2();
		DM1();
		DM2();
		ATC2();
		VM3();
		SM3();
		DM3();
		SM4();
		DM4();
		VM2();
	}
	public static void CT() {
		System.out.println("CT - Testing if we can create a menu collection");
		MenuCollection menuCollection = new MenuCollection();
		if (menuCollection != null) {
			System.out.println("Object has been created!");
		}else {
			System.out.println("Object has not been created! ");
		}	
		System.out.println("End CT-------\n");
		
	}
	
	
	
	public static void ATC1() {
		System.out.println("ATC.1 - Testing if we can add menu's to the collection");
		MainMenu newMenu = new MainMenu();
		MainMenu newMenu2 = new MainMenu();
		menuCollection.addToCollection(newMenu);
		
		System.out.println("******");
		System.out.println("Object reference 1");
		menuCollection.viewMenu();
		
		System.out.println("******");
		menuCollection.addToCollection(newMenu2);
		System.out.println("Object reference 1 and reference 2");
		//menuCollection.viewMenu();
		System.out.println("End ATC.1------------\n ");
	}
	
	public static void VM1() {
		System.out.println("VM.1 - Testing if we can view a menu collection. ");
		menuCollection.viewMenu();
		System.out.println("End VM.1------------\n ");
	}
	
	public static void SM1() {
		System.out.println("SM.1 - Test if can search for a menu in the collection");
		if (menuCollection.searchForMenu(1) != null) {
			System.out.println("Object has been found!");
		}else {
			System.out.println("Object has not been found!");
		}
		System.out.println("End SM.1------------\n ");	
	}
	
	public static void SM2() {
		System.out.println("SM.2 - Test if can search for a menu in the collection which does not exist");
		if (menuCollection.searchForMenu(6) != null) {
			System.out.println("Object has been found!");
		}else {
			System.out.println("Object has not been found!");
		}
		System.out.println("End SM.2------------\n ");	
	}
	
	public static void DM1() {
		System.out.println("DM.1 - Test if can delete  a menu in the collection");
		menuCollection.deleteMenu(1);
		menuCollection.viewMenu();
		System.out.println("End DM.1------------\n ");	
	}
	
	public static void DM2() {
		System.out.println("DM.2 - Test if can delete  a menu in the collection which does not exist");
		menuCollection.deleteMenu(6);
		menuCollection.viewMenu();
		System.out.println("End DM.2------------\n ");	
	}
	
	public static void ATC2() {
		
		System.out.println("ATC.2 - Testing if we can add menu's to the collection (Invalid data)");
		
		newMenu.addToCollection(null);
		
		System.out.println("******");

		newMenu.addToCollection(null);
	
	
		System.out.println("End ATC.2------------\n ");
	}
	
	public static void VM3() {
		System.out.println("VM.3 - Testing if we can view a menu if the collection is full of null values");
		
		newMenu.viewMenu();
		System.out.println("End VM.3------------\n ");
	}
	
	public static void SM3() {
		System.out.println("SM.3 - Test if can search for a menu in the collection which is null. ");
		if (newMenu.searchForMenu(1) != null) {
			System.out.println("Object has been found!");
		}else {
			System.out.println("Object has not been found!");
		}
		System.out.println("End SM.3------------\n ");	
	}
	
	public static void DM3()
	{	
		System.out.println("DM.3 - Test if can delete  a menu in the collection which is null");
		newMenu.deleteMenu(1);
		menuCollection.viewMenu();
		System.out.println("End DM.3------------\n ");	
	}
	public static void SM4() {
		System.out.println("SM.4 - Test if can search for a menu in the collection which is empty. ");
		if (empty.searchForMenu(2) != null) {
			System.out.println("Object has been found!");
		}else {
			System.out.println("Object has not been found!");
		}
		System.out.println("End SM.4------------\n ");	
	}
	
	public static void DM4(){

		System.out.println("DM.4 - Test if can delete  a menu in the collection which is empty");
		empty.deleteMenu(1);
		empty.viewMenu();
		System.out.println("End DM.4------------\n ");	
	}
	
	public static void VM2() {
		System.out.println("VM.2 - Testing if we can view a menu if the collection is empty. ");
		MenuCollection newMenu = new MenuCollection();
		newMenu.viewMenu();
		System.out.println("End VM.2------------\n ");
	}
	

	


}
