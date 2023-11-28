package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vf_conf_generate_seq")
public class GenerateSequenceData {

	
	@Id
	@Column(name = "SEQ_ID")
	private String seqId;
	
	@Column(name = "SEQ_NAME")
	private String seqName;
	
	@Column(name = "SEQ_GENERATOR")
	private String seqGenerator;
	
	@Column(name = "SEQ_PREFIX")
	private String seqPrefix;
	
	@Column(name = "FORM_ID")
	private String formId;

	public String getSeqId() {
		return seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public String getSeqGenerator() {
		return seqGenerator;
	}

	public void setSeqGenerator(String seqGenerator) {
		this.seqGenerator = seqGenerator;
	}

	public String getSeqPrefix() {
		return seqPrefix;
	}

	public void setSeqPrefix(String seqPrefix) {
		this.seqPrefix = seqPrefix;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public GenerateSequenceData(String seqId, String seqName, String seqGenerator, String seqPrefix, String formId) {
		super();
		this.seqId = seqId;
		this.seqName = seqName;
		this.seqGenerator = seqGenerator;
		this.seqPrefix = seqPrefix;
		this.formId = formId;
	}

	public GenerateSequenceData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
