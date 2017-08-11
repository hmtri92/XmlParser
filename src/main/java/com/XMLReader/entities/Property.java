package com.XMLReader.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "property" )
public class Property implements XMLEntity {

	@XmlAttribute (name = "name")
	String name;
	
	@XmlAttribute (name = "column")
	String column;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
	
}
