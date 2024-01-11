package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.RptExpression;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptExpressionRepository;

@Service
public class RptExpressionServices {
	
	@Autowired
	private RptExpressionRepository rptExpressionRepo;
	
	
	public RptExpression setExpId(@RequestBody RptExpression setData) {
		if(setData.getExpId() == null) {
			String seq = rptExpressionRepo.setExpId();
		    String formattedSeq = "EXP-" + seq;
		    setData.setExpId(formattedSeq);
		    return setData;
		}
		
		return setData;
	}
	
	public List<RptExpression> setRptExpData(@RequestParam List<RptExpression> setData) {
		
		List<RptExpression> list = rptExpressionRepo.saveAllAndFlush(setData);
		
		return list;
	}
}
