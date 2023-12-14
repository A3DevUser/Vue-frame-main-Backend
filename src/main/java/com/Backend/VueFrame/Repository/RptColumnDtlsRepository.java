package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.RptColumnDtls;

public interface RptColumnDtlsRepository extends JpaRepository<RptColumnDtls, String> {
	
	@Query(value = "SELECT RPT_COL_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setRptColIdSeq();
	
	List<RptColumnDtls> getByRptId(String rptId);
}
