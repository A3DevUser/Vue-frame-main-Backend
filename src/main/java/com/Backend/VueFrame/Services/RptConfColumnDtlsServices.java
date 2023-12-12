package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.RptConfColumnDtls;
import com.Backend.VueFrame.Repository.RptConfColumnDtlsRepository;

@Service
public class RptConfColumnDtlsServices {
	
	@Autowired
	private RptConfColumnDtlsRepository rptConfColumnDtlsRepo;
	
	
	public List<RptConfColumnDtls> getRptConfGen(String formId) {
		
		return rptConfColumnDtlsRepo.getByFormId(formId);
	}
}
