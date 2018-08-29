package com.XMLReader.entities.struts;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "form-property")
public class FormProperty implements XMLEntity {
	
	@XmlAttribute (name = "name")
	private String name;
	
	@XmlAttribute (name = "type")
	private String type;
	
	@XmlAnyElement(lax = true)
	private List<Object> anything;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Object> getAnything() {
		return anything;
	}

	public void setAnything(List<Object> anything) {
		this.anything = anything;
	}
	
}
