package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptColumnDtlsRepository;

@Service
public class RptColumnDtlsServices {
	
	@Autowired
	private RptColumnDtlsRepository rptColumnDtlsRepo;
}
