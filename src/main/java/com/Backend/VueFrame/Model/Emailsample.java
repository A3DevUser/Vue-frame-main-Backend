package com.Backend.VueFrame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "VF_EMAIL_QUEUE")
public class Emailsample {
	
	
	@Id
	@Column(name = "E_ID")
	private String eId;
	
	@Column(name = "EMAIL_BODY")
	private String emailBody;
	
	@Column(name = "EMAIL_CC")
	private String emailCc;
	
	@Column(name = "EMAIL_TO")
	private String emailTo;
	
	@Column(name = "SEND_DATE")
	private String sendDate;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "SUBJECT")
	private String subject;

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getEmailCc() {
		return emailCc;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Emailsample(String eId, String emailBody, String emailCc, String emailTo, String sendDate, String status,
			String subject) {
		super();
		this.eId = eId;
		this.emailBody = emailBody;
		this.emailCc = emailCc;
		this.emailTo = emailTo;
		this.sendDate = sendDate;
		this.status = status;
		this.subject = subject;
	}

	public Emailsample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
    
    

}
