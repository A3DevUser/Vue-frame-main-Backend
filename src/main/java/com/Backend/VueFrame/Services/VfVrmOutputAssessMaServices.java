package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.VfVrmOutputAssessMa;
import com.Backend.VueFrame.Model.VfVrmOutputAssessTpre;
import com.Backend.VueFrame.Repository.VfVrmOutputAssessMaRepository;

@Service
public class VfVrmOutputAssessMaServices {
	
	@Autowired
	private VfVrmOutputAssessMaRepository vfVrmOutputAssessMaRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	public VfVrmOutputAssessMa setAssessMaSeq(@RequestBody VfVrmOutputAssessMa setData) {
		String formattedSeq = a3PlanServ.getSeqId("VfVrmOutputAssessMaSeqId");
//	    String formattedSeq = "MA-" + seq;
	    setData.setMaId(formattedSeq);
	    return setData;
	}
	
	
	public List<VfVrmOutputAssessMa> setAssessMaData(@RequestParam List<VfVrmOutputAssessMa> setData) {
		
		List<VfVrmOutputAssessMa> list = vfVrmOutputAssessMaRepo.saveAllAndFlush(setData);
		
		return list;
		
	}
}
