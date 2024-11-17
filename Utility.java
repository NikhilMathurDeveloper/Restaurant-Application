package part01;
import java.util.ArrayList;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * To provide and store sorting capabilities, making them usable to other classes when required. 
 * These sorting requirements will sort recipes and ingredients based in alphabetical order. 
 */
public class Utility {
	
	private static int pointer;
	/**
	 * This method is to take an array list of ingredients and take each piece of data and perform an insertion sort. 
	 * @param data --> The array list which is to be sorted. 
	 * @return --> Returns the sorted array list. 
	 */
	public static ArrayList <Ingredient> sort(ArrayList <Ingredient> data){
		try {
			ArrayList <Ingredient> result = new ArrayList<Ingredient>();
			
			for (Ingredient ingredient : data) {
				if (data != null) {
					sort(ingredient,result);
				}
				
			}
			return result;
		}catch(Exception e) {
			
		}
		return null;
		
	}
	
	/**
	 * This sort is to be performed on the array list of recipes. One again it takes an array list of recipes and performs an insertion sort.  
	 * @param data --> The array list which is to be sorted. 
	 * @return
	 */
	public static ArrayList <Recipe> sort2(ArrayList <Recipe> data){
		try {
			if (data != null || data.size() != 0) {
				ArrayList<Recipe> result = new ArrayList<Recipe>();
				for (Recipe recipe: data) {
					if (data != null) {
						sort2(recipe, result);
					}
				}
				return result;	
			}
			System.out.println("The data is invalid");
			return null;	
		}catch(Exception e) {
			
		}
		return null;		
	}
	
	/**
	 * Insertion sort algorithm, which takes the ingredient, and the data. 
	 * It essential compares each value as its added into the array list, where .compareTo periodically checks if its alphabetically in the correct order.
	 * @param ingredient --> The ingredient which is to be added.
	 * @param data --> The data which stores all the ingredients which have been added.
	 */
	private static void sort(Ingredient ingredient, ArrayList <Ingredient> data) {
		int position;
		String name1 = ingredient.getName();
		for(position = 0; position < data.size(); position++) {
			String name2 = data.get(position).getName();
			if (name1.compareTo(name2) < 0) {
				break;
			}
		}
		data.add(position, ingredient);	
	}
	
	/**
	 * Similar to above, instead deals with recipe instances (object references and their associated name). 
	 * @param recipe --> New recipe to be added.
	 * @param data --> To store the sorted results. 
	 */
	private static void sort2(Recipe recipe, ArrayList <Recipe> data) {
		int position;
		String name1 = recipe.getName();
		if ((data != null || data.size() != 0) && recipe != null) {
			for (position = 0; position < data.size(); position++) {
				String name2  = data.get(position).getName();
				if (name1.compareTo(name2) < 0 ) {
					break;
				}
			}
			data.add(position, recipe);
		}else {
			System.out.println("This is not valid!");
		}
		
	}
}

	
	
	/*
	public static void sortAlphabetically(ArrayList <Ingredient> data) {
		Ingredient temp;
		Ingredient newArray[] = new Ingredient[data.size()];
		
		for (int j = 0; j < data.size(); j++) {
			newArray[pointer] = data.get(j);
			pointer++;
		}
		
		for (int index = 0; index < newArray.length; index++) {
			for (int index2 = index+1; index2 < newArray.length; index2++) {
				if (newArray[index].getName().compareTo(newArray[index2].getName()) > 0) {
					temp = newArray[index];
					newArray[index] = newArray[index2];
					newArray[index2] = temp;	
				}
			}
		}
		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i].getName());
		}
	}
	
	*/
	
	
	

	/*Suitable test cases
	 * Actual data, erroneous data, boundary data.
	 * compare what is expected and what was actually got. 
	 * a test program is to be created which will test the program. 
	 * We want to specify what happens before, and what happens after. 
	 * We should consider adding elements to the front, middle and end. 
	 * Look at cases which include normal and edge situations,
	 * E.g. Edge case:  if we add something to the very begining of the array.
	 * they are all very repetitive.
	 * Check if dealing with an array overflow can be dealt with.
	 * 
	 */
	/*
	 * Examples: test cases, inserting into array. 
	 * sorting a empty list. 
	 * Sorting a null list. Check for null!
	 * Sorting a list with 1 ingredient.
	 * Sorting a list that is already sorted. 
	 * Sorting a list which is disorered. 
	 * FORMAT: Inital data, inital data after sort, sorted data. 
	 * 
	 * 
	 * 
	 * 
	 */
/*
public static void sortAlphabetically(ArrayList<Ingredient> newIngredientList) {
	
	char collectionOfCharacters[] = new char[newIngredientList.size()];
	
	if (newIngredientList.size() != 0 || newIngredientList != null) {
		for (int index = 0; index < newIngredientList.size(); index++) {
			collectionOfCharacters[pointer] = newIngredientList.get(index).getName().charAt(0);
			
		}
		pointer++;
	}
	int temp = 0;
	for (int index = 0; index < collectionOfCharacters.length; index++) {
		for (int index2 = index + 1; index2 < collectionOfCharacters.length; index2++) {
			if (collectionOfCharacters[index] > collectionOfCharacters[index2]) {
				temp = collectionOfCharacters[index];
				collectionOfCharacters[index] = collectionOfCharacters[index2];
				collectionOfCharacters[index2] = (char) temp;
				
			}
		}
	}
	
	for (int index = 0; index < collectionOfCharacters.length; index++) {
		for (int index2 = 0; index2 < newIngredientList.size(); index2++) {
			if (newIngredientList.get(index2).getName().charAt(0) == collectionOfCharacters[index] ) {
				System.out.println("Ingredient: "+ newIngredientList.get(index2).toString());	
			}
		}
	}
}
*/

/*
public static String searchSorted(String name, ArrayList<Ingredient> newIngredientList) {
	if (name != null && newIngredientList != null && newIngredientList.size() != 0) {
		int low = 0;
		int high = newIngredientList.size()-1 ;
		int value2 = name.charAt(0);
		while (low <= high) {
			int middle = low + (high-low)/2;
			int value = newIngredientList.get(middle).getName().charAt(0);
			
			if (value < value2) {
				low = middle + 1;
			}else if(value > value2){
				high = middle -1;
				
			}else {
				System.out.println("We have found it");
				return newIngredientList.get(middle).toString();
			}	
		}	
	}
	return null;		
}
*/
	

