package banking;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;




public class Client /*implements IClient*/{
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    private static int counter = 0;

    public Client() {
        ++counter;
    }
    
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        String xml = "<Client>";
        xml += "<id>" + this.id + "</id>";
        xml += "<firstName>" + this.firstName + "</firstName>";
        xml += "<lastName>" + this.lastName + "</lastName>";
        for(Account a: accountList)
        {
            xml += a.toXML();
        }
        xml += "</Client>";
        return xml;
    }
    
    public void fromXML(Node clientNode) throws SAXException, ParserConfigurationException, IOException{
            Element clientElement = (Element) clientNode;
            
            this.id = Integer.parseInt(clientElement.getElementsByTagName("id").item(0).getTextContent());
            this.firstName = clientElement.getElementsByTagName("firstName").item(0).getTextContent();
            this.lastName = clientElement.getElementsByTagName("lastName").item(0).getTextContent(); 
            
            NodeList aList = clientNode.getChildNodes();
            for (int i = 0; i < aList.getLength(); i++) {
                Node accountNode = aList.item(i);
                
                if(accountNode.getNodeType() == Node.ELEMENT_NODE && accountNode.getNodeName().equals("Account")){
                    Element accountElement = (Element) accountNode;
                    
                    Account a = new Account();
                    a.fromXML(accountNode);
                    this.accountList.add(a);
                }
            }
    }
}
