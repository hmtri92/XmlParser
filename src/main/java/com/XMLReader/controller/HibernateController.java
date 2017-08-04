package com.XMLReader.controller;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang.StringUtils;

import com.XMLReader.entities.XMLEntity;
import com.XMLReader.entities.hibernate.HibernateEntity;

public class HibernateController extends BaseController {

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
//		try {
//			output = new FileOutputStream(((HibernateEntity)entity).getFilePath());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		super.marshal(entity, output);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new OutputStreamWriter(output));
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof HibernateEntity) {
				HibernateEntity entity = (HibernateEntity)item;
				entity.getLstSqlQuery().get(0).getContent().forEach(value -> {
					if (StringUtils.isNotBlank(value)) {
						System.out.println(value);
					}
				});
//				try {
//					marshal(entity, System.out);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
			}
		});
	}

}
