package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptDetailsRepository;

@Service
public class RptDetailsServices {
	
	@Autowired
	private RptDetailsRepository rptDetailsRepo;
}
