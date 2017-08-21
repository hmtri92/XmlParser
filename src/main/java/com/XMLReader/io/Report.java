package com.XMLReader.io;

import java.util.ArrayList;
import java.util.List;

import com.XMLReader.entities.report.ConvertReportPOJO;

public class Report {

	int totalSuccessQuery = 0;
	int totalFailQuery = 0;
	int totalResultMap = 0;
	int totalQuery = 0;
	int totalFile = 0;
	
	List<ConvertReportPOJO> lstSuccess = new ArrayList<ConvertReportPOJO>();
	List<ConvertReportPOJO> lstCannotConvert = new ArrayList<ConvertReportPOJO>();
	List<String> lstErrorUnmarshal = new ArrayList<String>();
	List<String> lstErrorMarshal = new ArrayList<String>();
	
	public String print() {
		StringBuilder reportResult = new StringBuilder();
		
		reportResult.append("\n");
		reportResult.append("Total files: ").append(totalFile).append("\n");
		reportResult.append("Total Query: ").append(totalQuery).append("\n");
		reportResult.append("Total success Query: ").append(totalSuccessQuery).append("\n");
		reportResult.append("Total fail Query: ").append(totalFailQuery).append("\n");
		reportResult.append("Total Result-Map: ").append(totalResultMap).append("\n");
		
		reportResult.append("----------------------------------").append("\n");
		reportResult.append("Unmarshal error: ").append("\n");
		for (String item : lstErrorUnmarshal) {
			reportResult.append("\t").append(item).append("\n");
		}
		
		reportResult.append("----------------------------------").append("\n");
		reportResult.append("Marshal error: ").append("\n");
		for (String item : lstErrorMarshal) {
			reportResult.append("\t").append(item).append("\n");
		}
		
		reportResult.append("----------------------------------").append("\n");
		reportResult.append("List Static query Cannot convert: ").append("\n");
		for (ConvertReportPOJO convertReportPOJO : lstCannotConvert) {
			reportResult.append("Path: ").append(convertReportPOJO.getPath()).append("\n");
			int count = 1;
			for (String queryName : convertReportPOJO.getQueryNames()) {
				reportResult.append("\t").append(count++).append(". ").append(queryName).append("\n");
			}
		}
		reportResult.append("----------------------------------").append("\n");
		
		return reportResult.toString();
	}
	
	public int getTotalSuccessQuery() {
		return totalSuccessQuery;
	}

	public void plusSuccess() {
		this.totalSuccessQuery++;
	}

	public int getTotalFailQuery() {
		return totalFailQuery;
	}

	public void plusFail() {
		this.totalFailQuery++;
	}
	
	public int getTotalResultMap() {
		return totalResultMap;
	}

	public void plusResultMap() {
		this.totalResultMap++;
	}

	public List<ConvertReportPOJO> getLstSuccess() {
		return lstSuccess;
	}

	public void setLstSuccess(List<ConvertReportPOJO> lstSuccess) {
		this.lstSuccess = lstSuccess;
	}
	
	public void addLstSuccess(ConvertReportPOJO convertReportPOJO) {
		this.lstSuccess.add(convertReportPOJO);
	}

	public List<ConvertReportPOJO> getLstCannotConvert() {
		return lstCannotConvert;
	}

	public void setLstCannotConvert(List<ConvertReportPOJO> lstCannotConvert) {
		this.lstCannotConvert = lstCannotConvert;
	}
	
	public void addLstCannotConvert(ConvertReportPOJO convertReportPOJO) {
		this.lstCannotConvert.add(convertReportPOJO);
	}

	public int getTotalQuery() {
		return totalQuery;
	}

	public void setTotalQuery(int totalQuery) {
		this.totalQuery = totalQuery;
	}

	public int getTotalFile() {
		return totalFile;
	}

	public void setTotalFile(int totalFile) {
		this.totalFile = totalFile;
	}
	
	public void plusTotalFile() {
		this.totalFile++;
	}

	public List<String> getLstErrorUnmarshal() {
		return lstErrorUnmarshal;
	}
	
	public void addLstErrorUnmarshal(String path) {
		lstErrorUnmarshal.add(path);
	}

	public List<String> getLstErrorMarshal() {
		return lstErrorMarshal;
	}
	
	public void addLstErrorMarshal(String path) {
		lstErrorMarshal.add(path);
	}
}
