package com.XMLReader.entities.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

import com.XMLReader.entities.XMLEntity;

/**
 * Only generate nameQuery
 * @author thuynh40
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "hibernate-mapping")
public class HibernateEntity implements XMLEntity {

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
}
