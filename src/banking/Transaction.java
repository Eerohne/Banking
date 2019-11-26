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
    private double ammount;
    
    private static DecimalFormat df = new DecimalFormat("#0.00"); 
    
    
    public Transaction(String type, double amount) {
        this.type = type;
        this.ammount = amount;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return this.ammount;
    }

    public void setAmount(double amount) {
        this.ammount = amount;
    }
    
    public String toString(){
        return "* " + this.type + " of " + this.ammount + "$";
    }
    
    public String toXML(){
        String xml = "";
        
        xml += "\t\t\t<Transaction>\n";
        xml += "\t\t\t\t<type>" + this.type + "</type>\n";
        xml += "\t\t\t\t<ammount>" + this.ammount + "</ammount>\n";
        xml += "\t\t\t</Transaction>\n";
        return xml;
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
        data += df.format(this.ammount) + " ";
        return data;
    }
}
