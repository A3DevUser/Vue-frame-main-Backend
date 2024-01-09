package com.Backend.VueFrame.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "vf_a3_account_data")

public class VFA3AccountData {	
		
		@Id
		@Column(name = "ACCOUNT_NUMBER")
	    @JsonProperty("Associate_Vend")
		private String Associate_Vend;
		
		@Column(name = "NAME")	
		private String customerName;
			
		@Column(name = "OUTSTANDING_BALANCE")
		private String outstandingAmt;
		
		@Column(name = "OVERDUES")
		private String overdue;
		
		@Column(name = "CUSTOMER_ID")
		private String customerId;
		
		@Column(name = "SCHEME_CODE")
		private String schemeCode;
		
		@Column(name = "SOL_ID")
		private String solId;
	
		
		@Column(name = "SANCTION_DATE")
		private String sanctionDate;
		
		@Column(name = "LIMIT")
		private String limit;
		
		@Column(name = "OVERDUES_SINCE")
		private String overduesSince;
		
		@Column(name = "ROI")
		private String roi;
		
		@Column(name = "ASSET_CLASS")
		private String assetClass;
		
		@Column(name = "DESCRIPTION_OF_ACTIVITY")
		private String descOfActivity;
		
		@Column(name = "ZONE")
		private String zone;
		
		@Column(name = "REGION")
		private String region;
		
		@Column(name = "BRANCH_NAME")
		private String branchName;
		
		@Column(name = "SCHEME_DESCRIPTION")
		private String schemeDesc;
		
		@Column(name = "STATUS")
		private String status;
		
		@Column(name = "USERID")
		private String userId;
		
		@Column (name="AUDIT_ID")
		private String dummy;
		
		@Column(name="Internal_rating")
		private String internalTraining;

		public String getAssociate_Vend() {
			return Associate_Vend;
		}

		public void setAssociate_Vend(String associate_Vend) {
			Associate_Vend = associate_Vend;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getOutstandingAmt() {
			return outstandingAmt;
		}

		public void setOutstandingAmt(String outstandingAmt) {
			this.outstandingAmt = outstandingAmt;
		}

		public String getOverdue() {
			return overdue;
		}

		public void setOverdue(String overdue) {
			this.overdue = overdue;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getSchemeCode() {
			return schemeCode;
		}

		public void setSchemeCode(String schemeCode) {
			this.schemeCode = schemeCode;
		}

		public String getSolId() {
			return solId;
		}

		public void setSolId(String solId) {
			this.solId = solId;
		}

		public String getSanctionDate() {
			return sanctionDate;
		}

		public void setSanctionDate(String sanctionDate) {
			this.sanctionDate = sanctionDate;
		}

		public String getLimit() {
			return limit;
		}

		public void setLimit(String limit) {
			this.limit = limit;
		}

		public String getOverduesSince() {
			return overduesSince;
		}

		public void setOverduesSince(String overduesSince) {
			this.overduesSince = overduesSince;
		}

		public String getRoi() {
			return roi;
		}

		public void setRoi(String roi) {
			this.roi = roi;
		}

		public String getAssetClass() {
			return assetClass;
		}

		public void setAssetClass(String assetClass) {
			this.assetClass = assetClass;
		}

		public String getDescOfActivity() {
			return descOfActivity;
		}

		public void setDescOfActivity(String descOfActivity) {
			this.descOfActivity = descOfActivity;
		}

		public String getZone() {
			return zone;
		}

		public void setZone(String zone) {
			this.zone = zone;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public String getSchemeDesc() {
			return schemeDesc;
		}

		public void setSchemeDesc(String schemeDesc) {
			this.schemeDesc = schemeDesc;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getDummy() {
			return dummy;
		}

		public void setDummy(String dummy) {
			this.dummy = dummy;
		}

		public String getInternalTraining() {
			return internalTraining;
		}

		public void setInternalTraining(String internalTraining) {
			this.internalTraining = internalTraining;
		}

		public VFA3AccountData(String associate_Vend, String customerName, String outstandingAmt, String overdue,
				String customerId, String schemeCode, String solId, String sanctionDate, String limit,
				String overduesSince, String roi, String assetClass, String descOfActivity, String zone, String region,
				String branchName, String schemeDesc, String status, String userId, String dummy,
				String internalTraining) {
			super();
			Associate_Vend = associate_Vend;
			this.customerName = customerName;
			this.outstandingAmt = outstandingAmt;
			this.overdue = overdue;
			this.customerId = customerId;
			this.schemeCode = schemeCode;
			this.solId = solId;
			this.sanctionDate = sanctionDate;
			this.limit = limit;
			this.overduesSince = overduesSince;
			this.roi = roi;
			this.assetClass = assetClass;
			this.descOfActivity = descOfActivity;
			this.zone = zone;
			this.region = region;
			this.branchName = branchName;
			this.schemeDesc = schemeDesc;
			this.status = status;
			this.userId = userId;
			this.dummy = dummy;
			this.internalTraining = internalTraining;
		}

		public VFA3AccountData() {
			super();
			// TODO Auto-generated constructor stub
		}



		
		
		

}
