package com.Backend.VueFrame.Repository;

import java.util.List;
import java.util.Map;

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
	
	
	@Procedure(procedureName = "GET_ONBOARDING_DATA", outputParameterName = "v_result")
	String getOnBoardingData(@Param("v_reviewId") String reviewId);
	
	
	@Procedure(procedureName = "GET_ONBOARDING_DATA_2", outputParameterName = "v_result")
	String getOnBoardingData2(@Param("v_reviewId") String reviewId);
	
	
	@Query(value = "SELECT QUESTION_ID, QUESTION_TYPE, RISK_DOMAIN, QUESTION, RESPONSE_TYPE, RESPONSE_DISPLAY_VAL, "
				 + "RESPONSE_RATING, MANDATORY_EVIDENCE,\r\n"
				 + "VENDOR_TYPE FROM VF_VRM_QUESTION_DATA WHERE QUESTION_TYPE = :p_question_type and VENDOR_TYPE = :p_vendor_type", nativeQuery = true)
	List<Map<String, String>> getQuestionData(@Param("p_question_type") String pQueType, @Param("p_vendor_type") String pVenType);
	
	
	// IF THE FUNCTION RETURN TYPE IS CLOB THEN IT WILL NOT RUN IN SPRING BOOT
//	@Query(value = "SELECT GET_QUESTIONS_DATA(:v_assess_type, :v_category) FROM DUAL", nativeQuery = true)
//	String getQuestionData2(@Param("v_assess_type") String assessType, @Param("v_category") String category);

	
	@Procedure(procedureName = "GET_QUESTIONS_DATA_PROC", outputParameterName = "v_result")
	String getQuestionData2(@Param("v_assess_type") String assessType, @Param("v_category") String category);

	
	@Procedure(procedureName = "VF_INSRT_INTO_REVIEW_PLAN")
	String setReviewData(@Param("v_review_id") String reviewId, 
	                     @Param("v_review_type") String Review_Type,
	                     @Param("v_review_name") String reviewName, 
	                     @Param("v_review_freq") String Review_Freq,
	                     @Param("v_review_sub_freq") String Sub_Frequency,
	                     @Param("v_review_status") String reviewStatus,
	                     @Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID
	                     );


//	@Procedure(procedureName = "GET_ONBOARDING_DATA", outputParameterName = "v_result")
//	String getOnBoardingData1(@Param("v_reviewId") String reviewDataList);
//	
	
//	List<ReviewData> setReviewData(@Param("p_json_data") List<ReviewData> reviewDataList);
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO VRM_PLAN_REVIEW_TABLE (review_id,review_type,review_name,review_freq,sub_frequency,review_status,VF_MAIN_OBJ_ID,VF_CURRENT_USER, VF_CREATED_BY)\r\n"
			+ "     VALUES(:v_review_id,:v_review_type,:v_review_name,:v_review_freq,:v_review_sub_freq, 'Pending Approval',\r\n"
			+ "            :v_VF_MAIN_OBJ_ID, 'VRM_PLAN_CHECKER', 'madhur1')", nativeQuery = true)
	void setData(@Param("v_review_id") String reviewId,
			       @Param("v_review_type") String Review_Type,
			       @Param("v_review_name")String reviewName,
			       @Param("v_review_freq") String Review_Freq,
			       @Param("v_review_sub_freq") String Sub_Frequency,
			       @Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID);
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO VF_ASSIGNMENT_TASK_TBL ( FORM_ID, VF_MAIN_OBJ_ID, VF_CURRENT_USER,VF_CREATED_ON)\r\n"
			+ "     VALUES ('FORM-1145', :v_VF_MAIN_OBJ_ID, 'VRM_PLAN_CHECKER',to_char(sysdate, 'YYYY-MM-DD'))" , nativeQuery = true)
	void setTasktData(@Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID);
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO VRM_TPRE (VF_MAIN_OBJ_ID,VF_CURRENT_USER,REVIEW_PLAN_ID,REVIEW_TYPE,\r\n"
			+ "REVIEW_FREQ,SUB_FREQUENCY,REVIEW_STATUS)\r\n"
			+ "VALUES (:v_VF_MAIN_OBJ_ID,'PLAN_CHECKER',:v_review_id,:v_review_type,:v_review_freq,\r\n"
			+ ":v_review_sub_freq,'PENDING ASSESSMENT')" , nativeQuery = true)
	void setTableTPREData(@Param("v_review_id") String reviewId,
		       @Param("v_review_type") String Review_Type,
		       @Param("v_review_freq") String Review_Freq,
		       @Param("v_review_sub_freq") String Sub_Frequency,
		       @Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_I);
	
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO VF_ASSIGNMENT_TASK_TBL (FORM_ID, VF_MAIN_OBJ_ID, VF_CURRENT_USER)\r\n"
			+ "                VALUES ('FORM-1145', :v_VF_MAIN_OBJ_ID, 'VRM_PLAN_CHECKER')", nativeQuery = true)
	
	void setTPRETaskData(@Param("v_VF_MAIN_OBJ_ID") String VF_MAIN_OBJ_ID);
}
