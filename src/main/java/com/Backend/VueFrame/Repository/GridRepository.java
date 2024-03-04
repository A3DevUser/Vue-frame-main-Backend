package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.GridData;

public interface GridRepository extends JpaRepository<GridData, String>{

//	List<GridData> getBySecId(String secId);

	List<GridData> getByFormId(String formId);
	
//	@Query(value = "SELECT * FROM VF_GRID_DETAILS WHERE FORM_ID = :form_id AND END_DATE IS NULL", nativeQuery = true)
	@Procedure(procedureName="vf_getGridData", outputParameterName = "v_result")
	String getGridData(@Param("p_formId") String formId);
	
	//not in use
//	@Query(value = "SELECT GRID_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setGridSequence();
//	
	@Procedure(procedureName="VF_MROW_DATA", outputParameterName = "p_result")
	String getMrowData(@Param("p_form_id") String formId);

	//not in use
//	@Query(value = "SELECT VF_MROW_GRID_ID.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setMrowGridId();
}
/*
 * import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.GridData;

public interface GridRepository extends JpaRepository<GridData, String>{

//	List<GridData> getBySecId(String secId);

	List<GridData> getByFormId(String formId);
	
	@Query(value = "SELECT * FROM VF_GRID_DETAILS WHERE FORM_ID = :form_id AND END_DATE IS NULL", nativeQuery = true)
	List<GridData> getGridData(@Param("form_id") String formId);
	
	
	@Query(value = "SELECT GRID_ID_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
	String setGridSequence();
	
	@Procedure(procedureName="VF_MROW_DATA", outputParameterName = "p_result")
	String getMrowData(@Param("p_form_id") String formId);

	
	@Query(value = "SELECT VF_MROW_GRID_ID.NEXTVAL FROM DUAL", nativeQuery = true)
	String setMrowGridId();
}
 
*/