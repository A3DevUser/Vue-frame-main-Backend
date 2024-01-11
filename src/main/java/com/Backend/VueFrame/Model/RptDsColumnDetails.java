package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_DS_COLUMN_DTLS")
public class RptDsColumnDetails {
	
	@Id
	@Column(name = "COLUMN_ID")
	private String columnId;
	
	@Column(name = "EXP_ID")
	private String expId;
	
	@Column(name = "DS_ID")
	private String dsId;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "COLUMN_LABEL")
	private String columnLabel;
	
	@Column(name = "COLUMN_TYPE")
	private String columnType;
	
	@Column(name = "TARGET_ID")
	private String targetId;
	

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	
	public RptDsColumnDetails(String columnId, String expId, String dsId, String columnName, String columnLabel,
			String columnType, String targetId) {
		super();
		this.columnId = columnId;
		this.expId = expId;
		this.dsId = dsId;
		this.columnName = columnName;
		this.columnLabel = columnLabel;
		this.columnType = columnType;
		this.targetId = targetId;
	}

	public RptDsColumnDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
