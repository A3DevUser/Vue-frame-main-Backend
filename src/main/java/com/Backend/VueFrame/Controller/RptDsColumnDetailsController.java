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

import com.Backend.VueFrame.Model.RptDsColumnDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptDsColumnDetailsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptDsColumnDetailsController {
	
	@Autowired
	private RptDsColumnDetailsServices rptDsColumnDetailsServs;
	
	
	@PostMapping("setRptDsColDtls")
	 public List<RptDsColumnDetails> setRptDsColDtls(@RequestBody List<RptDsColumnDetails> setData) {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptDsColumnDetails i :  setData) {
			 rptDsColumnDetailsServs.setDsColId(i);
//            obj.put("wfId",wf.getWfId());
//            obj.put("formId",wf.getFormId());
		 }
		 
		 System.out.println(setData);
		 
		 List<RptDsColumnDetails> list = rptDsColumnDetailsServs.setRptDsColDtls(setData);
		 
		 return list;
	 }
}
