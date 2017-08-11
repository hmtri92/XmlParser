package com.XMLReader;

import com.XMLReader.controller.HibernateController;
import com.XMLReader.controller.IbatisController;

public class App 
{
    public static void main( String[] args )
    {
    	String dir = "D:/workspace_spring/XMLReader/runtest";
    	
        
		try {
			IbatisController ibatis = new IbatisController(dir);
			ibatis.unMarshalAll();
			ibatis.test();
			
			HibernateController hibernate = new HibernateController(ibatis);
			hibernate.marshalAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
