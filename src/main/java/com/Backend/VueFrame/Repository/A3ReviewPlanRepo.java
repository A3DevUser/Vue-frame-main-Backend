package com.Backend.VueFrame.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	String setReviewData(@Param("v_review_id") String reviewId, 
	                     @Param("v_review_type") String Review_Type,
	                     @Param("v_review_name") String reviewName, 
	                     @Param("v_review_freq") String Review_Freq,
	                     @Param("v_review_sub_freq") String Sub_Frequency,
	                     @Param("v_review_status") String reviewStatus,
	                     @Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID
	                     );


	@Procedure(procedureName = "GET_ONBOARDING_DATA", outputParameterName = "v_result")
	String getOnBoardingData(@Param("v_reviewId") String reviewDataList);
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO VRM_PLAN_REVIEW_TABLE (review_id,review_type,review_name,review_freq,sub_frequency,review_status,VF_MAIN_OBJ_ID,VF_CURRENT_USER)\r\n"
			+ "     VALUES(:v_review_id,:v_review_type,:v_review_name,:v_review_freq,:v_review_sub_freq,:v_review_status,\r\n"
			+ "            :v_VF_MAIN_OBJ_ID, 'VRM_PLAN_CHECKER')", nativeQuery = true)
	String setData(@Param("v_review_id") String reviewId,
			       @Param("v_review_type") String Review_Type,
			       @Param("v_review_name")String reviewName,
			       @Param("v_review_freq") String Review_Freq,
			       @Param("v_review_sub_freq") String Sub_Frequency,
			       @Param("v_review_status") String reviewStatus,
			       @Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID);
	
	
	
	
}
