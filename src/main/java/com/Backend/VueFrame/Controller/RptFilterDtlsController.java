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

import com.Backend.VueFrame.Model.RptFilterDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.RptFilterDtlsServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptFilterDtlsController {
	
	@Autowired
	private RptFilterDtlsServices rptFilterDtlsServs;
	
	
	@PostMapping("setRptFilterDtls")
	 public Object setRptFilterDtls(@RequestBody List<RptFilterDtls> setData) {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptFilterDtls i :  setData) {
			 rptFilterDtlsServs.setRptFilIdSeq(i);
             obj.put("filId",i.getFilId());
             obj.put("rptId",i.getRptId());
		 }
			 
		 List<RptFilterDtls> list = rptFilterDtlsServs.setRptFilterDtls(setData);
		 
		 return obj;
		 
	 }
	
	@GetMapping("getRptFilData")
	public List<RptFilterDtls> getRptFilData(@RequestParam String rptId) {
		
		return rptFilterDtlsServs.getRptFilData(rptId);

	}
}
