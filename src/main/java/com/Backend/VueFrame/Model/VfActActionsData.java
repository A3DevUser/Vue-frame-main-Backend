package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vf_act_actions")
public class VfActActionsData {
	
	
	@Column(name="ISSUE_ID")
	private String issue_id;
	
	@Column(name="ISSUE_NAME")
	private String issue_name;
	
	@Id
	@Column(name="ACTION_ID")
	private String action_id;
	
	@Column(name="ACTION_NAME")
	private String action_name;
	
	@Column(name="DUE_DATE")
	private String due_date;
	
	@Column(name="OWNER")
	private String owner;
	
	@Column(name="RESOLUTION")
	private String resolution;
	
	@Column(name="RESOLUTION_COM")
	private String resolution_com;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="VF_CURRENT_USER")
	private String vf_Curr_User;

	
	
	public VfActActionsData(String issue_id, String issue_name, String action_id, String action_name, String due_date,
			String owner, String resolution, String resolution_com, String remarks, String vf_Curr_User) {
		super();
		this.issue_id = issue_id;
		this.issue_name = issue_name;
		this.action_id = action_id;
		this.action_name = action_name;
		this.due_date = due_date;
		this.owner = owner;
		this.resolution = resolution;
		this.resolution_com = resolution_com;
		this.remarks = remarks;
		this.vf_Curr_User = vf_Curr_User;
	}



	public String getIssue_id() {
		return issue_id;
	}



	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}



	public String getIssue_name() {
		return issue_name;
	}



	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}



	public String getAction_id() {
		return action_id;
	}



	public void setAction_id(String action_id) {
		this.action_id = action_id;
	}



	public String getAction_name() {
		return action_name;
	}



	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}



	public String getDue_date() {
		return due_date;
	}



	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public String getResolution() {
		return resolution;
	}



	public void setResolution(String resolution) {
		this.resolution = resolution;
	}



	public String getResolution_com() {
		return resolution_com;
	}



	public void setResolution_com(String resolution_com) {
		this.resolution_com = resolution_com;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public String getVf_Curr_User() {
		return vf_Curr_User;
	}



	public void setVf_Curr_User(String vf_Curr_User) {
		this.vf_Curr_User = vf_Curr_User;
	}



	public VfActActionsData() {
		super();
	}

		
	
}
