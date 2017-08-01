package com.XMLReader.io;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;

/**
 * @author thuynh40
 *  Process DOCTYPE
 * <!DOCTYPE sql-map PUBLIC "-//iBATIS.com//DTD SQL Map 1.0//EN" "http://www.ibatis.com/dtd/sql-map.dtd">
 * publicID: "-//iBATIS.com//DTD SQL Map 1.0//EN"
 * systemID: "http://www.ibatis.com/dtd/sql-map.dtd">
 * baseURI: filePath
 */
public class DocXMLResolver implements XMLResolver {
	
	private String publicID;
    private String systemID;
    private String baseURI;
    private String namespace;

	@Override
	public Object resolveEntity(String publicID, String systemID,
			String baseURI, String namespace) throws XMLStreamException {
		this.publicID = publicID;
        this.systemID = systemID;
        this.baseURI = baseURI;
        this.namespace = namespace;
		return null;
	}

	public String getPublicID() {
		return publicID;
	}

	public void setPublicID(String publicID) {
		this.publicID = publicID;
	}

	public String getSystemID() {
		return systemID;
	}

	public void setSystemID(String systemID) {
		this.systemID = systemID;
	}

	public String getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

}
