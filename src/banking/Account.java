/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class Account implements IAccount{
    
    //Initialise variables - Abderrahman
    protected int accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    protected String type;
    protected String owner;
    protected int counter;
    public int a;
    
    //Constructor - Abderrahman
    public Account(String type) {
        this.type = type;
    }
    
    //Getter to get the transaction list - Abderrahman
    @Override
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    //Update the balance after with deposit - Abderrahman
    @Override
    public double deposit(double d) {
        this.balance += d;
        this.transactions.add(new Transaction("Withdrawal", d));
        
        return this.balance;
    }

    //Print all transactions - Abderrahman
    @Override
    public void displayAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
    
    ///Update balance with withdrawal - Abderrahman
    @Override
    public double withdrawal(double w) {
        this.balance -= w;
        this.transactions.add(new Transaction("Withdrawal", w));
        
        return this.balance;
    }
    
}
