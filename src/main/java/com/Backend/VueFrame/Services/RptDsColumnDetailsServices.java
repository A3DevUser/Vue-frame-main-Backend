package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.RptDsColumnDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptDsColumnDetailsRepository;

@Service
public class RptDsColumnDetailsServices {
	
	@Autowired
	private RptDsColumnDetailsRepository rptDsColumnDetailsRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	public RptDsColumnDetails setDsColId(@RequestBody RptDsColumnDetails setData) {
		if(setData.getColumnId().isBlank()) {
			String formattedSeq = a3PlanServ.getSeqId("RptDsColumnDetailsSeqId");
//		    String formattedSeq = "DSC-" + seq;
		    setData.setColumnId(formattedSeq);
		    return setData;
		}
		
		return setData;
	}
	
	
	public List<RptDsColumnDetails> setRptDsColDtls(@RequestParam List<RptDsColumnDetails> setData) {
		
		List<RptDsColumnDetails> list = rptDsColumnDetailsRepo.saveAllAndFlush(setData);
		
		return list;
	}
}
