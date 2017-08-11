package com.XMLReader.entities.hibernate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.Property;
import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "composite-id")
public class CompositeID implements XMLEntity {
	
	@XmlElement (name = "key-property")
	Property keyProperty;
	
	public Property getKeyProperty() {
		return keyProperty;
	}

	public void setKeyProperty(Property keyProperty) {
		this.keyProperty = keyProperty;
	}

}
