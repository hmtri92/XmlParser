package com.XMLReader.entities.ibatis;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "result-map" )
public class ResultMap {

	List<Property> properties;
	
	public List<Property> getProperties() {
		return properties;
	}

	@XmlElement( name = "property")
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	@XmlRootElement( name = "property" )
	class Property {
		String name;
		String EntityClass;
		
		public String getName() {
			return name;
		}
		
		@XmlAttribute (name = "name")
		public void setName(String name) {
			this.name = name;
		}
		
		public String getEntityClass() {
			return EntityClass;
		}
		
		@XmlAttribute (name = "class")
		public void setEntityClass(String entityClass) {
			EntityClass = entityClass;
		}
	}
}
