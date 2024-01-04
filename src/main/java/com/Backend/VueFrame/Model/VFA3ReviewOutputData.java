package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "VF_A3_REVIEW_OUTPUT_TBL")
public class VFA3ReviewOutputData {
	
	
	@Id
	@Column(name = "ID")
	private String idData;
	
	@Column(name = "VENDOR_CODE")
	private String id;
	
	@Column(name = "TEST_ID")
	private String testId;
	
	@Column(name = "TEST_TITLE")
	private String testTitle;
	
	@Column(name = "RESPONSE")
	private String response;
	
	@Column(name = "VF_MAIN_OBJ_ID")
	private String VF_MAIN_OBJ_ID;

	public String getIdData() {
		return idData;
	}

	public void setIdData(String idData) {
		this.idData = idData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public String getVF_MAIN_OBJ_ID() {
		return VF_MAIN_OBJ_ID;
	}

	public void setVF_MAIN_OBJ_ID(String vF_MAIN_OBJ_ID) {
		VF_MAIN_OBJ_ID = vF_MAIN_OBJ_ID;
	}

	public VFA3ReviewOutputData(String idData, String id, String testId, String testTitle, String response,
			String vF_MAIN_OBJ_ID) {
		super();
		this.idData = idData;
		this.id = id;
		this.testId = testId;
		this.testTitle = testTitle;
		this.response = response;
		VF_MAIN_OBJ_ID = vF_MAIN_OBJ_ID;
	}

	public VFA3ReviewOutputData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
