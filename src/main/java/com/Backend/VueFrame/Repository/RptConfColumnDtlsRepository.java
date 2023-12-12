package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.VueFrame.Model.RptConfColumnDtls;

public interface RptConfColumnDtlsRepository extends JpaRepository<RptConfColumnDtls, String> {
	
	List<RptConfColumnDtls> getByFormId(String formId);
}
