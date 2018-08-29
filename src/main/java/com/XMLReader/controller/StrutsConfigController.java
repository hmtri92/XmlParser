package com.XMLReader.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import com.XMLReader.classbuilder.ClassBuilder;
import com.XMLReader.entities.struts.StrutsConfig;

public class StrutsConfigController extends BaseController {

	public StrutsConfigController() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(StrutsConfig.class);
	}

	public StrutsConfigController(String workingDir) throws JAXBException {
		super(workingDir);
		jaxbContext = JAXBContext.newInstance(StrutsConfig.class);
	}

	@Override
	StrutsConfig unMarshal(File file) throws JAXBException {
		try {
	        XMLStreamReader xsr = getXMLStreamReader(file);
			
			Unmarshaller unmars = jaxbContext.createUnmarshaller();
			StrutsConfig entity = (StrutsConfig) unmars.unmarshal(xsr);
			entity.setFilePath(file.getAbsolutePath());
			
			return entity;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return null;
	}
	
	public void test() {
		getLstEntity().forEach(item -> {
			if (item instanceof StrutsConfig) {
				StrutsConfig entity = (StrutsConfig)item;
				try {
					marshal(entity, System.out);
				} catch (Exception e) {
					error(e.getMessage());
				}
			}
		});
	}
	
	public void buildFormBean() {
		getLstEntity().forEach(item -> {
			if (item instanceof StrutsConfig) {
				StrutsConfig entity = (StrutsConfig)item;
				ClassBuilder builder = new ClassBuilder();
				builder.buildFormBean(entity);
			}
		});
	}

}
