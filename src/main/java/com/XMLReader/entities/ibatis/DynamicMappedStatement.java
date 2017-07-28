package com.XMLReader.entities.ibatis;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "dynamic-mapped-statement")
public class DynamicMappedStatement {

	String name;
	String resultmap;

	public String getName() {
		return name;
	}

	@XmlAttribute( name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String getResultmap() {
		return resultmap;
	}

	@XmlAttribute( name = "result-map")
	public void setResultmap(String resultmap) {
		this.resultmap = resultmap;
	}
}
