package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3SubmitDataController {
	
	
	@PostMapping("SubmitA3Data")
	public List<String> submitData(@RequestBody List<String> setData) {

	    List<String> out = new ArrayList<>();

	    for (String obj : setData) {
	        out.add(obj);
	       
	        String savedObj = saveAndFlush(obj);
	        out.add(savedObj);
	    }

	    return out;
	}

	private String saveAndFlush(String obj) {
	    
	    String savedObj = "Saved: " + obj;
	    return savedObj;
	}

		 


	}


