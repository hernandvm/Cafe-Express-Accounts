/**
 * 
 * File: ExpressAccount.java
 * Project: CS150 Project 2, Fall 2022
 * Date: 9/27/2022
 * E-mail: hernandv@lafayette.edu
 * 
 * Class Description: 
 * This ExpressAccount class includes a constructor and methods
 * that create a (Student/Faculty)ExpressAccount object (express card account).
 * The methods in this class allow for the account information
 * to be changed and managed when called. Said information 
 * includes account balance, number of meals, and deposits. This
 * parent class is inherited by FacultyExpressAccount and
 * StudentExpressAccount superclasses.
 *
 * @author Victor Hernandez Jr
 * @version September 27, 2022
 */
public abstract class ExpressAccount
{
    private double accountBalance;
    private int accountNumber;
    private int numberOfMeals;
    private double pricePerMeal;
    private double baseAmtForBonus = 0d;
    private String accountTypeName;

    /**
     * Constructor for ExpressAccount class
     */
    public ExpressAccount(int accNum) {
        accountBalance = 0.0;
        accountNumber = accNum;
        numberOfMeals = 0;
    }

    /**
     * Name: getAccountNumber
     * Preconditon:
     * Postcondition:
     * @param
     * @return int - Account number
     */
    public int getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Name: setAccountTypeName
     * Precondition: accountTypeName has not been initialized
     * Postcondition: accountTypeName has been initialized to 
     * "Student" or "Faculty"
     * @param name - String from respective subclass
     * @return
     */
    public void setAccountTypeName(String name)
    {
        accountTypeName = name;
    }

    /**
     * Name: getAccountTypeName
     * Precondition:
     * Postcondition:
     * @param
     * @return String - Account type name
     */
    public String getAccountTypeName()
    {
        return accountTypeName; 
    }

    /**
     * Name: getAccountBalance
     * Preconditon:
     * Postcondition:
     * @param
     * @return double - Account balance rounded to the nearest hundredth
     */
    public double getAccountBalance()
    {
        return Math.round(accountBalance * 100d) / 100d;
    }

    /**
     * Name: setAccountBalance
     * Precondition: Account balance needs to be updated
     * Postcondition: Account balance is updated according to parameter newBalance
     * @param newBalance - new account balance to update to
     * @return
     */
    public void setAccountBalance(double newBalance)
    {
        accountBalance = Math.round(newBalance * 100d) / 100d;
    }

    /**
     * Name: getBaseAmtForBonus
     * Preconditon:
     * Postcondition:
     * @param
     * @return double - Base amount for deposit bonus
     */
    public double getBaseAmtForBonus()
    {
        return baseAmtForBonus;
    }

    /**
     * Name: setBaseAmtForBonus
     * Precondition: Base amount for bonus must be updated
     * Postcondition: Base amount for bonus is updated according to parameter baseAmt
     * @param baseAmt - double type with value to set baseAmtForBonus to
     * @return
     */
    public void setBaseAmtForBonus(double baseAmt)
    {
        baseAmtForBonus = baseAmt;
    }

    /**
     * Name: setPricePerMeal
     * Precondition: pricePerMeal has not been initialized
     * Postcondition: pricePerMeal is initialized by constructor
     * of respective subclass
     * @param price - variable of double type from
     * subclass for initialization
     * @return
     */
    public void setPricePerMeal(double price)
    {
        pricePerMeal = price;
    }

    /**
     * Name: getPricePerMeal
     * Preconditon:
     * Postcondition:
     * @param
     * @return double - Price per each meal (8.0 or 10.0)
     */
    public double getPricePerMeal()
    {
        return pricePerMeal;
    }

    /**
     * Name: getNumOfMeals
     * Preconditon:
     * Postcondition:
     * @param 
     * @return int - Number of meals in express card account
     */
    public int getNumOfMeals()
    {
        return numberOfMeals;
    } 

    /**
     * Name: toString
     * Preconditon:
     * Postcondition:
     * @param
     * @return String - Express Account account number, 
     * account balance, and number of meals in the account 
     */
    public String toString()
    {
        return accountTypeName.toUpperCase() 
        + " EXPRESS ACCOUNT #" + accountNumber 
        + ", BALANCE: $" + getAccountBalance() 
        + ", NUMBER OF MEALS: " + numberOfMeals;
    }

    /**
     * Name: haveMeal
     * Preconditon: number of meals is greater than 0
     * Postcondition: number of meals decrease based on number of meals
     * @param
     * @return
     */
    public void haveMeal(){
        if (numberOfMeals <= 0) 
        {
            System.out.println("No meals left on your account. Please purchase meals first.");
        } else {
            numberOfMeals -= 1;
            System.out.println("Enjoy your meal!");
        }
    }

    /**
     * Name: makeDeposit
     * Description: This abstract class is meant to be overidden by 
     * subclasses, which will use parameter "deposit," of 
     * double type and from user's input, to add to account balance
     */
    public abstract void makeDeposit(double deposit);

    /**
     * Name: purchaseMeals
     * Preconditon: user has sufficient funds for the desired amount of
     * meals they want to purchase
     * Postcondition: number of meals has increased based upon meals
     * purchased
     * @param mealsAmt - integer amount of meals user entered to purchase
     * @return
     */
    public void purchaseMeals(int mealsAmt)
    {
        if (mealsAmt > 0) {
            int finalMealsAmt = mealsAmt;
            double affordableBalance = accountBalance - (accountBalance % pricePerMeal);
            double charge = finalMealsAmt * pricePerMeal;
            while ((Math.round((affordableBalance - charge) * 100d) / 100d) < 0.00) {
                finalMealsAmt--;
                charge = finalMealsAmt * pricePerMeal;
            }
            if (finalMealsAmt < mealsAmt) {
                System.out.println("Not enough balance for " + mealsAmt + " meals. ");
            }
            numberOfMeals += finalMealsAmt;
            accountBalance -= charge;
            System.out.print("Purchased " + finalMealsAmt + " meal(s) "
                + "with $" + pricePerMeal + " per meal || ");
            System.out.println("New Balance: $" + getAccountBalance());
        } else {
            System.out.println("Entry for meal amount must be positive.");
        }
    }
}