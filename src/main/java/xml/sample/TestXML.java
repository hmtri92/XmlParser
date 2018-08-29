package xml.sample;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXML {

	String xml;
	
	public TestXML() {
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Object><one/><two>1</two><three>1</three><four>1</four></Object>";
//		getNodeJdom(xml);
//		getNodew3c(xml);
		
	}
	
	public void getNodeJdom(String xml) {
		SAXBuilder saxBuilder = new SAXBuilder();
		org.jdom2.Document doc;
		try {
			doc = saxBuilder.build(new StringReader(xml));
			Element root = doc.getRootElement();
			
			List<Element> lstElement = root.getChildren();
			
			for (Element element : lstElement) {
				String elementName = element.getName();
				String value = element.getText();
				
				System.out.println(elementName + " - " + value);
			}
			
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getNodew3c(String xml) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			org.w3c.dom.Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				org.w3c.dom.Node node = nodeList.item(i);
				if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					NodeList lstChildNode = node.getChildNodes();
					for (int j = 0; j < lstChildNode.getLength(); j++) {
						org.w3c.dom.Node childNode = lstChildNode.item(j);
						
						if (childNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
							org.w3c.dom.Element element = (org.w3c.dom.Element)childNode;
							String tagName = element.getTagName();
							String value = element.getTextContent();
							
							System.out.println(tagName + "-" + value);
						}
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void soap() throws IOException, SOAPException {
		// create message factory
        MessageFactory mf = MessageFactory.newInstance();
        // headers for a SOAP message
        MimeHeaders header = new MimeHeaders();     
        header.addHeader("Content-Type", "text/xml");

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
         "<soapenv:Body>"+
           "<theRequest>"+
             "<username>user</username>"+
             "<password>password</password>"+
             "<someMsg>sooomeMessage</someMsg>"+
           "</theRequest>"+
          "</soapenv:Body>"+
        "</soapenv:Envelope>";
        InputStream is = new ByteArrayInputStream(request.getBytes());

        // create the SOAPMessage
        SOAPMessage soapMessage = mf.createMessage(header,is);
        // get the body
        SOAPBody soapBody = soapMessage.getSOAPBody();
        // find your node based on tag name
        NodeList nodes = soapBody.getElementsByTagName("someMsg");
        System.out.println(nodes.getClass().getName());
        
        // check if the node exists and get the value
        String someMsgContent = null;
        Node node = nodes.item(0);
        someMsgContent = node != null ? node.getTextContent() : "";

        System.out.println(someMsgContent);
	}
	
	
	public static void main(String[] args) {
		TestXML testXML = new TestXML();
		try {
			testXML.soap();
		} catch (IOException | SOAPException e) {
			// T-TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
