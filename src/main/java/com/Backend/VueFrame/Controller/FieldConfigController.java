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
import com.Backend.VueFrame.Services.FieldConfigServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class FieldConfigController {
	
	@Autowired
	private FieldConfigServices fieldConfigServices;
	
	@PostMapping("setFieldConfig")
	public Object setFieldConfig(@RequestBody List<FieldConfigData> setData) {
		
		Map<String,Object> obj = new HashMap<>();
		
		for (FieldConfigData wf :  setData) {
			fieldConfigServices.setFieldId(wf);
			obj.put("wfId", wf.getWfId());
		}
		
		List<FieldConfigData> list = fieldConfigServices.setFieldConfig(setData);
		
		return obj;
	}
}
