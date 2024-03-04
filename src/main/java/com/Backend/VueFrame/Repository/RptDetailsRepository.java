package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.RptDetails;

public interface RptDetailsRepository extends JpaRepository<RptDetails, String>{
	//not in use
//	@Query(value = "SELECT RPT_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setRptIdSeq();
	
	List<RptDetails> getByRptId(String rptId);
	
	
	@Procedure(procedureName = "VF_REPORT_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String getRptEditData(@Param("p_report_id") String rptId);
	
	
	@Procedure(procedureName = "VF_FILTER_JSON_FOR_STORED_VALUE", outputParameterName = "v_result")
	 String getJsonFilterforStoredVal(@Param("p_json_array") String pJsonArray);

}
