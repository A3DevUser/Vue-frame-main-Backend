package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptExpressionRepository;

@Service
public class RptExpressionServices {
	
	@Autowired
	private RptExpressionRepository rptExpressionRepo;
	
}
