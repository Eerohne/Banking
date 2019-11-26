/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

//Merouane Issad

import java.text.DecimalFormat;

public class Transaction implements ITransaction{
    private String type;
    private double amount;
    
    private static DecimalFormat df = new DecimalFormat("#0.00"); 
    
    
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String toString(){
        return "* " + this.type + " of " + this.amount + "$";
    }
    
    public String save ()
    {
        String data = "";
        
        if(this.type.equals("Deposit"))
                     {
                         data += "d ";
                     }else  if(this.type.equals("Withdrawal"))
                     {
                         data += "w ";
                     }
        data += df.format(this.amount) + " ";
        return data;
    }
}
