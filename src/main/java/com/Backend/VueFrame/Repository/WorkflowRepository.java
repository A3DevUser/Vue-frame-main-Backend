package com.Backend.VueFrame.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.FormData;
import com.Backend.VueFrame.Model.WorkflowData;

import io.micrometer.core.lang.Nullable;

public interface WorkflowRepository extends JpaRepository<WorkflowData, String> {

	List<WorkflowData> getByFormId(String formId);
	
	
//	   @Query(value = "CALL WF_PACKAGE.VF_WORKFLOW_PROCEDURE(:jsonData)", nativeQuery = true)
//       void callWorkflowProcedure(List<List<FormData>> jsonData);
//	
//	
//	@Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "BEGIN "
//            + "json_data := :jsonData; "
//            + "VF_JSONARRAYPACKAGE.InsertDataFromDynamicJsonArray(json_data); "
//            + "COMMIT; "
//            + "END;")
//    void callWorkflowProcedure(String jsonData);
//
//	
	 @Procedure(procedureName = "VF_JSONARRAYPACKAGE.InsertDataFromDynamicJsonArray")
	    void insertDataFromDynamicJsonArray(@Param("p_json_array") String json);
	 
	 @Procedure(procedureName = "SET_GRID_DATA")
		void setGridData(@Param("p_gridId") String gridId);


	@Query(value = "SELECT VF_WF_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
			String setWfSequence();

	
//	@Query(value = "select VF_GET_JSON_OBJ.VF_MULT_GRID_JSON(:formId) from dual", nativeQuery = true)
//	  String getJsonDataFromTable(@Param("formId") String formId);
//	
	
	 
	 @Procedure(procedureName = "VF_MULT_GRID_JSON_PROC", outputParameterName = "v_obj")
	   String getJsonDataFromTable(@Param("P_FORM_ID") String formId);
	 
	 
	
	
	 @Procedure(procedureName = "SET_GRID_DATA_1")
		void setGridData1(@Param("VF_STAGE") String VF_STAGE,
				          @Param("VF_STATUS") String VF_STATUS,
	                       @Param("VF_ACTION") String VF_ACTION,
	                       @Param("VF_ORGANISATION_ID") String VF_ORGANISATION_ID,
	                       @Param("VF_ROLE") String VF_ROLE,
	                       @Param("VF_INSTANCE_ID") String VF_INSTANCE_ID,
	                       @Param("VF_CREATED_BY") String VF_CREATED_BY,
	                       @Param("VF_CREATED_ON") String VF_CREATED_ON,
	                       @Param("VF_MODIFIED_ON") String VF_MODIFIED_ON,
	                       @Param("VF_MODIFIED_BY") String VF_MODIFIED_BY,
	                       @Param("formId") String formId,
	                       @Param("VF_CURRENT_USER") String VF_CURRENT_USER,
	                       @Param("VF_OBJ_ID") String VF_OBJ_ID);
	 

	 
	 @Procedure(procedureName = "VF_GENERATE_SEQUENCE", outputParameterName = "v_result")
	   String generateObjId(@Param("formId") String formId);
	 
	 
	 @Procedure(procedureName = "VF_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String setConfigData(@Param("p_form_id") String formId);
	 
	 
	 
	
}




     