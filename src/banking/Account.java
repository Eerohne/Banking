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
    
    protected int accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    protected String type;
    protected String owner;
    protected int counter;
    
    public Account(String type) {
        this.type = type;
    }

    @Override
    public double deposit(double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayAllTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double withdrawal(double w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
