package com.Backend.VueFrame.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewData {

	
	private String reviewName;
	@JsonProperty(value = "ASSOCIATE_VEND")
    private String ASSOCIATE_VEND;
	@JsonProperty(value = "VENDOR_ID")
    private String VENDOR_ID;
    private String reviewStatus;
    private String reviewComment;
    
    
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
	public ReviewData(String reviewName, String ASSOCIATE_VEND, String VENDOR_ID, String reviewStatus,
			String reviewComment) {
		super();
		this.reviewName = reviewName;
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
		this.VENDOR_ID = VENDOR_ID;
		this.reviewStatus = reviewStatus;
		this.reviewComment = reviewComment;
	}
	
	
    
    
}
