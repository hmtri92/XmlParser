package com.XMLReader;

import org.apache.log4j.Logger;

import com.XMLReader.controller.ControllerFactory;
import com.XMLReader.controller.HibernateController;
import com.XMLReader.controller.IbatisController;

public class ConvertIbatis {
	
	/*public static void main(String[] args) {
		String str="SINH H 123456";
		String numberOnly= str.replaceAll("[^0-9]", "");
		System.out.println(numberOnly);
		
	}*/
	
    public static void main( String[] args )  {
//    	String dir = "D:/workspaceSpring/XmlParser/runtest";
    	String dir = "D:/workspace_spring/XMLReader/runtest";
    	
        
		try {
			ControllerFactory factory = new ControllerFactory();
			IbatisController ibatis = (IbatisController) factory.getController(ControllerFactory.IBATIS, dir);
			ibatis.unMarshalAll();
//			ibatis.test();
			
			HibernateController hibernate = new HibernateController(ibatis);
			hibernate.marshalAll();
			
			Logger logger = Logger.getLogger(ConvertIbatis.class);
			logger.info(Utilities.report.print());
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger(ConvertIbatis.class);
			logger.error("main error", e);
		}
    }
}
