package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VF_WF_CONFIG")
public class WfStageConfigData {
	
	@Id
	@Column(name = "CONFIG_ID")
	private String configId;
	
	@Column(name = "STAGE")
	private String stage;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "ORG")
	private String org;
	
	@Column(name = "NEXT_APPROVER")
	private String nextApprover;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "OBJ_ID")
	private String objId;
	
	@Column(name = "FORM_ID")
	private String formId;
	
	@Column(name = "IS_START_STAGE")
	private String isStartSatge;
	
	@Column(name = "IS_END_STAGE")
	private String isEndStage;
	
	@Column (name = "CONFIG_NAME")
    private String configName;
	
	@Column (name = "NEXT_STAGE")
	private String nextStage;
	
	@Column (name = "WF_ID")
	private String wfId;
	
	@Column (name  ="NEXT_STATUS")
	private String nextStatus;
	
	@Column (name  ="TARGET_ID")
	private String targetId;
	
	@Column (name  ="END_DATE")
	private String endDate;
	
	
	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getNextApprover() {
		return nextApprover;
	}

	public void setNextApprover(String nextApprover) {
		this.nextApprover = nextApprover;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getIsStartSatge() {
		return isStartSatge;
	}

	public void setIsStartSatge(String isStartSatge) {
		this.isStartSatge = isStartSatge;
	}

	public String getIsEndStage() {
		return isEndStage;
	}

	public void setIsEndStage(String isEndStage) {
		this.isEndStage = isEndStage;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getNextStage() {
		return nextStage;
	}

	public void setNextStage(String nextStage) {
		this.nextStage = nextStage;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}
	
	public String getWfId() {
		return wfId;
	}

	public void setWfId(String wfId) {
		this.wfId = wfId;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public WfStageConfigData(String configId, String stage, String status, String action, String org,
			String nextApprover, String role, String objId, String formId, String isStartSatge, String isEndStage,
			String configName, String nextStage, String wfId, String nextStatus, String targetId, String endDate) {
		super();
		this.configId = configId;
		this.stage = stage;
		this.status = status;
		this.action = action;
		this.org = org;
		this.nextApprover = nextApprover;
		this.role = role;
		this.objId = objId;
		this.formId = formId;
		this.isStartSatge = isStartSatge;
		this.isEndStage = isEndStage;
		this.configName = configName;
		this.nextStage = nextStage;
		this.wfId = wfId;
		this.nextStatus = nextStatus;
		this.targetId = targetId;
		this.endDate = endDate;
	}

	public WfStageConfigData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WfStageConfigData [configId=" + configId + ", stage=" + stage + ", status=" + status + ", action="
				+ action + ", org=" + org + ", nextApprover=" + nextApprover + ", role=" + role + ", objId=" + objId
				+ ", formId=" + formId + ", isStartSatge=" + isStartSatge + ", isEndStage=" + isEndStage
				+ ", configName=" + configName + ", nextStage=" + nextStage + ", wfId=" + wfId + ", nextStatus="
				+ nextStatus + ", targetId=" + targetId + "]";
	}
	
	
	
		
}