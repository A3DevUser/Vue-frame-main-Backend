package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.ReviewData;
import com.Backend.VueFrame.Model.VfA3ReviewPlan;

public interface A3ReviewPlanRepo extends JpaRepository<VfA3ReviewPlan, String> {
	
	@Query(value = "SELECT VF_A3_REVIEW_PLAN.NEXTVAL FROM DUAL", nativeQuery = true)
	String reviewPlan();
	
	@Query(value = "select vf_review_plan_id.NEXTVAL FROM DUAL", nativeQuery = true)
	String reviewPlanId();

	
	List<VfA3ReviewPlan> getByReviewId(String reviewId);

	
	@Procedure(procedureName = "VF_INSRT_INTO_REVIEW_PLAN")
	List<ReviewData> setReviewData(@Param("p_json_data") List<ReviewData> reviewDataList);

	@Procedure(procedureName = "GET_ONBOARDING_DATA", outputParameterName = "v_result")
	String getOnBoardingData(@Param("v_reviewId") String reviewDataList);
	
}
