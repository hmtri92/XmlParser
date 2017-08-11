package com.XMLReader.entities.ibatis;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.Property;
import com.XMLReader.entities.XMLEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "result-map" )
public class ResultMap implements XMLEntity {

	@XmlElement( name = "property")
	List<Property> properties;
	
	@XmlAttribute (name = "class")
	String EntityClass;
	
	@XmlAttribute (name = "name")
	String name;
	
	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public void addProperties(Property property) {
		if (properties == null) {
			properties = new ArrayList<Property>();
		}
		
		properties.add(property);
	}
	
	public String getEntityClass() {
		return EntityClass;
	}
	
	public void setEntityClass(String entityClass) {
		EntityClass = entityClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
