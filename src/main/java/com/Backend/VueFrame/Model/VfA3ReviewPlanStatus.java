package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vf_a3_review_plan_status")
public class VfA3ReviewPlanStatus {
	
	@Id
	@Column(name = "REVIEW_ID")
    private String reviewId;
	
	@Column(name = "REVIEW_NAME")
	private String reviewName;
	
	@Column(name = "REVIEW_STATUS")
	private String reviewStatus;
	
	@Column(name = "REVIEW_COMMENT")
	private String reviewComment;

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

	public VfA3ReviewPlanStatus(String reviewId, String reviewName, String reviewStatus, String reviewComment) {
		super();
		this.reviewId = reviewId;
		this.reviewName = reviewName;
		this.reviewStatus = reviewStatus;
		this.reviewComment = reviewComment;
	}

	public VfA3ReviewPlanStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
