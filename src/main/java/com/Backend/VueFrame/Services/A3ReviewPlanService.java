package com.Backend.VueFrame.Services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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
	
	
	@Transactional
    public void saveData(String reviewId, String reviewType,
                         String reviewFreq, String subFrequency, String vfMainObjId, String reviewName) {
        
        // Call the first method
		a3ReviewPlanRepo.setData(reviewId, reviewType,reviewName,reviewFreq, subFrequency,vfMainObjId);

        // Call the second method
		a3ReviewPlanRepo.setTasktData(vfMainObjId);
    }
	
	
	public String getQuestionData2(String assessType, String category) {

		return a3ReviewPlanRepo.getQuestionData2(assessType, category);
	}
	
	
	public String getSeqId(String formSeqDtls) {

		return a3ReviewPlanRepo.getSeqId(formSeqDtls);
	}

}
