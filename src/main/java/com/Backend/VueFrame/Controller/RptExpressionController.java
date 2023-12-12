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

import com.Backend.VueFrame.Model.RptExpression;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptExpressionRepository;
import com.Backend.VueFrame.Services.RptExpressionServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptExpressionController {
	
	@Autowired
	private RptExpressionServices rptExpressionServs;
	
	@Autowired
	private RptExpressionRepository rptExpressionRepo;
	
	
	@PostMapping("setRptExpData")
	 public String setRptExpData(@RequestBody List<RptExpression> setData) {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (RptExpression i : setData) {
			 rptExpressionServs.setExpId(i);
//			 obj.put("expId",i.getExpId());
//			 obj.put("dsId", i.getDsId());
		 }
		  
		 List<RptExpression> list = rptExpressionServs.setRptExpData(setData);
		 
		 String v_result = null;
		 
		 for (RptExpression i : setData) {
			 v_result = rptExpressionRepo.setRptQueryColumns(i.getExpId(), i.getDsId(), i.getExpression());
			 
		 }
		 
		 return v_result;
	 }
}
