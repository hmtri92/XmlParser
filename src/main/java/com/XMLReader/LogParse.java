package com.XMLReader;

import java.io.IOException;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class LogParse
{
    public static Collection<Integer> getIdsByMessage(String xmlStr, String message) 
    		throws ParserConfigurationException, SAXException, IOException {
    	
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlStr);
        NodeList nodeList = document.getElementsByTagName("entry");
        for(int x = 0, size = nodeList.getLength(); x<size; x++) {
        	NodeList chilNode = nodeList.item(x).getChildNodes();
        	int y = 0;
//        	for (sizey = nodeList.getLength(); y < sizey; y++)
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue());
        }
    	
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
       String xml = "<?xml version=\"1.0\"?>\n" +
                "<log>\n" +
                "    <entry id = \"1\">\n" +
                "        <message>Application started</message>\n" +
                "    </entry>\n" +
                "    <entry id = \"2\">\n" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n"+
                "</log>";

        Collection<Integer> results = null;
		try {
			results = LogParse.getIdsByMessage(xml, "Application ended");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for(int i : results) {
            System.out.print(i + " ");
        }
    }
}