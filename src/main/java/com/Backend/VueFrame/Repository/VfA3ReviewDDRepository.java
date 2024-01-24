package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.VfA3ReviewDD;


@Repository
public interface VfA3ReviewDDRepository extends JpaRepository<VfA3ReviewDD, String> {
	
	
	
	
	@Query(value = "SELECT REVIEW_FREQ_DROPDWN(:p_review_type) FROM DUAL", nativeQuery = true)
    String getReviewFreqDropdown(@Param("p_review_type") String reviewType);

    @Query(value = "SELECT REVIEW_SUB_FREQ_DROPDWN(:p_review_freq) FROM DUAL", nativeQuery = true)
    String getReviewSubFreqDropdown(@Param("p_review_freq") String reviewFreq);
    
    @Procedure(procedureName = "VF_A3_GET_REVIEW_PLAN_OBJ", outputParameterName = "v_result")
    String getReviewA3Data(
        @Param("p_review_freq") String reviewFreq,@Param ("p_review_sub_freq") String reviewSubFreq
    ); 

}
