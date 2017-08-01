package com.XMLReader.entities.ibatis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "mapped-statement")
public class MappedStatement implements XMLEntity {

	@XmlAttribute( name = "name")
	String name;
	
	@XmlAttribute( name = "result-map")
	String resultMap;
	
	@XmlValue
	String value;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResultMap() {
		return resultMap;
	}
	
	public void setResultMap(String resultMap) {
		this.resultMap = resultMap;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
