package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.RptExpression;

public interface RptExpressionRepository extends JpaRepository<RptExpression, String> {
	
	@Query(value = "SELECT RPT_DS_EXP_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setExpId();
	
	
	@Procedure(procedureName = "VF_RPT_QUERY_COLUMNS", outputParameterName = "v_result")
	String setRptQueryColumns(@Param("p_exp_id") String expId, @Param("p_ds_id") String dsId, @Param("P_QUERY") String pQuery);
	
	@Procedure(procedureName = "get_rpt_query_result", outputParameterName = "v_result")
	String getRptQueryResult(@Param("v_rptid") String rptId);
}
