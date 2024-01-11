package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.RptColumnDtlsRepository;

@Service
public class RptColumnDtlsServices {
	
	@Autowired
	private RptColumnDtlsRepository rptColumnDtlsRepo;
	
	
	public RptColumnDtls setRptColId(@RequestBody RptColumnDtls setData) {
		if(setData.getRptColId().isBlank()) {
			String seq = rptColumnDtlsRepo.setRptColIdSeq();
		    String formattedSeq = "RPTC-" + seq;
		    setData.setRptColId(formattedSeq);
		    return setData;
		}
		
		return setData;
	}
	
	public List<RptColumnDtls> setRptColDtls(@RequestParam List<RptColumnDtls> setData) {
		
		List<RptColumnDtls> list = rptColumnDtlsRepo.saveAllAndFlush(setData);
		
		return list;
	}
	
	
	public List<RptColumnDtls> getRptColData(@RequestParam String rptId) {
		
		return rptColumnDtlsRepo.getByRptId(rptId);
		
	}
}
