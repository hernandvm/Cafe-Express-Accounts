/**
 * 
 * File: FacultyExpressAccount.java
 * Project: CS150 Project 2, Fall 2022
 * Date: 9/27/2022
 * E-mail: hernandv@lafayette.edu
 * 
 * Class Description: 
 * This FacultyExpressAccount class is a superclass of ExpressAccount
 * which includes a constructor and overriden makeDeposit method that create 
 * a FacultyExpressAccount object (faculty express card account). 
 * This superclass will allow for the account information to be changed
 * and managed when its method is called.
 *
 * @author Victor Hernandez Jr
 * @version September 27, 2022
 */
public class FacultyExpressAccount extends ExpressAccount
{
    private double baseAmtForBonus = 0.0;
    /** Percentage multiplied by deposits for bonuses **/
    private double rewardPct = 0.01;
    private double pricePerMeal = 8.0;
    private String accName = "Faculty";

    /**
    * Constructor for objects of class FacultyExpressAccount
    */
    public FacultyExpressAccount(int accNum)
    {
        super(accNum);
        setAccountTypeName(accName);
        setPricePerMeal(pricePerMeal);
        setBaseAmtForBonus(baseAmtForBonus);
    }

    /**
     * Name: makeDeposit
     * Preconditon: deposit is less than base amount for deposit bonus
     * Postcondition: account balance increases based on deposit value
     * with deposit bonus if earned
     * @param deposit - deposit value entered by express account owner
     * @return
     */
    public void makeDeposit(double deposit)
    {
        if (deposit > 0d) {
            double depositReward = deposit * rewardPct;
            double accBal = getAccountBalance();
            System.out.println("Received bonus of $" + depositReward);
            System.out.print("Deposit: $" + deposit);
            setAccountBalance(accBal + deposit + depositReward);
            System.out.println(" || New Balance: $" + getAccountBalance());
        } else {
            System.out.println("The deposit must be a positive amount.");
        }
    }
}