package com.XMLReader.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import com.XMLReader.convert.ConvertIbatisToHibernate;
import com.XMLReader.entities.XMLEntity;
import com.XMLReader.entities.hibernate.HibernateEntity;
import com.XMLReader.entities.ibatis.IbatisEntity;

public class HibernateController extends BaseController {
	
	public HibernateController() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(HibernateEntity.class);
	}

	public HibernateController(String workingDir) throws JAXBException {
		super(workingDir);
		jaxbContext = JAXBContext.newInstance(HibernateEntity.class);
	}
	
	public HibernateController(IbatisController ibatisController) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(HibernateEntity.class);
		convertIbatisToHibernate(ibatisController);
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
			error(e.getMessage());
		}
		return null;
	}
	

	/**
	 * OutputStream set null to write file
	 */
	@Override
	protected void marshal(XMLEntity entity, OutputStream output) throws JAXBException {
		// defaul write to file
		if (output == null) {
			HibernateEntity hibernateEntity = (HibernateEntity) entity;
			
			try {
				File file = new File(hibernateEntity.getFilePath());
				FileWriter fileWriter = new FileWriter(file);
				
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
				marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
				
				StringWriter stringWriter = new StringWriter(); 
				marshaller.marshal(hibernateEntity, stringWriter);
				
				StringBuilder content = new StringBuilder();
				content.append(hibernateEntity.getEncode());
				content.append(hibernateEntity.getDocType());
				content.append(stringWriter.toString());
				
				fileWriter.write(content.toString());
				fileWriter.flush();
				fileWriter.close();
				
			} catch (IOException e) {
				error(e.getMessage());
			}
		} else {
			super.marshal(entity, output);
		}
		
	}
	
	public void convertIbatisToHibernate(IbatisController ibatisController) {
		ConvertIbatisToHibernate converter = new ConvertIbatisToHibernate();
		
		List<XMLEntity> lstIbatis = ibatisController.getLstEntity();
		for (XMLEntity xmlEntity : lstIbatis) {
			HibernateEntity entity = converter.convert((IbatisEntity) xmlEntity);
			this.addEntity(entity);
		}
		
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof HibernateEntity) {
				HibernateEntity entity = (HibernateEntity)item;
				try {
//					OutputStream output = new FileOutputStream(((HibernateEntity)entity).getFilePath()+".out");
					marshal(entity, null);
//					marshal(entity, System.out);
				} catch (Exception e) {
					error(e.getStackTrace().toString());
				}
				
			}
		});
	}

}
