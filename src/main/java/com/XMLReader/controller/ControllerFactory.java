package com.XMLReader.controller;

import javax.xml.bind.JAXBException;


public class ControllerFactory {
	
	public static final int IBATIS = 1;
	public static final int HIBERNATE = 2;

	public BaseController getController (int controllerType) throws JAXBException {
		
		switch (controllerType) {
		case IBATIS:
			return new IbatisController();
		case HIBERNATE:
			return new HibernateController();

		default:
			break;
		}
		
		return null;
	}
	
	public BaseController getController (int controllerType, String dir) throws JAXBException {
		
		switch (controllerType) {
		case IBATIS:
			return new IbatisController(dir);
		case HIBERNATE:
			return new HibernateController(dir);
			
		default:
			break;
		}
		
		return null;
	}
}
