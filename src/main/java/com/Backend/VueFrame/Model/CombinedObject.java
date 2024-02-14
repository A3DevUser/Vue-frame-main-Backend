package com.Backend.VueFrame.Model;

public class CombinedObject {
	
	private String navName;
	private String navStoredValue;
	private String navigate;
	private String gridName;
	private String dbTableName;
	private String isMain;
	private String isMrow;
	private String seqId;
	private String cat;
	private String targetId;
	private String formId;
	private String gridId;
	private String isMultiSelect;
	private String dsId;
	private String isImportExport;
	
	
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	public String getNavStoredValue() {
		return navStoredValue;
	}
	public void setNavStoredValue(String navStoredValue) {
		this.navStoredValue = navStoredValue;
	}
	public String getNavigate() {
		return navigate;
	}
	public void setNavigate(String navigate) {
		this.navigate = navigate;
	}
	public String getGridName() {
		return gridName;
	}
	public void setGridName(String gridName) {
		this.gridName = gridName;
	}
	public String getDbTableName() {
		return dbTableName;
	}
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	
	
	public String getIsMrow() {
		return isMrow;
	}
	public void setIsMrow(String isMrow) {
		this.isMrow = isMrow;
	}
	
	
	public String getSeqId() {
		return seqId;
	}
	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}
	
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	
	public String getFormId() {
		return formId;
	}
	
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
	public String getGridId() {
		return gridId;
	}
	public void setGridId(String gridId) {
		this.gridId = gridId;
	}
	
	
	
	public String getIsMultiSelect() {
		return isMultiSelect;
	}
	public void setIsMultiSelect(String isMultiSelect) {
		this.isMultiSelect = isMultiSelect;
	}
	
	
	
	
	
	public String getDsId() {
		return dsId;
	}
	public void setDsId(String dsId) {
		this.dsId = dsId;
	}
	
	
	
	
	
	public String getIsImportExport() {
		return isImportExport;
	}
	public void setIsImportExport(String isImportExport) {
		this.isImportExport = isImportExport;
	}
	
	
	
	public CombinedObject(String navName, String navStoredValue, String navigate, String gridName, String dbTableName,
			String isMain, String isMrow, String seqId, String cat, String targetId, String formId, String gridId,
			String isMultiSelect, String dsId, String isImportExport) {
		super();
		this.navName = navName;
		this.navStoredValue = navStoredValue;
		this.navigate = navigate;
		this.gridName = gridName;
		this.dbTableName = dbTableName;
		this.isMain = isMain;
		this.isMrow = isMrow;
		this.seqId = seqId;
		this.cat = cat;
		this.targetId = targetId;
		this.formId = formId;
		this.gridId = gridId;
		this.isMultiSelect = isMultiSelect;
		this.dsId = dsId;
		this.isImportExport = isImportExport;
	}
	public CombinedObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
