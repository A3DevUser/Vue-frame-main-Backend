package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Repository.VfA3ConfRepository;

@Service
public class VFA3ConfService {
	
	

	    
	    @Autowired
	    private VfA3ConfRepository confepository;

	    public List<String> fetchArea(String branchName) {
	        return confepository.fetchArea(branchName);
	    }

	    public List<String> fetchScheme(String areaName) {
	        return confepository.fetchScheme(areaName);
	    }
	}



