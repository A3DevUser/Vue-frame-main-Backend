package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "VF_COL_DROPDOWNS")
public class DropDownData {
	
	@Id
	@Column(name="DROPDOWN_ID")
	private String dropdownId;
	@Column(name="GRID_ID")
	private String gridId;
	@Column(name="COL_ID")
	private String colId;
	@Column(name="QUERY")
	private String query;
	@Column(name="FORM_ID")
	private String formId;
	
	@Column(name = "dropdown_name")
	private String dropName;
	
	@Column(name = "TARGET_ID")
	private String targetId;
	
	
	public String getGridId() {
		return gridId;
	}
	public void setGridId(String gridId) {
		this.gridId = gridId;
	}
	public String getColId() {
		return colId;
	}
	public void setColId(String colId) {
		this.colId = colId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getDropdownId() {
		return dropdownId;
	}
	public void setDropdownId(String dropdownId) {
		this.dropdownId = dropdownId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	public String getDropName() {
		return dropName;
	}
	public void setDropName(String dropName) {
		this.dropName = dropName;
	}
	
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	public DropDownData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DropDownData(String dropdownId, String gridId, String colId, String query, String formId, String dropName,
			String targetId) {
		super();
		this.dropdownId = dropdownId;
		this.gridId = gridId;
		this.colId = colId;
		this.query = query;
		this.formId = formId;
		this.dropName = dropName;
		this.targetId = targetId;
	}
	
	
	
}
