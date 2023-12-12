package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_CONF_SECTION_DTLS")
public class RptConfSecDtls {
	
	@Id
	@Column(name = "FORM_ID")
	private String formId;
	
	@Column(name = "SEC_ID")
	private String secId;
	
	@Column(name = "SEC_NAME")
	private String secName;
	
	@Column(name = "SEC_STORED_VALUE")
	private String secStoredValue;
	
	@Column(name = "SEC_IS_OPEN")
	private String secIsOpen;
	
	@Column(name = "WIDTH")
	private String width;
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "API")
	private String api;

	
	
	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getSecStoredValue() {
		return secStoredValue;
	}

	public void setSecStoredValue(String secStoredValue) {
		this.secStoredValue = secStoredValue;
	}

	public String getSecIsOpen() {
		return secIsOpen;
	}

	public void setSecIsOpen(String secIsOpen) {
		this.secIsOpen = secIsOpen;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	
	public RptConfSecDtls(String formId, String secId, String secName, String secStoredValue, String secIsOpen,
			String width, String height, String api) {
		super();
		this.formId = formId;
		this.secId = secId;
		this.secName = secName;
		this.secStoredValue = secStoredValue;
		this.secIsOpen = secIsOpen;
		this.width = width;
		this.height = height;
		this.api = api;
	}

	
	public RptConfSecDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
