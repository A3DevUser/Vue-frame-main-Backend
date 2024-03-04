package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.VfVrmOutputAssessTpre;

public interface VfVrmOutputAssessTpreRepository extends JpaRepository<VfVrmOutputAssessTpre, String> {
	//not in use
//	@Query(value = "SELECT VRM_ASSESS_TPRE_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setAssessTpreSeq();
}
