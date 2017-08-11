package com.XMLReader.entities.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.Property;
import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "class")
public class EntityClass implements XMLEntity {

	@XmlAttribute (name = "entity-name")
	String entityName;
	
	@XmlAttribute (name = "name")
	String name;
	
	@XmlAttribute (name = "table")
	String table;
	
	@XmlAttribute (name = "lazy")
	String lazy = "false";
	
	@XmlElement (name = "composite-id")
	CompositeID compositeID;
	
	@XmlElement (name = "property")
	List<Property> lstProperty;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getLazy() {
		return lazy;
	}

	public void setLazy(String lazy) {
		this.lazy = lazy;
	}

	public List<Property> getLstProperty() {
		return lstProperty;
	}

	public void setLstProperty(List<Property> lstProperty) {
		this.lstProperty = lstProperty;
	}
	
	public void addProperty(Property property) {
		if (this.lstProperty == null) {
			this.lstProperty = new ArrayList<Property>();
		}
		this.lstProperty.add(property);
	}

	public CompositeID getCompositeID() {
		return compositeID;
	}

	public void setCompositeID(CompositeID compositeID) {
		this.compositeID = compositeID;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
