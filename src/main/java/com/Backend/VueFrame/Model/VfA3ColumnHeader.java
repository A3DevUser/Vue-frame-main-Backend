package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VF_A3_CONF_COLUMN_HEADER")
public class VfA3ColumnHeader {

	@Id
	@Column(name="SR_NO")
	private int srNo;
	
	@Column(name="FORM_NAME")
	private String formName;
	
	@Column(name="FIELD_NAME")
	private String fieldName;
	
	@Column(name="ACCESSOR")
	private String accessor;
	
	@Column(name="COLUMN_FILTER")
	private String columnFilter;
	
	@Column(name="STICKY")
	private String sticky;
	
	@Column (name= "FORM_ID")
	private String formId;
	
	@Column (name ="PARENT_CELL")
	private String parentCell;
	
	@Column (name = "CELL_TYPE")
	private String cellType;
	
	@Column (name = "AUDIT_TYPE")
	private String auditType;
	
	@Column (name = "WIDTH")
	private String width;
	
	@Column (name = "ORDER_BY")
	private String orderBy;
	
	@Column (name = "AREA_NAME")
	private String areaName;
	
	@Column (name = "PORTFOLIO")
	private String portfolio;
	
	@Column (name = "SNS")
	private String sns;
	
	@Column (name = "IS_PAGE_TYPE")
	private String isPageType;
	
	@Column(name = "IS_SCORING")
	private String isScoring;
	
	@Column(name = "is_dependent")
	private String isdependent;

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getAccessor() {
		return accessor;
	}

	public void setAccessor(String accessor) {
		this.accessor = accessor;
	}

	public String getColumnFilter() {
		return columnFilter;
	}

	public void setColumnFilter(String columnFilter) {
		this.columnFilter = columnFilter;
	}

	public String getSticky() {
		return sticky;
	}

	public void setSticky(String sticky) {
		this.sticky = sticky;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getParentCell() {
		return parentCell;
	}

	public void setParentCell(String parentCell) {
		this.parentCell = parentCell;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getIsPageType() {
		return isPageType;
	}

	public void setIsPageType(String isPageType) {
		this.isPageType = isPageType;
	}

	
	
	
	public String getIsScoring() {
		return isScoring;
	}

	public void setIsScoring(String isScoring) {
		this.isScoring = isScoring;
	}

	

	public String getIsdependent() {
		return isdependent;
	}

	public void setIsdependent(String isdependent) {
		this.isdependent = isdependent;
	}

	

	public VfA3ColumnHeader(int srNo, String formName, String fieldName, String accessor, String columnFilter,
			String sticky, String formId, String parentCell, String cellType, String auditType, String width,
			String orderBy, String areaName, String portfolio, String sns, String isPageType, String isScoring,
			String isdependent) {
		super();
		this.srNo = srNo;
		this.formName = formName;
		this.fieldName = fieldName;
		this.accessor = accessor;
		this.columnFilter = columnFilter;
		this.sticky = sticky;
		this.formId = formId;
		this.parentCell = parentCell;
		this.cellType = cellType;
		this.auditType = auditType;
		this.width = width;
		this.orderBy = orderBy;
		this.areaName = areaName;
		this.portfolio = portfolio;
		this.sns = sns;
		this.isPageType = isPageType;
		this.isScoring = isScoring;
		this.isdependent = isdependent;
	}

	public VfA3ColumnHeader() {
		super();
		// TODO Auto-generated constructor stub
	}


}
