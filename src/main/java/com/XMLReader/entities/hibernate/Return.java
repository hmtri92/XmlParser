package com.XMLReader.entities.hibernate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "return")
public class Return implements XMLEntity {
	
	@XmlAttribute (name = "entity-name")
	String entityName;

	@XmlAttribute(name = "class")
	String returnClass;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getReturnClass() {
		return returnClass;
	}

	public void setReturnClass(String returnClass) {
		this.returnClass = returnClass;
	}
}
