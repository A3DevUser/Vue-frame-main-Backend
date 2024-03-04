package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.VfVrmOutputAssessDdq;

public interface VfVrmOutputAssessDdqRepository extends JpaRepository<VfVrmOutputAssessDdq, String> {
	//not in use
//	@Query(value = "SELECT VRM_ASSESS_DDQ_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setAssessDdqSeq();
}
