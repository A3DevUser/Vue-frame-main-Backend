package com.Backend.VueFrame.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Backend.VueFrame.Model.EmailDetails;
import com.Backend.VueFrame.Services.EmailService;
import com.Backend.VueFrame.Services.LoggerService;


@Component

public class EmailScheduler {
	
	@Autowired
    private EmailService emailService;
	
//	@Autowired
//	private LoggerService log;
    private static final Logger logger = LoggerFactory.getLogger(EmailScheduler.class);

	
	@Scheduled(fixedRate = 600000) // Run every 60 seconds (adjust as needed)
	public void sendScheduledMail() {
	    try {
	        logger.info("Scheduled Task started");

	        EmailDetails emailDetails = new EmailDetails();
	        emailDetails.setRecipient("swapnalig@claptek.com");
	        emailDetails.setMsgBody("This is the email body");
	        emailDetails.setSubject("Subject of the email");

	        String status = emailService.sendSimpleMail(emailDetails);

	        logger.info("Scheduled Task completed with status: " + status);
	    } catch (Exception e) {
	    	logger.error("Scheduled Task failed", e);
	    }
	}
    
    
    
}