/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cstuser
 */
public  class LoadingInputs {
    static File f = new File("C:\\Users\\cstuser\\Documents\\NetBeansProjects\\Banking\\src\\banking\\a.txt");   
    private static ArrayList <String> command = new ArrayList<String>();

    
    public static void load() throws FileNotFoundException{
       
        Scanner scan = new Scanner(f);
        while(scan.hasNextLine()){
            command.add(scan.next());
        }
        
        for(int i = 0; i < command.size(); i++)
        {
            if( command.get(i) == "c")
            {
                String lastName, firstName;
                i++;
                firstName = command.get(i);
                i++;
                lastName = command.get(i);
                
                Client c = new Client(firstName, lastName);
                
            }
        }
        
        /*for(String s : command)
        {
            System.out.println(s);
        */}
    }

