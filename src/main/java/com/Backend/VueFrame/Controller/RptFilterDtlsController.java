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
import com.Backend.VueFrame.Model.RptFilterDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.Backend.VueFrame.Services.RptFilterDtlsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptFilterDtlsController {
	
	@Autowired
	private RptFilterDtlsServices rptFilterDtlsServs;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptFilterDtls")
	 public Object setRptFilterDtls(@RequestBody List<RptFilterDtls> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptFilterDtls i :  setData) {
			 rptFilterDtlsServs.setRptFilIdSeq(i);
		 }
		 
		 // using ObjectMapper dependancy to convert object into string.
	 	 ObjectMapper mapper = new ObjectMapper();
	 		   
	 	 // converting object into string
	 	 String pJsonData = mapper.writeValueAsString(setData);
	 		
	 	 System.out.println(pJsonData);
	 		
	 	 // Filtering json data for stored value
	 	 String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	 	 
	 	 System.out.println(filteredJsonData);
	 		
	 	 List<RptFilterDtls> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<RptFilterDtls>>() {});
	 	 
	 	 System.out.println(convertedObject);
			 
		 List<RptFilterDtls> list = rptFilterDtlsServs.setRptFilterDtls(convertedObject);
		 
		 return obj;
		 
	 }
	
	@GetMapping("getRptFilData")
	public List<RptFilterDtls> getRptFilData(@RequestParam String rptId) {
		
		return rptFilterDtlsServs.getRptFilData(rptId);

	}
}
