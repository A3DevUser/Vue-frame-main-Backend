package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VfActActionsData;
import com.Backend.VueFrame.Services.VfActActionsServices;

@RestController
@RequestMapping("VF/")
//@CrossOrigin(origins = "*")
public class VfActActionsController {
	
	@Autowired
	private VfActActionsServices vfActActionsServ;
	
	
	@GetMapping("getActions")
	public List<VfActActionsData> fetchActionData(@RequestParam String currUser)
	{
		
		System.out.println("Inside get api");
		return vfActActionsServ.getActionData( currUser);
	}
}
