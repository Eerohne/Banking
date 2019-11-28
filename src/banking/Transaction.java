/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

//Merouane Issad

import java.text.DecimalFormat;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Transaction implements ITransaction{
    private String type;
    private double ammount;
    
    private static DecimalFormat df = new DecimalFormat("#,###,###0.00"); 

    public Transaction() {
    }
    
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
        return "* " + this.type + " of " + df.format(this.ammount) + "$";
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
    
    public String toXML(){
        String xml = "";
        
        xml += "<Transaction>";
        xml += "<type>" + this.type + "</type>";
        xml += "<ammount>" + this.ammount + "</ammount>";
        xml += "</Transaction>";
        return xml;
    }
    
    public void fromXML(Node n){
        Element e = (Element) n;
        this.type = e.getElementsByTagName("type").item(0).getTextContent();
        this.ammount = Double.parseDouble(e.getElementsByTagName("ammount").item(0).getTextContent());
    }
}
