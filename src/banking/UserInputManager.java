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
        System.out.print("> Input account number : ");
        int number = 0;
        try{
            number = scan.nextInt();
        } catch(Exception e){
            printError("> Invalid Input");
        }
        scan.nextLine();
        return number;
    }

   
    @Override
    public Account retrieveAccountType() {
        System.out.println("> Account Types: ");
        System.out.println("*[1] Checking \n*[2] Savings");
        int type;
        while(true)
        {
            System.out.print("> Choose an account type : ");
            try{
                type = scan.nextInt();
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
            } catch(Exception e){
                printError("> Invalid input");
            }
            scan.nextLine();
        }
        
    }

    
    @Override
    public int retrieveClientId() {
        System.out.print("> Input client id : ");
        int id = 0;
        try{
            id = scan.nextInt();
        } catch(Exception e){
            printError("> Invalid Input");
        }
        scan.nextLine();
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
        System.out.print("> Input transaction ammount : ");
        double amount = 0;
        try{
            amount = scan.nextDouble();
        } catch(Exception e){
            printError("> Invalid Input");
        }
        scan.nextLine();
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
        while(true){
            try{
                System.out.print("> Choose an option : ");
                int choice = scan.nextInt();
                return choice;
            } catch(Exception e){
                printError("> Invalid Input");
            }
            //Next instruction is to clear a line. If you find a better way, modify it. - Abderrahman
            scan.nextLine();
        }
    }
    
    //Error printer (Alternative to System.err). - Abderrahman
    public static void printError(String message){
        System.out.println("\u001b[31m" + message + "\u001b[0m");
    }
}
