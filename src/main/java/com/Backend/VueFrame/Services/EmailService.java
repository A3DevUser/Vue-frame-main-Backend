package com.Backend.VueFrame.Services;

import com.Backend.VueFrame.Model.EmailDetails;

//Interface
	public interface EmailService {
	 
	    // Method
	    // To send a simple email
	    String sendSimpleMail(EmailDetails details);
	 
	    // Method
	    // To send an email with attachment
	    String sendMailWithAttachment(EmailDetails details);
	}
