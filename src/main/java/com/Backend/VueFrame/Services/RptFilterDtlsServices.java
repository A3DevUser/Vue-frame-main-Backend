package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptFilterDtlsRepository;

@Service
public class RptFilterDtlsServices {
	
	@Autowired
	private RptFilterDtlsRepository rptFilterDtlsRepo;
}
