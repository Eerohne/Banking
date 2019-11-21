/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Banking {
    private static final String BLACK = "\u001b[0m";
    private static final String GREEN = "\u001b[32m";
    private static final String RED = "\u001b[31m";
    private static final String BLUE = "\u001b[34m";
    private static UserInputManager uim = new UserInputManager();
    private static Bank bank = new Bank(3333333, "25 Wall st");
    
    
    
    public static void main(String[] args) throws AccountNotFound, ClientDoesNotExist, FileNotFoundException {
        System.out.println(BLUE + "Welcome " + RED + "to " +  GREEN + "Bank!" + BLACK);
        boolean isRunning = true;
        LoadingInputs.load();
        while(isRunning){
            int choice = uim.retrieveUserOption();
            
            switch(choice){
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    //Checked - Abderrahman
                    bank.addClient(uim.retrieveClientInfo());
                    break;
                case 2:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done
                    try{
                        Client client = bank.getClient(uim.retrieveClientId());
                        Account newAccount = uim.retrieveAccountType();
                        newAccount.setOwner(client.getFirstName() + " " + client.getLastName());
                        client.addAccount(newAccount);
                    } catch(ClientDoesNotExist cdne){
                        UserInputManager.printError(cdne.getMessage());
                    }
                    break;
                case 3:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done 
                    executeTransaction(true);
                    break;
                case 4:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done
                    executeTransaction(false);
                    break;
                case 5:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done
                    try{
                        Account transAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                        transAccount.displayAllTransactions();
                        System.out.println(transAccount);
                    } catch(ClientDoesNotExist c){
                        UserInputManager.printError(c.getMessage());
                    } catch(AccountNotFound a){
                        UserInputManager.printError(a.getMessage());                        
                    }
                    break;
                case 6:
                    //Checked - Abderrahman
                    try{
                        bank.displayClientList();
                    } catch(EmptyList el){
                        UserInputManager.printError(el.getMessage());
                    }
                    break;
                case 7:
                    //Should expect a null account - Abderrahman for Jean
                    //Done --Jean
                    try{
                        bank.displayClientAccounts(uim.retrieveClientId());
                    } catch(ClientDoesNotExist c){
                        UserInputManager.printError(c.getMessage());
                    } catch (EmptyList ex) {
                        UserInputManager.printError(ex.getMessage());
                    }
                    break;
                    
                
            }
        }
    }
    
    private static void executeTransaction(boolean isDeposit){
        try{
            Account a = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
            double d = uim.retrieveTransactionAmount();
            if(isDeposit)
                a.deposit(d);
            else
                a.withdrawal(d);
            System.out.println(a);
        } catch(ClientDoesNotExist c){
            UserInputManager.printError(c.getMessage());
        } catch(AccountNotFound a){
            UserInputManager.printError(a.getMessage());                        
        }
    }
}
