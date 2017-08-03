package com.XMLReader.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterCDATA extends XmlAdapter<String, String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String marshal(String arg0) throws Exception {
		return "<![CDATA[" + arg0 + "]]>";
	}

	@Override
	public String unmarshal(String arg0) throws Exception {
		return arg0;
	}

}
