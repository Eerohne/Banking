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
public class Client /*implements IClient*/{
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 0;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountList = new ArrayList<Account>();
        counter++;
        this.id = this.counter;
    }
    
    
    //create new Account --Jean
    //@Override
    public void addAccount(Account newAccount) {
        accountList.add(newAccount);
    }

    //print all accounts --Jean
    //@Override
    public void displayAccounts() throws EmptyList{
        if (this.accountList.size()>0){
            for(Account account: accountList){
                System.out.println(account);
                return;
            }
        }
        throw new EmptyList("The account list is empty");
    }

    //get account by accountNumber --Jean
    //@Override
    public Account getAccount(int accountNumber) throws AccountNotFound{
        for(Account account: accountList){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        /*Old null*/ 
        throw new AccountNotFound("The account was not found");
    }
    
    //toString for client
    public String toString(){
        return "* " + "("+this.getId()+")"+this.getFirstName()+", "+this.getLastName();
    }

    //getters and setters for the class --Jean
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccountList() {
        return this.accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public static int getCounter() {
        return Client.counter;
    }

    public static void setCounter(int counter) {
        Client.counter = counter;
    }
    
}
