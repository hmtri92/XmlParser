package com.XMLReader.controller;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringUtils;

import com.XMLReader.entities.XMLEntity;
import com.XMLReader.io.DocXMLResolver;
import com.XMLReader.io.LogUtil;
import com.XMLReader.io.Reader;

public abstract class BaseController extends LogUtil {

	private String workingDir = "";
	private Reader reader;
	private List<File> files;
	private List<XMLEntity> lstEntity;
	protected JAXBContext jaxbContext;
	
	public BaseController() {
	}

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
		} else {
			error("No workingDir");
		}
	}
	
	public void unMarshalAll() {
		if (!files.isEmpty()) {
			files.forEach(file -> {
				try {
					XMLEntity item = this.unMarshal(file);
					getLstEntity().add(item);
				} catch (Exception e) {
					error("unMarshalAll()" + e.getMessage());
				}
			});
		}
	}
	
	public void marshalAll() {
		if (!lstEntity.isEmpty()) {
			lstEntity.forEach(entity -> {
				try {
					this.marshal(entity, null);
				} catch (Exception e) {
					error("marshalAll()" + e.getMessage());
				}
			});
		}
	}
	
	// Fix error file contain DOCTYPE
	protected XMLStreamReader getXMLStreamReader(File file) throws XMLStreamException {
		XMLInputFactory xif = XMLInputFactory.newFactory();
        DocXMLResolver resolver = new DocXMLResolver();
        xif.setXMLResolver(resolver);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(file));
        
        return xsr;
	}
	
	
	abstract XMLEntity unMarshal(File file) throws JAXBException;
	
	protected void marshal(XMLEntity entity, OutputStream output) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new OutputStreamWriter(output));
	}

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
	
	public void addEntity(XMLEntity entity) {
		if (this.lstEntity == null) {
			this.lstEntity = new ArrayList<XMLEntity>();
		}
		this.lstEntity.add(entity);
	}

}
