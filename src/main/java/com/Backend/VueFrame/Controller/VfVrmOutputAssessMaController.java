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

import com.Backend.VueFrame.Model.VfVrmOutputAssessMa;
import com.Backend.VueFrame.Model.VfVrmOutputAssessTpre;
import com.Backend.VueFrame.Services.VfVrmOutputAssessMaServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfVrmOutputAssessMaController {
	
	@Autowired
	private VfVrmOutputAssessMaServices vfVrmOutputAssessMaServ;
	
	//not in use
	@PostMapping("setAssessMaData")
	public Object setAssessMaData(@RequestBody List<VfVrmOutputAssessMa> setData) {
		
		Map<String,Object> obj = new HashMap<>();

		 for (VfVrmOutputAssessMa i :  setData) {
			 vfVrmOutputAssessMaServ.setAssessMaSeq(i);
		 }
		 
		 List<VfVrmOutputAssessMa> list = vfVrmOutputAssessMaServ.setAssessMaData(setData);
		 
		 return obj;
	}
}
