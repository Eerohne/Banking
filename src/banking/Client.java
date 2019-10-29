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
public class Client implements IClient{
    protected int id;
    protected String firstName;
    protected String lastName;
    protected ArrayList<Account> accountList;
    protected static int counter;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = this.counter;
        counter++;
    }
    
    
    //create new Account --Jean
    @Override
    public void addAccount(Account newAccount) {
        accountList.add(new Account());
    }

    //print all accounts --Jean
    @Override
    public void displayAccounts() {
        for(Account account: accountList){
            System.out.println(account.toString());
        }
    }

    //get account by accountNumber --Jean
    @Override
    public Account getAccount(int accountNumber) {
        for(Account account: accountList){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }

    //getters for this class --Jean
    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    
}
