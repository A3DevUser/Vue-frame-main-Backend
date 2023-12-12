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

	public RptExpression(String expId, String dsId, String expression) {
		super();
		this.expId = expId;
		this.dsId = dsId;
		this.expression = expression;
	}

	
	public RptExpression() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
