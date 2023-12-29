package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Services.VFA3ConfService;




@RequestMapping("VF/")
@CrossOrigin(origins = "*")
@RestController
public class VFA3ConfController {
	
	
	
	
	@Autowired
	private VFA3ConfService confServ;
	
	 @GetMapping("fetchArea")
	    public List<String> fetchArea(@RequestParam String branchName) {
	        return confServ.fetchArea(branchName);
	    }

	    @GetMapping("fetchScheme")
	    public List<String> fetchScheme(@RequestParam String areaName) {
	        return confServ.fetchScheme(areaName);
	    }

}
