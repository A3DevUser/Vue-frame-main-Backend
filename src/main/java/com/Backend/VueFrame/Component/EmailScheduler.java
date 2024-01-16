//package com.Backend.VueFrame.Component;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.Backend.VueFrame.Model.EmailDetails;
//import com.Backend.VueFrame.Model.Emailsample;
//import com.Backend.VueFrame.Repository.WfEmailConfigRepository;
//import com.Backend.VueFrame.Services.EmailService;
//import com.Backend.VueFrame.Services.LoggerService;
//
//
//@Component
//
//public class EmailScheduler {
//	
//	@Autowired
//    private EmailService emailService;
//	
//	@Autowired 
//	private WfEmailConfigRepository emailRepo;
//	
////	@Autowired
////	private LoggerService log;
//    private static final Logger logger = LoggerFactory.getLogger(EmailScheduler.class);
//
//    
//    public List<Emailsample> getUnsendEmails() {
//        return emailRepo.findByStatus("Unsend");
//    }
//    
//    
//	@Scheduled(fixedRate = 60000) // Run every 60 seconds (adjust as needed)
//    public void sendScheduledMail() {
//        try {
//            logger.info("Scheduled Task started");
//
//            List<Emailsample> unsendEmails = getUnsendEmails();
//
//            for (Emailsample email : unsendEmails) {
//                emailService.sendSimpleMail(email);
//                email.setStatus("send");
//                emailRepo.save(email); // Update the status in the database
//
//
//            }
//
//            logger.info("Scheduled Task completed");
//        } catch (Exception e) {
//            logger.error("Scheduled Task failed", e);
//        }
//    }
//    
//	
// 
//	
////	@Scheduled(fixedRate = 60000) // Run every 60 seconds (adjust as needed)
////	public void sendScheduledMail() {
////	    try {
////	        logger.info("Scheduled Task started");
////
////	        EmailDetails emailDetails = new EmailDetails();
////	        emailDetails.setRecipient("vishalb@claptek.com");
////	        emailDetails.setMsgBody("This is the email body");
////	        emailDetails.setSubject("Subject of the email");
////
////	        String status = emailService.sendSimpleMail(emailDetails);
////
////	        logger.info("Scheduled Task completed with status: " + status);
////	    } catch (Exception e) {
////	    	logger.error("Scheduled Task failed", e);
////	    }
////	}
//}
//
//
//
