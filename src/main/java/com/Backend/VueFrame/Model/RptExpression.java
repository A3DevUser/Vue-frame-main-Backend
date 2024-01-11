package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VF_RPT_DS_QUERY_EXP")
public class RptExpression {
	
	@Id
	@Column(name = "EXP_ID")
	private String expId;
	
	@Column(name = "DS_ID")
	private String dsId;
	
	@Column(name = "EXPRESSION")
	private String expression;
	
	@Column(name = "TARGET_ID")
	private String targetId;

	
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	
	
	public RptExpression(String expId, String dsId, String expression, String targetId) {
		super();
		this.expId = expId;
		this.dsId = dsId;
		this.expression = expression;
		this.targetId = targetId;
	}

	public RptExpression() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
