package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_CONF_GRID_DTLS")
public class RptConfGridDtls {
	
	@Id
	@Column(name = "GRID_ID")
	private String gridId;
	
	@Column(name = "GRID_NAME")
	private String gridName;
	
	@Column(name = "SEC_ID")
	private String secId;
	
	@Column(name = "FORM_ID")
	private String formId;
	
	@Column(name = "IS_MROW")
	private String isMrow;
	
	@Column(name = "API")
	private String api;
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "WIDTH")
	private String width;

	
	
	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getIsMrow() {
		return isMrow;
	}

	public void setIsMrow(String isMrow) {
		this.isMrow = isMrow;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public RptConfGridDtls(String gridId, String gridName, String secId, String formId, String isMrow, String api,
			String height, String width) {
		super();
		this.gridId = gridId;
		this.gridName = gridName;
		this.secId = secId;
		this.formId = formId;
		this.isMrow = isMrow;
		this.api = api;
		this.height = height;
		this.width = width;
	}

	public RptConfGridDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
