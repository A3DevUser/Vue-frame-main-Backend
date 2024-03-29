package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Services.vfConfEditableCellPathServices;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins="*")
public class vfConfEditableCellPath {
	@Autowired
	private vfConfEditableCellPathServices vfConfEditableCellPathServ;
	
	@GetMapping("getEditableCellPath") 
	public String getEditableCellPath(){
		return vfConfEditableCellPathServ.getEditableCellPath();
	}
	
	
	@GetMapping("getEditableGidFormId") 
	public String getEditableGidFormId(){
		return vfConfEditableCellPathServ.getEditableGidFormId();
	}

}
