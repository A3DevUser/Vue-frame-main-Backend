package com.Backend.VueFrame.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewData {

	@Override
	public String toString() {
		return "ReviewData [reviewId=" + reviewId + ", reviewName=" + reviewName + ", ASSOCIATE_VEND=" + ASSOCIATE_VEND
				+ ", VENDOR_ID=" + VENDOR_ID + ", reviewStatus=" + reviewStatus + ", reviewComment=" + reviewComment
				+ ", Review_Type=" + Review_Type + ", Review_Freq=" + Review_Freq + ", Sub_Frequency=" + Sub_Frequency
				+ ", VF_MAIN_OBJ_ID=" + VF_MAIN_OBJ_ID + ", VENDOR_TYPE=" + VENDOR_TYPE + "]";
	}
	private String reviewId;
	private String reviewName;
	@JsonProperty(value = "ASSOCIATE_VEND")
    private String ASSOCIATE_VEND;
	@JsonProperty(value = "VENDOR_ID")
    private String VENDOR_ID;
    private String reviewStatus;
    private String reviewComment;
    private String Review_Type;
    private String Review_Freq;
    private String Sub_Frequency;
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
	
	
	
	public String getReview_Type() {
		return Review_Type;
	}
	public void setReview_Type(String Review_Type) {
		Review_Type = Review_Type;
	}
	public String getReview_Freq() {
		return Review_Freq;
	}
	public void setReview_Freq(String Review_Freq) {
		Review_Freq = Review_Freq;
	}
	public String getSub_Frequency() {
		return Sub_Frequency;
	}
	public void setSub_Frequency(String Sub_Frequency) {
		Sub_Frequency = Sub_Frequency;
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
			String reviewComment, String Review_Type, String Review_Freq, String Sub_Frequency, String VF_MAIN_OBJ_ID, String VENDOR_TYPE) {
		super();
		this.reviewId = reviewId;
		this.reviewName = reviewName;
		this.ASSOCIATE_VEND = ASSOCIATE_VEND;
		this.VENDOR_ID = VENDOR_ID;
		this.reviewStatus = reviewStatus;
		this.reviewComment = reviewComment;
		this.Review_Type = Review_Type;
		this.Review_Freq = Review_Freq;
		this.Sub_Frequency = Sub_Frequency;
		this.VF_MAIN_OBJ_ID = VF_MAIN_OBJ_ID;
		this.VENDOR_TYPE = VENDOR_TYPE;
	}
	public ReviewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
    
    
}
