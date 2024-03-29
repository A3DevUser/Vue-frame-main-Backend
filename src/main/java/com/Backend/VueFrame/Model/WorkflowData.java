package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VF_WORKFLOW_DTLS")
public class WorkflowData {
	
	@Id
	@Column(name = "WORKFLOW_ID")
	private String wfId;
	
	@Column(name = "WORKFLOW_NAME")
	private String workflowName;
	
	@Column(name = "FORM_ID")
	private String formId;
	
	@Column(name = "HOOK_PROCEDURE")
	private String hookProcedure;
	
	@Column(name = "TARGET_ID")
	private String targetId;
	
	
	
	public String getWfId() {
		return wfId;
	}

	public void setWfId(String wfId) {
		this.wfId = wfId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getHookProcedure() {
		return hookProcedure;
	}

	public void setHookProcedure(String hookProcedure) {
		this.hookProcedure = hookProcedure;
	}
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	
	public WorkflowData(String wfId, String workflowName, String formId, String hookProcedure, String targetId) {
		super();
		this.wfId = wfId;
		this.workflowName = workflowName;
		this.formId = formId;
		this.hookProcedure = hookProcedure;
		this.targetId = targetId;
	}

	public WorkflowData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}