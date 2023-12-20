package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.RptDetails;

public interface RptDetailsRepository extends JpaRepository<RptDetails, String>{
	
	@Query(value = "SELECT RPT_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setRptIdSeq();
	
	List<RptDetails> getByRptId(String rptId);

}
