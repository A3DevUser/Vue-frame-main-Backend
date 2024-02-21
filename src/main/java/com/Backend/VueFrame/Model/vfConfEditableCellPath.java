package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VF_CONF_EDITABLE_CELL_PATH")
public class vfConfEditableCellPath {
	@Id
	@Column(name="SR_NO")
	private String srNo;
	
	@Column(name="COMPONENT_NAME")
	private String CellName;
	
	@Column(name="PATH_LINK")
	private String data;

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getCellName() {
		return CellName;
	}

	public void setCellName(String cellName) {
		CellName = cellName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public vfConfEditableCellPath(String srNo, String cellName, String data) {
		super();
		this.srNo = srNo;
		CellName = cellName;
		this.data = data;
	}

	public vfConfEditableCellPath() {
		super();
		// TODO Auto-generated constructor stub
	}

}
