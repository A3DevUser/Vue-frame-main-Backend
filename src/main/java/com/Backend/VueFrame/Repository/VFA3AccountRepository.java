package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;import com.Backend.VueFrame.Controller.VFA3ConfController;
import com.Backend.VueFrame.Model.VFA3AccountData;

public interface VFA3AccountRepository extends JpaRepository<VFA3AccountData, String> {
	
	
	@Query(value = "SELECT * FROM TABLE(vf_a3_get_account_data_fn(:p_scheme_code))", nativeQuery = true)
	List<VFA3AccountData> fetchAccount(@Param("p_scheme_code") String scheme_code);
	
	

	@Query(value = "SELECT * FROM TABLE(vf_a3_get_account_by_id_fn(:p_scheme_code, :p_ids))", nativeQuery = true)
	List<VFA3AccountData> fetchAccountById(@Param("p_scheme_code") String scheme_code, @Param("p_ids") String accountId );
	

}
