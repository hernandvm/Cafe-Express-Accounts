/**
 * 
 * File: StudentExpressAccount.java
 * Project: CS150 Project 2, Fall 2022
 * Date: 9/27/2022
 * E-mail: hernandv@lafayette.edu
 * 
 * Class Description: 
 * This StudentExpressAccount class is a superclass of ExpressAccount
 * which includes a constructor and overriden makeDeposit methods that create 
 * an StudentExpressAccount object (student express card account). 
 * This superclass will allow for the account information to be changed
 * and managed when its methods are called.
 *
 * @author Victor Hernandez Jr
 * @version September 27, 2022
 */
public class StudentExpressAccount extends ExpressAccount
{
    private double baseAmtForBonus = 500.0;
    /** Reward level to divide deposits eligible for deposit bonuses **/
    private double rewardLevel = 200.0;
    /** Reward amount per reward level bonus **/
    private double rewardAmt = 2.0;
    private double pricePerMeal = 10.0;
    private String accName = "Student";

    /**
     * Constructor for objects of class StudentExpressAccount
     */
    public StudentExpressAccount(int accNum)
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
            double depositBase;
            double rewardMultiplier;
            double rewardEarned = 0.00;
            double accBal = getAccountBalance();
            double bonusBase = getBaseAmtForBonus();
            if (deposit >= bonusBase) {
                depositBase = deposit - (deposit % rewardLevel);
                rewardMultiplier = depositBase / rewardLevel;
                rewardEarned += (rewardMultiplier * rewardAmt);
                System.out.println("Bonus earned from deposit: $" + rewardEarned);
            }
            setAccountBalance(accBal + deposit + rewardEarned);
            System.out.print("Deposit: $" + deposit);
            System.out.println(" || New Balance: $" + getAccountBalance());
        } else {
            System.out.println("The deposit must be a positive amount.");
        }
    }
}