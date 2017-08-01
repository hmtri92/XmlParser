package com.XMLReader.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;

import com.XMLReader.entities.XMLEntity;
import com.XMLReader.io.DocXMLResolver;
import com.XMLReader.io.Reader;

public abstract class BaseController {

	private String workingDir = "";
	private Reader reader;
	private List<File> files;
	private List<XMLEntity> lstEntity;
	
	public BaseController(String workingDir) {
		this.workingDir = workingDir;
		init();
	}
	
	private void init() {
		reader = new Reader();
		lstEntity = new ArrayList<XMLEntity>();
		readFiles();
	}
	
	private void readFiles() {
		if (!StringUtils.isEmpty(workingDir)) {
			files = reader.getXMLFiles(workingDir);
		}
	}
	
	public void unMarshalAll() {
		if (!files.isEmpty()) {
			files.forEach(file -> {
				try {
					XMLEntity item = this.unMarshal(file);
					getLstEntity().add(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
	
	XMLStreamReader getXMLStreamReader(File file) throws XMLStreamException {
		XMLInputFactory xif = XMLInputFactory.newFactory();
        DocXMLResolver resolver = new DocXMLResolver();
        xif.setXMLResolver(resolver);
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(file));
        
        return xsr;
	}
	
	
	abstract XMLEntity unMarshal(File file) throws JAXBException;

	public String getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	public List<XMLEntity> getLstEntity() {
		return lstEntity;
	}

	public void setLstEntity(List<XMLEntity> lstEntity) {
		this.lstEntity = lstEntity;
	}

}
