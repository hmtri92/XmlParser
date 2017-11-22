package com.XMLReader.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.XMLReader.Utilities;
import com.XMLReader.entities.Property;
import com.XMLReader.entities.hibernate.CompositeID;
import com.XMLReader.entities.hibernate.EntityClass;
import com.XMLReader.entities.hibernate.HibernateEntity;
import com.XMLReader.entities.hibernate.ReturnEntity;
import com.XMLReader.entities.hibernate.SqlQuery;
import com.XMLReader.entities.ibatis.DynamicMappedStatement;
import com.XMLReader.entities.ibatis.IbatisEntity;
import com.XMLReader.entities.ibatis.MappedStatement;
import com.XMLReader.entities.ibatis.ResultMap;
import com.XMLReader.entities.report.ConvertReportPOJO;

public class IbatisToHibernateConverter {
	
	private String filePath = "";
	ConvertReportPOJO successEnty;
	ConvertReportPOJO failEnty;
	
	// Insert by thuynh40 - Nov 15, 2017
	// T-TODO Report condition
	public HibernateEntity convert (IbatisEntity ibatisEntity) {
		successEnty = new ConvertReportPOJO();
		failEnty = new ConvertReportPOJO();
		
		filePath = ibatisEntity.getFilePath();
		successEnty.setPath(filePath);
		failEnty.setPath(filePath);
		
		HibernateEntity hibernateEntity = new HibernateEntity();
		
		hibernateEntity.setFilePath(convertFilePath(ibatisEntity.getFilePath()));
		
		List<EntityClass> lstEntityClass = convertResultMap(ibatisEntity.getResultMaps());
		hibernateEntity.setLstEntityClass(lstEntityClass);
		
		List<SqlQuery> lstSqlQuery = convertMappedStatement(ibatisEntity.getMappedStatements());
		List<SqlQuery> lstDynamicMappedStatements = 
				convertDynamicMappedStatement(ibatisEntity.getDynamicMappedStatements());
		
		lstSqlQuery.addAll(lstDynamicMappedStatements);
		hibernateEntity.setLstSqlQuery(lstSqlQuery);
		
		Utilities.report.plusTotalFile();
		Utilities.report.addLstCannotConvert(failEnty);
		Utilities.report.addLstSuccess(successEnty);
		
		return hibernateEntity;
	}
	
	private String convertFilePath (String filePath) {
		return filePath.replaceAll(IbatisEntity.subfix, HibernateEntity.subfix);
	}
	
	private List<EntityClass> convertResultMap (List<ResultMap> resultMaps) {
		List<EntityClass> lstEntityClass = new ArrayList<EntityClass>();
		
		for (ResultMap resultMap : resultMaps) {
			Utilities.report.plusResultMap();
			EntityClass entityClass = new EntityClass();
			
			String entityName = resultMap.getName();
			String name = resultMap.getEntityClass();
			entityClass.setEntityName(entityName);
			entityClass.setName(name);
			
			List<Property> properties = resultMap.getProperties();
			Iterator<Property> iterator = properties.iterator();
			if (iterator.hasNext()) {
				// get FIRST property to create composite-id
				Property firtProperty = iterator.next();
				CompositeID compositeId = new CompositeID();
				compositeId.setKeyProperty(firtProperty);
				entityClass.setCompositeID(compositeId);
				
				while (iterator.hasNext()) {
					entityClass.addProperty(iterator.next());
				}
			}
			
			lstEntityClass.add(entityClass);
		}
		
		return lstEntityClass;
	}
	
	/**
	 *  Content empty when query has <dynamic> tag
	 * 	Can not convert to name query ==> proccess in java code
	 */
	private List<SqlQuery> convertDynamicMappedStatement(List<DynamicMappedStatement> dynamicMappedStatements) {
		List<SqlQuery> lstSqlQuery = new ArrayList<SqlQuery>();
		
		for (DynamicMappedStatement dynamicMappedStatement : dynamicMappedStatements) {
			String content = Utilities.trim(dynamicMappedStatement.getContent());
			if (content.isEmpty()) {
				// Cannot convert Dynamic query, enhance in java code.
				failEnty.addQueryNames(dynamicMappedStatement.getName());
				Utilities.report.plusFail();
				continue;
			}
			
			SqlQuery sqlQuery = new SqlQuery();
			
			sqlQuery.setName(dynamicMappedStatement.getName());
			
			if (dynamicMappedStatement.getResultMap() != null) {
				ReturnEntity returnClass = new ReturnEntity();
				returnClass.setEntityName(dynamicMappedStatement.getResultMap());
				sqlQuery.setReturnEntity(returnClass);
			}
			
			sqlQuery.addContent(convertQuery(content));
			
			lstSqlQuery.add(sqlQuery);
			
			successEnty.addQueryNames(dynamicMappedStatement.getName());
			Utilities.report.plusSuccess();
		}
		
		return lstSqlQuery;
	}
	
	private List<SqlQuery> convertMappedStatement (List<MappedStatement> mappedStatements) {
		List<SqlQuery> lstSqlQuery = new ArrayList<SqlQuery>();
		
		for (MappedStatement mappedStatement : mappedStatements) {
			SqlQuery sqlQuery = new SqlQuery();
			
			sqlQuery.setName(mappedStatement.getName());
			
			if (mappedStatement.getResultMap() != null) {
				ReturnEntity returnClass = new ReturnEntity();
				returnClass.setEntityName(mappedStatement.getResultMap());
				sqlQuery.setReturnEntity(returnClass);
			}
			
			String content = Utilities.trim (mappedStatement.getContent());
			sqlQuery.addContent(convertQuery(content));
			
			lstSqlQuery.add(sqlQuery);
			
			successEnty.addQueryNames(mappedStatement.getName());
			Utilities.report.plusSuccess();
		}
		
		return lstSqlQuery;
	}
	
	private String convertQuery(String query) {
		String REGEX = "\\#(.*?)\\#";
		Pattern p = Pattern.compile(REGEX);
	      
		Matcher m = p.matcher(query);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			String replace = ":" + m.group().replaceAll("#", "");
			m.appendReplacement(sb, replace);
		}
		m.appendTail(sb);
		
		return "\n" + sb.toString();
	}
	
	public static void main(String[] args) {
		String test = "abc,123";
		String REGEX = ",";
		String[] result = test.split(REGEX);
		
		for (String item : result) {
			System.out.println(item);			
		}
		
	}

}
