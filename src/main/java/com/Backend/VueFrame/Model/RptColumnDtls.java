package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_COLUMN_DTLS")
public class RptColumnDtls {
	
	@Id
	@Column(name = "RPT_COL_ID")
	private String rptColId;
	
	@Column(name = "RPT_ID")
	private String rptId;
	
	@Column(name = "RPT_COL_NAME")
	private String rptColName;
	
	@Column(name = "RPT_COL_LABEL")
	private String rptColLabel;
	
	@Column(name = "RPT_COL_TYP")
	private String rptColTyp;
	
	@Column(name = "RPT_COL_TOOLTIP")
	private String rptColTooltip;
	
	@Column(name = "RPT_COL_WIDTH")
	private String rptColWidth;
	
	@Column(name = "RPT_COL_SORT")
	private String rptColSort;
	
	@Column(name = "DS_ID")
	private String dsId;

	
	public String getRptColId() {
		return rptColId;
	}

	public void setRptColId(String rptColId) {
		this.rptColId = rptColId;
	}

	public String getRptId() {
		return rptId;
	}

	public void setRptId(String rptId) {
		this.rptId = rptId;
	}

	public String getRptColName() {
		return rptColName;
	}

	public void setRptColName(String rptColName) {
		this.rptColName = rptColName;
	}

	public String getRptColLabel() {
		return rptColLabel;
	}

	public void setRptColLabel(String rptColLabel) {
		this.rptColLabel = rptColLabel;
	}

	public String getRptColTyp() {
		return rptColTyp;
	}

	public void setRptColTyp(String rptColTyp) {
		this.rptColTyp = rptColTyp;
	}

	public String getRptColTooltip() {
		return rptColTooltip;
	}

	public void setRptColTooltip(String rptColTooltip) {
		this.rptColTooltip = rptColTooltip;
	}

	public String getRptColWidth() {
		return rptColWidth;
	}

	public void setRptColWidth(String rptColWidth) {
		this.rptColWidth = rptColWidth;
	}

	public String getRptColSort() {
		return rptColSort;
	}

	public void setRptColSort(String rptColSort) {
		this.rptColSort = rptColSort;
	}
	
	
	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}
	

	public RptColumnDtls(String rptColId, String rptId, String rptColName, String rptColLabel, String rptColTyp,
			String rptColTooltip, String rptColWidth, String rptColSort, String dsId) {
		super();
		this.rptColId = rptColId;
		this.rptId = rptId;
		this.rptColName = rptColName;
		this.rptColLabel = rptColLabel;
		this.rptColTyp = rptColTyp;
		this.rptColTooltip = rptColTooltip;
		this.rptColWidth = rptColWidth;
		this.rptColSort = rptColSort;
		this.dsId = dsId;
	}
	

	public RptColumnDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
