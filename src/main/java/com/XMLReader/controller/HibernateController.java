package com.XMLReader.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import com.XMLReader.entities.XMLEntity;
import com.XMLReader.entities.hibernate.HibernateEntity;

public class HibernateController extends BaseController {

	public HibernateController(String workingDir) {
		super(workingDir);
	}

	@Override
	XMLEntity unMarshal(File file) throws JAXBException {
		try {
	        XMLStreamReader xsr = getXMLStreamReader(file);
			
	        JAXBContext jaxbContext = JAXBContext.newInstance(HibernateEntity.class);
			Unmarshaller unmars = jaxbContext.createUnmarshaller();
			HibernateEntity ibatisEntity = (HibernateEntity) unmars.unmarshal(xsr);
			
			return ibatisEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof HibernateEntity) {
				HibernateEntity entity = (HibernateEntity)item;
				System.out.println(entity.getLstEntityClass().get(0).getName());
				
				
			}
		});
	}

}
