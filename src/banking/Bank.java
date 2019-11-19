/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class Bank /*implements IBank*/{
    private int bankNumber;
    private String address;
    private ArrayList<Client> clientList;

    public Bank(int bankNumber, String address) {
        this.bankNumber = bankNumber;
        this.address = address;
        
        clientList = new ArrayList<Client>();
    }
    
    
    // add a new Client --Jean
    //@Override
    public void addClient(Client newClient) {
        clientList.add(newClient);
    }

    //display the client's accounts --Jean
    //@Override
    public void displayClientAccounts(int clientId) throws EmptyList, ClientDoesNotExist{
        for(Client client: clientList){
            if(client.getId()==clientId){
                System.out.println("* Listing accounts for : ");
                System.out.println(client);
                client.displayAccounts();
                return;
            }
        }
        throw new ClientDoesNotExist("The client does not exist");
    }

    //diplay all the clients --Jean
    //@Override
    //This function prints "List of current clients: " for every client **TO FIX**- Abderrahman
    //Done --Jean
    public void displayClientList() throws EmptyList{
        if (this.clientList.size()>0){
            System.out.println("* List of current clients: ");
            for(Client client: clientList){
                System.out.println(client);
            }
            return;
        }
        else
            throw new EmptyList("This bank has no clients yet");
    }

    //get the client by his id --Jean
    //@Override
    public Client getClient(int id) throws ClientDoesNotExist{
        for(Client client: clientList){
            if(client.getId()==id){
                return client;
            }
        }
        ///
        throw new ClientDoesNotExist("The client you researched does not exist");
    }

    //Add a verifier for the client id before passing to the Account checker --Abderrahman for Jean
    //Done --Jean
    //get an account based on accountNumber and id --Jean
    //@Override
    public Account getClientAccount(int clientId, int accountNumber) throws AccountNotFound, ClientDoesNotExist{
        //Abderrahman: Added error handling for null accoutn and client.
        for(Client client: clientList){
            if(client.getId()==clientId){
                Account a = client.getAccount(accountNumber);
                return a;
            }
        }
        throw new ClientDoesNotExist("The client you researched does not exist");
    }
}
