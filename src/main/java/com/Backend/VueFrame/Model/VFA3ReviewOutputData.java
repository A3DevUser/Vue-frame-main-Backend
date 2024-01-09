package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "VF_A3_REVIEW_OUTPUT_TBL")
public class VFA3ReviewOutputData {
	
	
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
	
	@Column(name = "RESULT")
	private String result;
	
	@Column(name = "ATTACHMENT")
	private String attachment;
	
	@Column(name = "REMARK")
	private String remark;
	
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
		this.Associate_Vend = associate_Vend;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVF_MAIN_OBJ_ID() {
		return VF_MAIN_OBJ_ID;
	}

	public void setVF_MAIN_OBJ_ID(String vF_MAIN_OBJ_ID) {
		this.VF_MAIN_OBJ_ID = vF_MAIN_OBJ_ID;
	}

	public VFA3ReviewOutputData(String id, String associate_Vend, String testId, String testTitle, String result,
			String attachment, String remark, String vF_MAIN_OBJ_ID) {
		super();
		this.id = id;
		this.Associate_Vend = associate_Vend;
		this.testId = testId;
		this.testTitle = testTitle;
		this.result = result;
		this.attachment = attachment;
		this.remark = remark;
		this.VF_MAIN_OBJ_ID = vF_MAIN_OBJ_ID;
	}

	public VFA3ReviewOutputData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
