package com.XMLReader;

import org.apache.commons.lang.StringUtils;

import com.XMLReader.io.Report;

public class Utilities {
	public static Report report = new Report();
	
	public static String trim(String content) {
		return StringUtils.trimToEmpty(content);
	}
	
}
