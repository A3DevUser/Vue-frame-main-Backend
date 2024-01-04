package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "VF_A3_ONBOARDING_OUTPUT_TBL")
public class VFA3OnBoardingOutputData {
	
	  
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "ASSOCIATE_VEND")
	@JsonProperty("Associate_Vend")
	private String Associate_Vend;
	
	@Column(name = "TEST_ID")
	private String testId;
	
	@Column(name = "TEST_TITLE")
	private String testTitle;
	
	@Column(name = "RESPONSE")
	private String response;
	
	@Column(name = "VF_MAIN_OBJ_ID")
	@JsonProperty("VF_MAIN_OBJ_ID")
	private String VF_MAIN_OBJ_ID;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssociate_Vend() {
		return Associate_Vend;
	}

	public void setAssociate_Vend(String associate_Vend) {
		Associate_Vend = associate_Vend;
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

	public VFA3OnBoardingOutputData(String id, String associate_Vend, String testId, String testTitle,
			String response, String vF_MAIN_OBJ_ID) {
		super();
		this.id = id;
		Associate_Vend = associate_Vend;
		this.testId = testId;
		this.testTitle = testTitle;
		this.response = response;
		VF_MAIN_OBJ_ID = vF_MAIN_OBJ_ID;
	}

	public VFA3OnBoardingOutputData() {
		super();
		// TODO Auto-generated constructor stub
	}
		
		
		
		
		
	    


}
