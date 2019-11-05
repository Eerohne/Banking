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
        
        //Account test
        Account account = new Account("chequing");
        
        //client test
        Client client1 = new Client("jean", "ka");
        Client c = new Client("s", "s");
        client1.addAccount(account);
        client1.displayAccounts();
        
        
        //bank test
        Bank bank = new Bank(123456, "somewhere");
        
        bank.addClient(client1);
        bank.addClient(c);
        
        UserInputManager uim = new UserInputManager();
        
        
        int userInput = 7;
        //Banking application specifications
        switch(userInput){
            case 1:
                bank.addClient(uim.retrieveClientInfo());
                break;
            case 6:
                bank.displayClientList();
                break;
            case 7:
                Client client = bank.getClient(uim.retrieveClientId());
                client.displayAccounts();
                break;
        }
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
