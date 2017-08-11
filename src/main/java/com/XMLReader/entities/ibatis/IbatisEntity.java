package com.XMLReader.entities.ibatis;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.XMLReader.entities.XMLEntity;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name = "sql-map")
public class IbatisEntity implements XMLEntity {
	@XmlTransient
	String filePath = "";
	
	@XmlTransient
	public static final String subfix = ".xml";
	
	@XmlAttribute
	String name;
	
	@XmlElement( name = "result-map")
	List<ResultMap> resultMaps;
	
	@XmlElement( name = "dynamic-mapped-statement")
	List<DynamicMappedStatement> dynamicMappedStatements;
	
	@XmlElement( name = "mapped-statement")
	List<MappedStatement> mappedStatements;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResultMap> getResultMaps() {
		return resultMaps;
	}

	public void setResultMaps(List<ResultMap> resultMaps) {
		this.resultMaps = resultMaps;
	}
	
	public void addResulMap(ResultMap resultMap) {
		if (resultMaps == null) {
			resultMaps = new ArrayList<ResultMap>();
		}
		
		resultMaps.add(resultMap);
	}

	public List<DynamicMappedStatement> getDynamicMappedStatements() {
		return dynamicMappedStatements;
	}

	public void setDynamicMappedStatements(
			List<DynamicMappedStatement> dynamicMappedStatements) {
		this.dynamicMappedStatements = dynamicMappedStatements;
	}
	
	public void addDynamicMapStatement(DynamicMappedStatement dynamicMappedStatement) {
		if (dynamicMappedStatements == null) {
			dynamicMappedStatements = new ArrayList<DynamicMappedStatement>();
		}
		
		dynamicMappedStatements.add(dynamicMappedStatement);
	}

	public List<MappedStatement> getMappedStatements() {
		return mappedStatements;
	}

	public void setMappedStatements(List<MappedStatement> mappedStatements) {
		this.mappedStatements = mappedStatements;
	}
	
	public void addMappedStatement(MappedStatement mappedStatement) {
		if (mappedStatements == null) {
			mappedStatements = new ArrayList<MappedStatement>();
		}
		
		this.mappedStatements.add(mappedStatement);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSubfix() {
		return subfix;
	}
}
