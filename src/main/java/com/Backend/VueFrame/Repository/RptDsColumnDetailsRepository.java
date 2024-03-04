package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.RptDsColumnDetails;

public interface RptDsColumnDetailsRepository extends JpaRepository<RptDsColumnDetails, String>{
	
	//not in use
//	@Query(value = "SELECT VF_RPT_DS_COL_ID.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setDsColId();
}
