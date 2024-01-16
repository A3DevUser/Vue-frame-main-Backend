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

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptColumnDtlsServices;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptColumnDtlsController {
	
	@Autowired
	private RptColumnDtlsServices rptColumnDtlsServs;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptColDtls")
	 public Object setRptColDtls(@RequestBody List<RptColumnDtls> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptColumnDtls i :  setData) {
			 rptColumnDtlsServs.setRptColId(i);
             obj.put("rptId",i.getRptId());
             obj.put("dsId", i.getDsId());
		 }
		 
		// using ObjectMapper dependancy to convert object into string.
 		ObjectMapper mapper = new ObjectMapper();
 		   
 		// converting object into string
 		String pJsonData = mapper.writeValueAsString(setData);
 		
 		System.out.println(pJsonData);
 		
 		// Filtering json data for stored value
 		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
 		
 		List<RptColumnDtls> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<RptColumnDtls>>() {});
 		
		List<RptColumnDtls> list = rptColumnDtlsServs.setRptColDtls(convertedObject);
		 
		return obj;
	 }
	
	
	@GetMapping("getRptColData")
	public List<RptColumnDtls> getRptColData(@RequestParam String rptId) {
		
		return rptColumnDtlsServs.getRptColData(rptId);	
	}
}
