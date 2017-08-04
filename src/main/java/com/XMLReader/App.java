package com.XMLReader;

import javax.xml.bind.JAXBException;

import com.XMLReader.controller.HibernateController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String dir = "D:/workspace_spring/XMLReader/runtest";
    	
//    	IbatisController ibatis = new IbatisController(dir);
//        ibatis.unMarshalAll();
//        ibatis.test();
        
        HibernateController hibernate;
		try {
			hibernate = new HibernateController(dir);
			hibernate.unMarshalAll();
			hibernate.test();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
