package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.ReviewData;
import com.Backend.VueFrame.Model.VfA3ReviewPlan;
import com.Backend.VueFrame.Model.VfA3ReviewPlanStatus;
import com.Backend.VueFrame.Repository.A3ReviewPlanRepo;
import com.Backend.VueFrame.Repository.A3ReviewPlanStatusRepo;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class A3ReviewPlanController {
	
	
	@Autowired
	private A3ReviewPlanRepo a3ReviewPlanRepo;
	
	
	@Autowired
	private A3ReviewPlanStatusRepo a3ReviewPlanStatusRepo;
	
	
	@PostMapping("setReviewPlanData")
	public String postReviews(@RequestBody List<ReviewData> reviewDataList) {
	    List<VfA3ReviewPlan> reviewPlans = new ArrayList<>();
	    List<VfA3ReviewPlanStatus> reviewPlanStatusList = new ArrayList<>();

	    
        String reviewId = "Rev-" + a3ReviewPlanRepo.reviewPlan();

	    for (ReviewData reviewData : reviewDataList) {
	    	String reviewPlanId = "RP-" + a3ReviewPlanRepo.reviewPlanId();
     
	        VfA3ReviewPlan reviewPlan = new VfA3ReviewPlan(reviewPlanId,reviewId, reviewData.getReviewName(),
	                reviewData.getASSOCIATE_VEND(), reviewData.getVENDOR_ID());
	        reviewPlans.add(reviewPlan);

	        VfA3ReviewPlanStatus reviewPlanStatus = new VfA3ReviewPlanStatus(reviewId,
	                reviewData.getReviewName(), reviewData.getReviewStatus(), reviewData.getReviewComment());
	        reviewPlanStatusList.add(reviewPlanStatus);
	    }

	    a3ReviewPlanRepo.saveAll(reviewPlans);
	    a3ReviewPlanStatusRepo.saveAll(reviewPlanStatusList);

	    a3ReviewPlanRepo.saveAndFlush(reviewPlans.get(0)); 
	    a3ReviewPlanStatusRepo.saveAndFlush(reviewPlanStatusList.get(0)); 

	    return "Reviews saved successfully!";
	}

}
