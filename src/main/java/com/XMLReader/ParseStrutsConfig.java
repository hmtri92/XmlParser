package com.XMLReader;

import org.apache.log4j.Logger;

import com.XMLReader.classbuilder.ClassBuilder;
import com.XMLReader.controller.ControllerFactory;
import com.XMLReader.controller.StrutsConfigController;

public class ParseStrutsConfig {
	
    public static void main( String[] args )  {
    	String dir = "D:\\workspaceSpring\\XmlParser\\runtest";
        
		try {
			ControllerFactory factory = new ControllerFactory();
			StrutsConfigController contronller = (StrutsConfigController) factory.getController(ControllerFactory.STRUTS1, dir);
			contronller.unMarshalAll();
			contronller.test();
			contronller.buildFormBean();
			
			Logger logger = Logger.getLogger(ParseStrutsConfig.class);
			logger.info(Utilities.report.print());
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger(ParseStrutsConfig.class);
			logger.error("main error", e);
		}
    }
}
