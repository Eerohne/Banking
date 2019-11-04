/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.Scanner;
//Merouane Issad : The whole class
public class UserInputManager implements IUserInputManager{

    Scanner scan = new Scanner(System.in);
    
    public int retrieveAccountNumber() {
        System.out.print("Input account number : ");
        int number = scan.nextInt();
        return number;
    }

   
    public Account retrieveAccountType() {
        System.out.print("Input client type : ");
        String type = scan.next();
        if(type == "checking"){
         CheckingAccount checkingAccount = new CheckingAccount();
         return checkingAccount;
        }
        else 
        if(type == "savings"){
         SavingsAccount savingsAccount = new SavingsAccount();
         return savingsAccount;
        }
        else
        {
         CheckingAccount checkingAccount = new CheckingAccount();
         return checkingAccount; 
        }
    }

    
    public int retrieveClientId() {
        System.out.print("Input client id : ");
        int id = scan.nextInt();
        return id;
    }

   
    public Client retrieveClientInfo() {
       System.out.print("Input client first name : ");
       String firstName = scan.next();
       System.out.print("Input client last name : ");
       String lastName = scan.next();
       
       Client client = new Client(firstName, lastName);
       return client;
    }

    
    public double retrieveTransactionAmount() {
        System.out.print("Input transaction amount : ");
        double amount = scan.nextDouble();
        return amount;
    }

   
    public int retrieveUserOption() {
        System.out.print("Choose an option : ");
        int choise = scan.nextInt();
        return choise;
    }
  
}
