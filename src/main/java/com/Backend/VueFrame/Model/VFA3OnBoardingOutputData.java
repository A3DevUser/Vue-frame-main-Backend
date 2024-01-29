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
	@JsonProperty("QUESTION_ID")
	private String QUESTION_ID;
	
	@Column(name = "TEST_TITLE")
	@JsonProperty("QUESTION")
	private String QUESTION;
	
	@Column(name = "RESPONSE")
	@JsonProperty("RESPONSE")
	private String RESPONSE;
	
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

	public void setAssociate_Vend(String Associate_Vend) {
		this.Associate_Vend = Associate_Vend;
	}

	

	public String getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(String QUESTION_ID) {
		this.QUESTION_ID = QUESTION_ID;
	}

	public String getQUESTION() {
		return QUESTION;
	}

	public void setQUESTION(String QUESTION) {
		this.QUESTION = QUESTION;
	}

	
	public String getRESPONSE() {
		return RESPONSE;
	}

	public void setRESPONSE(String RESPONSE) {
		this.RESPONSE = RESPONSE;
	}

	public String getVF_MAIN_OBJ_ID() {
		return VF_MAIN_OBJ_ID;
	}

	public void setVF_MAIN_OBJ_ID(String VF_MAIN_OBJ_ID) {
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
	}

	

	public VFA3OnBoardingOutputData(String id, String Associate_Vend, String QUESTION_ID, String QUESTION,
			String RESPONSE, String VF_MAIN_OBJ_ID) {
		super();
		this.id = id;
		this.Associate_Vend = Associate_Vend;
		this.QUESTION_ID = QUESTION_ID;
		this.QUESTION = QUESTION;
		this.RESPONSE = RESPONSE;
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
	}

	public VFA3OnBoardingOutputData() {
		super();
		// TODO Auto-generated constructor stub
	}
		
		
		
		
		
	    


}
