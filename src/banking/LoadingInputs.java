/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;




/**
 *
 * @author cstuser
 */
public  class LoadingInputs {
      
    private static ArrayList <String> command = new ArrayList<String>();
    private static DecimalFormat df = new DecimalFormat("#0.00");        

    
    public static void load(Bank bank, String name) throws FileNotFoundException{
        
        File f = new File("./src/banking/"+ name + ".txt"); 
        Scanner scan = new Scanner(f);
        command.clear();
        while(scan.hasNextLine()){
            command.add(scan.next());
        }
        
        bank.getClientList().clear();
        Client.setCounter(0);
        
        for(int i = 0; i < command.size(); i++)
        {
            String l = command.get(i);
            if(command.get(i).equals("c"))
            {
                String lastName, firstName;
                i++;
                firstName = command.get(i);
                i++;
                lastName = command.get(i);
                Client c = new Client(firstName, lastName);
                
                i++;
                double accountNumber = Double.parseDouble(command.get(i));
                if(accountNumber > 0)
                {
                    for(int j = 0; j< accountNumber; j++)
                    {
                        i++;
                        Account a = new Account("");
                        if(command.get(i).equals("ch"))
                        {
                            a.type = "checking";
                        }
                        else if(command.get(i).equals("s"))
                        {
                            a.type = "savings";
                        }
                        
                        i++;
                        double transactionNumber = Double.parseDouble(command.get(i));
                        if(transactionNumber > 0)
                        {
                            for(int k = 0; k < transactionNumber; k++)
                            {
                                 i++;
                                 if(command.get(i).equals("w"))
                                 {
                                     i++;
                                     a.withdrawal(Double.parseDouble(command.get(i)));
                                 }
                                 else
                                 if(command.get(i).equals("d"))
                                 {
                                    i++;
                                    a.deposit(Double.parseDouble(command.get(i))); 
                                 }
                            }
                        }
                        c.addAccount(a);
                    }
                }
                bank.addClient(c);
            }
        }
    }
    
     public static void save(Bank bank, String name) throws FileNotFoundException, IOException {
         String data = "";
         for(Client c : bank.getClientList())
         {
             data += "c ";
             data += c.getFirstName() + " ";
             data += c.getLastName() + " ";
             data += c.getAccountList().size() + " ";
             
             for(Account a : c.getAccountList())
             {
                  if(a.getType().equals("checking"))
                  {
                      data += "ch ";
                  }else
                  {
                      data += "s ";
                  }
                    data += a.getTransactions().size() + " ";
                    
                 for(Transaction t : a.getTransactions())
                 {
                    if(t.getType().equals("Deposit"))
                     {
                         data += "d ";
                     }else  if(t.getType().equals("Withdrawal"))
                     {
                         data += "w ";
                     }
                    data += df.format(t.getAmount()) + " ";
                 }
             }
         }
         
          data = data.substring(0, data.length() - 1);
         
        File path = new File("./src/banking/"+ name + ".txt");
        PrintWriter pw = new PrintWriter(path);
        pw.print(data);
        pw.close();
     }
}

