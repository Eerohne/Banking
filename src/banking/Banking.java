/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/*
 *
 * We shall add more estetic interfaces.
 * //Done
 */

/**
 *
 * @author cstuser
 */
public class Banking {
    private static final String BLACK = "\u001b[0m";
    private static final String GREEN = "\u001b[32m";
    private static final String RED = "\u001b[31m";
    private static final String BLUE = "\u001b[34m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank(3333333, "25 Wall st");
        UserInputManager uim = new UserInputManager();
        
        
        
        System.out.println(BLUE + "Welcome " + RED + "to " +  GREEN + "Bank!" + BLACK);
        boolean isRunning = true;
        
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
                    Client client = bank.getClient(uim.retrieveClientId());
                    if(client != null){
                        Account newAccount = uim.retrieveAccountType();
                        newAccount.setOwner(client.getFirstName() + " " + client.getLastName());
                        client.addAccount(newAccount);
                    }
                    else
                        System.out.println(RED + "Please enter an existing client ID" + BLACK);
                    break;
                case 3:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done 
                    Account depAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(depAccount == null){
                        System.out.println(RED + "Please input an existing account" + BLACK);
                    }
                    else{
                        double d = uim.retrieveTransactionAmount();
                        depAccount.deposit(d);
                        System.out.println(depAccount.toString());
                    }
                    break;
                case 4:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done
                    
                    Account withAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(withAccount == null){
                        System.out.println(RED + "Please input an existing account" + BLACK);
                    }
                    else{
                        double w = uim.retrieveTransactionAmount();
                        withAccount.withdrawal(w);
                        System.out.println(withAccount);
                    }
                    break;
                case 5:
                    //Should expect a null client - Abderrahman for Abderrahman
                    //Done
                    Account transAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    if(transAccount != null){
                        transAccount.displayAllTransactions();
                        System.out.println(transAccount);
                    }
                    else
                        System.out.println(RED + "Please input an existing account or client ID" + BLACK);
                    break;
                case 6:
                    //Checked - Abderrahman
                    bank.displayClientList();
                    break;
                case 7:
                    //Should expect a null account - Abderrahman for Jean
                    //Done --Jean
                    Client c = bank.getClient(uim.retrieveClientId());
                    if (c!=null){
                        //System.out.println("* Accounts for " + c.getFirstName() + ", " + c.getLastName() + "(" + c.getId() + "):");
                        
                        System.out.println("* Listing Accounts for: ");
                        System.out.println(c);
                        c.displayAccounts();
                    }
                    else{
                        System.out.println(RED + "Please enter an existing client." + BLACK);
                    }
                    break;
                default:
                    System.out.println(RED + "Please enter a valid command." + BLACK);
            }
        }
    }
}
