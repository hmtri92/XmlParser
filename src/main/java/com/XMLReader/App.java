package com.XMLReader;

import com.XMLReader.controller.HibernateController;
import com.XMLReader.controller.IbatisController;

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
        
        HibernateController hibernate = new HibernateController(dir);
        hibernate.unMarshalAll();
        hibernate.test();
    }
}
