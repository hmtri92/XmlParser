package com.XMLReader.entities.struts;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "struts-config")
public class StrutsConfig implements XMLEntity {
	
	@XmlElement (name = "form-beans")
	private FormBeans formBeans;
	
	@XmlAnyElement(lax = true)
	private List<Object> anything;
	
	@XmlTransient
	String filePath = "";

	public FormBeans getFormBeans() {
		return formBeans;
	}

	public void setFormBeans(FormBeans formBeans) {
		this.formBeans = formBeans;
	}

	public List<Object> getAnything() {
		return anything;
	}

	public void setAnything(List<Object> anything) {
		this.anything = anything;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
