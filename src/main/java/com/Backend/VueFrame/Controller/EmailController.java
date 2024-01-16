package com.Backend.VueFrame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.EmailDetails;
import com.Backend.VueFrame.Model.Emailsample;
import com.Backend.VueFrame.Services.EmailService;
import com.Backend.VueFrame.Services.LoggerService;


//Annotation
@RestController
//Class
public class EmailController {

	@Autowired private EmailService emailService;
	@Autowired private LoggerService log;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public String
	sendMail(@RequestBody Emailsample details)
	{
		String status = 
		 emailService.sendSimpleMail(details);
		log.log("e", "error", "email details-" + status);
		log.log("i", "info", "email details-" + status);

		

		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(
		@RequestBody EmailDetails details)
	{
		String status
			= emailService.sendMailWithAttachment(details);

		return status;
	}
}
