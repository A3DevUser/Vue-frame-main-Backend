package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptConfColumnDtls;
import com.Backend.VueFrame.Services.RptConfColumnDtlsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptConfColumnDtlsController {
	
	@Autowired
	private RptConfColumnDtlsServices rptConfColumnDtlsServs;
	
	
	@GetMapping("getRptConfCol")
	public List<RptConfColumnDtls> getRptConfGen(@RequestParam String formId) {
		
		return rptConfColumnDtlsServs.getRptConfGen(formId);
	}
}
