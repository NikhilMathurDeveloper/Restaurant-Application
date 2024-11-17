package part01;
import java.util.ArrayList;
/**
 * Author: Nikhil Mathur
 * Student Number: 40404282
 * Purpose: To allow end users to create a blueprint/outline of a recipe. This is essentially the foundations of the recipe
 * Which specifies its different requirements and needs. 
 */
public class Recipe {
	
	
	private int id; //ID used to uniquely identify the recipe.
	private String name; //Name used to identify the recipe alphabetically.
	private ArrayList<Ingredient>collectionOfIngredients; //Used to store the different ingredients used within the recipe.
	private MethodForRecipe newMethodForRecipe; //Creates a baseline for a MethodForRecipe object instantiation.
	

	private int numberOfPortions; //States the number of portions the recipe serves.
	private static int nextNumberInSequence = 1; //Used to help declare the ID for each recipe.

	/**
	 * 
	 * @param name --> Takes the name of the recipe. 
	 * @param collectionOfIngredients --> Takes the collection of ingredients associated with the recipe. 
	 * @param numberOfPortions --> Takes the number of portions the recipes serves. 
	 */
	public Recipe(String name,  ArrayList <Ingredient> collectionOfIngredients, int numberOfPortions) {
		if (name == null || collectionOfIngredients.size() == 0 || collectionOfIngredients == null || numberOfPortions <= 0 ) {
			throw new IllegalArgumentException("Invalid data");
			
		}
		this.id = this.nextNumberInSequence; //The ID is initialized. 
		this.nextNumberInSequence++;
		this.collectionOfIngredients = new ArrayList<Ingredient>();
		this.name = name;
		this.collectionOfIngredients = collectionOfIngredients;
		
		this.numberOfPortions = numberOfPortions;
		
			
	}
	public String getName() {

		if (this.name == null) {
			System.out.println("This is not valid! ");
		}
		return this.name;		
	}
	
	public void setName(String newName) {
		if (newName != null) {
			this.name = newName;
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getNumberOfPortions() {
		return this.numberOfPortions;
	}
	
	public void setNumberOfPortions(int newPortions) {
		try {
			if (newPortions > 0) {
				this.numberOfPortions = newPortions;
			}else {
				System.out.println("This is not valid");
			}
		}catch(Exception e) {
			System.out.println("This is not valid!");
		}
		
		
	}
	
	/**
	 * This method iterates through the collection of ingredients, where its associated calories is retrieved, summed together.
	 * Its sum is then multiplied by the number of portions needed.
	 * @return --> the value is then returned, ensuring that its usable in other parts of the program. 
	 */
	
	public double calculateAllCalories() {
		
		if (collectionOfIngredients ==null || collectionOfIngredients.size() == 0) {
			return 0;
		}
		double totalSum = 0;
		for (int index = 0; index < this.collectionOfIngredients.size(); index++) {//Iteration through collection.
			totalSum = totalSum + this.collectionOfIngredients.get(index).getCalories();//Gets the number of calories and concatenates it to the total sum.
			totalSum = totalSum * getNumberOfPortions();//Multiplied by the number of portions. 
			
		}
		return totalSum;
	


		
	}
	
	
	/**
	 * This method is to iterate through the collection of ingredients, and display's all contents. 
	 */
	
	public void viewAllIngredients() {
		if (collectionOfIngredients != null || collectionOfIngredients.size() != 0) {
			for (int index = 0; index < this.collectionOfIngredients.size(); index++) {//Iteration through collection.
				System.out.println(this.collectionOfIngredients.get(index).toString());//Necessary information about ingredient displayed to the screen.
			}
		}else {
			System.out.println("There are no ingredients within! ");
		}
	}
	public void clearIngredients() {
		collectionOfIngredients.clear();
	}
	/**
	 * Adds new ingredients to the collection, by removing all ingredients and adding the relevant new ingredients. 
	 * @param newIngredient --> A new ingredient object reference which is to be newly added into the collection of ingredients.
	 */
	public void setIngredients(Ingredient newIngredient) {
		if (collectionOfIngredients != null || collectionOfIngredients.size() != 0) {
			//collectionOfIngredients.clear();
			addIngredients(newIngredient);
		}
	}
	
	
	public ArrayList<Ingredient> getCollectionOfIngredients() {
		return this.collectionOfIngredients;
	}
	
	public String toString() {
		String info = "Name: " + "\n"+ getName()+ "Collection of ingredients: " + "\n"+  getCollectionOfIngredients() +"\n"+ "Number of portions: " +"\n"+ getNumberOfPortions();
		return info;
	}
	/**
	 * This method is to add new ingredients to the collection.
	 * @param newIngredient --> A new ingredient object reference which is to be added to the collection of ingredients. 
	 * @return --> Returns true or false depending on whether the process has gone swiftly. 
	 */
	public boolean addIngredients(Ingredient newIngredient) {
		if (newIngredient != null) {
			this.collectionOfIngredients.add(newIngredient);
			return false;
		}else {
			System.out.println("Not possible");
			return false;
		}
	}
	
	 /**
	  * This method is to instantiate the MethodForRecipe object, by taking the number of steps parameter. 
	  * @param numberOfSteps --> declare the number of steps involved in the method. 
	  * @return
	  */
	public MethodForRecipe createMethod(int numberOfSteps) {
		this.newMethodForRecipe = new MethodForRecipe(numberOfSteps);//Instantiates MethodForRecipe object.
		return newMethodForRecipe;// Returns the newly created object reference. 
		//Method
	}
	
	/**
	 * Returns the info associated with the method. 
	 */
	public void viewMethod() {
		this.newMethodForRecipe.getInfo();
	}
	public String viewReturnableInfo() {
		return this.newMethodForRecipe.returnableInfo();
	}
	
	public void clearIngredientCollection() {
		this.newMethodForRecipe.getCollectionOfIngredientPerStep().clear();
	}
	/**
	 * This method is to enable the ingredients per step, and its associated amount to be changed/replaced if needed( In regards to the newMethodForRecipe object reference.) 
	 * @param newIngredients --> Ingredients object reference which is to be added
	 * @param amount --> Ingredients associated amount.
	 */
	public void modifyMethodForIngredientsPerStep(int step ,Ingredient newIngredients, double amount) {
		
		this.newMethodForRecipe.addCollectionOfIngredientsPerStep(step,newIngredients, amount);
		//Could provide a loop to allow users to select numerous ingredients. 
	}
	/**
	 * This method is to enable more information (series of steps) to be added to the method for the recipe if needed.
	 * @param info --> This parameter is the extra information (series of steps) which is to be added on.
	 */
	public void modifyInformation(String info) {
		if (info != null) {
			this.newMethodForRecipe.addExtraInformation(info);
		}
	}
	
	

	public int getNumberOfSteps() {
		return this.newMethodForRecipe.getNumberOfSteps();
	}
	/**
	 * Method calls the set method in the "method for recipe" class. 
	 */
	public void setNumberOfSteps() {
		this.newMethodForRecipe.setNumberOfSteps();
	}
	/**
	 * This method is to be add a new ingredient to a specific step. 
	 * @param step --> The step to be modified is declared. 
	 * @param ingredient --> The new ingredient object reference which is to be added is specified.
	 */
	public void addNewIngredientsForStep(int step,Ingredient ingredient, double amount ) {
		for (int index = 0; index < this.collectionOfIngredients.size();index++) { //The ingredients per step is iterated through
			if ((step-1) == (index)) {//The specific step is identified
				System.out.println(this.collectionOfIngredients);
				this.newMethodForRecipe.addCollectionOfIngredientsPerStep(index,ingredient,amount );//The new ingredient is added.
			}
		}
	}
	/**
	 * This method sets a new amount for a specific ingredient within a specific step. 
	 * @param step --> The step to be modified. 
	 * @param position --> The choice of the ingredients amount to be modified. 
	 * @param newAmount --> The amount which is to replace the old amount. 
	 */
	public void setNewAmountForEachStep(int step,int position,  double newAmount) {
		if (step > 0 && position > 0 && newAmount > 0) {
			for (int index = 0; index < this.newMethodForRecipe.getAmountOfIngredientsRequired().size(); index++) {//Iterates through ingredients available in the method for recipe.
				if ((step-1) == (index)) { //The specific step is identified. 
					System.out.println(this.newMethodForRecipe.getAmountForEachIngredient());
					for (int index2 = 0; index2 < this.newMethodForRecipe.getAmountOfIngredientsRequired().get(index).size(); index2++) {
						if (index2 == (position-1)) {//The specific choice of the ingredients amount is identified.
							this.newMethodForRecipe.getAmountOfIngredientsRequired().get(index).remove(index2);//The old amount is removed. 
							this.newMethodForRecipe.getAmountOfIngredientsRequired().get(index).add(index2, newAmount);//The new amount is added.
				
						}
					}
				}
			}
			
		}else {
			System.out.println("Not valid!");
		}
	
		
	}
	
	public ArrayList<ArrayList<Double>> getAmount(){
		return this.newMethodForRecipe.getAmountOfIngredientsRequired(); 
		
	}
	/**
	 * This method sets a new ingredient per step, where according to the step and the respective ingredient within that step a new ingredient object reference is to replace the other reference.
	 * @param step --> The step in the method which is to be modified. 
	 * @param position --> The ingredient which is to be replaced.
	 * @param ingredient --> The new ingredient object reference which is to be replace the old ingredient object reference. 
	 */
	public void setNewIngredientsPerStep(int step,int position,  Ingredient ingredient) {
		if (ingredient != null&& position > 0 && step > 0 ) {
			for (int index = 0; index < this.newMethodForRecipe.getCollectionOfIngredientPerStep().size(); index++) {
				if ((step-1) == (index)) {
					for (int index2 = 0; index2 < this.newMethodForRecipe.getCollectionOfIngredientPerStep().get(index).size(); index2++) {
						if (index2 == (position-1)) {
							System.out.println(this.newMethodForRecipe.getCollectionOfIngredientPerStep());
							this.newMethodForRecipe.getCollectionOfIngredientPerStep().get(index).remove(index2);
							this.newMethodForRecipe.getCollectionOfIngredientPerStep().get(index).add(index2, ingredient);
							
							setIngredients(ingredient);
						}
					}
				}
			}
		}else {
			System.out.println("This is not valid! ");
		}
	
			
	}
	/**
	 * This method focuses on setting a new unit for a specific amount within a step. 
	 * @param step --> The step which is to be modified. 
	 * @param position --> The unit for a specific step which is to be replaced .
	 * @param unitOfMeasurement --> The new unit which is to replace the old unit. 
	 */
	
	public void setNewUnitForAmount(int step, int position, UnitOfMeasurement unitOfMeasurement) {
		if (step > 0 && position > 0 && unitOfMeasurement!= null) {
			for (int index = 0; index < this.newMethodForRecipe.getUnitsForEachAmount().size(); index++) {//Iteration through the units for each amount.
				if ((step-1) == (index)) {//Identifies if the step to be modified matches, and allows contents to be modified. 
					System.out.println(this.newMethodForRecipe.getAmountOfIngredientsRequired());
					for (int index2 = 0; index2 < this.newMethodForRecipe.getUnitsForEachAmount().get(index).size(); index2++) {
						if (index2 == (position-1)) { //The unit which is to be replaced is identified. 
							this.newMethodForRecipe.getUnitsForEachAmount().get(index).remove(index2);//The unit to be replaced is removed. 
							this.newMethodForRecipe.getUnitsForEachAmount().get(index).add(index2, unitOfMeasurement); //The new unit is added into the position of the old unit. 
						}
					}
				}
			}
			
		}else {
			System.out.println("Not valid! ");
		}
	
		
	}
	
	public ArrayList<ArrayList<UnitOfMeasurement>> getUnitsForAmount() {
		return this.newMethodForRecipe.getUnitsForEachAmount();
	}
	/**
	 * This method is to set a new time required for a specific step. By replacing an old time. 
	 * @param step --> The step to be modified.
	 * @param position --> The specific time which is to be replaced. 
	 * @param time --> The new time which is to replace the old time. 
	 */
	
	public void setNewTimeForEachStep(int step, int position, double time) {
		if (step > 0 && position > 0 && time > 0) {
			for (int index = 0; index < this.newMethodForRecipe.getTimeForEachStep().size();index++) { //An iteration through the times for each step.
				if (index == (position-1)) { //The time to be removed is identified. 
					System.out.println(this.newMethodForRecipe.getTimeForEachStep());
					this.newMethodForRecipe.getTimeForEachStep().remove(index); //That time is removed. 
					this.newMethodForRecipe.getTimeForEachStep().add(index,time);//The new time is added into the position of the old time.
				}
			}	
		}else {
			System.out.println("This is not valid!");
		}
		
		
	}
	/**
	 * This method is to set a new unit for time for each specific step. By replacing the old unit. 
	 * @param step --> the step to be modified. 
	 * @param position --> The unit to be replaced. 
	 * @param time --> The new unit which is to replace the old unit. 
	 */
	public void setNewUnitForTimeEachStep(int step, int position, Time time) {
		if (step > 0 && position > 0 && time != null) {
			for (int index = 0; index < this.newMethodForRecipe.getUnitForTimeForEachStep().size();index++) { //An iteration through the units for each step. 
				if (index == (position-1)) { //The unit to be replaced is identified. 
					System.out.println(this.newMethodForRecipe.getUnitForTimeForEachStep());
					this.newMethodForRecipe.getUnitForTimeForEachStep().remove(index); //The old unit is removed
					this.newMethodForRecipe.getUnitForTimeForEachStep().add(index,time); //The new unit is added into the position of the old unit. 
				}
			}
		}else {
			System.out.println("This is not valid !");
		}
		
	}
	
	public ArrayList <ArrayList<Ingredient>> getPerStep() {
		return this.newMethodForRecipe.getCollectionOfIngredientPerStep();
	}
	/**
	 * Method to set the unit for each amount.
	 * @param units --> The units in an array list is passed as a parameter for setting.
	 */
	public void setUnitForAmount(ArrayList <UnitOfMeasurement> units ) {
		this.newMethodForRecipe.createUnitsForEachAmount(units);
	}
	/**
	 * The time for each step is set, via a double value passed.
	 * @param time --> New time passed.
	 */
	public void setTimeForStep(double time) {
		this.newMethodForRecipe.addTimeForEachStep(time);
	}
	
	public ArrayList<Double> getTimeForEach() {
		return this.newMethodForRecipe.getTimeForEachStep();
	}
	/**
	 * The unit of time is set via this method.
	 * @param newTime --> New unit passed.
	 */
	public void setTimeUnitForStep(Time newTime) {
		this.newMethodForRecipe.addUnitForEachTime(newTime);
	}
	
	public ArrayList<Time> getUnitForTime(){
		return this.newMethodForRecipe.getUnitForTimeForEachStep();
	}
	
	
	
}
