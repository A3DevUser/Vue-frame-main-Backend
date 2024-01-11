package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_FILTER_DTLS")
public class RptFilterDtls {
	
	@Id
	@Column(name = "FIL_ID")
	private String filId;
	
	@Column(name = "RPT_ID")
	private String rptId;
	
	@Column(name = "COLUMN_ID")
	private String columnId;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "COL_FIL_NAME")
	private String colFilName;
	
	@Column(name = "COL_FIL_LABEL")
	private String colFilLabel;
	
	@Column(name = "COL_FIL_TYP")
	private String colFilTyp;
	 
	@Column(name = "DS_NAME")
	private String dsName;
	
	@Column(name = "FIL_ORDER")
	private String filOrder;

	@Column(name = "TARGET_ID")
	private String targetId;
	
	
	public String getFilId() {
		return filId;
	}

	public void setFilId(String filId) {
		this.filId = filId;
	}

	public String getRptId() {
		return rptId;
	}

	public void setRptId(String rptId) {
		this.rptId = rptId;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColFilName() {
		return colFilName;
	}

	public void setColFilName(String colFilName) {
		this.colFilName = colFilName;
	}

	public String getColFilLabel() {
		return colFilLabel;
	}

	public void setColFilLabel(String colFilLabel) {
		this.colFilLabel = colFilLabel;
	}

	public String getColFilTyp() {
		return colFilTyp;
	}

	public void setColFilTyp(String colFilTyp) {
		this.colFilTyp = colFilTyp;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getFilOrder() {
		return filOrder;
	}

	public void setFilOrder(String filOrder) {
		this.filOrder = filOrder;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public RptFilterDtls(String filId, String rptId, String columnId, String columnName, String colFilName,
			String colFilLabel, String colFilTyp, String dsName, String filOrder, String targetId) {
		super();
		this.filId = filId;
		this.rptId = rptId;
		this.columnId = columnId;
		this.columnName = columnName;
		this.colFilName = colFilName;
		this.colFilLabel = colFilLabel;
		this.colFilTyp = colFilTyp;
		this.dsName = dsName;
		this.filOrder = filOrder;
		this.targetId = targetId;
	}

	public RptFilterDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
