package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.RptDataSource;

public interface RptDataSourceRepository extends JpaRepository<RptDataSource, String> {
	
	//not in use
//	@Query(value = "SELECT RPT_DS_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
//	String setDSIdGen();
	
	
	@Procedure(procedureName = "VF_DATASOURCE_CONFIG_DATA_OBJ", outputParameterName = "v_result")
	 String getDsEditData(@Param("p_ds_id") String dsId);
	
}
