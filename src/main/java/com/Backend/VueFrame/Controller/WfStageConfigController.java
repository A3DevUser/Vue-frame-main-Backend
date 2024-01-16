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
import com.Backend.VueFrame.Model.WfStageConfigData;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.Backend.VueFrame.Services.WfStageConfigServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class WfStageConfigController {
	
	@Autowired
	private WfStageConfigServices wfStageConfigServs; 
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	@PostMapping("setWfStageConfig")
	public Object setWfStageConfig(@RequestBody List<WfStageConfigData> setData) throws JsonProcessingException {
		
		
        Map<String,Object> obj = new HashMap<>();

		for(WfStageConfigData wf : setData) {
			wfStageConfigServs.setConfigId(wf);
            obj.put("formId",wf.getFormId());
            obj.put("wfId", wf.getWfId());
			
		}
		
		// using ObjectMapper dependancy to convert object into string.
		ObjectMapper mapper = new ObjectMapper();
		 		   
		// converting object into string
		String pJsonData = mapper.writeValueAsString(setData);
		 		
		System.out.println(pJsonData);
		 		
		// Filtering json data for stored value
		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
		 		
		List<WfStageConfigData> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<WfStageConfigData>>() {});
		
		List<WfStageConfigData> list = wfStageConfigServs.setWfStageConfig(convertedObject);
		
		return obj;
	}
}
