package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VfVRMRatingData;
import com.Backend.VueFrame.Repository.VfVrmRatingRepo;



@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfVrmRatingController {
	
	
	
	@Autowired
	private VfVrmRatingRepo vfVrmRatingRepo;
	
	
	@PostMapping("setVRMRatingData")
	public List<VfVRMRatingData> setData(@RequestBody List<VfVRMRatingData> setData) {
		
		List<VfVRMRatingData> list = vfVrmRatingRepo.saveAllAndFlush(setData);
		
		return list;
	}
	
	

}
