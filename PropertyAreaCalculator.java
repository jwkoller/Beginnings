/**FILENAME: Property Area Calculator
 * AUTHOR: Jon Koller
 * COURSE: CPT167
 * PURPOSE: To calculate the area of a piece of property, including the area of a house and pool.
 * CREATEDATE: 08/30/2018**/

package edu.cpt167.koller.program1;


import java.util.Scanner;

public class PropertyAreaCalculator 

{

	public static void main(String[] args)
	
	{
		//Declare and initialize a Scanner object
		Scanner input = new Scanner(System.in);
		//Declare variables and default values
		String userName = "";
		double propertyLength = 0.0;
		double propertyWidth = 0.0;
		double propertySquareFootage = 0.0;
		double houseLength = 0.0;
		double houseWidth = 0.0;
		double houseSquareFootage = 0.0;
		double poolLength = 0.0;
		double poolWidth = 0.0;
		double poolSquareFootage = 0.0;
		double coveredSquareFootage = 0.0;
		double uncoveredSquareFootage = 0.0;
		
		//Welcome Banner
		System.out.println("Welcome to the Property Area Calculator!");
		System.out.println("This calculator will figure out the total square footage");
		System.out.println("of your property and the house and pool on it.");
		System.out.println("************************************************************");
		
		//Assign userName and variables from input
		System.out.println("\nLets start by entering your first name: ");
		userName = input.nextLine();
		System.out.println("\nThank you " + userName + ".  Now we'll talk about your");
		System.out.println("property. What is the overall property length in feet?");
		propertyLength = input.nextDouble();
		System.out.println("\nThank you. And it's width?");
		propertyWidth = input.nextDouble();
		System.out.println("\nThanks " + userName + ".  Next I'll ask about your house.");
		System.out.println("Now keeping in mind the house can't be bigger than the");
		System.out.println("whole property, what is the length of your house,");
		System.out.println("also in feet?");
		houseLength = input.nextDouble();
		System.out.println("\nExcellent.  And what is the house's width?");
		houseWidth = input.nextDouble();
		System.out.println("\nGreat, thanks for that info " + userName + ".  We're");
		System.out.println("almost done, only the pool is left. Just like the house,");
		System.out.println("the pool can't be bigger than the whole property.");
		System.out.println("So what is the length of the pool in feet?");
		poolLength = input.nextDouble();
		System.out.println("\nThanks. And the pool's width?");
		poolWidth = input.nextDouble();
		System.out.println("Thanks! Now lets put this all together!");
		
		//All area calculations from input variables
		propertySquareFootage = propertyLength * propertyWidth;
		houseSquareFootage = houseLength * houseWidth;
		poolSquareFootage = poolLength * poolWidth;
		coveredSquareFootage = houseSquareFootage + poolSquareFootage;
		uncoveredSquareFootage = propertySquareFootage - coveredSquareFootage;
		
		//Display results to user
		System.out.println("\nOk " + userName + ", here's what I've got. You told me");
		System.out.println("your property has a length of " + propertyLength + " and a");
		System.out.println("width of " + propertyWidth + ". That means its total area");
		System.out.println("is " + propertySquareFootage + " sqft.");
		System.out.println("\nThe length of your house is " + houseLength + " and its");
		System.out.println("width is " + houseWidth + ". That puts the area of the");
		System.out.println("house at " + houseSquareFootage + " sqft.");
		System.out.println("\nNow your pool has a length of " + poolLength + ", and");
		System.out.println("a width of " + poolWidth + ". So the total area of your");
		System.out.println("pool comes out to " + poolSquareFootage + " sqft.");
		System.out.println("\nThat leaves a total of " + uncoveredSquareFootage + " sqft of");
		System.out.println("uncovered area on your property.");
		
		//Farewell message
		System.out.println("\nThank you for using the Property Area Calculator");
		System.out.println(userName + "! I hope it was helpfull, and I hope you");
		System.out.println("have a great rest of your day!");
		
		//Close the scanner
		input.close();

	}

}
