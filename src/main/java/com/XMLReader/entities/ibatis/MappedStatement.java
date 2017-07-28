package com.XMLReader.entities.ibatis;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "mapped-statement")
public class MappedStatement {

	String name;
	String resultMap;
	
	public String getName() {
		return name;
	}
	
	@XmlAttribute( name = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResultMap() {
		return resultMap;
	}
	
	@XmlAttribute( name = "result-map")
	public void setResultMap(String resultMap) {
		this.resultMap = resultMap;
	}
	
}
