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
    private File file;
    private final static String PATH = "./src/banking/";

    public XMLReaderWriter() {
        
    }
    
    public NodeList xmlNode(String tagName, String fileName) throws UnsupportedEncodingException, SAXException, ParserConfigurationException, IOException{
        file = new File(PATH + fileName + ".xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        StringBuilder xmlStringBuilder = new StringBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(
                    xmlStringBuilder.toString().getBytes("UTF-8"));
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(tagName);
        
        return nodeList;
    }
    
    public void saveToXML(Bank b, String fileName) throws FileNotFoundException{
        try {
            file = new File(PATH + fileName + ".xml");
            PrintWriter pw = new PrintWriter(file);
            pw.print(b.toXML());
            pw.close();
        } catch (Exception e) {
            UserInputManager.printError(e.getMessage());
        }
    }
    
    public void loadXML(Bank b, String fileName) throws ParserConfigurationException, IOException, SAXException{
        try {
            b.getClientList().clear();
            Client.setCounter(0);
            Account.setCounter(0);
            b.fromXML(fileName);   
        } catch (FileNotFoundException e) {
            UserInputManager.printError(e.getMessage());
        }
    }
    
    public File getFile() {
        return this.file;
    }

    public void setFile(File f) {
        this.file = f;
    }
}
