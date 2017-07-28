package com.XMLReader.entities.ibatis;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "sql-map")
public class IbatisEntity {
	
	String name;
	List<ResultMap> resultMaps;
	List<DynamicMappedStatement> dynamicMappedStatements;
	List<MappedStatement> mappedStatements;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public List<ResultMap> getResultMaps() {
		return resultMaps;
	}

	@XmlElement( name = "result-map")
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

	@XmlElement( name = "dynamic-mapped-statement")
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

	@XmlElement( name = "mapped-statement")
	public void setMappedStatements(List<MappedStatement> mappedStatements) {
		this.mappedStatements = mappedStatements;
	}
	
	public void addMappedStatement(MappedStatement mappedStatement) {
		if (mappedStatements == null) {
			mappedStatements = new ArrayList<MappedStatement>();
		}
		
		this.mappedStatements.add(mappedStatement);
	}
}
