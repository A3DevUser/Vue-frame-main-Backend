package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_A3_REVIEW_DD")
public class VfA3ReviewDD {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "REVIEW_TYPE")
	private String reviewType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public VfA3ReviewDD(String id, String reviewType) {
		super();
		this.id = id;
		this.reviewType = reviewType;
	}

	public VfA3ReviewDD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
