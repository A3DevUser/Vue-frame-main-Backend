package com.Backend.VueFrame.Model;

public class Emailsample {
	
	
	private String ccEmail;
    private String emailBody;
    private String eId;
    private String subject;
    private String toEmail;
	public String getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public Emailsample(String ccEmail, String emailBody, String eId, String subject, String toEmail) {
		super();
		this.ccEmail = ccEmail;
		this.emailBody = emailBody;
		this.eId = eId;
		this.subject = subject;
		this.toEmail = toEmail;
	}
	public Emailsample() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    

}
