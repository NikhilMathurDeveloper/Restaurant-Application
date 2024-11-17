package part01;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: 
 * This class provides a blue print for creating a Method (Step by step directions, and other details) associated with a recipe.
 * This is separate class due to the level of detail it holds. 
 */
public class MethodForRecipe {
	
	private int numberOfSteps; //Used to dictate the number of steps involved in the recipe. 
	private ArrayList<ArrayList <Ingredient>> collectionOfIngredientPerStep; //2D array list, used to store the ingredients involved with each step.
	private ArrayList <ArrayList<Double>> amountForSpecificIngredient; //2D array list, used to store the amount needed for each ingredient selected per step.
	private ArrayList <Double>amountForEachIngredient; //This array list is used to store the number of ingredients needed per step. 
	private ArrayList <ArrayList <UnitOfMeasurement>> unitForEachAmount;// A 2D array list used to store the unit for each amount involved with a specific ingredient per step. 
	private ArrayList<Double> timeForEachStep; //This array list is used to store the time associated with each step. 
	private ArrayList<Time> unitForEachTimePerStep;//This array list is to store the unit for the time's selected for each step. 
	private String information = ""; //Used to concatenate relevant information (series of steps) associated with the recipe.
	private Scanner input;//Declared in-case the user is to enter any information. 
	private int counter;
	
	/**
	 * 
	 * @param numberOfSteps -> The number of steps involved in a method is to define the method. 
	 */
	public MethodForRecipe(int numberOfSteps) {
		if (numberOfSteps <= 0) {
			throw new IllegalArgumentException("Invalid data");
		}
		this.numberOfSteps = numberOfSteps;
		this.input = new Scanner(System.in);
		this.collectionOfIngredientPerStep= new ArrayList<ArrayList <Ingredient>>(); //2D array list, used to store the ingredients involved with each step.
		this.amountForSpecificIngredient = new ArrayList<ArrayList<Double>>();
		this.amountForEachIngredient  = new ArrayList<Double>();
		this.unitForEachAmount = new ArrayList<ArrayList<UnitOfMeasurement>>();
		this.timeForEachStep = new ArrayList<Double>();
		this.unitForEachTimePerStep = new ArrayList<Time>();
		
		
	}
	
	/**
	 * The purpose of this method is to allow users to add ingredients per step, and their associated amount. 
	 * @param newIngredient --> To add an ingredient needed per step, a new ingredient object reference is taken as a parameter.
	 * @param amount --> the Amount needed for the specific ingredient is also taken into consideration. 
	 * @return --> True or false returned, to indicate if processes have successfully been completed. 
	 */
	
	public boolean addCollectionOfIngredientsPerStep(int step,Ingredient newIngredient, double amount) {
		ArrayList <Ingredient> collectionOfIngredient = new ArrayList<Ingredient>();
		ArrayList<Double> collectionOfAmount = new ArrayList<Double>();
		if (newIngredient != null) {
			collectionOfIngredient.add(newIngredient);
			collectionOfAmount.add(amount);
			collectionOfIngredientPerStep.add(step,collectionOfIngredient);
			amountForSpecificIngredient.add(step,collectionOfAmount);
			return true;
		}
		return false;
	}
	
	public boolean addCollectionOfIngredientsPerStep(Ingredient newIngredient, double amount) {
		ArrayList <Ingredient> collectionOfIngredient = new ArrayList<Ingredient>();
		ArrayList<Double> collectionOfAmount = new ArrayList<Double>();
		if (newIngredient != null) {
			collectionOfIngredient.add(newIngredient);
			collectionOfAmount.add(amount);
			collectionOfIngredientPerStep.add(collectionOfIngredient);
			amountForSpecificIngredient.add(collectionOfAmount);
			return true;
		}
		return false;
	}
	
	public ArrayList<ArrayList <Ingredient>>  getCollectionOfIngredientPerStep() {
		return this.collectionOfIngredientPerStep;
	}
	
	public ArrayList<ArrayList <Double>> getAmountOfIngredientsRequired(){
		return this.amountForSpecificIngredient;
	}
 	
	/**
	 * 
	 * @param amount -->  A number of ingredients needed per step . 
	 * @return --> returns true or false checking if processes have gone swiftly. 
	 */
	public boolean addAmountForEachStep(double amount) {
		if (amount >0) {
			amountForEachIngredient.add(amount);
			return true;
		}
		return false;
	}
	

	/**
	 * 
	 * @param units --> Takes a array list as a parameter, where later placed into the relevant 2D array list. 
	 * @return --> return true or false depending on whether processes have gone swiftly. 
	 */
	public boolean createUnitsForEachAmount(ArrayList <UnitOfMeasurement> units) {
		unitForEachAmount.add(units);
		return true;
	}
	
	public ArrayList <ArrayList<UnitOfMeasurement>> getUnitsForEachAmount(){
		return this.unitForEachAmount;
	}
	
	
	/**
	 * Purpose: to add the new time specified into the relevant array list. 
	 * @param newTime --> The new time specified. 
	 * @return
	 */
	
	public boolean addTimeForEachStep(double newTime) {
		if (newTime != 0) {
			timeForEachStep.add(newTime);
			return true;
		}
		return false;
	}
	/**
	 * Purpose: To allow new units for the associated times to be added when needed.
	 * @param newTimeUnit --> The new unit associated with a relevant time.
	 * @return --> Returns true or false depending on whether processes have gone smoothly. 
	 */
	public boolean addUnitForEachTime(Time newTimeUnit) {
		if (newTimeUnit != null) {
			unitForEachTimePerStep.add(newTimeUnit);
			return true;
		}
		return false;	
	}
	
	public ArrayList <Double> getTimeForEachStep(){
		return this.timeForEachStep;
	}
	
	public ArrayList <Time> getUnitForTimeForEachStep(){
		return this.unitForEachTimePerStep;
	}
	
	
	/**
	 * Purpose: This method is to concatenate information, and more especially create a series of steps which can be followed. 
	 * @param info --> the info specified by the user, which is to be concatenated. 
	 * @return --> returns true or false depending if the processes have gone swiftly. 
	 */
	
	public boolean addExtraInformation(String info) {
		if (info != null) {
			information = information + info + "\n";
			counter++;
			return true;
		}
		return false;
	}
	
	
	public int getNumberOfSteps() {
		return this.numberOfSteps;
	}
	public void setNumberOfSteps() {
		this.numberOfSteps++;
	}
	
	public ArrayList<Double> getAmountForEachIngredient() {
		return amountForEachIngredient;
	}
	/**
	 * Purpose: This method is to display all details of the method. 
	 * This includes the ingredients per step, their associated amount and unit. 
	 * The time for each step, and its associated unit. 
	 * The extra information is also displayed to the user.  (Series of steps).
	 */
	
	public void getInfo() {
		int x= 1;
		
		for (int index = 0; index < collectionOfIngredientPerStep.size(); index++) {
			
			for (int index3 = 0; index3 < collectionOfIngredientPerStep.get(index).size(); index3++) {
				System.out.println("Step" + x + ")" + " Ingredient: " + "\n"+ "\t"+ collectionOfIngredientPerStep.get(index).get(index3).getName());
				System.out.println("Step" + x + ")" + " Amount: " +"\n"+ "\t"+ amountForSpecificIngredient.get(index).get(index3));
				
			}
			x++;
		}
		
		//" Unit: " + unitForEachAmount.get(index).get(index3)
		for (int inc = 0; inc < unitForEachAmount.size(); inc++){
			for (int inc2 = 0; inc2 < unitForEachAmount.get(inc).size(); inc2++) {
				System.out.println("Unit: " + unitForEachAmount.get(inc).get(inc2));
			}
		}
		int y = 1;
		for (int index2 = 0; index2 < timeForEachStep.size(); index2++) {
			System.out.println("Step" + y + ")" +" Time: " + "\n"+ "\t"+ timeForEachStep.get(index2)  +" Unit for time: "+unitForEachTimePerStep.get(index2));

			y++;
		}
		System.out.println("Extra info: ");
		System.out.println(information);	
	}
	
	/**
	 * This method returns all the info associated with the method for recipe. 
	 * This allows the info to be used as actual data. 
	 * @return --> Returns the info 
	 */
	public String returnableInfo() {
		int x= 1;
		String allInfo1 = "";
		String allInfo2 = "";
		String allInfo3 = "";
		String allInfo4 = "";
		
		for (int index = 0; index < collectionOfIngredientPerStep.size(); index++) {
			
			for (int index3 = 0; index3 < collectionOfIngredientPerStep.get(index).size(); index3++) {
				allInfo1 += "Step" + x + ")" + " Ingredient: " + "\n"+ "\t"+ collectionOfIngredientPerStep.get(index).get(index3).getName();
				allInfo2 += "Step" + x + ")" + " Amount: " +"\n"+ "\t"+ amountForSpecificIngredient.get(index).get(index3);
				
			}
			x++;
		}
		
		//" Unit: " + unitForEachAmount.get(index).get(index3)
		for (int inc = 0; inc < unitForEachAmount.size(); inc++){
			for (int inc2 = 0; inc2 < unitForEachAmount.get(inc).size(); inc2++) {
				allInfo3 +="Unit: " + unitForEachAmount.get(inc).get(inc2);
			}
		}
		int y = 1;
		for (int index2 = 0; index2 < timeForEachStep.size(); index2++) {
			allInfo4 +="Step" + y + ")" +" Time: " + "\n"+ "\t"+ timeForEachStep.get(index2)  +" Unit for time: "+unitForEachTimePerStep.get(index2);

			y++;
		}
		//System.out.println("Extra info: ");
		//System.out.println(information);
		String allCombinedInfo = allInfo1 + "\n" + allInfo2 + "\n" + allInfo3 + "\n" + allInfo4 + "\n" + "Extra information" + information;
		return allCombinedInfo;
	}
	
	

}
