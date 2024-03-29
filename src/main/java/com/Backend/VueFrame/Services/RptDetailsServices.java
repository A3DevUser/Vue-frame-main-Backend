package com.Backend.VueFrame.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.NavBarData;
import com.Backend.VueFrame.Model.RptDetails;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptDetailsRepository;

@Service
public class RptDetailsServices {
	
	@Autowired
	private RptDetailsRepository rptDetailsRepo;
	
	
	@Autowired
    private ConfigurationFomrService confService;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	
	public RptDetails setRptIdSeq(@RequestBody RptDetails setData) {
		if(setData.getRptId().isBlank()) {
			String formattedSeq = a3PlanServ.getSeqId("RptDetailsSeqId");
//		    String formattedSeq = "RPT-" + seq;
		    setData.setRptId(formattedSeq);
		    return setData;
		}
		
		return setData;
	}
	
	public List<RptDetails> setRptData(@RequestParam List<RptDetails> setData) {
		
		List<RptDetails> list = rptDetailsRepo.saveAllAndFlush(setData);
		
		
		List<NavBarData> navBarDataList = new ArrayList<>();
		
		for(RptDetails i : setData) {
			
			NavBarData navBarData = new NavBarData();
			
			navBarData.setFormId(i.getRptId());
			navBarData.setNavName(i.getRptName());
			navBarData.setNavStoredValue(i.getRptPkg());
			navBarData.setNavigate("/confreport");
			navBarData.setCat(i.getRptInfcDtls());
			
			navBarDataList.add(navBarData);
		}
		
		List<NavBarData> updatedNavDataList = confService.SetNavData(navBarDataList);
		
		return list;
	}
	
	
	public List<RptDetails> getRptData(@RequestParam String rptId) {
		
		return rptDetailsRepo.getByRptId(rptId);
		
	}
	
	
	public String getRptEditData(String rptId) {
		
		String getData = rptDetailsRepo.getRptEditData(rptId);
		
		return getData;
	}
	
	
	public String getJsonFilterforStoredVal(String pJsonArray) {
		
		String getData = rptDetailsRepo.getJsonFilterforStoredVal(pJsonArray);
		
		return getData;
	}
	
}
