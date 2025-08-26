/**
 * 
 * File: ExpAcct.java
 * Project: CS150 Project 2, Fall 2022
 * Date: 9/27/2022
 * E-mail: hernandv@lafayette.edu
 * 
 * Class Description:
 * This class includes the main method and other methods
 * which allow a user to repeatedly create and
 * manage student and faculty express card accounts 
 * through the executions of different methods. The user
 * is able to toggle through a main menu and sub menu which 
 * allows them to deposit money to the express card
 * (increasing the balance), purchase meals at a fixed rate 
 * (decreasing the balance), and have meals (each swipe 
 * of the card reduces the remaining meals by one). 
 * ExpAcct class also includes methods that seek valid integer
 * or double valued input (positive values only).
 *
 * @author Victor Hernandez Jr
 * @version September 27, 2022
 */

import java.util.Scanner;
import java.util.ArrayList;
public class ExpAcct
{
    /** Global scanner initialized for accessibility for all methods **/
    public static Scanner sc = new Scanner(System.in);

    /**
     * Name: main
     * Description: This main method uses loops to run the Express Account
     * program with the call of other methods and class methods until
     * user decides to quit and end the running program
     */
    public static void main(String[] args) 
    {
        /** ArrayList of express accounts **/
        ArrayList<ExpressAccount> accountsList = new ArrayList<ExpressAccount>();

        /** Initial array indices of express accounts to access **/
        int numOfAccounts = 0;

        /** User input for main menu selection **/
        int mainSelection;

        /** User input for account type selection **/
        int accountType;

        /** Account number of express account created or logs into **/
        int accountNum;

        /** Account referenced to be managed **/
        ExpressAccount account;

        System.out.println("Welcome to the Express Account Company!");

        displayMainMenu();
        mainSelection = mainMenuSelection();
        while (mainSelection != 3) {
            // 0. Invalid entry || 1. Create new account || 2. a) Log into existing account b) No account exists, restart menu
            if (mainSelection == 0) {
                System.out.println("Invalid selection. Please try again.");
            } else if (mainSelection == 1) {
                displayAccountTypeOptions();
                accountType = accountTypeSelection();
                accountNum = numOfAccounts; //accountNum is last index
                // 1. Create student account || 2. Create faculty account
                if (accountType == 1) {
                    accountsList.add(new StudentExpressAccount(accountNum));
                } else {
                    accountsList.add(new FacultyExpressAccount(accountNum));
                }
                account = accountsList.get(numOfAccounts);
                System.out.println("Created new " + account.getAccountTypeName() 
                    + " Express Account #" + account.getAccountNumber() 
                    + ", balance: $" + account.getAccountBalance() 
                    + ", number of meals: " + account.getNumOfMeals());
                numOfAccounts++;
                subMenu(account);
            } else if (mainSelection == 2 && numOfAccounts > 0){
                accountNum = accountNumSelection(numOfAccounts);
                account = accountsList.get(accountNum);
                System.out.println("Welcome back " + account.getAccountTypeName()
                    + " Express account #" + account.getAccountNumber()
                    + ", balance: $" + account.getAccountBalance()
                    + ", number of meals: " + account.getNumOfMeals());
                subMenu(account);
            } else {
                System.out.println("Please create an account first.");
            }
            displayMainMenu();
            mainSelection = mainMenuSelection();
        }
        System.out.println("Exiting the system");
    }

    /**
     * Name: subMenu
     * Description: This method displays the sub menu options and loops 
     * sub menu functions such as making deposits, purchasing meals, 
     * and having a meal for Express Account until user logs out
     * @param account - ExpressAccount to display and access sub menu options
     * @return
     */
    public static void subMenu(ExpressAccount account)
    {
        /** User input for sub menu selection **/
        int subSelection;

        displaySubMenu(account);
        subSelection = subMenuSelection();
        while (subSelection != 4) {
            if (subSelection == 0) {
                System.out.println("Invalid Selection. Please try again.");
            } else if (subSelection == 1) {
                double deposit = depositEntry();
                account.makeDeposit(deposit);
            } else if (subSelection == 2) {
                if (account.getAccountBalance() >= account.getPricePerMeal()){
                    int mealAmt = mealIntEntry();
                    account.purchaseMeals(mealAmt);
                } else {
                    System.out.print("Balance not enough for any meals. ");
                    System.out.println("Please make a deposit.");
                }
            } else {
                account.haveMeal();
            }
            displaySubMenu(account);
            subSelection = subMenuSelection();
        }   
        System.out.println("Goodbye!");
    }    

    /**
     * Name: displayMainMenu
     * Precondition: Main menu options have not been displayed
     * Postcondition: Main menu options are displayed with
     * options to access to accounts or exit system
     * @param
     * @return
     */
    public static void displayMainMenu()
    {
        System.out.println("\nMAIN MENU");
        System.out.println("1.) Create a new account");
        System.out.println("2.) Log into an existing account");
        System.out.println("3.) Exit the system");
    }

    /**
     * Name: displaySubMenu
     * Precondition: Sub menu options have not been displayed
     * Postcondition: Sub menu options are displayed with account information
     * and options for account management
     * @param
     * @return
     */
    public static void displaySubMenu(ExpressAccount account)
    {
        System.out.println("\n" + account.toString());
        System.out.println("1.) Make a deposit");
        System.out.println("2.) Purchase meals");
        System.out.println("3.) Have meal");
        System.out.println("4.) Log out");
    }

    /**
     * Name: displayAccountTypeOptions
     * Precondition: Account type options have not been displayed
     * Postcondition: Account type options are displayed for user reference
     * @param
     * @return
     */
    public static void displayAccountTypeOptions()
    {
        System.out.println("\nCHOOSE THE TYPE FOR THE NEW ACCOUNT");
        System.out.println("1.) Student express account");
        System.out.println("2.) Faculty express account");
    }

    /**
     * Name: mainMenuSelection
     * Precondition: User has not entered their input for main menu selection
     * Postcondition: User has entered their entry (can be a valid or an invalid entry)
     * @param
     * @return int - integer for if-else statements for main menu in the main method
     */
    public static int mainMenuSelection() 
    {
        System.out.print("Please enter your selection: ");
        String input = sc.nextLine();
        switch (input) 
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                input = "0";
                break;
        }
        return Integer.parseInt(input);
    } 

    /**
     * Name: subMenuSelection
     * Precondition: User has not entered their input for sub menu selection
     * Postcondition: User has entered their entry (can be a valid or an invalid entry)
     * @param
     * @return int - integer for sub menu in the subMenu method
     */
    public static int subMenuSelection()
    {
        System.out.print("Please enter your selection: ");
        String input = sc.nextLine();
        switch (input) 
        {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                input = "0";
                break;
        }
        return Integer.parseInt(input);
    }

    /**
     * Name: accountTypeSelection
     * Precondition: User has not entered valid input for account type selection
     * Postcondition: User has entered valid input for account type selection
     * @param
     * @return int - integer for account type selection when creating new account
     */
    public static int accountTypeSelection()
    {
        boolean invalid = true;
        System.out.print("Please enter your selection: ");
        String input = sc.nextLine();
        while (invalid) {
            switch (input)
            {
                case "1":
                    invalid = false;
                    break;
                case "2":
                    invalid = false;
                    break;
                default:
                    System.out.println("Invalid Selection. Please try again.");
                    displayAccountTypeOptions();
                    System.out.print("Please enter a valid selection: ");
                    input = sc.nextLine();
                    break;
            }
        }
        return Integer.parseInt(input);
    }

    /**
     * Name: accountNumSelection
     * Precondition: User has not entered a valid entry account number to log in to
     * Postcondition: User has entered a valid account number to for menu access
     * @param accounts - number of accounts
     * @return int - account number existing within list of Express accounts
     */
    public static int accountNumSelection(int accounts)
    {
        boolean invalid = true;
        String input;
        int lastIndex = accounts - 1;
        int accountNum = 0;
        while (invalid) {
            System.out.print("Please enter a valid account number: ");
            try {
                input = sc.nextLine();
                accountNum = Integer.parseInt(input);
                if (accountNum > lastIndex) {
                    System.out.println("Invalid account number " +
                        "(must be between 0 and " + lastIndex + ")\n");
                } else {
                    invalid = false;
                }
            } catch (Exception ex) {
                System.out.println("Invalid entry " +
                        "(must be a number between 0 and " + lastIndex 
                        + ")\n");
            }
        }
        return accountNum;
    }

    /**
     * Name: depositEntry
     * Precondition: User has not entered input for deposit entry
     * Postcondition: User has entered their input
     * @param
     * @return double - deposit value to send to ExpressAccount subclasses' makeDeposit methods
     */
    public static double depositEntry()
    {
        String input;
        double deposit = -1d;
        System.out.print("Enter deposit amount: ");
        try {
            input = sc.nextLine();
            deposit = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("Invalid entry. Please try again.");
        }
        return Math.round(deposit * 100d) / 100d;
    }

    /**
     * Name: mealIntEntry
     * Precondition: User has not entered input for desired meal amount to purchase
     * Postcondition: User has entered their input
     * @param
     * @return int - meal amount (int type) to send to ExpressAccount purchaseMeals method
     */
    public static int mealIntEntry()
    {
        String input;
        int entry = 0;
        System.out.print("Enter the number of meals you want to purchase: ");
        try {
            input = sc.nextLine();
            entry = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid entry. Please try again.");
        }
        return entry;
    }
}
