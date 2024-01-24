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
	
	
	@PostMapping("setReviewPlanData")
    public ResponseEntity<List<ReviewData>> postReviews(@RequestBody List<ReviewData> reviewDataList) {
        try {
            String reviewId = "Rev-" + a3ReviewPlanRepo.reviewPlan();

          
//            	System.out.println("reviewData = " + reviewDataList.toString() + " reviewId = " + reviewId);
//            	@SuppressWarnings("unused")
//				String result = a3ReviewPlanRepo.setData(
//						reviewId,
//						((ReviewData) reviewDataList).getReview_Type(),
//						((ReviewData) reviewDataList).getReviewName(),
//						((ReviewData) reviewDataList).getReview_Freq(),
//						((ReviewData) reviewDataList).getSub_Frequency(),
//						((ReviewData) reviewDataList).getReviewStatus(),
//						((ReviewData) reviewDataList).getVF_MAIN_OBJ_ID()
//                        );

            
            for (ReviewData reviewData : reviewDataList) {
                String reviewPlanId = "RP-" + a3ReviewPlanRepo.reviewPlanId();

//                String reviewId = reviewData.getReviewId();
                
//                System.out.println("reviewData = " + reviewData.get);
//                String result = a3ReviewPlanRepo.setData(reviewData.getReviewId(),
//                                                               reviewData.getReview_Type(),
//                                                               reviewData.getReviewName(),
//                                                               reviewData.getReview_Freq(),
//                                                               reviewData.getSub_Frequency(),
//                                                               reviewData.getReviewStatus(),
//                                                               reviewData.getVF_MAIN_OBJ_ID());

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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	
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

}
