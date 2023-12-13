package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.RptFilterDtls;

public interface RptFilterDtlsRepository extends JpaRepository<RptFilterDtls, String> {
	
	@Query(value = "SELECT RPT_FIL_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setRptFilIdSeq();
}
