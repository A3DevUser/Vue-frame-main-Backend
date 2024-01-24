package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.VfVrmOutputAssessMa;

public interface VfVrmOutputAssessMaRepository extends JpaRepository<VfVrmOutputAssessMa, String> {
	
	@Query(value = "SELECT VRM_ASSESS_MA_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setAssessMaSeq();
}
