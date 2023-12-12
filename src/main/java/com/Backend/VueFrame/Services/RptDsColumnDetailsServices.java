package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptDsColumnDetailsRepository;

@Service
public class RptDsColumnDetailsServices {
	
	@Autowired
	private RptDsColumnDetailsRepository rptDsColumnDetailsRepo;
}
