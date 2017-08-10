package tls.ida.testHibernate;

import java.io.Serializable;

public class TlsLicAuthDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String strClientID;
	protected String strApplNo;
	protected String strLicStatus;
	protected String strDuration;
	protected String strFeeCd;
	protected String strOnlineID;
	protected String strFeeDesc;
	protected String strStatusCd;
	protected String strStatusDesc;
	protected String strInitialFee;
	protected String strDiscAppl;
	protected String strDiscPercnt;
	protected String strGSTInd;
	protected String strGSTCd;
	protected String strProcFlg;
	protected String strProcFee;
	protected String strFeeCalType;
	protected String strTotalFee;
	protected String strRemarks;
	protected String strLicType;
	protected String strTransID;
	protected String strDisAmt;
	protected String strStationFee;
	protected String strFreqFee;
	protected String strBaseFee;
	protected String strNetwrkFee;
	protected String strSchemeType;
	protected String strRecommResult;
	protected String strLicReqd;
	protected String strPenaltyAmt;
	protected String strInvestOfficer;
	protected String strBreachType;
	protected String strEnfoNo;
	protected String strCaseRefNo;
	protected String strCompName;
	protected String strGSTAppln;
	protected String strGSTFreq;
	protected String strROExmNo;
	protected String strRoExamDt;
	protected String strRoTotCand;
	protected String strRoExamTypeCd;
	protected String strRoExamTypeDesc;
	protected String strExamCondBy;
	protected java.util.ArrayList lstROCandFee;
	protected String strTempFee;
	protected String strApplnName;
	protected String strAuthType;
	protected String strOffenceType;
	protected String strLicDesc;
	protected String strCnt;
	protected String strNRIC;
	protected String strInvestOffId;
	protected String lstRemarks;
	protected String strInitFeeInd;
	protected String strNetFeeInd;
	protected String strSNMRemks;
	// ----------CR-TLS-2005-038 ------------
	protected String strSBOProrate;

	protected String strcallsignFee;
	protected String strGSTcallsignFee;
	// Start Raymond: 30Apr15
	protected String strCourierFeeCd;
	protected String strCourierFee;
	protected String strCourierFeeInd;

	// End: Raymond: 30Apr15

	public String getStrSBOProrate() {
		return strSBOProrate;
	}

	public void setStrSBOProrate(String strSBOProrate) {
		this.strSBOProrate = strSBOProrate;
	}

	// ----------CR-TLS-2005-038 ------------

	public TlsLicAuthDTO() {
	}

	public String getStrClientID() {
		return strClientID;
	}

	public void setStrClientID(String strClientID) {
		this.strClientID = strClientID;
	}

	public String getStrApplNo() {
		return strApplNo;
	}

	public void setStrApplNo(String strApplNo) {
		this.strApplNo = strApplNo;
	}

	public String getStrLicStatus() {
		return strLicStatus;
	}

	public void setStrLicStatus(String strLicStatus) {
		this.strLicStatus = strLicStatus;
	}

	public String getStrDuration() {
		return strDuration;
	}

	public void setStrDuration(String strDuration) {
		this.strDuration = strDuration;
	}

	public String getStrFeeCd() {
		return strFeeCd;
	}

	public void setStrFeeCd(String strFeeCd) {
		this.strFeeCd = strFeeCd;
	}

	public String getStrOnlineID() {
		return strOnlineID;
	}

	public void setStrOnlineID(String strOnlineID) {
		this.strOnlineID = strOnlineID;
	}

	public String getStrFeeDesc() {
		return strFeeDesc;
	}

	public void setStrFeeDesc(String strFeeDesc) {
		this.strFeeDesc = strFeeDesc;
	}

	public String getStrStatusCd() {
		return strStatusCd;
	}

	public void setStrStatusCd(String strStatusCd) {
		this.strStatusCd = strStatusCd;
	}

	public String getStrStatusDesc() {
		return strStatusDesc;
	}

	public void setStrStatusDesc(String strStatusDesc) {
		this.strStatusDesc = strStatusDesc;
	}

	public String getStrInitialFee() {
		return strInitialFee;
	}

	public void setStrInitialFee(String strInitialFee) {
		this.strInitialFee = strInitialFee;
	}

	public String getStrDiscAppl() {
		return strDiscAppl;
	}

	public void setStrDiscAppl(String strDiscAppl) {
		this.strDiscAppl = strDiscAppl;
	}

	public String getStrDiscPercnt() {
		return strDiscPercnt;
	}

	public void setStrDiscPercnt(String strDiscPercnt) {
		this.strDiscPercnt = strDiscPercnt;
	}

	public String getStrGSTInd() {
		return strGSTInd;
	}

	public void setStrGSTInd(String strGSTInd) {
		this.strGSTInd = strGSTInd;
	}

	public String getStrGSTCd() {
		return strGSTCd;
	}

	public void setStrGSTCd(String strGSTCd) {
		this.strGSTCd = strGSTCd;
	}

	public String getStrProcFlg() {
		return strProcFlg;
	}

	public void setStrProcFlg(String strProcFlg) {
		this.strProcFlg = strProcFlg;
	}

	public String getStrProcFee() {
		return strProcFee;
	}

	public void setStrProcFee(String strProcFee) {
		this.strProcFee = strProcFee;
	}

	public String getStrFeeCalType() {
		return strFeeCalType;
	}

	public void setStrFeeCalType(String strFeeCalType) {
		this.strFeeCalType = strFeeCalType;
	}

	public String getStrTotalFee() {
		return strTotalFee;
	}

	public void setStrTotalFee(String strTotalFee) {
		this.strTotalFee = strTotalFee;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrLicType() {
		return strLicType;
	}

	public void setStrLicType(String strLicType) {
		this.strLicType = strLicType;
	}

	public String getStrTransID() {
		return strTransID;
	}

	public void setStrTransID(String strTransID) {
		this.strTransID = strTransID;
	}

	public String getStrDisAmt() {
		return strDisAmt;
	}

	public void setStrDisAmt(String strDisAmt) {
		this.strDisAmt = strDisAmt;
	}

	public String getStrStationFee() {
		return strStationFee;
	}

	public void setStrStationFee(String strStationFee) {
		this.strStationFee = strStationFee;
	}

	public String getStrFreqFee() {
		return strFreqFee;
	}

	public void setStrFreqFee(String strFreqFee) {
		this.strFreqFee = strFreqFee;
	}

	public String getStrBaseFee() {
		return strBaseFee;
	}

	public void setStrBaseFee(String strBaseFee) {
		this.strBaseFee = strBaseFee;
	}

	public String getStrNetwrkFee() {
		return strNetwrkFee;
	}

	public void setStrNetwrkFee(String strNetwrkFee) {
		this.strNetwrkFee = strNetwrkFee;
	}

	public String getStrSchemeType() {
		return strSchemeType;
	}

	public void setStrSchemeType(String strSchemeType) {
		this.strSchemeType = strSchemeType;
	}

	public String getStrRecommResult() {
		return strRecommResult;
	}

	public void setStrRecommResult(String strRecommResult) {
		this.strRecommResult = strRecommResult;
	}

	public String getStrLicReqd() {
		return strLicReqd;
	}

	public void setStrLicReqd(String strLicReqd) {
		this.strLicReqd = strLicReqd;
	}

	public String getStrPenaltyAmt() {
		return strPenaltyAmt;
	}

	public void setStrPenaltyAmt(String strPenaltyAmt) {
		this.strPenaltyAmt = strPenaltyAmt;
	}

	public String getStrInvestOfficer() {
		return strInvestOfficer;
	}

	public void setStrInvestOfficer(String strInvestOfficer) {
		this.strInvestOfficer = strInvestOfficer;
	}

	public String getStrBreachType() {
		return strBreachType;
	}

	public void setStrBreachType(String strBreachType) {
		this.strBreachType = strBreachType;
	}

	public String getStrEnfoNo() {
		return strEnfoNo;
	}

	public void setStrEnfoNo(String strEnfoNo) {
		this.strEnfoNo = strEnfoNo;
	}

	public String getStrCaseRefNo() {
		return strCaseRefNo;
	}

	public void setStrCaseRefNo(String strCaseRefNo) {
		this.strCaseRefNo = strCaseRefNo;
	}

	public String getStrCompName() {
		return strCompName;
	}

	public void setStrCompName(String strCompName) {
		this.strCompName = strCompName;
	}

	public String getStrGSTAppln() {
		return strGSTAppln;
	}

	public void setStrGSTAppln(String strGSTAppln) {
		this.strGSTAppln = strGSTAppln;
	}

	public String getStrGSTFreq() {
		return strGSTFreq;
	}

	public void setStrGSTFreq(String strGSTFreq) {
		this.strGSTFreq = strGSTFreq;
	}

	public String getStrROExmNo() {
		return strROExmNo;
	}

	public void setStrROExmNo(String strROExmNo) {
		this.strROExmNo = strROExmNo;
	}

	public String getStrRoExamDt() {
		return strRoExamDt;
	}

	public void setStrRoExamDt(String strRoExamDt) {
		this.strRoExamDt = strRoExamDt;
	}

	public String getStrRoTotCand() {
		return strRoTotCand;
	}

	public void setStrRoTotCand(String strRoTotCand) {
		this.strRoTotCand = strRoTotCand;
	}

	public String getStrRoExamTypeCd() {
		return strRoExamTypeCd;
	}

	public void setStrRoExamTypeCd(String strRoExamTypeCd) {
		this.strRoExamTypeCd = strRoExamTypeCd;
	}

	public String getStrRoExamTypeDesc() {
		return strRoExamTypeDesc;
	}

	public void setStrRoExamTypeDesc(String strRoExamTypeDesc) {
		this.strRoExamTypeDesc = strRoExamTypeDesc;
	}

	public String getStrExamCondBy() {
		return strExamCondBy;
	}

	public void setStrExamCondBy(String strExamCondBy) {
		this.strExamCondBy = strExamCondBy;
	}

	public java.util.ArrayList getLstROCandFee() {
		return lstROCandFee;
	}

	public void setLstROCandFee(java.util.ArrayList lstROCandFee) {
		this.lstROCandFee = lstROCandFee;
	}

	public String getStrTempFee() {
		return strTempFee;
	}

	public void setStrTempFee(String strTempFee) {
		this.strTempFee = strTempFee;
	}

	public String getStrApplnName() {
		return strApplnName;
	}

	public void setStrApplnName(String strApplnName) {
		this.strApplnName = strApplnName;
	}

	public String getStrAuthType() {
		return strAuthType;
	}

	public void setStrAuthType(String strAuthType) {
		this.strAuthType = strAuthType;
	}

	public String getStrOffenceType() {
		return strOffenceType;
	}

	public void setStrOffenceType(String strOffenceType) {
		this.strOffenceType = strOffenceType;
	}

	public String getStrLicDesc() {
		return strLicDesc;
	}

	public void setStrLicDesc(String strLicDesc) {
		this.strLicDesc = strLicDesc;
	}

	public String getStrCnt() {
		return strCnt;
	}

	public void setStrCnt(String strCnt) {
		this.strCnt = strCnt;
	}

	public String getStrNRIC() {
		return strNRIC;
	}

	public void setStrNRIC(String strNRIC) {
		this.strNRIC = strNRIC;
	}

	public String getStrInvestOffId() {
		return strInvestOffId;
	}

	public void setStrInvestOffId(String strInvestOffId) {
		this.strInvestOffId = strInvestOffId;
	}

	public String getLstRemarks() {
		return lstRemarks;
	}

	public void setLstRemarks(String lstRemarks) {
		this.lstRemarks = lstRemarks;
	}

	public String getStrInitFeeInd() {
		return strInitFeeInd;
	}

	public void setStrInitFeeInd(String strInitFeeInd) {
		this.strInitFeeInd = strInitFeeInd;
	}

	public String getStrNetFeeInd() {
		return strNetFeeInd;
	}

	public void setStrNetFeeInd(String strNetFeeInd) {
		this.strNetFeeInd = strNetFeeInd;
	}

	public String getStrSNMRemks() {
		return strSNMRemks;
	}

	public void setStrSNMRemks(String strSNMRemks) {
		this.strSNMRemks = strSNMRemks;
	}

	public String getStrcallsignFee() {
		return strcallsignFee;
	}

	public void setStrcallsignFee(String strcallsignFee) {
		this.strcallsignFee = strcallsignFee;
	}

	public String getStrGSTcallsignFee() {
		return strGSTcallsignFee;
	}

	public void setStrGSTcallsignFee(String strGSTcallsignFee) {
		this.strGSTcallsignFee = strGSTcallsignFee;
	}

	public String getStrCourierFee() {
		return strCourierFee;
	}

	public void setStrCourierFee(String strCourierFee) {
		this.strCourierFee = strCourierFee;
	}

	public String getStrCourierFeeCd() {
		return strCourierFeeCd;
	}

	public void setStrCourierFeeCd(String strCourierFeeCd) {
		this.strCourierFeeCd = strCourierFeeCd;
	}

	public String getStrCourierFeeInd() {
		return strCourierFeeInd;
	}

	public void setStrCourierFeeInd(String strCourierFeeInd) {
		this.strCourierFeeInd = strCourierFeeInd;
	}

}
