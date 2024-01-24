package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_VRM_OUTPUT_ASSESS_MA")
public class VfVrmOutputAssessMa {
	
	@Id
	@Column(name = "MA_ID")
	private String maId;
	
	@Column(name = "REVIEW_ID")
	private String reviewId;
	
	@Column(name = "VENDOR_ID")
	private String vendorId;
	
	@Column(name = "ASSOCIATE_VENDOR")
	private String associateVendor;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "QUESTION_ID")
	private String questionId;
	
	@Column(name = "QUESTION_TYPE")
	private String questionType;
	
	@Column(name = "RISK_DOMAIN")
	private String riskDomain;
	
	@Column(name = "QUESTION_NAME")
	private String questionName;
	
	@Column(name = "RESPONSE")
	private String response;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "MANDATORY_EVIDENCE")
	private String mandatoryEvidence;
	
	@Column(name = "RATING")
	private String rating;
	
	@Column(name = "RATIONALE")
	private String rationable;

	
	
	public String getMaId() {
		return maId;
	}

	public void setMaId(String maId) {
		this.maId = maId;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getAssociateVendor() {
		return associateVendor;
	}

	public void setAssociateVendor(String associateVendor) {
		this.associateVendor = associateVendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getRiskDomain() {
		return riskDomain;
	}

	public void setRiskDomain(String riskDomain) {
		this.riskDomain = riskDomain;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMandatoryEvidence() {
		return mandatoryEvidence;
	}

	public void setMandatoryEvidence(String mandatoryEvidence) {
		this.mandatoryEvidence = mandatoryEvidence;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRationable() {
		return rationable;
	}

	public void setRationable(String rationable) {
		this.rationable = rationable;
	}
	

	public VfVrmOutputAssessMa(String maId, String reviewId, String vendorId, String associateVendor, String status,
			String questionId, String questionType, String riskDomain, String questionName, String response,
			String comments, String mandatoryEvidence, String rating, String rationable) {
		super();
		this.maId = maId;
		this.reviewId = reviewId;
		this.vendorId = vendorId;
		this.associateVendor = associateVendor;
		this.status = status;
		this.questionId = questionId;
		this.questionType = questionType;
		this.riskDomain = riskDomain;
		this.questionName = questionName;
		this.response = response;
		this.comments = comments;
		this.mandatoryEvidence = mandatoryEvidence;
		this.rating = rating;
		this.rationable = rationable;
	}
	

	public VfVrmOutputAssessMa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
