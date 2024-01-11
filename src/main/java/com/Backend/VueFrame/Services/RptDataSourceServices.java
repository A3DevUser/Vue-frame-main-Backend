package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.RptDataSource;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptDataSourceRepository;

@Service
public class RptDataSourceServices {
	
	@Autowired
	private RptDataSourceRepository rptDataSourceRepo;
	
	
	public RptDataSource setDSIdGen(@RequestBody RptDataSource setData) {
		if(setData.getDsId().isBlank()) {
			String seq = rptDataSourceRepo.setDSIdGen();
		    String formattedSeq = "DS-" + seq;
		    setData.setDsId(formattedSeq);
		    return setData;
		}
		
		return setData;
	}
	
	
	public List<RptDataSource> setRptDsGenData(@RequestParam List<RptDataSource> setData) {
		
		List<RptDataSource> list = rptDataSourceRepo.saveAllAndFlush(setData);
		
		return list;
	}
	
	
	public String getDsEditData(String wfId) {
		
		String getData = rptDataSourceRepo.getDsEditData(wfId);
		
		return getData;
	}

}
