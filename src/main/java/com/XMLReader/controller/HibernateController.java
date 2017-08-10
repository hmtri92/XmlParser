package com.XMLReader.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import com.XMLReader.entities.XMLEntity;
import com.XMLReader.entities.hibernate.HibernateEntity;

public class HibernateController extends BaseController {
	private String encode = "<?xml version='1.0' encoding='utf-8'?>";
	private String docType = "\n<!DOCTYPE hibernate-mapping PUBLIC\n"
			+ "\t\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"\n"
			+ "\t\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">\n";

	public HibernateController(String workingDir) throws JAXBException {
		super(workingDir);
		jaxbContext = JAXBContext.newInstance(HibernateEntity.class);
	}

	@Override
	XMLEntity unMarshal(File file) throws JAXBException {
		try {
	        XMLStreamReader xsr = getXMLStreamReader(file);
			
			Unmarshaller unmars = jaxbContext.createUnmarshaller();
			HibernateEntity entity = (HibernateEntity) unmars.unmarshal(xsr);
			entity.setFilePath(file.getAbsolutePath());
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	protected void marshal(XMLEntity entity, OutputStream output) throws JAXBException {
		HibernateEntity hibernateEntity = (HibernateEntity) entity;
		
		try {
			File file = new File(hibernateEntity.getFilePath() + ".out");
			FileWriter fileWriter = new FileWriter(file);
			hibernateEntity.setFilePath(null);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			
			StringWriter stringWriter = new StringWriter(); 
			marshaller.marshal(hibernateEntity, stringWriter);
			
			fileWriter.write(encode + docType + stringWriter.toString());
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof HibernateEntity) {
				HibernateEntity entity = (HibernateEntity)item;
				try {
//					OutputStream output = new FileOutputStream(((HibernateEntity)entity).getFilePath()+".out");
//					marshal(entity, output);
					marshal(entity, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
