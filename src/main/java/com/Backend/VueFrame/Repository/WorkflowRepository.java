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

	
//	@Procedure(procedureName = "VF_GET_JSON_OBJ.VF_MULT_GRID_JSON")
//	  String getJsonDataFromTable(@Param("P_FORM_ID") String formId);
//	
//	
//	 fetch grid data from table using formId
	 @Procedure(procedureName = "VF_MULT_GRID_JSON_PROC", outputParameterName = "v_obj")
	   String getJsonDataFromTable(@Param("P_FORM_ID") String formId, @Param("P_USER_ID") String VF_CURRENT_USER);
	 
//	 
	
	//for set workflow data in table
//	 @Procedure(procedureName = "SET_GRID_DATA_1")
//		void setGridData1(@Param("v_curr_stage") String VF_STAGE,
//				          @Param("v_status") String VF_STATUS,
//	                       @Param("v_action") String VF_ACTION,
//	                       @Param("v_VF_ORGANISATION_ID") String VF_ORGANISATION_ID,
//	                       @Param("v_VF_ROLE") String VF_ROLE,
//	                       @Param("v_process_inst_id") String VF_PROCESS_INSTANCE_ID,
//	                       @Param("v_instance_id") String VF_INSTANCE_ID,
//	                       @Param("v_created_by") String VF_CREATED_BY,
//	                       @Param("v_created_on") String VF_CREATED_ON,
//	                       @Param("v_modified_on") String VF_MODIFIED_ON,
//	                       @Param("v_modified_by") String VF_MODIFIED_BY,
//	                       @Param("v_form_id") String formId,
//	                       @Param("v_curr_user") String VF_CURRENT_USER,
//	                       @Param("v_obj_id") String VF_OBJ_ID);
//	 

	 @Query(value = "SELECT DECODE(IS_MAIN,'true',IS_MAIN,null,'false') FROM VF_GRID_DETAILS WHERE GRID_ID = :grid_id", nativeQuery = true)
	 String getIsMain(@Param("grid_id") String grid_id);
	 
	//change by akshay
	 @Procedure(procedureName = "SET_GRID_DATA_2")
		void setGridData1(@Param("v_curr_stage") String VF_STAGE,
				          @Param("v_status") String VF_STATUS,
	                       @Param("v_action") String VF_ACTION,
	                       @Param("v_VF_ORGANISATION_ID") String VF_ORGANISATION_ID,
	                       @Param("v_VF_ROLE") String VF_ROLE,
	                       @Param("v_process_inst_id") String VF_PROCESS_INSTANCE_ID,
	                       @Param("v_instance_id") String VF_INSTANCE_ID,
	                       @Param("v_created_by") String VF_CREATED_BY,
	                       @Param("v_created_on") String VF_CREATED_ON,
	                       @Param("v_modified_on") String VF_MODIFIED_ON,
	                       @Param("v_modified_by") String VF_MODIFIED_BY,
	                       @Param("v_form_id") String formId,
	                       @Param("v_curr_user") String VF_CURRENT_USER,
	                       @Param("v_main_obj_id") String VF_MAIN_OBJ_ID);

	 
	 @Procedure(procedureName = "VF_GENERATE_SEQUENCE", outputParameterName = "v_result")
	   String generateObjId(@Param("formId") String formId);
	 
	 
	 @Procedure(procedureName = "VF_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String setConfigData(@Param("p_form_id") String formId);
	 
	 
	 
	 
	
}




     