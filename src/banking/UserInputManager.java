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
    
    @Override
    public int retrieveAccountNumber() {
        int number = (int)askInput("> Input account number : ");
        return number;
    }

   
    @Override
    public Account retrieveAccountType() {
        System.out.println("> Account Types: ");
        System.out.println("*[1] Checking \n*[2] Savings");
        int type = 0;
        while(true)
        {
            type = (int)askInput("> Choose an account type : ");
            
            switch(type)
            {

                case 1:
                    CheckingAccount checkingAccount = new CheckingAccount();
                    return checkingAccount;

                case 2:
                    SavingsAccount savingsAccount = new SavingsAccount();
                    return savingsAccount;
                default:
                    printError("> Please enter a valid option");
            }
        }
        
        
    }

    
    @Override
    public int retrieveClientId() {
        int id = (int)askInput("> Input client id : ");
        return id;
    }

    
    @Override
    public Client retrieveClientInfo() {
       System.out.print("> Input client first name : ");
       String firstName = scan.next();
       System.out.print("> Input client last name : ");
       String lastName = scan.next();
       
       Client client = new Client(firstName, lastName);
       return client;
    }

    
    @Override
    public double retrieveTransactionAmount() {
        double amount = askInput("> Input transaction ammount : ");
        return amount;
    }

//Remove checker -- Abderrahman for Merouane   
    //Done -- Merouane
    @Override
    public int retrieveUserOption() {
/*
Add a new Client  Create a new Account Make a Deposit Make a Withdrawal List Account Transaction List Clients List Client Accounts
*/
        System.out.println("********************************************************\n"
        + "*[1] Add a new Client         [2] Create a new Account *"
        + "\n*[3] Make a Deposit           [4] Make a Withdrawal    *"
        + "\n*[5] List Account Transaction [6] List Clients         *"
        + "\n*[7] List Client Accounts     [0] Exit                 *\n" 
        + "********************************************************");
        
        int choice = -1;
        while(choice == -1){
            choice = (int)askInput("> Choose an option : ");
            if((choice > 7))
                printError("> Invalid Input");
        }
        
        return choice;
    }
    
    //Error printer (Alternative to System.err). - Abderrahman
    public static void printError(String message){
        System.out.println("\u001b[31m" + message + "\u001b[0m");
    }
    
    private double askInput(String prompt){
        double number = -1;
        try{
            System.out.print(prompt);
            number = scan.nextDouble();
        } catch(Exception e){
            printError("> Invalid Input");
        }
        scan.nextLine();
        return number;
    }
}
