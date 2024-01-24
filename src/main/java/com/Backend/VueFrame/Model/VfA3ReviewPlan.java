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

	public VfA3ReviewPlan(String reviewPlanId,String reviewId, String reviewName, String ASSOCIATE_VEND, String VENDOR_ID) {
		super();
		this.reviewPlanId= reviewPlanId;
		this.reviewId = reviewId;
		this.reviewName = reviewName;
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
		this.VENDOR_ID = VENDOR_ID;
	}

	public VfA3ReviewPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	
	
	
}
