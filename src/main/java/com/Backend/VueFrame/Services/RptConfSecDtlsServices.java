package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptConfSecDtlsRepository;

@Service
public class RptConfSecDtlsServices {
	
	@Autowired
	private RptConfSecDtlsRepository rptConfSecDtlsRepo;
}
