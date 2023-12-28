package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.A3TestData;
import com.Backend.VueFrame.Repository.VFA3TestRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3SubmitDataController {
	
	
     @Autowired
     private VFA3TestRepository vfa3TestRepo;

	
	@PostMapping("SubmitA3Data")
	public List<A3TestData> submitData(@RequestBody List<A3TestData> testItems) {
	    List<A3TestData> out = new ArrayList<>();

	    for (A3TestData obj : testItems) {
	         obj.setIdData(obj.getId().concat(obj.getVendor_name()));
	            	out.add(obj);
	            	}	
			 
			 
			List<A3TestData>  list = vfa3TestRepo.saveAllAndFlush(out);
			
			
			return list;	
	}
	
	
	
	@GetMapping("fetchDataId")
	public List<A3TestData> getData() {
		
		return vfa3TestRepo.findAll();
	}



	}


