package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_DTLS")
public class RptDetails {
	
	@Id
	@Column(name = "RPT_ID")
	private String rptId;
	
	@Column(name = "RPT_NAME")
	private String rptName;
	
	@Column(name = "RPT_TITLE")
	private String rptTitle;
	
	@Column(name = "RPT_DATA_SRC")
	private String rptDataSrc;
	
	@Column(name = "RPT_PKG")
	private String rptPkg;
	
	@Column(name = "RPT_INFC_DTLS")
	private String rptInfcDtls;
	
	@Column(name = "RPT_TYPE")
	private String rptType;

	
	
	public String getRptId() {
		return rptId;
	}

	public void setRptId(String rptId) {
		this.rptId = rptId;
	}

	public String getRptName() {
		return rptName;
	}

	public void setRptName(String rptName) {
		this.rptName = rptName;
	}

	public String getRptTitle() {
		return rptTitle;
	}

	public void setRptTitle(String rptTitle) {
		this.rptTitle = rptTitle;
	}

	public String getRptDataSrc() {
		return rptDataSrc;
	}

	public void setRptDataSrc(String rptDataSrc) {
		this.rptDataSrc = rptDataSrc;
	}

	public String getRptPkg() {
		return rptPkg;
	}

	public void setRptPkg(String rptPkg) {
		this.rptPkg = rptPkg;
	}

	public String getRptInfcDtls() {
		return rptInfcDtls;
	}

	public void setRptInfcDtls(String rptInfcDtls) {
		this.rptInfcDtls = rptInfcDtls;
	}

	public String getRptType() {
		return rptType;
	}

	public void setRptType(String rptType) {
		this.rptType = rptType;
	}

	
	public RptDetails(String rptId, String rptName, String rptTitle, String rptDataSrc, String rptPkg,
			String rptInfcDtls, String rptType) {
		super();
		this.rptId = rptId;
		this.rptName = rptName;
		this.rptTitle = rptTitle;
		this.rptDataSrc = rptDataSrc;
		this.rptPkg = rptPkg;
		this.rptInfcDtls = rptInfcDtls;
		this.rptType = rptType;
	}
	

	public RptDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
