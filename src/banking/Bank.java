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
    public void displayClientList() {
        for(Client client: clientList){
            System.out.println("List of current clients: ");
            System.out.println("("+client.getId()+")"+client.getFirstName()+", "+client.getLastName());
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
