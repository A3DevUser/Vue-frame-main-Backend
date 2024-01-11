package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_DATA_SRC_GEN")
public class RptDataSource {
	
	@Id
	@Column(name = "DS_ID")
	private String dsId;
	
	@Column(name = "DS_NAME")
	private String dsName;
	
	@Column(name = "DS_PKG")
	private String dsPkg;
	
	@Column(name = "DS_START_DATE")
	private String dsStartDate;
	
	@Column(name = "DS_END_DATE")
	private String dsEndDate;
	
	@Column(name = "DS_TYPE")
	private String dsType;
	
	@Column(name = "TARGET_ID")
	private String targetId;

	
	
	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsPkg() {
		return dsPkg;
	}

	public void setDsPkg(String dsPkg) {
		this.dsPkg = dsPkg;
	}

	public String getDsStartDate() {
		return dsStartDate;
	}

	public void setDsStartDate(String dsStartDate) {
		this.dsStartDate = dsStartDate;
	}

	public String getDsEndDate() {
		return dsEndDate;
	}

	public void setDsEndDate(String dsEndDate) {
		this.dsEndDate = dsEndDate;
	}

	public String getDsType() {
		return dsType;
	}

	public void setDsType(String dsType) {
		this.dsType = dsType;
	}
	
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	

	public RptDataSource(String dsId, String dsName, String dsPkg, String dsStartDate, String dsEndDate, String dsType,
			String targetId) {
		super();
		this.dsId = dsId;
		this.dsName = dsName;
		this.dsPkg = dsPkg;
		this.dsStartDate = dsStartDate;
		this.dsEndDate = dsEndDate;
		this.dsType = dsType;
		this.targetId = targetId;
	}
	

	public RptDataSource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
