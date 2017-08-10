package com.XMLReader.entities.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.XMLReader.entities.XMLEntity;

/**
 * Only generate nameQuery
 * @author thuynh40
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "hibernate-mapping")
public class HibernateEntity implements XMLEntity {
	
	@XmlTransient
	private final String encode = "<?xml version='1.0' encoding='utf-8'?>";
	
	@XmlTransient
	private final String docType = "\n<!DOCTYPE hibernate-mapping PUBLIC\n"
			+ "\t\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"\n"
			+ "\t\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">\n";
	
	@XmlTransient
	String filePath = "";

	@XmlElement (name = "class")
	List<EntityClass> lstEntityClass;
		
	@XmlElementRef (name = "sql-query")
	List<SqlQuery> lstSqlQuery;

	public List<EntityClass> getLstEntityClass() {
		return lstEntityClass;
	}

	public void setLstEntityClass(List<EntityClass> lstEntityClass) {
		this.lstEntityClass = lstEntityClass;
	}
	
	public void addEntityClass (EntityClass entityClass) {
		if (lstEntityClass.isEmpty()) {
			lstEntityClass = new ArrayList<EntityClass>();
		}
		
		lstEntityClass.add(entityClass);
	}
	
	public List<SqlQuery> getLstSqlQuery() {
		return lstSqlQuery;
	}

	public void setLstSqlQuery(List<SqlQuery> lstSqlQuery) {
		this.lstSqlQuery = lstSqlQuery;
	}

	public void addSqlQuery(SqlQuery sqlQuery) {
		if (lstSqlQuery.isEmpty()) {
			lstSqlQuery = new ArrayList<SqlQuery>();
		}
		
		lstSqlQuery.add(sqlQuery);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEncode() {
		return encode;
	}

	public String getDocType() {
		return docType;
	}
}
