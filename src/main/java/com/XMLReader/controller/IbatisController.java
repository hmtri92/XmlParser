package com.XMLReader.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import com.XMLReader.entities.ibatis.IbatisEntity;

public class IbatisController extends BaseController {
	
	public IbatisController(String workingDir) {
		super(workingDir);
	}
	
	@Override
	IbatisEntity unMarshal(File file) throws JAXBException {
		try {
	        XMLStreamReader xsr = getXMLStreamReader(file);
			
	        JAXBContext jaxbContext = JAXBContext.newInstance(IbatisEntity.class);
			Unmarshaller unmars = jaxbContext.createUnmarshaller();
			IbatisEntity ibatisEntity = (IbatisEntity) unmars.unmarshal(xsr);
			
			return ibatisEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof IbatisEntity) {
				IbatisEntity entity = (IbatisEntity)item;
				System.out.println(entity.getName());
				System.out.println(entity.getResultMaps().get(0).getProperties().get(0).getName());
			}
		});
	}

}
