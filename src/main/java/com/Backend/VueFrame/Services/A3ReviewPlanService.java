package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.ReviewData;
import com.Backend.VueFrame.Repository.A3ReviewPlanRepo;

@Service
public class A3ReviewPlanService {
	
	@Autowired
	private A3ReviewPlanRepo a3ReviewPlanRepo;
	
	
//	 public List<ReviewData> callStoredProcedure(String reviewDataList) {
//	        return a3ReviewPlanRepo.setReviewData(reviewDataList);
//	    }

}
