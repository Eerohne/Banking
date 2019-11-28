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
    private static File file = new File("./src/banking/save.xml");
    
    public static void saveToXML(Bank b) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(file);
        pw.print(b.toXML());
        pw.close();
    }
    
    public static void loadXML(Bank b) throws ParserConfigurationException, IOException, SAXException{
        b.getClientList().clear();
        b.fromXML();
    }
    
    public static File getFile() {
        return file;
    }

    public static void setFile(File f) {
        XMLReaderWriter.file = f;
    }
}
