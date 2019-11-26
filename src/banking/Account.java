/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.text.DecimalFormat;
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
    private static int counter;
    private static DecimalFormat df = new DecimalFormat("#,###,##0.00");    
    
    //Constructors - Abderrahman
    public Account(String type){
        this.type = type;
        counter++;
        this.accountNumber = counter;
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

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Account.counter = counter;
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
        for (Transaction transaction : this.transactions) {
            System.out.println(transaction);
        }
    }
    
    ///Update balance with withdrawal - Abderrahman
    @Override
    public double withdrawal(double w) {
        this.balance -= w;
        this.transactions.add(new Transaction("Withdrawal", w));
        
        return this.balance;
    }
    
    public String save()
    {
        String data = "";
        if(this.type.equals("checking"))
                  {
                      data += "ch ";
                  }else
                  {
                      data += "s ";
                  }
                    data += transactions.size() + " ";
                    
                 for(Transaction t : transactions)
                 {
                    data += t.save();
                 }
        return data;
    }
    
    @Override
    public String toString(){
        String ans = " - " + this.getType()+"("+this.getAccountNumber()+"): "+ df.format(this.getBalance())+"$";
        
        return ans;
    }
    
    public String toXML(){
        String xml = "";
        
        xml += "\t\t<Account>\n";
        xml += "\t\t\t<accountNumber>" + this.accountNumber + "</accountNumber>\n";
        xml += "\t\t\t<balance>" + this.balance + "</balance>\n";
        xml += "\t\t\t<type>" + this.type + "</type>\n";
        xml += "\t\t\t<owner>" + this.owner + "</owner>\n";
        for (Transaction transaction : transactions) {
            xml += transaction.toXML();
        }
        xml += "\t\t</Account>\n";
        
        return xml;
    }
}
