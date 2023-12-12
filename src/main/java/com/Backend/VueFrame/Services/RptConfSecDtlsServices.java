package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.RptConfGridDtls;
import com.Backend.VueFrame.Model.RptConfSecDtls;
import com.Backend.VueFrame.Repository.RptConfSecDtlsRepository;

@Service
public class RptConfSecDtlsServices {
	
	@Autowired
	private RptConfSecDtlsRepository rptConfSecDtlsRepo;
	
	
	public List<RptConfSecDtls> getRptConfSec(String formId) {
		
		return rptConfSecDtlsRepo.getByFormId(formId);
	}
}
