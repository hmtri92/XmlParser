package com.XMLReader.entities.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.XMLReader.entities.AdapterCDATA;
import com.XMLReader.entities.XMLEntity;
import com.sun.xml.txw2.annotation.XmlCDATA;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sql-query")
public class SqlQuery implements XMLEntity {

	@XmlAttribute(name = "name")
	String name;

	@XmlElement(name = "return-scalar")
	List<ReturnScalar> lstReturnScaler;

	@XmlMixed
	@XmlAnyElement(lax = true)
	@XmlJavaTypeAdapter(AdapterCDATA.class)
	List<String> content;

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

	public void addReturnScaler(ReturnScalar returnScalar) {
		if (lstReturnScaler.isEmpty()) {
			lstReturnScaler = new ArrayList<ReturnScalar>();
		}

		lstReturnScaler.add(returnScalar);
	}

	public List<String> getContent() {
		return content;
	}

	@XmlCDATA
	public void setContent(List<String> content) {
		this.content = content;
	}

}
