package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "VF_FIELD_CONF")
public class FieldConfigData {
	
	@Id
	@Column(name = "FIELD_ID")
	private String fieldId;
	
	@Column(name = "WF_ID")
	private String wfId;
	
	@Column(name = "GRID_NAME")
	private String gridName;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "EDITABLE")
	private String editable;
	
	@Column(name = "IS_VISIBLE")
	private String isVisible;
	
	@Column(name = "CONF_NAME")
	private String confName;

	
	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getWfId() {
		return wfId;
	}

	public void setWfId(String wfId) {
		this.wfId = wfId;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}
	
	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName;
	}
	

	public FieldConfigData(String fieldId, String wfId, String gridName, String columnName, String editable,
			String isVisible, String confName) {
		super();
		this.fieldId = fieldId;
		this.wfId = wfId;
		this.gridName = gridName;
		this.columnName = columnName;
		this.editable = editable;
		this.isVisible = isVisible;
		this.confName = confName;
	}

	public FieldConfigData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}