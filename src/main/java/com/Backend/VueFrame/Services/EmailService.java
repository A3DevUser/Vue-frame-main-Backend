package com.Backend.VueFrame.Services;

import java.util.List;

import com.Backend.VueFrame.Model.EmailDetails;
import com.Backend.VueFrame.Model.Emailsample;

//Interface
	public interface EmailService {
	 
	    // Method
	    // To send a simple email
	    String sendSimpleMail(Emailsample details);
	 
	    // Method
	    // To send an email with attachment
	    String sendMailWithAttachment(EmailDetails details);

	    
	}
