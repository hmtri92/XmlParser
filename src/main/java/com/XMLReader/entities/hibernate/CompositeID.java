package com.XMLReader.entities.hibernate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "composite-id")
public class CompositeID implements XMLEntity {
	
	@XmlElement (name = "key-property")
	KeyProperty keyProperty;
	
	public KeyProperty getKeyProperty() {
		return keyProperty;
	}

	public void setKeyProperty(KeyProperty keyProperty) {
		this.keyProperty = keyProperty;
	}

	@XmlAccessorType (XmlAccessType.FIELD)
	@XmlRootElement (name = "key-property")
	static class KeyProperty implements XMLEntity {
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

}
