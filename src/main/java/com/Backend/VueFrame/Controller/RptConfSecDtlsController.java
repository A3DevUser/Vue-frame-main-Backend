package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptConfSecDtls;
import com.Backend.VueFrame.Services.RptConfSecDtlsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptConfSecDtlsController {
	
	@Autowired
	private RptConfSecDtlsServices rptConfSecDtlsServs;
	
	@GetMapping("getRptConfSec")
	public List<RptConfSecDtls> getRptConfSec(@RequestParam String formId) {
		
		return rptConfSecDtlsServs.getRptConfSec(formId);
	}
}
