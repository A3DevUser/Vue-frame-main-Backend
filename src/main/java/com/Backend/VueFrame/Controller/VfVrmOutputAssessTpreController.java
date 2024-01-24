package com.Backend.VueFrame.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.RptDetails;
import com.Backend.VueFrame.Model.VfVrmOutputAssessTpre;
import com.Backend.VueFrame.Repository.VfVrmOutputAssessTpreRepository;
import com.Backend.VueFrame.Services.VfVrmOutputAssessTpreSevices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfVrmOutputAssessTpreController {
	
	@Autowired
	private VfVrmOutputAssessTpreSevices VfVrmOutputAssessTpreSevr;
	
	
	@PostMapping("setAssessTpreData")
	public Object setAssessTpreData(@RequestBody List<VfVrmOutputAssessTpre> setData) {
		
		Map<String,Object> obj = new HashMap<>();

		 for (VfVrmOutputAssessTpre i :  setData) {
			 VfVrmOutputAssessTpreSevr.setAssessTpreSeq(i);
		 }
		 
		 List<VfVrmOutputAssessTpre> list = VfVrmOutputAssessTpreSevr.setAssessTpreData(setData);
		 
		 return obj;
	}
}
