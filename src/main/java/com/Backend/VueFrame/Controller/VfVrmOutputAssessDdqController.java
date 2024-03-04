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

import com.Backend.VueFrame.Model.VfVrmOutputAssessDdq;
import com.Backend.VueFrame.Model.VfVrmOutputAssessMa;
import com.Backend.VueFrame.Services.VfVrmOutputAssessDdqServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfVrmOutputAssessDdqController {
	
	@Autowired
	private VfVrmOutputAssessDdqServices vfVrmOutputAssessDdqServ;
	
	//not in use
	@PostMapping("setAssessDdqData")
	public Object setAssessDdqData(@RequestBody List<VfVrmOutputAssessDdq> setData) {
		
		Map<String,Object> obj = new HashMap<>();

		 for (VfVrmOutputAssessDdq i :  setData) {
			 vfVrmOutputAssessDdqServ.setAssessDdqSeq(i);
		 }
		 
		 List<VfVrmOutputAssessDdq> list = vfVrmOutputAssessDdqServ.setAssessDdqData(setData);
		 
		 return obj;
	}
	
}
