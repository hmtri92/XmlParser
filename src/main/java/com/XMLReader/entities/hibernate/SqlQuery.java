package com.XMLReader.entities.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "sql-query")
public class SqlQuery implements XMLEntity {
	
	@XmlAttribute (name = "name")
	String name;

	@XmlElement (name = "return-scalar")
	List<ReturnScalar> lstReturnScaler;
	
	@XmlValue
	String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReturnScalar> getLstReturnScaler() {
		return lstReturnScaler;
	}

	public void setLstReturnScaler(List<ReturnScalar> lstReturnScaler) {
		this.lstReturnScaler = lstReturnScaler;
	}
	
	public void addReturnScaler (ReturnScalar returnScalar) {
		if (lstReturnScaler.isEmpty()) {
			lstReturnScaler = new ArrayList<ReturnScalar>();
		}
		
		lstReturnScaler.add(returnScalar);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
