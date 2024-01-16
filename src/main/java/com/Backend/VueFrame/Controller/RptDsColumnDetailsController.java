package com.Backend.VueFrame.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Model.RptDsColumnDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.Backend.VueFrame.Services.RptDsColumnDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDsColumnDetailsController {
	
	@Autowired
	private RptDsColumnDetailsServices rptDsColumnDetailsServs;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptDsColDtls")
	 public List<RptDsColumnDetails> setRptDsColDtls(@RequestBody List<RptDsColumnDetails> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptDsColumnDetails i :  setData) {
			 rptDsColumnDetailsServs.setDsColId(i);
//            obj.put("wfId",wf.getWfId());
//            obj.put("formId",wf.getFormId());
		 }
		 
		 // using ObjectMapper dependancy to convert object into string.
	 	 ObjectMapper mapper = new ObjectMapper();
	 		   
	 	 // converting object into string
	 	 String pJsonData = mapper.writeValueAsString(setData);
	 		
	 	 System.out.println(pJsonData);
	 		
	 	 // Filtering json data for stored value
	 	 String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	 		
	 	 List<RptDsColumnDetails> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<RptDsColumnDetails>>() {});

		 
		 List<RptDsColumnDetails> list = rptDsColumnDetailsServs.setRptDsColDtls(convertedObject);
		 
		 return list;
	 }
}
