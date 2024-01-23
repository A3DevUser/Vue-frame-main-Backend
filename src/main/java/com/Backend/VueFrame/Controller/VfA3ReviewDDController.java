package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VfA3ReviewDD;
import com.Backend.VueFrame.Repository.VfA3ReviewDDRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3ReviewDDController {
	
	
	@Autowired
	private VfA3ReviewDDRepository vfA3ReviewRepo;
	
	
	@GetMapping("getReviewData")
	public List<VfA3ReviewDD> getData() {
		
		return vfA3ReviewRepo.findAll();
	}
	
	
	@GetMapping("getReviewFreqDd")
	public String getReviewFreq(@RequestParam String reviewType) {
		
		return vfA3ReviewRepo.getReviewFreqDropdown(reviewType);
	}
	
	
	@GetMapping("getReviewSubFreqDD")
	public String getReviewSubFreqDD(@RequestParam String reviewFreq) {
	
	return vfA3ReviewRepo.getReviewSubFreqDropdown(reviewFreq);
	}
	
	
	@GetMapping("getA3ReviewOBData")
	public String getReviewOBData(@RequestParam String reviewFreq, @RequestParam String reviewSubFreq) {
		
		return vfA3ReviewRepo.getReviewA3Data(reviewFreq, reviewSubFreq);
	}
}
