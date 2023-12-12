package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_CONF_COLUMN_DTLS")
public class RptConfColumnDtls {
	
	@Column(name = "FORM_ID")
	private String formId;
	
	@Id
	@Column(name = "COLUMN_ID")
	private String columnId;
	
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "COLUMN_STORED_VALUE")
	private String columnStoredValue;
	
	@Column(name = "COLUMN_FILTER_TYPE")
	private String columnFilterType;
	
	@Column(name = "SEC_ID")
	private String secId;
	
	@Column(name = "CELL_TYPE")
	private String cellType;
	
	@Column(name = "WIDTH")
	private String width;
	
	@Column(name = "SUB_SEC_ID")
	private String subSecId;
	
	@Column(name = "SUB_SEC_NAME")
	private String subSecName;
	
	@Column(name = "SUB_SEC_WIDTH")
	private String subSecWidth;
	
	@Column(name = "SUB_SEC_TYPE")
	private String subSecType;
	
	@Column(name = "ORDER_BY")
	private String orderBy;
	
	@Column(name = "CATEGORY_ID")
	private String categoryId;
	
	@Column(name = "GRID_ID")
	private String gridId;
	
	@Column(name = "HIDE_SHOW")
	private String hideShow;

	
	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
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

	public String getColumnStoredValue() {
		return columnStoredValue;
	}

	public void setColumnStoredValue(String columnStoredValue) {
		this.columnStoredValue = columnStoredValue;
	}

	public String getColumnFilterType() {
		return columnFilterType;
	}

	public void setColumnFilterType(String columnFilterType) {
		this.columnFilterType = columnFilterType;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getSubSecId() {
		return subSecId;
	}

	public void setSubSecId(String subSecId) {
		this.subSecId = subSecId;
	}

	public String getSubSecName() {
		return subSecName;
	}

	public void setSubSecName(String subSecName) {
		this.subSecName = subSecName;
	}

	public String getSubSecWidth() {
		return subSecWidth;
	}

	public void setSubSecWidth(String subSecWidth) {
		this.subSecWidth = subSecWidth;
	}

	public String getSubSecType() {
		return subSecType;
	}

	public void setSubSecType(String subSecType) {
		this.subSecType = subSecType;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	
	

	public RptConfColumnDtls(String formId, String columnId, String columnName, String columnStoredValue,
			String columnFilterType, String secId, String cellType, String width, String subSecId, String subSecName,
			String subSecWidth, String subSecType, String orderBy, String categoryId, String gridId, String hideShow) {
		super();
		this.formId = formId;
		this.columnId = columnId;
		this.columnName = columnName;
		this.columnStoredValue = columnStoredValue;
		this.columnFilterType = columnFilterType;
		this.secId = secId;
		this.cellType = cellType;
		this.width = width;
		this.subSecId = subSecId;
		this.subSecName = subSecName;
		this.subSecWidth = subSecWidth;
		this.subSecType = subSecType;
		this.orderBy = orderBy;
		this.categoryId = categoryId;
		this.gridId = gridId;
		this.hideShow = hideShow;
	}

	public RptConfColumnDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
