package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Backend.VueFrame.Model.RptConfGridDtls;

public interface RptConfGridDtlsRepository extends JpaRepository<RptConfGridDtls, String>{
	
	List<RptConfGridDtls> getByFormId(String formId);
}
