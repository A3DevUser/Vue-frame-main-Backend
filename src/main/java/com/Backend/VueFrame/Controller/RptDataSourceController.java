package com.Backend.VueFrame.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Model.RptDataSource;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDataSourceServices;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDataSourceController {
	
	@Autowired
	private RptDataSourceServices rptDataSourceServs;
	
	
	@PostMapping("setRptDsGenData")
	 public Object setRptDsGenData(@RequestBody List<RptDataSource> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptDataSource i :  setData) {
			 rptDataSourceServs.setDSIdGen(i);
             obj.put("dsId",i.getDsId());
		 }
		 		 
		 List<RptDataSource> list = rptDataSourceServs.setRptDsGenData(setData);
		 
		 return obj;
	 }
	
	
	// to get all Data Source data for Data Source edit functionality
	@GetMapping("getDsEditData")
	public String getDsEditData(@RequestParam String dsId) {
			 
		String getData = rptDataSourceServs.getDsEditData(dsId);
			 
		return getData;
	}
	
}
