package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		String reviewId = a3PlanServ.getSeqId("A3ReviewPlanSeqId");
	    // Save data using the saveData method
		saveData(firstReviewData,reviewId);
            

            for (ReviewData reviewData : reviewDataList) {
                String reviewPlanId = a3PlanServ.getSeqId("ReviewPlanSeqId");

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
		

	@PostMapping("updateStatusToAccept")
	public void setStatus(@RequestBody List<Map<String, String>> reviewDataList) {
		
		System.out.println("reviewDataList = " + reviewDataList.toString());
//		for (int i =0; i<=0; i++)
//		{
//			VfA3ReviewPlanStatus reviewData = reviewDataList.get(i);
//		}
//	    for (VfA3ReviewPlanStatus reviewData : reviewDataList) {
//	    	
//	    	System.out.println("reviewData = " + reviewData.toString());
////	        if ("approve".equalsIgnoreCase(reviewData.getReviewStatus())) {
	            try {
	                ObjectMapper objectMapper = new ObjectMapper();
	                String jsonData = objectMapper.writeValueAsString(reviewDataList);
	                
	                System.out.println("jsonData "+jsonData);
	                a3ReviewPlanStatusRepo.setReviewPlan(jsonData);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
//	        }
//	    }
	}

	
	
	@GetMapping("getOutputReviewPlan")
	public String getOnBoardingData(String reviewId) {
		return a3ReviewPlanRepo.getOnBoardingData(reviewId);
	}
	
	
	@GetMapping("getOutputReviewPlan2")
	public String getOnBoardingData2(String reviewId) {
		return a3ReviewPlanRepo.getOnBoardingData2(reviewId);
	}


	@GetMapping("getQuestionData")
	public List<Map<String, String>> getQuestionData(String pQueType, String pVenType) {

		return a3ReviewPlanRepo.getQuestionData(pQueType, pVenType);
	}
	
	@GetMapping("getQuestionData2")
	public String getQuestionData2(@RequestParam String assessType, @RequestParam String category) {

		return a3PlanServ.getQuestionData2(assessType, category);
	}
	
	
	private void saveData(ReviewData yourDataDto, String reviewId) {
	    // Extract necessary data from yourDataDto
	    a3PlanServ.saveData(reviewId, yourDataDto.getReviewType(),
	            yourDataDto.getReviewFreq(), yourDataDto.getReviewSubFreq(), reviewId,
	            yourDataDto.getReviewName());
	}
	
	
//	@GetMapping("getSeqId")
//	public String getSeqId(String formSeqDtls) {
//
//		return a3PlanServ.getSeqId(formSeqDtls);
//	}

}
