package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.VfVrmOutputAssessDdq;
import com.Backend.VueFrame.Model.VfVrmOutputAssessMa;
import com.Backend.VueFrame.Repository.VfVrmOutputAssessDdqRepository;

@Service
public class VfVrmOutputAssessDdqServices {
	
	@Autowired
	private VfVrmOutputAssessDdqRepository vfVrmOutputAssessDdqRepo;
	
	public VfVrmOutputAssessDdq setAssessDdqSeq(@RequestBody VfVrmOutputAssessDdq setData) {
		String seq = vfVrmOutputAssessDdqRepo.setAssessDdqSeq();
	    String formattedSeq = "DDQ-" + seq;
	    setData.setDdqId(formattedSeq);
	    return setData;
	}
	
	
	public List<VfVrmOutputAssessDdq> setAssessDdqData(@RequestParam List<VfVrmOutputAssessDdq> setData) {
		
		List<VfVrmOutputAssessDdq> list = vfVrmOutputAssessDdqRepo.saveAllAndFlush(setData);
		
		return list;
		
	}
	
}
