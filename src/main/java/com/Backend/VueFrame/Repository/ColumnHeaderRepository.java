package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.ColumnHeaderData;

@Repository
public interface ColumnHeaderRepository extends JpaRepository<ColumnHeaderData, String> {

	List<ColumnHeaderData> getByFormId(String formId);

//	List<ColumnHeaderData> findByOrderByOrdByAsc();

	List<ColumnHeaderData> findByOrderByNumberAsc();

//	List<ColumnHeaderData> getByFormIdAndGridId(String formId);
	
	//not in use
//	@Query(value = "SELECT COLUMN_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setColumnSequence();
	
	
//	@Query(value = "select FORM_ID, COLUMN_ID, COLUMN_NAME, \r\n"
//            + "COLUMN_STORED_VALUE, \r\n"
//            + "COLUMN_FILTER_TYPE, \r\n"
//            + "SEC_ID,DECODE(:emd,'yes',CELL_TYPE,'add',CELL_TYPE,'no',null,null) as CELL_TYPE,\r\n"
//            + "WIDTH, SUB_SEC_ID, SUB_SEC_NAME, SUB_SEC_WIDTH, \r\n"
//            + "SUB_SEC_TYPE, ORDER_BY, CATEGORY_ID, GRID_ID, STICKY , DB_COLUMN_LIMIT, DB_COLUMN_CONST, HIDE_SHOW, TARGET_ID\r\n"
//            + "from vf_column_header where FORM_ID = :formId\r\n"
//            + "and (CELL_TYPE not in ('modalBtn','import','export','iEdropDown','link') or CELL_TYPE is null)\r\n"
//            + "union\r\n"
//            + "select FORM_ID, COLUMN_ID, COLUMN_NAME, \r\n"
//            + "COLUMN_STORED_VALUE, \r\n"
//            + "COLUMN_FILTER_TYPE, \r\n"
//            + "SEC_ID, CELL_TYPE, WIDTH, \r\n"
//            + "SUB_SEC_ID, SUB_SEC_NAME, SUB_SEC_WIDTH, \r\n"
//            + "SUB_SEC_TYPE, ORDER_BY, CATEGORY_ID, GRID_ID, STICKY, DB_COLUMN_LIMIT, DB_COLUMN_CONST, HIDE_SHOW, TARGET_ID \r\n"
//            + "from vf_column_header where FORM_ID = :formId\r\n"
//            + "and CELL_TYPE in ('modalBtn','import','export','iEdropDown','link')", nativeQuery = true)
	@Procedure(procedureName="VF_GET_COL_DATA", outputParameterName = "P_RESULT")
	String getlistofColumns(@Param("P_FORM_ID") String formId, @Param("P_EMD") String gridId);	

	
	@Procedure(procedureName="VF_WF_FIELD_CONF_PROC", outputParameterName = "p_result")
	String getlistofColumns2(@Param("P_FORM_ID") String formId, @Param("P_USER_NAME") String pUserName);
	
	
	@Procedure(procedureName="VF_CREATE_GRIDS", outputParameterName = "p_result")
	String getGridCreationDtls(@Param("p_form_id") String formId);	
	
	
	// form edit functionality (to update vf_navbar_details and vf_grid_details for main table)
	@Procedure(procedureName="VF_UPDATE_GENERAL_DATA")
	void updateNavAndGrid(@Param("p_json_data") String pJsonData);	
	
	
	// form edit functionality (to update vf_column_header for main table)
	@Procedure(procedureName="VF_UPDATE_COL_DTLS")
	void updateColumnHeader(@Param("p_json_data") String pJsonData);	
	
	
	// form edit functionality (to update vf_grid_details for multirow tables)
	@Procedure(procedureName="VF_UPDATE_MULTIROW_DATA")
	void updateMultGridDtls(@Param("p_json_data") String pJsonData);	
	
}
/*package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.ColumnHeaderData;

@Repository
public interface ColumnHeaderRepository extends JpaRepository<ColumnHeaderData, String> {

	List<ColumnHeaderData> getByFormId(String formId);

//	List<ColumnHeaderData> findByOrderByOrdByAsc();

	List<ColumnHeaderData> findByOrderByNumberAsc();

//	List<ColumnHeaderData> getByFormIdAndGridId(String formId);
	
	@Query(value = "SELECT COLUMN_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
	String setColumnSequence();
	
	
	@Query(value = "select FORM_ID, COLUMN_ID, COLUMN_NAME, \r\n"
            + "COLUMN_STORED_VALUE, \r\n"
            + "COLUMN_FILTER_TYPE, \r\n"
            + "SEC_ID,DECODE(:emd,'yes',CELL_TYPE,'add',CELL_TYPE,'no',null,null) as CELL_TYPE,\r\n"
            + "WIDTH, SUB_SEC_ID, SUB_SEC_NAME, SUB_SEC_WIDTH, \r\n"
            + "SUB_SEC_TYPE, ORDER_BY, CATEGORY_ID, GRID_ID, STICKY , DB_COLUMN_LIMIT, DB_COLUMN_CONST, HIDE_SHOW, TARGET_ID\r\n"
            + "from vf_column_header where FORM_ID = :formId\r\n"
            + "and (CELL_TYPE not in ('modalBtn','import','export','iEdropDown','link') or CELL_TYPE is null)\r\n"
            + "union\r\n"
            + "select FORM_ID, COLUMN_ID, COLUMN_NAME, \r\n"
            + "COLUMN_STORED_VALUE, \r\n"
            + "COLUMN_FILTER_TYPE, \r\n"
            + "SEC_ID, CELL_TYPE, WIDTH, \r\n"
            + "SUB_SEC_ID, SUB_SEC_NAME, SUB_SEC_WIDTH, \r\n"
            + "SUB_SEC_TYPE, ORDER_BY, CATEGORY_ID, GRID_ID, STICKY, DB_COLUMN_LIMIT, DB_COLUMN_CONST, HIDE_SHOW, TARGET_ID \r\n"
            + "from vf_column_header where FORM_ID = :formId\r\n"
            + "and CELL_TYPE in ('modalBtn','import','export','iEdropDown','link')", nativeQuery = true)
	List<ColumnHeaderData> getlistofColumns(@Param("formId") String formId, @Param("emd") String gridId);	

	
	@Procedure(procedureName="VF_WF_FIELD_CONF_PROC", outputParameterName = "p_result")
	String getlistofColumns2(@Param("P_FORM_ID") String formId, @Param("P_USER_NAME") String pUserName);
	
	
	@Procedure(procedureName="VF_CREATE_GRIDS", outputParameterName = "p_result")
	String getGridCreationDtls(@Param("p_form_id") String formId);	
	
	
	// form edit functionality (to update vf_navbar_details and vf_grid_details for main table)
	@Procedure(procedureName="VF_UPDATE_GENERAL_DATA")
	void updateNavAndGrid(@Param("p_json_data") String pJsonData);	
	
	
	// form edit functionality (to update vf_column_header for main table)
	@Procedure(procedureName="VF_UPDATE_COL_DTLS")
	void updateColumnHeader(@Param("p_json_data") String pJsonData);	
	
	
	// form edit functionality (to update vf_grid_details for multirow tables)
	@Procedure(procedureName="VF_UPDATE_MULTIROW_DATA")
	void updateMultGridDtls(@Param("p_json_data") String pJsonData);	
	
}
*/