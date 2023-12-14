package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.RptFilterDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptFilterDtlsRepository;

@Service
public class RptFilterDtlsServices {
	
	@Autowired
	private RptFilterDtlsRepository rptFilterDtlsRepo;
	
	
	public RptFilterDtls setRptFilIdSeq(@RequestBody RptFilterDtls setData) {
		String seq = rptFilterDtlsRepo.setRptFilIdSeq();
	    String formattedSeq = "FIL-" + seq;
	    setData.setFilId(formattedSeq);
	    return setData;
	}
	
	public List<RptFilterDtls> setRptFilterDtls(@RequestParam List<RptFilterDtls> setData) {
		
		List<RptFilterDtls> list = rptFilterDtlsRepo.saveAllAndFlush(setData);
		
		return list;
	}
	
	
	public List<RptFilterDtls> getRptFilData(@RequestParam String rptId) {
		
		return rptFilterDtlsRepo.getByRptId(rptId);

	}
}
