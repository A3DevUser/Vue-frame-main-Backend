package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.RptConfGridDtls;
import com.Backend.VueFrame.Repository.RptConfGridDtlsRepository;

@Service
public class RptConfGridDtlsServices {
	
	@Autowired
	private RptConfGridDtlsRepository rptConfGridDtlsRepo;
	
	
	public List<RptConfGridDtls> getRptConfGen(String formId) {
		
		return rptConfGridDtlsRepo.getByFormId(formId);
	}
}
