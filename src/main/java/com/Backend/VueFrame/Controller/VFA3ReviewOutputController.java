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

import com.Backend.VueFrame.Model.VFA3ReviewOutputData;
import com.Backend.VueFrame.Model.VFA3ReviewOutputData;
import com.Backend.VueFrame.Repository.VFA3ReviewOutputRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VFA3ReviewOutputController {
	
	@Autowired
	private VFA3ReviewOutputRepository vfReviewRepo;
	
	
	@PostMapping("SubmitReviewData")
	public List<VFA3ReviewOutputData> submitData(@RequestBody List<VFA3ReviewOutputData> testItems) {
	    List<VFA3ReviewOutputData> out = new ArrayList<>();

	    for (VFA3ReviewOutputData obj : testItems) {
	         obj.setIdData("Review-".concat(obj.getId().concat("-").concat(obj.getTestId().concat("-").concat(obj.getVF_MAIN_OBJ_ID()))));
	            	out.add(obj);
	            	}	
			 
			 
			List<VFA3ReviewOutputData>  list = vfReviewRepo.saveAllAndFlush(out);
			
			
			return list;	
	}
	
	
	
	@GetMapping("fetchDataId")
	public List<VFA3ReviewOutputData> getData() {
		
		return vfReviewRepo.findAll();
	}


}
