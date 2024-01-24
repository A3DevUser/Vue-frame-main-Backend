package com.Backend.VueFrame.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.VfA3ReviewPlanStatus;

public interface A3ReviewPlanStatusRepo extends JpaRepository<VfA3ReviewPlanStatus, String> {


	
	
//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE vf_a3_review_plan_status SET review_status = 'Accepted' where review_id = :review_id", nativeQuery = true)
//	String updateReviewPlanStatusAcc(@Param ("review_id") String reviewId );
//	
//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE vf_a3_review_plan_status SET review_status = 'Rejected' where review_id = :review_id", nativeQuery = true)
//	String updateReviewPlanStatusRej(@Param ("review_id") String reviewId );
//	
	
//	VF_INSERT_INTO_VEND_REVIEW (
//			P_JSON_DATA IN CLOB
//			) 
	
	
	@Procedure(procedureName = "VF_INSERT_INTO_VEND_REVIEW")
	 void setReviewPlan(@Param ("P_JSON_DATA") String pJsonData);
	 
}
