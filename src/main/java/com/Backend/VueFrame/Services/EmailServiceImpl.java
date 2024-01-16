package com.Backend.VueFrame.Services;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.EmailDetails;
import com.Backend.VueFrame.Model.Emailsample;
import com.Backend.VueFrame.Repository.WfEmailConfigRepository;
import com.Backend.VueFrame.Repository.WorkflowRepository;
import com.fasterxml.jackson.databind.ObjectMapper;



//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	@Autowired
	private WorkflowRepository wfRepo;
	
	@Autowired
	private WfEmailConfigRepository emailRepo;
	
	@Autowired
	private LoggerService log;

	@Value("${spring.mail.username}") private String sender;

	// Method 1
	// To send a simple email
//	public String sendSimpleMail(EmailDetails details)
//	{
//
//		
//		// Try block to check for exceptions
//		try {
//
//			// Creating a simple mail message
//			SimpleMailMessage mailMessage
//				= new SimpleMailMessage();
//
//			// Setting up necessary details
//			mailMessage.setFrom(sender);
//			mailMessage.setTo(details.getRecipient());
//			mailMessage.setText(details.getMsgBody());
//			mailMessage.setSubject(details.getSubject());
//
//			// Sending the mail
//			javaMailSender.send(mailMessage);
//
////			String jsonData = convertMailMessageToJson(mailMessage);
////
////	        log.log("e", "Error", "jsonData" + jsonData);
////
////            // Call the stored procedure
////            wfRepo.logEmail(jsonData);
//            
//			return "Mail Sent Successfully...";
//		}
//
//		// Catch block to handle the exceptions
//		catch (Exception e) {
//			return "Error while Sending Mail";
//		}
//	}
	
	
	
	public String sendSimpleMail(Emailsample emailSample) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Assuming that your Emailsample class has appropriate getter methods
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailSample.getEmailTo());
            mailMessage.setText(emailSample.getEmailBody());
            mailMessage.setSubject(emailSample.getSubject());

            javaMailSender.send(mailMessage);

            // Assuming you have a method to convert Emailsample to JSON
            String jsonData = convertEmailsampleToJson(emailSample);

            // Assuming you have a LoggerService to log the JSON data
            log.log("e", "Error", "jsonData" + jsonData);

            // Assuming you have a repository to store the JSON data
            wfRepo.logEmail(jsonData);
            
           

            return "Mail Sent Successfully...";
        } catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    // Assuming you have a method to convert Emailsample to JSON
    private String convertEmailsampleToJson(Emailsample emailSample) {
        // Implement your logic to convert Emailsample to JSON
        // This is a placeholder and should be replaced with your actual implementation
        return "{ \"emailTo\": \"" + emailSample.getEmailTo() + "\", \"emailBody\": \"" + emailSample.getEmailBody() + "\" }";
    }


//	private String convertMailMessageToJson(SimpleMailMessage mailMessage) {
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        return objectMapper.writeValueAsString(mailMessage);
//	    } catch (Exception e) {
//	        log.log("e", "Error", "Error Details" + mailMessage);
//	        return null; // Handle the error accordingly
//	    }
//	}

	// Method 2
	// To send an email with attachment
	public String
	sendMailWithAttachment(EmailDetails details)
	{
		// Creating a mime message
		MimeMessage mimeMessage
			= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper
				= new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(
				details.getSubject());

			// Adding the attachment
			FileSystemResource file
				= new FileSystemResource(
					new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(
				file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			log.log("e", "error","insidecatch" + sender);
			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}
	
	
	
}
