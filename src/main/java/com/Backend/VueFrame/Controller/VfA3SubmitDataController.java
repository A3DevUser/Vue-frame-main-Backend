package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.A3TestData;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3SubmitDataController {
	
	
//	@PostMapping("SubmitA3Data")
//	public List<String> submitData(@RequestBody List<String> setData) {
//
//	    List<String> out = new ArrayList<>();
//
//	    for (String obj : setData) {
//	        out.add(obj);
//	       
//	        String savedObj = saveAndFlush(obj);
//	        out.add(savedObj);
//	    }
//
//	    return out;
//	}
//
//	private String saveAndFlush(String obj) {
//	    
//	    String savedObj = "Saved: " + obj;
//	    return savedObj;
//	}

	
	@PostMapping("SubmitA3Data")
	public List<String> submitData(@RequestBody List<A3TestData> testItems) {
	    List<String> out = new ArrayList<>();

	    for (A3TestData item : testItems) {
	        // Your processing logic here
	        out.add(item.getResponse());
	    }

	    return out;
	}



	}


