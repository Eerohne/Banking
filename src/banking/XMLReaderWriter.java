/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

/**
 *
 * @author cstuser
 */
public class XMLReaderWriter {
    
    public static void saveToXML(Bank b) throws FileNotFoundException{
        File f = new File("./src/banking/save.xml");
        PrintWriter pw = new PrintWriter(f);
        pw.print(b.toXML());
        pw.close();
    }
    
    /*public static void loadXML() throws ParserConfigurationException, IOException, SAXException{
        NodeList cList = doc.getElementsByTagName("Bank");
        
        for (int i = 0; i < cList.getLength(); i++) {
            
        }
    }*/
}
