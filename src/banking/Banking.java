/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/*
 *
 * We shall add more estetic interfaces, like in the teacher's example.
 *
 */

/**
 *
 * @author cstuser
 */
public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank(3333333, "25 Wall st");
        UserInputManager uim = new UserInputManager();
        
        
        
        System.out.println("\u001b[34m" + "Welcome " + "\u001b[35m" + "to " +  "\u001b[32m" + "Bank!" + "\u001b[0m");
        while(true){
            int choice = uim.retrieveUserOption();
            
            switch(choice){
                case 1:
                    //Checked - Abderrahman
                    bank.addClient(uim.retrieveClientInfo());
                    break;
                case 2:
                    //Should expect a null client - Abderrahman for Abderrahman
                    Client client = bank.getClient(uim.retrieveClientId());
                    if(client != null){
                        Account newAccount = uim.retrieveAccountType();
                        newAccount.setOwner(client.getFirstName() + " " + client.getLastName());
                        client.addAccount(newAccount);
                    }
                    else
                        System.err.println("Please input an existing client ID");
                    break;
                case 3:
                    //Should expect a null client - Abderrahman for Abderrahman
                    Account depAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(depAccount == null){
                        System.err.println("Please input an existing account or client ID");
                    }
                    else{
                        double d = uim.retrieveTransactionAmount();
                        depAccount.deposit(d);
                        System.out.println(depAccount.toString());
                    }
                    break;
                case 4:
                    //Should expect a null client - Abderrahman for Abderrahman
                    Account withAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(withAccount == null){
                        System.err.println("Please input an existing account or client ID");
                    }
                    else{
                        double w = uim.retrieveTransactionAmount();
                        withAccount.withdrawal(w);
                        System.out.println(withAccount.toString());
                    }
                    break;
                case 5:
                    //Should expect a null client - Abderrahman for Abderrahman
                    Account transAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(transAccount != null){
                        transAccount.displayAllTransactions();
                        System.out.println(transAccount.toString());
                    }
                    else
                        System.err.println("Please input an existing account or client ID");
                    break;
                case 6:
                    //Checked - Abderrahman
                    bank.displayClientList();
                    break;
                case 7:
                    //Should expect a null account - Abderrahman for Jean
                    //Done --Jean
                    Client c = bank.getClient(uim.retrieveClientId());
                    System.out.println("Accounts for " + c.getFirstName() + ", " + c.getLastName() + "(" + c.getId() + "):");
                    c.displayAccounts();
                    break;
                default:
                    System.err.println("Please enter a valid command.");
            }
        }
    }
}
