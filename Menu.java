package part01;
import java.util.Scanner;
/**
* Author: Nikhil Mathur
* Student Number: 40404282
* Purpose: 
* The purpose of this class is to provide a blueprint for creating internal menu's for the end users, 
* so that they have a sequential listing of choices to specific demands. This menu is to allow users to view choices and make nessary decisions.
*/
public class Menu {
	
	private String title;
	private String options[];
	private Scanner input; 
	
	/**
	 * 
	 * @param title -> The title of the respective menu to be created.
	 * @param options -> The different options/choices which can be chosen. 
	 * A scanner has also been created to allow users to enter their choice when needed.
	 */
	public Menu(String title, String options[]) {
		this.title = title;
		this.options = options;
		this.input = new Scanner(System.in);
		
	}
	/**
	 * The purpose of this method is to display all the instance data in a structured manner. 
	 * The title, and the numerous choices in a neat and appropriate manner. 
	 */
	private void display() {
		if (options != null || options.length != 0) {
			System.out.println(title);
			
			System.out.println("");
			
			for (int index = 0; index < title.length(); index++) {
				System.out.print("*");
				
			}
			
			System.out.println("");
			int x = 1;
			for (int index = 0; index < options.length; index++) {
				System.out.println(x + " " + options[index]);
				x++;
			}
		}	
	}
	
	/**
	 * This method asks the user for the their choice, where this is returned. Hence can be used in other programs if needed.
	 * @return --> returns the choice entered by the user. 
	 */
	public int getChoice() {
		display();//The private display method called in order to display the menu.
		
		System.out.println("Please enter the value of your choice: ");
		
		int value = input.nextInt(); //User asked for their choice and this is returned.
		return value;
	}
	
	


}
