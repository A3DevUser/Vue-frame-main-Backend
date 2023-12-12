package com.Backend.VueFrame.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.RptDataSourceRepository;

@Service
public class RptDataSourceServices {
	
	@Autowired
	private RptDataSourceRepository rptDataSourceRepo;

}
