package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vf_vrm_vendor_rating")
public class VfVRMRatingData {
	
	@Id
	@Column(name = "VENDOR_ID")
	@JsonProperty("VENDOR_ID")
	private String VENDOR_ID;
	
	@Column(name = "TPRE_SCORE")
	private String tpreScore;
	
	@Column(name = "TPRE_RATING")
	private String tpreRating;
	
	@Column(name = "IS_MATERIAL")
	private String isMaterial;
	
	@Column(name = "DUE_DILLIGENCE_SCORE")
	private String dueDilligenceScore;

	public String getVENDOR_ID() {
		return VENDOR_ID;
	}

	public void setVENDOR_ID(String VENDOR_ID) {
		VENDOR_ID = VENDOR_ID;
	}

	public String getTpreScore() {
		return tpreScore;
	}

	public void setTpreScore(String tpreScore) {
		this.tpreScore = tpreScore;
	}

	public String getTpreRating() {
		return tpreRating;
	}

	public void setTpreRating(String tpreRating) {
		this.tpreRating = tpreRating;
	}

	public String getIsMaterial() {
		return isMaterial;
	}

	public void setIsMaterial(String isMaterial) {
		this.isMaterial = isMaterial;
	}

	public String getDueDilligenceScore() {
		return dueDilligenceScore;
	}

	public void setDueDilligenceScore(String dueDilligenceScore) {
		this.dueDilligenceScore = dueDilligenceScore;
	}

	public VfVRMRatingData(String VENDOR_ID, String tpreScore, String tpreRating, String isMaterial,
			String dueDilligenceScore) {
		super();
		this.VENDOR_ID = VENDOR_ID;
		this.tpreScore = tpreScore;
		this.tpreRating = tpreRating;
		this.isMaterial = isMaterial;
		this.dueDilligenceScore = dueDilligenceScore;
	}

	public VfVRMRatingData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
