package com.XMLReader.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType (XmlAccessType.FIELD)
public class CustomString implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlJavaTypeAdapter(AdapterCDATA.class)
	String content;

	public String getContent() {
		if (StringUtils.isNotEmpty(content)) {
			return "<![CDATA[" + content + "]]>";
		}
		
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
