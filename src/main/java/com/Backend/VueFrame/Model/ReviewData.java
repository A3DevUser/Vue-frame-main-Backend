package com.Backend.VueFrame.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewData {


	private String reviewId;
	private String reviewName;
	@JsonProperty(value = "ASSOCIATE_VEND")
    private String ASSOCIATE_VEND;
	@JsonProperty(value = "VENDOR_ID")
    private String VENDOR_ID;
    private String reviewStatus;
    private String reviewComment;
    private String reviewType;
    private String reviewFreq;
    private String reviewSubFreq;
	@JsonProperty(value = "VF_MAIN_OBJ_ID")
    private String VF_MAIN_OBJ_ID;
	@JsonProperty(value = "VENDOR_TYPE")
	private String VENDOR_TYPE;
	
	

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
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	
	
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	
	public String getReviewFreq() {
		return reviewFreq;
	}
	public void setReviewFreq(String reviewFreq) {
		this.reviewFreq = reviewFreq;
	}
	
	
	public String getReviewSubFreq() {
		return reviewSubFreq;
	}
	public void setReviewSubFreq(String reviewSubFreq) {
		this.reviewSubFreq = reviewSubFreq;
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
	
	
	public ReviewData(String reviewId, String reviewName, String ASSOCIATE_VEND, String VENDOR_ID, String reviewStatus,
			String reviewComment, String reviewType, String reviewFreq, String reviewSubFreq, String VF_MAIN_OBJ_ID, String VENDOR_TYPE) {
		super();
		this.reviewId = reviewId;
		this.reviewName = reviewName;
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
		this.VENDOR_ID = VENDOR_ID;
		this.reviewStatus = reviewStatus;
		this.reviewComment = reviewComment;
		this.reviewType = reviewType;
		this.reviewFreq = reviewFreq;
		this.reviewSubFreq = reviewSubFreq;
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
		this.VENDOR_TYPE = VENDOR_TYPE;
	}
	
	
	public ReviewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
    
    
}
