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

import com.Backend.VueFrame.Model.RptDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDetailsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDetailsController {
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptData")
	 public Object setRptData(@RequestBody List<RptDetails> setData) {
		 
	     Map<String,Object> obj = new HashMap<>();

		 
		 for (RptDetails i :  setData) {
			 rptDetailsServs.setRptIdSeq(i);
             obj.put("rptId",i.getRptId());
             obj.put("rptDataSrc",i.getRptDataSrc());
		 }
			 
		 List<RptDetails> list = rptDetailsServs.setRptData(setData);
		 
		 return obj;
	 }
}
