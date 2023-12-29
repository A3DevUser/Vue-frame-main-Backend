package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.VFA3ConfModel;

@Repository
public interface VfA3ConfRepository extends JpaRepository<VFA3ConfModel, String> {
	
	@Query(value = "SELECT * FROM TABLE(VF_A3_FILTER_PKG.vf_a3_fetch_area(:branchName))", nativeQuery = true)
    List<String> fetchArea(@Param("branchName") String branchName);
    
    @Query(value = "SELECT * FROM TABLE(VF_A3_FILTER_PKG.vf_a3_fetch_scheme(:areaName))", nativeQuery = true)
    List<String> fetchScheme(@Param("areaName") String areaName);
	
	
	

}
