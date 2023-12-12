package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptConfGridDtls;
import com.Backend.VueFrame.Services.RptConfGridDtlsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptConfGridDtlsController {
	
	@Autowired
	private RptConfGridDtlsServices rptConfGridDtlsServs;
	
	
	@GetMapping("getRptConfGen")
	public List<RptConfGridDtls> getRptConfGen(@RequestParam String formId) {
		
		return rptConfGridDtlsServs.getRptConfGen(formId);
	}
	
	
}
