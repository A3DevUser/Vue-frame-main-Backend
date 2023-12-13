package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.VueFrame.Model.RptConfSecDtls;

public interface RptConfSecDtlsRepository extends JpaRepository<RptConfSecDtls, String>{
	
	List<RptConfSecDtls> getByFormId(String formId);
}
