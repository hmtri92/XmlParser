package com.XMLReader.io;

import org.apache.log4j.Logger;

public class LogUtil {
	private Logger logger = Logger.getLogger(getClass().getName());

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void error(String message) {
		getLogger().error(message);
	}
	
	public void error(Exception e) {
		getLogger().error("ERROR", e);		
	}
	
	public void info(String message) {
		getLogger().info(message);
	}
}
