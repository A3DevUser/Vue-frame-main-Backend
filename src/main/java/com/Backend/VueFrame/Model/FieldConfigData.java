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
	private String gridId;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "EDITABLE")
	private String editable;
	
	@Column(name = "IS_VISIBLE")
	private String hideShow;
	
	@Column(name = "CONF_NAME")
	private String confName;
	
	@Column(name = "TARGET_ID")
	private String targetId;
	
	
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

	
	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public String getHideShow() {
		return hideShow;
	}

	public void setHideShow(String hideShow) {
		this.hideShow = hideShow;
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
	

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	
	public FieldConfigData(String fieldId, String wfId, String gridId, String columnName, String editable,
			String hideShow, String confName, String targetId) {
		super();
		this.fieldId = fieldId;
		this.wfId = wfId;
		this.gridId = gridId;
		this.columnName = columnName;
		this.editable = editable;
		this.hideShow = hideShow;
		this.confName = confName;
		this.targetId = targetId;
	}
	

	public FieldConfigData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}