package com.Backend.VueFrame.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="VF_A3_CHECKLIST_TBL")
public class VfA3CheckListData {              
              @Id
              @Column(name = "ID")
              private String testId;
              
              @Column(name = "OBJECTIVE")
              private String objective;
              
              @Column(name = "PROCESS")
              private String process;   
              
              @Column(name = "SUB_PROCESS")
              private String subProcess;
              
              @Column(name = "TEST_REF")
              private String testRef;
              
              @Column(name = "TEST_TITLE")
              private String testTitle;
              
              @Column(name = "SCHEME_CODE")
              private String schemeCode;
              
              @Column(name = "audit_id")
              private String auditId;
              
              @Column(name = "RISK")
              private String risk;
              
              @Column(name = "CONTROL")
              private String control;

              @Column(name = "AREA_NAME")
              private String areaName;
              
              @Column(name = "FREQUENCY")
              private String frequency;
              
              @Column (name = "DROPDOWN")
              private String dropDown;
              
              @Column (name = "MIX_VAL")
              private String mixVal;
              
              @Column (name = "MAX_VAL")
              private String maxVal;
              
              @Column (name = "FORM_ID")
              private String formId;
              
              @Column(name = "RESPONSE_TYPE")
              private String resType;

			

			public String getTestId() {
				return testId;
			}

			public void setTestId(String testId) {
				this.testId = testId;
			}

			public String getObjective() {
				return objective;
			}

			public void setObjective(String objective) {
				this.objective = objective;
			}

			public String getProcess() {
				return process;
			}

			public void setProcess(String process) {
				this.process = process;
			}

			public String getSubProcess() {
				return subProcess;
			}

			public void setSubProcess(String subProcess) {
				this.subProcess = subProcess;
			}

			public String getTestRef() {
				return testRef;
			}

			public void setTestRef(String testRef) {
				this.testRef = testRef;
			}

			public String getTestTitle() {
				return testTitle;
			}

			public void setTestTitle(String testTitle) {
				this.testTitle = testTitle;
			}

			public String getSchemeCode() {
				return schemeCode;
			}

			public void setSchemeCode(String schemeCode) {
				this.schemeCode = schemeCode;
			}

			public String getAuditId() {
				return auditId;
			}

			public void setAuditId(String auditId) {
				this.auditId = auditId;
			}

			public String getRisk() {
				return risk;
			}

			public void setRisk(String risk) {
				this.risk = risk;
			}

			public String getControl() {
				return control;
			}

			public void setControl(String control) {
				this.control = control;
			}

			public String getAreaName() {
				return areaName;
			}

			public void setAreaName(String areaName) {
				this.areaName = areaName;
			}

			public String getFrequency() {
				return frequency;
			}

			public void setFrequency(String frequency) {
				this.frequency = frequency;
			}

			public String getDropDown() {
				return dropDown;
			}

			public void setDropDown(String dropDown) {
				this.dropDown = dropDown;
			}

			public String getMixVal() {
				return mixVal;
			}

			public void setMixVal(String mixVal) {
				this.mixVal = mixVal;
			}

			public String getMaxVal() {
				return maxVal;
			}

			public void setMaxVal(String maxVal) {
				this.maxVal = maxVal;
			}

			public String getFormId() {
				return formId;
			}

			public void setFormId(String formId) {
				this.formId = formId;
			}
			
			

			public String getResType() {
				return resType;
			}

			public void setResType(String resType) {
				this.resType = resType;
			}

			

			public VfA3CheckListData(String testId, String objective, String process, String subProcess, String testRef,
					String testTitle, String schemeCode, String auditId, String risk, String control, String areaName,
					String frequency, String dropDown, String mixVal, String maxVal, String formId, String resType) {
				super();
				this.testId = testId;
				this.objective = objective;
				this.process = process;
				this.subProcess = subProcess;
				this.testRef = testRef;
				this.testTitle = testTitle;
				this.schemeCode = schemeCode;
				this.auditId = auditId;
				this.risk = risk;
				this.control = control;
				this.areaName = areaName;
				this.frequency = frequency;
				this.dropDown = dropDown;
				this.mixVal = mixVal;
				this.maxVal = maxVal;
				this.formId = formId;
				this.resType = resType;
			}

			public VfA3CheckListData() {
				super();
				// TODO Auto-generated constructor stub
			}

			
			
              

              
              
}
