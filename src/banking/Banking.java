/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

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
        
        while(true){
            int choice = uim.retrieveUserOption();
            
            switch(choice){
                case 1:
                    bank.addClient(uim.retrieveClientInfo());
                    break;
                case 2:
                    Client client = bank.getClient(uim.retrieveClientId());
                    Account newAccount = uim.retrieveAccountType();
                    newAccount.setOwner(client.getFirstName() + " " + client.getLastName());
                    client.addAccount(newAccount);
                    break;
                case 3:
                    Account depAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    double d = uim.retrieveTransactionAmount();
                    depAccount.deposit(d);
                    depAccount.toString();
                    break;
                case 4:
                    Account withAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    double w = uim.retrieveTransactionAmount();
                    withAccount.deposit(w);
                    withAccount.toString();
                    break;
                case 5:
                    Account transAccount = bank.getClientAccount(uim.retrieveClientId(), uim.retrieveAccountNumber());
                    transAccount.displayAllTransactions();
                    transAccount.toString();
                case 6:
                    bank.displayClientList();
                    break;
                case 7:
                    Client c = bank.getClient(uim.retrieveClientId());
                    System.out.println("Accounts for " + c.getFirstName() + ", " + c.getLastName() + "(" + c.getId() + "):");
                    c.displayAccounts();
                    break;
            }
        }
    }
    
}
