/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;



/**
 *
 * @author cstuser
 */
public class Client /*implements IClient*/{
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 0;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountList = new ArrayList<Account>();
        Client.counter++;
        this.id = this.counter;
    }
    
    
    //create new Account --Jean
    //@Override
    public void addAccount(Account newAccount) {
        this.accountList.add(newAccount);
    }

    //print all accounts --Jean
    //@Override
    public void displayAccounts() throws EmptyList{
        if (this.accountList.size()>0){
            for(Account account: this.accountList){
                System.out.println(account);
            }
            return;
        }
        throw new EmptyList("The account list is empty");
    }

    //get account by accountNumber --Jean
    //@Override
    public Account getAccount(int accountNumber) throws AccountNotFound{
        for(Account account: this.accountList){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        /*Old null*/ 
        throw new AccountNotFound("The account was not found");
    }
    
    //toString for client
    public String toString(){
        return "* " + "("+this.getId()+")"+this.getFirstName()+", "+this.getLastName();
    }

    //getters and setters for the class --Jean
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccountList() {
        return this.accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public static int getCounter() {
        return Client.counter;
    }

    public static void setCounter(int counter) {
        Client.counter = counter;
    }
    
    public String save()
    {
        String data = "";
         data += "c ";
             data += this.firstName + " ";
             data += this.lastName + " ";
             data += this.accountList.size() + " ";
             
             for(Account a : accountList)
             {
                  data += a.save();
             }
              
        return data;
    }
    
    public String toXML(){
        String xml = "\t<Client>\n";
        xml += "\t\t<id>" + this.id + "</id>\n";
        xml += "\t\t<firstName>" + this.id + "</firstName>\n";
        xml += "\t\t<lastName>" + this.id + "</lastName>\n";
        for(Account a: accountList)
        {
            xml += a.toXML();
        }
        xml += "\t</Client>\n";
        return xml;
    }
    
    public static Client fromXML(int id) throws SAXException, ParserConfigurationException, IOException, ClientDoesNotExist{
        NodeList cList = UserInputManager.xmlNode("Client");
        Node node = cList.item(id);
            
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element clientElement = (Element) node;

            String firstName = clientElement.getElementsByTagName("firstName").item(0).getTextContent();
            String lastName = clientElement.getElementsByTagName("lastName").item(0).getTextContent();
            
            //ADD ACCOUNTLIST READER
            
            return new Client(firstName, lastName);
        }
        
        throw new ClientDoesNotExist("The client you try to load does not exist");
    }
}
