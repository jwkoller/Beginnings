/**FILENAME: SodNotZod
 * AUTHOR: Jon Koller
 * COURSE: CPT167
 * PURPOSE: Program flowchart for attendance
 * CREATEDATE: 09/04/2018**/


package edu.cpt167.koller.sodnotzod;

import java.util.Scanner;

public class SodNotZod 
{
public static int count = 0;

//Declare constants
public static final double DISCOUNT_RATE_SENIOR = 0.25;
public static final String DISCOUNT_NAME_SENIOR = "Senior Citizen Discount";
public static final double DISCOUNT_RATE_MEMBER = 0.15;
public static final String DISCOUNT_NAME_MEMBER = "S.N.Z. Membership Discount";
public static final String DISCOUNT_NAME_NONE = "No Discount";
public static final double DISCOUNT_RATE_NONE = 0.0;
public static final double TAX_RATE = .075;
public static final String SOD_SODDY_NAME = "Soddy Sod";
public static final double SOD_SODDY_PRICE = 1.39;
public static final String SOD_GREEN_NAME = "Greenest Sod";
public static final double SOD_GREEN_PRICE = 1.89;
public static final String SOD_SUPER_NAME = "Super Sod";
public static final double SOD_SUPER_PRICE = 2.09;

	public static void main(String[] args) 
	
	{
		//Declare and initialize scanner
		Scanner input = new Scanner(System.in);
		
		//Declare and initialize variables
		String userName = "";
		String sodType = "";
		char sodMenuSelect = ' ';
		char menuSelect = ' ';
		double origPrice = 0.0;
		double totalCost = 0.0;
		double discountPrice = 0.0;
		double subTotal = 0.0;
		double tax = 0.00;
		double discountRate = 0.0;
		double discountAmt = 0.0;						
		double regularPriceTotal = 0.0;
		double couldSaveAmt = 0.0;
		double grandTotal = 0.0;
		double howMany = 0.0;
		int memberCount = 0;
		int seniorCount = 0;
		int noDiscountCount = 0;
		int totalDiscountCount = 0;
		int soddyCount = 0;
		int greenCount = 0;
		int superCount = 0;
		
		//Display welcome banner
		displayWelcomeBanner();
		
		//Obtain user name
		userName = getUserName(input);
		
		//Display main menu and validate user input
		menuSelect = validateMainMenu(input);

		
		//Run-while for NOT QUIT loop
		while (menuSelect != 'Q')
		{
			//Display menu for sod type and cost
			sodMenuSelect = validSodMenuType(input, userName);
			
			//Display menu for how many
			howMany = validateHowMany(input);
		
		//Selection structure for main menu
		if (menuSelect == 'A')
		{
			discountRate = DISCOUNT_RATE_SENIOR;
			seniorCount++;
		}
		else if (menuSelect == 'B')
		{
			discountRate = DISCOUNT_RATE_MEMBER;
			memberCount++;
		}
		else
		{
			discountRate = DISCOUNT_RATE_NONE;
			noDiscountCount++;
		}
		
		//Selection structure for sod type and price menu
		if (sodMenuSelect == 'A')
		{
			sodType = SOD_SODDY_NAME;
			origPrice = SOD_SODDY_PRICE;
			soddyCount++;
			
		}
		else if (sodMenuSelect == 'B')
		{
			sodType = SOD_GREEN_NAME;
			origPrice = SOD_GREEN_PRICE;
			greenCount++;
		}
		else
		{
			sodType = SOD_SUPER_NAME;
			origPrice = SOD_SUPER_PRICE;
			superCount++;
		}
		
		
		//Calculate discount price and and total cost
		regularPriceTotal = origPrice * howMany;
		discountAmt = origPrice * discountRate * howMany;
		discountPrice = origPrice * (1 - discountRate);
		subTotal = howMany * discountPrice;
		tax = subTotal * TAX_RATE;
		totalCost = subTotal + tax;
		couldSaveAmt = origPrice * DISCOUNT_RATE_MEMBER * howMany;
		grandTotal = grandTotal + subTotal;
				
		//display receipt
		displayItemReceipt(userName, menuSelect, sodType, howMany, origPrice, regularPriceTotal, discountAmt,
			subTotal, tax, totalCost, discountRate, couldSaveAmt, memberCount, seniorCount, noDiscountCount, DISCOUNT_NAME_SENIOR,
			DISCOUNT_NAME_MEMBER);
		
		//Modify LCV and return to main menu for new selection
		menuSelect = validateMainMenu(input);
		
		}//end of run while loop for NOT QUIT

		//Display final report is any sales were made
		if (grandTotal > 0)
		{
			displayFinalReport(totalDiscountCount, memberCount, seniorCount, noDiscountCount, grandTotal, soddyCount, greenCount, superCount);
		}
		
		//Display farewell message
		displayFarewellMessage(userName);
		
		//Close Scanner
		input.close();

	}//End of main method
	
	//Method for Welcome Banner
	public static void displayWelcomeBanner()
	{
		//Welcome Banner
		System.out.println("************************************************************");
		System.out.printf("%-7s%47s%6s\n", "", "Welcome to the Sod Not Zod discount calculator!", "");
		System.out.printf("%-6s%48s%6s\n", "", "This calculator will tell you just how much your", "");
		System.out.printf("%-11s%38s%11s\n", "","sod will cost at the discounted price.","");
		System.out.println("************************************************************");
	}//End of method for welcome banner
	
	//Method for Farewell Message
	public static void displayFarewellMessage(String borrowedUserName)
	
	{
		System.out.println("\nAnother great day at Sod Not Zod! Please enjoy the rest");
		System.out.println("of your evening!");
	}//End of method for farewell banner
	
	//Method for main menu selection and validation
	public static char validateMainMenu(Scanner borrowedInput)
	{
		char localMenuSelect = ' ';
		
		//Discount selection menu
		displayMainMenu();

		if (count > 0)
		{
		borrowedInput.nextLine();
		}//test for program count
		count++;
		localMenuSelect = borrowedInput.nextLine().toUpperCase().charAt(0);
		
		//Input validation
		while (localMenuSelect != 'A' && localMenuSelect != 'B' && localMenuSelect != 'C' && localMenuSelect != 'Q')
		{
			System.out.println("\nInvalid selection. Please try again.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			displayMainMenu();
			
			localMenuSelect = borrowedInput.nextLine().toUpperCase().charAt(0);		
		}//end of input validation

		return localMenuSelect;
	}//End of method for main menu selection and validation
	
	//Method for validating quantity
	public static double validateHowMany(Scanner borrowedInput)
	{
		double localHowMany = 0;
		
		System.out.println("\nHow many bags are you purchasing? ");
		localHowMany = borrowedInput.nextDouble();
	
		while (localHowMany <= 0 || localHowMany % 0.5 > 0)
		{
			System.out.println("Please enter an amount greater than 0.\n");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.println("\nHow many bags are you purchasing? ");
			localHowMany = borrowedInput.nextDouble();
		}
		
		return localHowMany;
	}//End of method for validating quantity
	
	//Method for receipt output
	public static void displayItemReceipt(String borrowedUserName, char borrowedMenuSelect, String borrowedSodType,
			double borrowedHowMany, double borrowedOrigPrice, double borrowedRegularPriceTotal, double borrowedDiscountAmt,
			double borrowedSubTotal, double borrowedTax, double borrowedTotalCost, double borrowedDiscountRate, double borrowedCouldSaveAmt,
			int borrowedMemberCount, int borrowedSeniorCount, int borrowedNoDiscountCount, String borrowedDiscountNameSenior,
			String borrowedDiscountNameMember)
	{
		//Display report
		System.out.println("\nOk " + borrowedUserName + ", here's what we've got: \n");
		System.out.println("\n************************************************************");
		System.out.printf("%-26s%7s%27s", "", "Receipt", "");
		System.out.println("\n************************************************************");
		System.out.printf("%-15s%-6s%17s%22s", "ITEM", "AMOUNT", "PRICE", "COST");
		System.out.println("\n************************************************************");
		System.out.println("\n");
		if (borrowedMenuSelect == 'A' || borrowedMenuSelect == 'B')
		{	
		
			System.out.printf("\n%-15s%6.1f%8s%1s%8.2f%14s%8.2f\n", borrowedSodType, borrowedHowMany, "", "$", borrowedOrigPrice, "$", borrowedRegularPriceTotal);
			System.out.printf("\n%-20s%17.0f%1s%22.2f\n",  "You get a discount!", 100*borrowedDiscountRate, "%", 0-borrowedDiscountAmt);
			System.out.printf("\n%-37s%8s%7s%8.2f\n", "", "Subtotal", "$", borrowedSubTotal);			
		}
		else
		{
			System.out.printf("\n%-15s%6d%8s%1s%8.2f%14s%8.2f\n", borrowedSodType, borrowedHowMany, "", "$", borrowedOrigPrice, "$", borrowedSubTotal);
		}
		
		System.out.printf("\n%-40s%5s%15.2f\n", "", "Tax", borrowedTax);
		System.out.printf("\n%-40s%5s%7s%8.2f\n", "", "Total", "$", borrowedTotalCost);
		System.out.println("\n");
		System.out.println("\n************************************************************");
		
		if (borrowedMenuSelect == 'A')
			{
				System.out.printf("\n%-10s%1s%6.2f%-10s%-23s%-10s\n", "You saved", "$", borrowedDiscountAmt, " with your ", borrowedDiscountNameSenior, "!");
			}
			else if (borrowedMenuSelect == 'B')
			{
				System.out.printf("\n%-10s%1s%6.2f%-10s%-26s%-5s\n", "You saved", "$", borrowedDiscountAmt, " with your ", borrowedDiscountNameMember, "!");
			}
			else
			{
				System.out.printf("\n%-21s%1s%6.2f%31s%1s", "You could have saved", "$", borrowedCouldSaveAmt, " with a Sod Not Zod Membership!", "");
				System.out.println("\nSee store representative for details!");
			}
		System.out.println("\nThank you " + borrowedUserName + " for shopping at Sod Not Zod!");
		System.out.println("\n............................................................\n");
			
	}//End of method for receipt output
	
	//Method for final report after all purchases
	public static void displayFinalReport (int borrowedTotalDiscountCount, int borrowedMemberCount, int borrowedSeniorCount, 
			int borrowedNoDiscountCount, double borrowedGrandTotal, int borrowedSoddyCount, int borrowedGreenCount, int borrowedSuperCount)
	{
		borrowedTotalDiscountCount = borrowedMemberCount + borrowedSeniorCount;
		
		System.out.println("\n************************************************************");
		System.out.printf("%-24s%12s%24s", "", "Final Report", "");
		System.out.println("\n************************************************************");
		System.out.printf("\n%-10s%-30s%20d", "Number of ", DISCOUNT_NAME_MEMBER , borrowedMemberCount);
		System.out.printf("\n%-10s%-30s%20d", "Number of ", DISCOUNT_NAME_SENIOR, borrowedSeniorCount);
		System.out.printf("\n%-10s%-30s%20d", "Number of ", DISCOUNT_NAME_NONE, borrowedNoDiscountCount);
		System.out.printf("\n%-30s%30d", "Total number of Discounts", borrowedTotalDiscountCount);
		System.out.printf("\n%-10s%-10s%-10s%30d", "Number of ", SOD_SODDY_NAME, "selections", borrowedSoddyCount);
		System.out.printf("\n%-10s%-13s%-10s%27d", "Number of ", SOD_GREEN_NAME, "selections", borrowedGreenCount);
		System.out.printf("\n%-10s%-10s%-10s%30d", "Number of ", SOD_SUPER_NAME, "selections", borrowedSuperCount);
		System.out.printf("\n%-30s%22s%8.2f", "Grand Total Cost of Purchases", "$", borrowedGrandTotal);
		System.out.println("\n************************************************************");
	
	}//End of method for final report after all purchases
	
	//Method for taking in user name
	public static String getUserName (Scanner borrowedInput)
	{
		String localUserName = "";
		
		//Assign user name
		System.out.print("\nPlease enter your first name: ");
		localUserName = borrowedInput.nextLine().toLowerCase();
		localUserName = localUserName.substring(0,1).toUpperCase() + localUserName.substring(1);
		
		return localUserName;
	}//End of method for taking in user name

	//Method for taking in sod type
	public static char validSodMenuType(Scanner borrowedInput, String borrowedUserName)
	{
		char localSodType = ' ';
		
		displaySodMenuType(borrowedUserName);
		localSodType = borrowedInput.nextLine().toUpperCase().charAt(0);
		
		while (localSodType != 'A' && localSodType != 'B' && localSodType != 'C')
		{
			System.out.println("\nInvalid Selection, please try again.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			displaySodMenuType(borrowedUserName);
			localSodType = borrowedInput.nextLine().toUpperCase().charAt(0);
		}
		
		return localSodType;
	}//End of method for taking in sod type.

	//Method to display Sod type menu
	public static void displaySodMenuType(String borrowedBorrowedUserName)
	{
		System.out.println("\nWhat type of sod are you buying " + borrowedBorrowedUserName +"?");
		System.out.printf("\n%-21s%18s%21s", "", "Sod Type Selection", "");
		System.out.printf("\n%-21s%18s%21s", "", "------------------", "");
		System.out.printf("\n%-15s%-4s%-12s%6s%7.2f%16s", "", "[A] ", SOD_SODDY_NAME, "$", SOD_SODDY_PRICE, "");
		System.out.printf("\n%-15s%-4s%-12s%6s%7.2f%16s", "", "[B] ", SOD_GREEN_NAME, "$", SOD_GREEN_PRICE, "");
		System.out.printf("\n%-15s%-4s%-12s%6s%7.2f%16s\n", "", "[C] ", SOD_SUPER_NAME, "$", SOD_SUPER_PRICE, "");
		System.out.print("\nPlease enter your selection here: ");
	}//End of method to display sod type menu.
	
	//Method to display main menu and discount selection
	public static void displayMainMenu()
	{
		System.out.printf("\n%-24s%13s%23s", "", "DISCOUNT MENU", "\n");
		System.out.printf("\n%-10s%-4s%2.0f%-2s%-32s", "", "[A]", 100*DISCOUNT_RATE_SENIOR, "%", DISCOUNT_NAME_SENIOR);
		System.out.printf("\n%-10s%-4s%2.0f%-2s%-32s", "", "[B]", 100*DISCOUNT_RATE_MEMBER, "%", DISCOUNT_NAME_MEMBER);
		System.out.printf("\n%-10s%-4s%-28s", "", "[C]", DISCOUNT_NAME_NONE);
		System.out.printf("\n%-10s%-4s%-28s", "", "[Q]", "Quit\n");
		System.out.print("\nPlease enter your discount selection here: ");
	}//End of method to display main menu and discount selection
	
}//End of public class

