package com.XMLReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import com.XMLReader.controller.HibernateController;
import com.XMLReader.controller.IbatisController;
import com.XMLReader.convert.ConvertIbatisToHibernate;
import com.XMLReader.entities.hibernate.HibernateEntity;
import com.XMLReader.entities.ibatis.IbatisEntity;

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
