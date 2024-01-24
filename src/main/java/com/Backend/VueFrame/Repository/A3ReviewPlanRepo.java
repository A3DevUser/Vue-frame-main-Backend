package com.Backend.VueFrame.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.VfA3ReviewPlan;

public interface A3ReviewPlanRepo extends JpaRepository<VfA3ReviewPlan, String> {
	
	@Query(value = "SELECT VF_A3_REVIEW_PLAN.NEXTVAL FROM DUAL", nativeQuery = true)
	String reviewPlan();
	
	@Query(value = "select vf_review_plan_id.NEXTVAL FROM DUAL", nativeQuery = true)
	String reviewPlanId();

	
//	List<VfA3ReviewPlan> getByReviewId(String reviewId);
	
	
	@Procedure(procedureName = "GET_ONBOARDING_DATA", outputParameterName = "v_result")
	String getOnBoardingData(@Param("v_reviewId") String reviewId);
	
	
	@Procedure(procedureName = "GET_ONBOARDING_DATA_2", outputParameterName = "v_result")
	String getOnBoardingData2(@Param("v_reviewId") String reviewId, @Param("v_vendor_type") String vendorType);
	
	
	@Query(value = "SELECT QUESTION_ID, QUESTION_TYPE, RISK_DOMAIN, QUESTION, RESPONSE_TYPE, RESPONSE_DISPLAY_VAL, "
				 + "RESPONSE_RATING, MANDATORY_EVIDENCE,\r\n"
				 + "VENDOR_TYPE FROM VF_VRM_QUESTION_DATA WHERE QUESTION_TYPE = :p_question_type and VENDOR_TYPE = :p_vendor_type", nativeQuery = true)
	List<Map<String, String>> getQuestionData(@Param("p_question_type") String pQueType, @Param("p_vendor_type") String pVenType);
	

}
