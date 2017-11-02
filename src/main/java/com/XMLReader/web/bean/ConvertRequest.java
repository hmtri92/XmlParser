package com.XMLReader.web.bean;

import java.io.Serializable;

public class ConvertRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7536169718628407703L;
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
