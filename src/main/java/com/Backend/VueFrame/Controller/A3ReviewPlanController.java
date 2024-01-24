package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.ReviewData;
import com.Backend.VueFrame.Model.VfA3ReviewPlan;
import com.Backend.VueFrame.Model.VfA3ReviewPlanStatus;
import com.Backend.VueFrame.Repository.A3ReviewPlanRepo;
import com.Backend.VueFrame.Repository.A3ReviewPlanStatusRepo;
import com.Backend.VueFrame.Services.A3ReviewPlanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class A3ReviewPlanController {
	
	
	@Autowired
	private A3ReviewPlanRepo a3ReviewPlanRepo;
	
	
	@Autowired
	private A3ReviewPlanStatusRepo a3ReviewPlanStatusRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	@PostMapping("setReviewPlanData")
    public ResponseEntity<List<ReviewData>> postReviews(@RequestBody List<ReviewData> reviewDataList) {
   
		
		ReviewData firstReviewData = reviewDataList.get(0);

	    // Save data using the saveData method
		saveData(firstReviewData);
            String reviewId = "Rev-" + a3ReviewPlanRepo.reviewPlan();

            for (ReviewData reviewData : reviewDataList) {
                String reviewPlanId = "RP-" + a3ReviewPlanRepo.reviewPlanId();

                VfA3ReviewPlan reviewPlan = new VfA3ReviewPlan(reviewPlanId, reviewId, reviewData.getReviewName(),
                                                               reviewData.getASSOCIATE_VEND(), reviewData.getVENDOR_ID(),
                                                               reviewData.getVF_MAIN_OBJ_ID(), reviewData.getVENDOR_TYPE());

                VfA3ReviewPlanStatus reviewPlanStatus = new VfA3ReviewPlanStatus(reviewId,
                                                                                 reviewData.getReviewName(),
                                                                                 reviewData.getReviewStatus(),
                                                                                 reviewData.getReviewComment());

                a3ReviewPlanRepo.saveAndFlush(reviewPlan);
                a3ReviewPlanStatusRepo.saveAndFlush(reviewPlanStatus);
            }
            

            return ResponseEntity.ok(reviewDataList);
      
	
	}
//	@PostMapping("updateStatusToAccept")
//	public void setStatus(@RequestBody List<ReviewData> reviewDataList) {
//		
//		List<VfA3ReviewPlanStatus> reviewPlanStatusList = new ArrayList<>();
//		
//		for(ReviewData reviewData :  reviewDataList) {
//			
//			
//			 VfA3ReviewPlanStatus reviewPlanStatus = new VfA3ReviewPlanStatus(reviewData.getReviewId(),
//		                reviewData.getReviewName(), reviewData.getReviewStatus(), reviewData.getReviewComment());
//		        reviewPlanStatusList.add(reviewPlanStatus);
//		        
//		        
//		
//		        return;
//		        
//	}
//	}
	
	
	

	@PostMapping("updateStatusToAccept")
	public void setStatus(@RequestBody List<VfA3ReviewPlanStatus> reviewDataList) {
	    for (VfA3ReviewPlanStatus reviewData : reviewDataList) {
	        if ("approve".equalsIgnoreCase(reviewData.getReviewStatus())) {
	            try {
	                ObjectMapper objectMapper = new ObjectMapper();
	                String jsonData = objectMapper.writeValueAsString(reviewData);

	                a3ReviewPlanStatusRepo.setReviewPlan(jsonData);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	
	
	@GetMapping("getOutputReviewPlan")
	public String getOnBoardingData(String reviewId) {
		return a3ReviewPlanRepo.getOnBoardingData(reviewId);
	}
	
	
	private void saveData(ReviewData yourDataDto) {
	    // Extract necessary data from yourDataDto
	    a3PlanServ.saveData(yourDataDto.getReviewId(), yourDataDto.getReview_Type(),
	            yourDataDto.getReview_Freq(), yourDataDto.getSub_Frequency(), yourDataDto.getVF_MAIN_OBJ_ID());
	}

}
