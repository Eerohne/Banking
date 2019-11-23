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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cstuser
 */
public  class LoadingInputs {
      
    private static ArrayList <String> command = new ArrayList<String>();
    private static Object data;

    
    public static void load(Bank bank, String name) throws FileNotFoundException{
        
       File f = new File("./src/banking/"+ name + ".txt"); 
        Scanner scan = new Scanner(f);
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
                float accountNumber = Float.parseFloat(command.get(i));
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
                        float transactionNumber = Float.parseFloat(command.get(i));
                        if(transactionNumber > 0)
                        {
                            for(int k = 0; k < transactionNumber; k++)
                            {
                                 i++;
                                 if(command.get(i).equals("w"))
                                 {
                                     i++;
                                     a.withdrawal(Float.parseFloat(command.get(i)));
                                 }
                                 else
                                 if(command.get(i).equals("d"))
                                 {
                                    i++;
                                    a.deposit(Float.parseFloat(command.get(i))); 
                                 }
                            }
                        }
                        c.addAccount(a);
                    }
                }
                bank.addClient(c);
            }
        }
      /* 
        for(String s : command)
        {
            System.out.println(s);
        }
      */
    }
    
     public static void save(Bank bank, String name) throws FileNotFoundException {
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
                    data += t.getAmount() + " ";
                 }
             }
         }
         
         
         
          OutputStream os = null;
        try {
            String path = "./src/banking/"+ name + ".txt";
            //clearThefile(path);
            os = new FileOutputStream(new File(path));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }
     
     
     public static void clearTheFile(String path) throws IOException {
        FileWriter fwOb = new FileWriter(path, false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}

