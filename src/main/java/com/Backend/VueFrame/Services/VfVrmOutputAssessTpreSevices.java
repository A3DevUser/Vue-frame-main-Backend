package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.RptDetails;
import com.Backend.VueFrame.Model.VfVrmOutputAssessTpre;
import com.Backend.VueFrame.Repository.VfVrmOutputAssessTpreRepository;

@Service
public class VfVrmOutputAssessTpreSevices {
	
	@Autowired
	private VfVrmOutputAssessTpreRepository vfVrmOutputAssessTpreRepo;
	
	public VfVrmOutputAssessTpre setAssessTpreSeq(@RequestBody VfVrmOutputAssessTpre setData) {
			String seq = vfVrmOutputAssessTpreRepo.setAssessTpreSeq();
		    String formattedSeq = "TPRE-" + seq;
		    setData.setTpreId(formattedSeq);
		    return setData;
	}
	
	
	public List<VfVrmOutputAssessTpre> setAssessTpreData(@RequestParam List<VfVrmOutputAssessTpre> setData) {
		
		List<VfVrmOutputAssessTpre> list = vfVrmOutputAssessTpreRepo.saveAllAndFlush(setData);
		
		return list;
		
	}
}
