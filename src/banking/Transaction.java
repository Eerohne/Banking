/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

//Merouane Issad
public class Transaction implements ITransaction{
    private String type;
    private double amount;
    
    
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    
    public String toString(){
        return this.type + " of " + this.amount + "$";
    }
    
}