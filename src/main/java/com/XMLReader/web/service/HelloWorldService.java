package com.XMLReader.web.service;

import org.apache.commons.lang.StringUtils;

import com.XMLReader.io.LogUtil;

public class HelloWorldService extends LogUtil {

	public String getDesc() {

		debug("getDesc() is executed!");

		return "Gradle + Spring MVC Hello World Example";

	}

	public String getTitle(String name) {

		debug("getTitle() is executed! " + name);

		if(StringUtils.isEmpty(name)){
			return "Hello World";
		}else{
			return "Hello " + name;
		}
		
	}
}
