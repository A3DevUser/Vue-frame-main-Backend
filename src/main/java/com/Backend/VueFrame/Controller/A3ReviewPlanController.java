package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	    for (ReviewData reviewData : reviewDataList) {
	        String reviewId = "Rev-" + a3ReviewPlanRepo.reviewPlan();

	        VfA3ReviewPlan reviewPlan = new VfA3ReviewPlan(reviewId, reviewData.getReviewName(),
	                reviewData.getASSOCIATE_VEND(), reviewData.getVENDOR_ID());
	        reviewPlans.add(reviewPlan);

	        VfA3ReviewPlanStatus reviewPlanStatus = new VfA3ReviewPlanStatus(reviewId,
	                reviewData.getReviewName(), reviewData.getReviewStatus(), reviewData.getReviewComment());
	        reviewPlanStatusList.add(reviewPlanStatus);
	    }

	    a3ReviewPlanRepo.saveAll(reviewPlans);
	    a3ReviewPlanStatusRepo.saveAll(reviewPlanStatusList);

	    // Use saveAndFlush to immediately persist and flush changes to the database
	    a3ReviewPlanRepo.saveAndFlush(reviewPlans.get(0)); // assuming there is at least one element in the list
	    a3ReviewPlanStatusRepo.saveAndFlush(reviewPlanStatusList.get(0)); // assuming there is at least one element in the list

	    return "Reviews saved successfully!";
	}
	
	@GetMapping("getOutputReviewPlan")
	public List<VfA3ReviewPlan> getOutputReviewPlan(String reviewId) {
		return a3ReviewPlanRepo.getByReviewId(reviewId);
	}

}
