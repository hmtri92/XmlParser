package com.XMLReader.entities.struts;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "form-beans")
public class FormBeans implements XMLEntity {

	@XmlElement (name = "form-bean")
	private List<FormBean> lstFormBean;

	public List<FormBean> getLstFormBean() {
		return lstFormBean;
	}

	public void setLstFormBean(List<FormBean> lstFormBean) {
		this.lstFormBean = lstFormBean;
	}
	
}
