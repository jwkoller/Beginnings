/**FILENAME: Multipurpose Property Calculator
 * AUTHOR: Jon Koller
 * COURSE: CPT167
 * PURPOSE: Allow users to calculate the largest size house and pool allowed on a 
 * given piece of property, and choosing which type of sod and cost to cover the
 * remaining area.
 * CREATEDATE: September 14, 2018
 */


package edu.cpt167.koller.program3;

import java.util.Scanner;

public class MultiPurposePropertyCalculator 

{

	public static void main(String[] args) 
	
	{
		//Declare and initialize scanner object named input
		Scanner input = new Scanner(System.in);
		
		//Declare and initialize all constants, and variables with default values
		final double WIDTH_RESTRICT = 0.75;
		final double LENGTH_RESTRICT = 0.5;
		final String KENT_BLUEGRASS_NAME = "Kentucky Bluegrass";
		final double KENT_BLUEGRASS_PRICE = 1.47;
		final String SC_RYE_NAME = "South Carolina Rye";
		final double SC_RYE_PRICE = 0.57;
		final int WATER_DEPTH = 6;
		final String HEATER_1_NAME = "Unit A3.1";
		final double HEATER_1_CAPACITY = 3100;
		final String HEATER_2_NAME = "Unit B8.0";
		final double HEATER_2_CAPACITY = 8000;
		final String HEATER_3_NAME = "Unit C15";
		final double HEATER_3_CAPACITY = 15000;
		final String HEATER_4_NAME = "Unit D25";
		final double HEATER_4_CAPACITY = 25000;
		final String HEATER_5_NAME = "Unit E25+";
		String userName = "";
		double propertyLength = 0.0;
		double propertyWidth = 0.0;
		double propertySqFoot = 0.0;
		double houseLength = 0.0;
		double houseWidth = 0.0;
		double houseSqFoot = 0.0;
		double poolLength = 0.0;
		double poolWidth = 0.0;
		double poolSqFoot = 0.0;
		double poolWaterVolume = 0.0;
		String waterHeaterName = "";
		double coveredSqFoot = 0.0;
		double uncoveredSqFoot = 0.0;
		double sodCost = 0.0;
		String sodName = "";
		double sodPrice = 0.0;
		char sodSelect = ' ';
		
		
		//Welcome Banner
		System.out.println("************************************************************");
		System.out.printf("%-1s%10s%37s%11s%1s\n", "*","", "Hello and welcome to the Multipurpose", "", "*");
		System.out.printf("%-1s%19s%20s%19s%1s\n", "*", "", "Property Calculator!", "", "*");
		System.out.printf("%-1s%4s%49s%5s%1s\n", "*", "", "This calculator will help you plan out the house,", "", "*");
		System.out.printf("%-1s%11s%35s%12s%1s\n", "*", "", "pool, and grounds of your property.", "", "*");
		System.out.println("************************************************************");
		
		//Assign variables from user input
		System.out.println("\nTo begin, what is your first name?");
		userName = input.nextLine().toLowerCase();
		userName = userName.substring(0,1).toUpperCase() + userName.substring(1);
		System.out.println("\nThank you " + userName + ". The County has six housing");
		System.out.println("codes that must be followed for your property. They are:");
		System.out.printf("\n%-6s%-3s%-41s", "", "1.", "The length of your house must be no more");
		System.out.printf("\n%-6s%-3s%-5s%-2.0f%-34s", "", "", "than", 100*LENGTH_RESTRICT, "% of the property length.\n");
		System.out.printf("\n%-6s%-3s%-41s", "", "2.", "The width of your house must be no more");
		System.out.printf("\n%-6s%-3s%-5s%-2.0f%-34s", "", "", "than", 100*WIDTH_RESTRICT, "% of the property width.\n");
		System.out.printf("\n%-6s%-3s%-41s", "", "3.", "The length of the pool must be no more");
		System.out.printf("\n%-6s%-3s%-5s%-2.0f%-34s", "", "", "than", 100*LENGTH_RESTRICT, "% of the house length.\n");
		System.out.printf("\n%-6s%-3s%-41s", "", "4.", "The width of the pool must be no more");
		System.out.printf("\n%-6s%-3s%-5s%-2.0f%-34s", "", "", "than", 100*WIDTH_RESTRICT, "% of the house width.\n");
		System.out.printf("\n%-6s%-3s%-41s", "", "5.", "Your pool must have a heater to keep it at a");
		System.out.printf("\n%-6s%-3s%-41s", "", "", "warm but safe temperture.\n");
		System.out.printf("\n%-6s%-3s%-41s", "", "6.", "The area not covered by the house and pool");
		System.out.printf("\n%-6s%-3s%-41s", "", "", "must be covered by your choice of two");
		System.out.printf("\n%-6s%-3s%-41s", "", "", "types of sod.\n");
		System.out.println("\nWith all that in mind, I'll be figuring out the biggest");
		System.out.println("house and pool you can have, how much the sod you choose");
		System.out.println("is going to cost, and then how big of a heater your pool");
		System.out.println("will need.");
		System.out.println("\nSo " + userName + ", what is the length of your property");
		System.out.println("in feet?");
		propertyLength = input.nextDouble();
		System.out.println("\nAnd then what is its width?");
		propertyWidth = input.nextDouble();
		
		//Menu option for sod choice
		System.out.println("\nNow you can pick which kind of sod you want for the area");
		System.out.println("not covered by the house and pool.");
		System.out.printf("\n%-24s%11s%25s", "", "Sod Choices", "");
		System.out.printf("\n%-24s%11s%25s", "", "-----------", "");
		System.out.printf("\n%-8s%-4s%-18s%-6s%5.2f%10s%9s", "", "[A] ", KENT_BLUEGRASS_NAME, " at $ ", KENT_BLUEGRASS_PRICE, " per sqft.", "\n" );
		System.out.printf("\n%-8s%-4s%-18s%-6s%5.2f%10s%9s", "", "[B] ", SC_RYE_NAME, " at $ ", SC_RYE_PRICE, " per sqft.", "\n");
		System.out.println();
		System.out.print("\nPlease make your choice here: ");
		input.nextLine();
		sodSelect = input.nextLine().toUpperCase().charAt(0);
		//Selector structure for sod choice
		if (sodSelect == 'A')
		{
			sodName = KENT_BLUEGRASS_NAME;
			sodPrice = KENT_BLUEGRASS_PRICE;
		}
		else
		{
			sodName = SC_RYE_NAME;
			sodPrice = SC_RYE_PRICE;
		}
		
		//Processes and calculations
		propertySqFoot = propertyLength * propertyWidth;
		houseLength = propertyLength * LENGTH_RESTRICT;
		houseWidth = propertyWidth * WIDTH_RESTRICT;
		houseSqFoot = houseLength * houseWidth;
		poolLength = houseLength * LENGTH_RESTRICT;
		poolWidth = houseWidth * WIDTH_RESTRICT;
		poolSqFoot = poolLength * poolWidth;
		coveredSqFoot = houseSqFoot + poolSqFoot;
		uncoveredSqFoot = propertySqFoot - coveredSqFoot;
		sodCost = uncoveredSqFoot * sodPrice;
		poolWaterVolume = poolSqFoot * WATER_DEPTH;
		//Selector structure for pool water heater
		if (poolWaterVolume <= HEATER_1_CAPACITY)
		{
			waterHeaterName = HEATER_1_NAME;
		}
		else if (poolWaterVolume <= HEATER_2_CAPACITY)
		{
			waterHeaterName = HEATER_2_NAME;
		}
		else if (poolWaterVolume <= HEATER_3_CAPACITY)
		{
			waterHeaterName = HEATER_3_NAME;
		}
		else if (poolWaterVolume <= HEATER_4_CAPACITY)
		{
			waterHeaterName = HEATER_4_NAME;
		}
		else
		{
			waterHeaterName = HEATER_5_NAME;
		}
		
		//Display output and reports
		System.out.println("\n------------------------------------------------------------");
		System.out.printf("%27s%7s%26s", "", "Results", "");
		System.out.println("\n------------------------------------------------------------");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Property Length", "", propertyLength, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Property Width", "", propertyWidth, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Property Area", "", propertySqFoot, "sqft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "House Length", "", houseLength, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "House Width", "", houseWidth, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "House Area", "", houseSqFoot, "sqft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Pool Length", "", poolLength, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Pool Width", "", poolWidth, "ft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Pool Area", "", poolSqFoot, "sqft");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Pool Water Volume", "", poolWaterVolume, "cuft");
		System.out.printf("\n%-35s%1s%19s%5s", "Pool Water Heater Model", "", waterHeaterName, "");
		System.out.printf("\n%-35s%1s%19s%5s", "Type of sod chosen", "", sodName, "");
		System.out.printf("\n%-40s%1s%14.2f%5s", "Price of sod per sqft", "$", sodPrice, "");
		System.out.printf("\n%-40s%1s%14.1f%5s", "Sod Covered Area", "", uncoveredSqFoot, "sqft");
		System.out.printf("\n%-40s%1s%14.2f%5s", "Total Cost of Sod", "$", sodCost, "");
		System.out.println();
		System.out.println("\n------------------------------------------------------------");
		
		//Display farewell message
		System.out.println();
		System.out.println("\nThank you for using the calculator " + userName + ". I");
		System.out.println("hope you found it helpful, and I hope you have a great");
		System.out.println("rest of your day!");
		
		
		input.close();
			

	}

}
