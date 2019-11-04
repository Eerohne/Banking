/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.Scanner;

public class UserInputManager implements IUserInputManager{

    Scanner scan = new Scanner(System.in);
    
    public int retrieveAccountNumber() {
        System.out.print("Input it : ");
        int a = scan.nextInt();
        return 1;
    }

   
    public Account retrieveAccountType() {
        Account a = new Account("h");
         return a;
    }

    
    public int retrieveClientId() {
        return 1;
    }

   
    public Client retrieveClientInfo() {
        Client a = new Client("a", "b");
        return a;
    }

    
    public double retrieveTransactionAmount() {
        return 1;
    }

   
    public int retrieveUserOption() {
        return 1;
    }
  
}
