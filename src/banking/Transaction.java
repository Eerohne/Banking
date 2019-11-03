/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

//Merouane Issad
public class Transaction implements ITransaction{
    public String type;
    public double amount;
    public int helo;
    
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    public String toString(){
        return type + " of " + amount + "$";
    }
    
}