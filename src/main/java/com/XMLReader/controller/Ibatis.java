package com.XMLReader.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.XMLReader.entities.ibatis.IbatisEntity;
import com.XMLReader.io.Reader;

public class Ibatis {
	/**
	 * remove DOCTYPE tag
	 */
	
	private String workingDir = "";
	private Reader reader = new Reader();
	private List<String> files;
	private List<IbatisEntity> lstIbatisEntity;
	
	public Ibatis(String workingDir) {
		this.workingDir = workingDir;
		init();
	}
	
	private void init() {
		getFiles();
		lstIbatisEntity = new ArrayList<IbatisEntity>();
	}

	private void getFiles() {
		if (!StringUtils.isEmpty(workingDir)) {
			files = reader.getXMLFiles(workingDir);
		}
	}
	
	private IbatisEntity unMarshal(String file) throws JAXBException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(IbatisEntity.class);
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
	        spf.setFeature("http://www.ibatis.com/dtd/sql-map.dtd", false);
	        XMLReader xmlReader = spf.newSAXParser().getXMLReader();
	        InputSource inputSource = new InputSource(new FileReader(file));
	        SAXSource source = new SAXSource(xmlReader, inputSource);
			
			Unmarshaller unmars = jaxbContext.createUnmarshaller();
			IbatisEntity ibatisEntity = (IbatisEntity) unmars.unmarshal(source);
			
			return ibatisEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void getIbatisFile() {
		if (!files.isEmpty()) {
			files.forEach(file -> {
				try {
					IbatisEntity item = this.unMarshal(file);
					lstIbatisEntity.add(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
	
	public void test() {
		getLstIbatisEntity().forEach(item -> {
			System.out.println(item.getName());
			System.out.println(item.getResultMaps().get(0).getProperties().get(0).getName());
		});
	}

	public List<IbatisEntity> getLstIbatisEntity() {
		return lstIbatisEntity;
	}

	public void setLstIbatisEntity(List<IbatisEntity> lstIbatisEntity) {
		this.lstIbatisEntity = lstIbatisEntity;
	}
}
