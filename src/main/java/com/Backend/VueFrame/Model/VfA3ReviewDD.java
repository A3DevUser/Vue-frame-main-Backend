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
	private String stroredValue;
	
	@Column(name = "REVIEW_TYPE")
	private String displayValue;

	
	public String getStroredValue() {
		return stroredValue;
	}


	public void setStroredValue(String stroredValue) {
		this.stroredValue = stroredValue;
	}


	public String getDisplayValue() {
		return displayValue;
	}


	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}


	public VfA3ReviewDD(String stroredValue, String displayValue) {
		super();
		this.stroredValue = stroredValue;
		this.displayValue = displayValue;
	}


	public VfA3ReviewDD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
