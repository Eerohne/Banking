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

//Class done by Abderrahman
public class Account implements IAccount{
    
    //Initialise variables - Abderrahman
    protected int accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    protected String type;
    protected String owner;
    public static int counter;
    
    
    //Constructors - Abderrahman
    public Account(String type){
        this.type = type;
        counter++;
        this.accountNumber = counter;
    }
    
    public Account(String type, Client client) {
        this.type = type;
        counter++;
        this.accountNumber = counter;
        this.owner = client.getFirstName() + " " + client.getLastName();
    }

    //Getters and Setter - Abderrahman
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        this.transactions.add(new Transaction("Deposit", d));
        
        return this.balance;
    }

    //Print all transactions - Abderrahman
    @Override
    public void displayAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println("* " + transaction.toString());
        }
    }
    
    ///Update balance with withdrawal - Abderrahman
    @Override
    public double withdrawal(double w) {
        this.balance -= w;
        this.transactions.add(new Transaction("Withdrawal", w));
        
        return this.balance;
    }
    
    
    @Override
    public String toString(){
        String ans = this.getType()+"("+this.getAccountNumber()+"): "+ this.getBalance()+"$";
        
        return ans;
    }
}
