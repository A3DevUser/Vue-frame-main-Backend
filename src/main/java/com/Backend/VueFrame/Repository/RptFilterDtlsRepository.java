package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.RptFilterDtls;

public interface RptFilterDtlsRepository extends JpaRepository<RptFilterDtls, String> {
	//not in use
//	@Query(value = "SELECT RPT_FIL_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setRptFilIdSeq();
	
	
	List<RptFilterDtls> getByRptId(String rptId);
}
