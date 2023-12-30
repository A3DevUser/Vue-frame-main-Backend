package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VFA3AccountData;
import com.Backend.VueFrame.Repository.VFA3AccountRepository;
import com.Backend.VueFrame.Services.VFA3ConfService;




@RequestMapping("VF/")
@CrossOrigin(origins = "*")
@RestController
public class VFA3ConfController {
	
	
	
	
	@Autowired
	private VFA3ConfService confServ;
	
	@Autowired
	private VFA3AccountRepository vfA3AccountRepo;
	
	
	
	 @GetMapping("fetchArea")
	    public List<String> fetchArea(@RequestParam String branchName) {
	        return confServ.fetchArea(branchName);
	    }

	    @GetMapping("fetchScheme")
	    public List<String> fetchScheme(@RequestParam String areaName) {
	        return confServ.fetchScheme(areaName);
	    }
	    
	    
	    @GetMapping("fetchAccountData")
	    public List<VFA3AccountData> fetchAccount(@RequestParam String schemeCode) {
	    	
	    	List<VFA3AccountData> list = new ArrayList<>();
	    	System.out.println("columnname" +  list);
	        return vfA3AccountRepo.fetchAccount(schemeCode);
	    }

	    
	    @GetMapping("fetchAccountById")
	    public List<VFA3AccountData> fetchAccountById(@RequestParam String schemeCode, @RequestParam String accountId) {
	    	
	    	List<VFA3AccountData> list = new ArrayList<>();
	    	System.out.println("columnname" +  list);
	        return vfA3AccountRepo.fetchAccountById(schemeCode, accountId);
	    }
}
