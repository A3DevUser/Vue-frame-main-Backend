package com.Backend.VueFrame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Services.RptDsColumnDetailsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDsColumnDetailsController {
	
	@Autowired
	private RptDsColumnDetailsServices rptDsColumnDetailsServs;
}
