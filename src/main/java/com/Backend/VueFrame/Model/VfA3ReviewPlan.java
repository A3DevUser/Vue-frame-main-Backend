package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vf_a3_output_review_plan")
public class VfA3ReviewPlan {

	
	@Id
	@Column(name = "REVIEW_PLAN_ID")
	private String reviewPlanId;
	
	@Column(name = "REVIEW_ID")
	private String reviewId;
	
	@Column(name = "REVIEW_NAME")
	private String reviewName;
	
	@Column(name = "VENDOR_NAME")
	@JsonProperty(value = "ASSOCIATE_VEND")
	private String ASSOCIATE_VEND;
	
	@Column(name ="VENDOR_ID")
	@JsonProperty(value = "VENDOR_ID")
	private String VENDOR_ID;
	
	@Column(name = "VF_MAIN_OBJ_ID")
	@JsonProperty(value = "VF_MAIN_OBJ_ID")
	private String VF_MAIN_OBJ_ID;
	
	@Column(name = "VENDOR_TYPE")
	@JsonProperty(value = "VENDOR_TYPE")
	private String VENDOR_TYPE;
	
	public String getReviewPlanId() {
		return reviewPlanId;
	}

	public void setReviewPlanId(String reviewPlanId) {
		this.reviewPlanId = reviewPlanId;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public String getASSOCIATE_VEND() {
		return ASSOCIATE_VEND;
	}

	public void setASSOCIATE_VEND(String ASSOCIATE_VEND) {
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
	}

	public String getVENDOR_ID() {
		return VENDOR_ID;
	}

	public void setVENDOR_ID(String VENDOR_ID) {
		this.VENDOR_ID = VENDOR_ID;
	}
	
	
	

	public String getVF_MAIN_OBJ_ID() {
		return VF_MAIN_OBJ_ID;
	}

	public void setVF_MAIN_OBJ_ID(String VF_MAIN_OBJ_ID) {
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
	}

	public String getVENDOR_TYPE() {
		return VENDOR_TYPE;
	}

	public void setVENDOR_TYPE(String VENDOR_TYPE) {
		this.VENDOR_TYPE = VENDOR_TYPE;
	}

	

	public VfA3ReviewPlan(String reviewPlanId, String reviewId, String reviewName, String ASSOCIATE_VEND,
			String VENDOR_ID, String VF_MAIN_OBJ_ID, String VENDOR_TYPE) {
		super();
		this.reviewPlanId = reviewPlanId;
		this.reviewId = reviewId;
		this.reviewName = reviewName;
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
		this.VENDOR_ID = VENDOR_ID;
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
		this.VENDOR_TYPE = VENDOR_TYPE;
	}

	public VfA3ReviewPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	
	
	
}
