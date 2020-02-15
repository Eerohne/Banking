package banking;

import java.util.ArrayList;

public interface IAccount {

    /**
     * Update the account balance with the amount of the deposit
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    double deposit(double d);

    /**
     * Print every Transaction listed in the transactions list
     * 
     */
    void displayAllTransactions();

    /**
     * Update the account balance with the amount of the withdrawl
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    ArrayList<Transaction> getTransactions();

    /**
     * return the string that you want to output when printing the object
     */
    @Override
    String toString();

    /**
     * Update the account balance with the amount of the withdrawal
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    double withdrawal(double w);
    
}
