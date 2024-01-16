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
import com.Backend.VueFrame.Model.RptDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDetailsController {
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptData")
	 public Object setRptData(@RequestBody List<RptDetails> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 
		 for (RptDetails i :  setData) {
			 rptDetailsServs.setRptIdSeq(i);
             obj.put("rptId",i.getRptId());
             obj.put("dsId",i.getDsId());
		 }
		 
		 // using ObjectMapper dependancy to convert object into string.
	 	 ObjectMapper mapper = new ObjectMapper();
	 		   
	 	 // converting object into string
	 	 String pJsonData = mapper.writeValueAsString(setData);
	 		
	 	 System.out.println(pJsonData);
	 		
	 	 // Filtering json data for stored value
	 	 String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	 		
	 	 List<RptDetails> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<RptDetails>>() {});

			 
		 List<RptDetails> list = rptDetailsServs.setRptData(convertedObject);
		 
		 return obj;
	 }
	
	
	 @GetMapping("getRptData")
	 public List<RptDetails> getRptData(@RequestParam String rptId) {
		
		 return rptDetailsServs.getRptData(rptId);
	 }
	 
	 
	// to get all report data for report edit functionality
	 @GetMapping("getRptEditData")
	 public String getRptEditData(@RequestParam String rptId) {
				 
		 String getData = rptDetailsServs.getRptEditData(rptId);
				 
		 return getData;
	 }
	 
	 
	 
	 
}
