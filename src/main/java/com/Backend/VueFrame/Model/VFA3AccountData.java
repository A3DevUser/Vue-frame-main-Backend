package com.Backend.VueFrame.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "VRM_VENDOR_REVIEW")

public class VFA3AccountData {	
		
		@Id
		@Column(name = "VF_MAIN_OBJ_ID")
	    @JsonProperty("Associate_Vend")
		private String vfMainObjId;
		
		@Column(name = "REVIEW_TYPE")	
		private String reviewType;
			
		@Column(name = "ASSESSMENT_TYPE")
		private String assessmentType;
		
		@Column(name = "REVIEW_FREQ")
		private String reviewFreq;
		
		@Column(name = "SUB_FREQUENCY")
		private String subFrequency;
		
		@Column(name = "ASSOCIATE_ACT")
		private String associateAct;
		
		@Column(name = "ASSOCIATE_VEN")
		private String associateVen;
	
		
		@Column(name = "BUSINESS_UNIT")
		private String BusinessUnit;
		
		@Column(name = "VENDOR_NAME")
		private String vendorName;
		
		@Column(name = "VENDOR_STATUS")
		private String vendorStatus;
		
		@Column(name = "VENDOR_ONB_DATE")
		private String vendorOnbDate;

		public String getVfMainObjId() {
			return vfMainObjId;
		}

		public void setVfMainObjId(String vfMainObjId) {
			this.vfMainObjId = vfMainObjId;
		}

		public String getReviewType() {
			return reviewType;
		}

		public void setReviewType(String reviewType) {
			this.reviewType = reviewType;
		}

		public String getAssessmentType() {
			return assessmentType;
		}

		public void setAssessmentType(String assessmentType) {
			this.assessmentType = assessmentType;
		}

		public String getReviewFreq() {
			return reviewFreq;
		}

		public void setReviewFreq(String reviewFreq) {
			this.reviewFreq = reviewFreq;
		}

		public String getSubFrequency() {
			return subFrequency;
		}

		public void setSubFrequency(String subFrequency) {
			this.subFrequency = subFrequency;
		}

		public String getAssociateAct() {
			return associateAct;
		}

		public void setAssociateAct(String associateAct) {
			this.associateAct = associateAct;
		}

		public String getAssociateVen() {
			return associateVen;
		}

		public void setAssociateVen(String associateVen) {
			this.associateVen = associateVen;
		}

		public String getBusinessUnit() {
			return BusinessUnit;
		}

		public void setBusinessUnit(String businessUnit) {
			BusinessUnit = businessUnit;
		}

		public String getVendorName() {
			return vendorName;
		}

		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		public String getVendorStatus() {
			return vendorStatus;
		}

		public void setVendorStatus(String vendorStatus) {
			this.vendorStatus = vendorStatus;
		}

		public String getVendorOnbDate() {
			return vendorOnbDate;
		}

		public void setVendorOnbDate(String vendorOnbDate) {
			this.vendorOnbDate = vendorOnbDate;
		}

		public VFA3AccountData(String vfMainObjId, String reviewType, String assessmentType, String reviewFreq,
				String subFrequency, String associateAct, String associateVen, String businessUnit, String vendorName,
				String vendorStatus, String vendorOnbDate) {
			super();
			this.vfMainObjId = vfMainObjId;
			this.reviewType = reviewType;
			this.assessmentType = assessmentType;
			this.reviewFreq = reviewFreq;
			this.subFrequency = subFrequency;
			this.associateAct = associateAct;
			this.associateVen = associateVen;
			BusinessUnit = businessUnit;
			this.vendorName = vendorName;
			this.vendorStatus = vendorStatus;
			this.vendorOnbDate = vendorOnbDate;
		}

		public VFA3AccountData() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		



		
		
		

}
