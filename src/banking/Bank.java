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
public class Bank implements IBank{
    protected int bankNumber;
    protected String address;
    protected ArrayList<Client> clientList;

    public Bank(int bankNumber, String address) {
        this.bankNumber = bankNumber;
        this.address = address;
        
        clientList = new ArrayList<Client>();
    }
    
    
    // add a new Client --Jean
    @Override
    public void addClient(Client newClient) {
        clientList.add(newClient);
    }

    //display the client's accounts --Jean
    @Override
    public void displayClientAccounts(int clientId) {
        for(Client client: clientList){
            if(client.getId()==clientId){
                client.displayAccounts();
            }
        }
    }

    //diplay all the clients --Jean
    @Override
    //This function prints "List of current clients: " for every client **TO FIX**- Abderrahman
    public void displayClientList() {
        for(Client client: clientList){
            System.out.println("List of current clients: ");
            System.out.println(client.toString());
        }
    }

    //get the client by his id --Jean
    @Override
    public Client getClient(int id) {
        for(Client client: clientList){
            if(client.id==id){
                return client;
            }
        }
        return null;
    }

    //Add a verifier for the client id before passing to the Account checker --Abderrahman for Jean
    //get an account based on accountNumber and id --Jean
    @Override
    public Account getClientAccount(int clientId, int accountNumber) {
        for(Client client: clientList){
            if(client.id==clientId){
              return client.getAccount(accountNumber);
            }
        }
        return null;
    }
    
    
}
