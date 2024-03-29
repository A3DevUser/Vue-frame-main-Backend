package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.WorkflowData;

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
	 @Procedure(procedureName = "VF_JSONARRAYPACKAGE.InsertDataFromDynamicJsonArray", outputParameterName = "v_alert")
	    String insertDataFromDynamicJsonArray(@Param("p_json_array") String json);
	 
	 @Procedure(procedureName = "SET_GRID_DATA")
		void setGridData(@Param("p_gridId") String gridId);

    //not in use
//	@Query(value = "SELECT VF_WF_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//		String setWfSequence();

	
//	@Procedure(procedureName = "VF_GET_JSON_OBJ.VF_MULT_GRID_JSON")
//	  String getJsonDataFromTable(@Param("P_FORM_ID") String formId);
//	
//	
//	 fetch grid data from table using formId
	 @Procedure(procedureName = "VF_MULT_GRID_JSON_PROC", outputParameterName = "v_obj")
	   String getJsonDataFromTable(@Param("P_FORM_ID") String formId, @Param("P_USER_ID") String VF_CURRENT_USER, 
			   					   @Param("DAYS_FLAG") String daysFlag);
	 
	 
	 // to get the multirow data on the basis of main_obj_id
	 @Procedure(procedureName = "GET_MULTROW_DATA", outputParameterName = "V_RESULT")
	 String getMultRowData(@Param("V_FORM_ID") String formId, @Param("V_MAIN_OBJ_ID") String mainObjId);
	
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
	 
//	 @Query(value = "SELECT DECODE(IS_MAIN,'true',IS_MAIN,null,'false') as IS_MAIN, FORM_ID FROM VF_GRID_DETAILS \r\n"
//	 			  + "WHERE GRID_ID = GET_STORED_VALUE_FROM_COLUMN(:grid_id)", nativeQuery = true)
//	 Map<String,String> getIsMainAndFormId(@Param("grid_id") String grid_id);
	 
	 
	// it will return is_main and formId on the basis of gridId
	 @Query(value = "SELECT VF_GET_IS_MAIN_AND_FORMID_FUNC(:p_grid_id) FROM DUAL", nativeQuery = true)
	 String getIsMainAndFormIdRepo(@Param("p_grid_id") String grid_id);
	 
	 
//	 @Query(value = "SELECT COLUMN_NAME FROM VF_DEFAULT_COLS", nativeQuery = true)
//	 List<String> getDefaultCols();
	 
	 
	 @Procedure(procedureName = "vf_getDefaultCols")
	 String getDefaultCols();
	 
	 
	 //not in use
//	 @Query(value = "SELECT VF_IMPORT_EXPORT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	 String getImportVfObjIdSeq();
	 
	//change by akshay
	 @Procedure(procedureName = "SET_WF_DTLS")
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
	 
	 
//	 @Procedure(procedureName = "VF_EMAIL_LOGGER_PROC")
//	 String sendMail(@Param("P_JSON_DATA") String details);
//	 
//	 
//	 @Procedure(name = "VF_EMAIL_LOGGER_PROC")
//	    void logEmail(@Param("P_JSON_DATA") String jsonData);
//	
	 @Modifying
	    @Query(value = "BEGIN VF_EMAIL_LOGGER_PROC(:P_JSON_DATA); END;", nativeQuery = true)
	    void logEmail(@Param("P_JSON_DATA") String jsonData);
	 
	 @Procedure(procedureName = "VF_WORKFLOW_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String getWfEditData(@Param("p_workflow_id") String wfId);
	 
	 //function of fetch multiselect column data
	 @Procedure(procedureName = "vf_ms_column_data_proc", outputParameterName = "v_result_data")
	    String getColumnData(
	        @Param("v_grid_id") String gridId
	    );
	
	 @Procedure(procedureName = "vf_get_multiselect_data_obj", outputParameterName = "v_result")
	    String getMultiColumnData(
	        @Param("p_grid_id") String gridId
	    ); 
	 
	 
	 @Procedure(procedureName = "InsertAuditId")
        void setAuditId(@Param("audit_json_param") String auditId);
	 
	 
	 @Procedure(procedureName = "GET_APPROVED_DATA_TO_ADD_TBL", outputParameterName = "v_result")
	    String getApprovedDataToAddTbl(@Param("v_form_id") String formId); 
	 
}


/*package com.Backend.VueFrame.Repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;

import com.Backend.VueFrame.Model.EmailDetails;
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
	 @Procedure(procedureName = "VF_JSONARRAYPACKAGE.InsertDataFromDynamicJsonArray", outputParameterName = "v_alert")
	    String insertDataFromDynamicJsonArray(@Param("p_json_array") String json);
	 
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
	   String getJsonDataFromTable(@Param("P_FORM_ID") String formId, @Param("P_USER_ID") String VF_CURRENT_USER, 
			   					   @Param("DAYS_FLAG") String daysFlag);
	 
	 
	 // to get the multirow data on the basis of main_obj_id
	 @Procedure(procedureName = "GET_MULTROW_DATA", outputParameterName = "V_RESULT")
	 String getMultRowData(@Param("V_FORM_ID") String formId, @Param("V_MAIN_OBJ_ID") String mainObjId);
	
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
	 
	 // it will return is_main and formId on the basis of gridId
//	 @Query(value = "SELECT DECODE(IS_MAIN,'true',IS_MAIN,null,'false') as IS_MAIN, FORM_ID FROM VF_GRID_DETAILS \r\n"
//	 			  + "WHERE GRID_ID = GET_STORED_VALUE_FROM_COLUMN(:grid_id)", nativeQuery = true)
//	 Map<String,String> getIsMainAndFormId(@Param("grid_id") String grid_id);
	 
	 
	// it will return is_main and formId on the basis of gridId
	 @Query(value = "SELECT VF_GET_IS_MAIN_AND_FORMID_FUNC(:p_grid_id) FROM DUAL", nativeQuery = true)
	 String getIsMainAndFormIdRepo(@Param("p_grid_id") String grid_id);
	 
	 
//	 @Query(value = "SELECT COLUMN_NAME FROM VF_DEFAULT_COLS", nativeQuery = true)
//	 List<String> getDefaultCols();
	 
	 
	 @Procedure(procedureName = "vf_getDefaultCols")
	 String getDefaultCols();
	 
	 
	 @Query(value = "SELECT VF_IMPORT_EXPORT_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	 String getImportVfObjIdSeq();
	 
	//change by akshay
	 @Procedure(procedureName = "SET_WF_DTLS")
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
	 
	 
//	 @Procedure(procedureName = "VF_EMAIL_LOGGER_PROC")
//	 String sendMail(@Param("P_JSON_DATA") String details);
//	 
//	 
//	 @Procedure(name = "VF_EMAIL_LOGGER_PROC")
//	    void logEmail(@Param("P_JSON_DATA") String jsonData);
//	
	 @Modifying
	    @Query(value = "BEGIN VF_EMAIL_LOGGER_PROC(:P_JSON_DATA); END;", nativeQuery = true)
	    void logEmail(@Param("P_JSON_DATA") String jsonData);
	 
	 @Procedure(procedureName = "VF_WORKFLOW_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String getWfEditData(@Param("p_workflow_id") String wfId);
	 
	 //function of fetch multiselect column data
	 @Procedure(procedureName = "vf_ms_column_data_proc", outputParameterName = "v_result_data")
	    String getColumnData(
	        @Param("v_grid_id") String gridId
	    );
	
	 @Procedure(procedureName = "vf_get_multiselect_data_obj", outputParameterName = "v_result")
	    String getMultiColumnData(
	        @Param("p_grid_id") String gridId
	    ); 
	 
	 
	 @Procedure(procedureName = "InsertAuditId")
        void setAuditId(@Param("audit_json_param") String auditId);
	 
	 
	 @Procedure(procedureName = "GET_APPROVED_DATA_TO_ADD_TBL", outputParameterName = "v_result")
	    String getApprovedDataToAddTbl(@Param("v_form_id") String formId); 
	 
}







 */    