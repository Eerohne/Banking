/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.Scanner;
//Merouane Issad
public class UserInputManager implements IUserInputManager{

    Scanner scan = new Scanner(System.in);
    
    public int retrieveAccountNumber() {
        System.out.print("Input account number : ");
        int number = scan.nextInt();
        return number;
    }

   
    public Account retrieveAccountType() {
        Account a = new Account("h");
         return a;
    }

    
    public int retrieveClientId() {
        System.out.print("Input client id : ");
        int id = scan.nextInt();
        return id;
    }

   
    public Client retrieveClientInfo() {
        Client a = new Client("a", "b");
        return a;
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
