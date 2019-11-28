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
    private static final UserInputManager UIM = new UserInputManager();
    private static final String PATH = "./src/banking/";
    private static File file;
    
    public static void saveToXML(Bank b) throws FileNotFoundException{
        try {
            file = new File("./src/banking/" + UIM.retrieveFileName() + ".xml");
            PrintWriter pw = new PrintWriter(file);
            pw.print(b.toXML());
            pw.close();
            UserInputManager.printError("Successfil save!");
        } catch (Exception e) {
            UserInputManager.printError(e.getMessage());
        }
    }
    
    public static void loadXML(Bank b) throws ParserConfigurationException, IOException, SAXException{
        try {
            b.getClientList().clear();
            file = new File(PATH + UIM.retrieveFileName() + ".xml");
            b.fromXML();   
            UserInputManager.printError("Successfil load!");
        } catch (FileNotFoundException e) {
            UserInputManager.printError(e.getMessage());
        }
    }
    
    public static File getFile() {
        return file;
    }

    public static void setFile(File f) {
        XMLReaderWriter.file = f;
    }
}
