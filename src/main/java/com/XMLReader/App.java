package com.XMLReader;

import com.XMLReader.controller.Ibatis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String dir = "D:/workspace_spring/XMLReader/testData";
        Ibatis ibatis = new Ibatis(dir);
        ibatis.getIbatisFile();
        
        ibatis.test();
    }
}
