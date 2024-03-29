package com.Backend.VueFrame.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.Backend.VueFrame.Model.RptExpression;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptExpressionRepository;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.Backend.VueFrame.Services.RptExpressionServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class RptExpressionController {
	
	@Autowired
	private RptExpressionServices rptExpressionServs;
	
	@Autowired
	private RptExpressionRepository rptExpressionRepo;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setRptExpData")
	 public String setRptExpData(@RequestBody List<RptExpression> setData) throws JsonProcessingException {
		 
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
	
	
	@GetMapping("getRptQueryResult")
	 public String getRptQueryResult(@RequestParam String rptId) {
		
		String v_result = rptExpressionRepo.getRptQueryResult(rptId);
		
		return v_result;
	}
	
	
	@GetMapping("getRptQueryWithFilter")
	 public String getRptQueryWithFilter(@RequestParam String rptId, @RequestParam String pjson) throws UnsupportedEncodingException {
		String str = URLDecoder.decode(pjson,"UTF-8");
		System.out.println(str);
		String v_result = rptExpressionRepo.getRptQueryWithFilter(rptId, pjson);
		
		return v_result;
	}
	
}
