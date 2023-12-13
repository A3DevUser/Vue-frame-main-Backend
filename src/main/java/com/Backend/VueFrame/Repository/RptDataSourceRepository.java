package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.RptDataSource;

public interface RptDataSourceRepository extends JpaRepository<RptDataSource, String>{
	
	@Query(value = "SELECT RPT_DS_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setDSIdGen();
}
