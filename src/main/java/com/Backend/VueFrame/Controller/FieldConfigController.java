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

import com.Backend.VueFrame.Model.FieldConfigData;
import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Services.FieldConfigServices;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class FieldConfigController {
	
	@Autowired
	private FieldConfigServices fieldConfigServices;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	@PostMapping("setFieldConfig")
	public Object setFieldConfig(@RequestBody List<FieldConfigData> setData) throws JsonProcessingException {
		
		Map<String,Object> obj = new HashMap<>();
		
		for (FieldConfigData wf :  setData) {
			fieldConfigServices.setFieldId(wf);
			obj.put("wfId", wf.getWfId());
		}
		
		// using ObjectMapper dependancy to convert object into string.
		ObjectMapper mapper = new ObjectMapper();
		 		   
		// converting object into string
		String pJsonData = mapper.writeValueAsString(setData);
		 		
		System.out.println(pJsonData);
		 		
		// Filtering json data for stored value
		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
		 		
		List<FieldConfigData> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<FieldConfigData>>() {});

		
		List<FieldConfigData> list = fieldConfigServices.setFieldConfig(convertedObject);
		
		return obj;
	}
}
