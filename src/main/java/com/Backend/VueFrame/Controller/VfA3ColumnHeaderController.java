package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VfA3ColumnHeader;
import com.Backend.VueFrame.Repository.VfA3ColumnHeaderRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3ColumnHeaderController {
	
	@Autowired
	private VfA3ColumnHeaderRepository VfA3ColumnHeaderRepo;
	
	
	@GetMapping("getVfA3ConfColumnHeader")
	public List<VfA3ColumnHeader> getVfA3ColumnHeader (@RequestParam String formId , @RequestParam String isPageType) {	
		return VfA3ColumnHeaderRepo.getByFormIdAndIsPageType(formId, isPageType);
		
			
	}
	
	
	@GetMapping("columnHeader")
	public List<VfA3ColumnHeader> getAllData(){
		return this.VfA3ColumnHeaderRepo.findAll();
	}
	
	//not in use
	@GetMapping("getByFormIdAndArea")
	public List<VfA3ColumnHeader> getSchemeCode (@RequestParam String formId,@RequestParam String areaName) {
		return VfA3ColumnHeaderRepo.getByFormIdAndAreaName(formId, areaName);
	
}
	
//	@GetMapping("getColumnHeader")
//	public List<VfA3ColumnHeader> getColumnHeader (@RequestParam String formId,  @RequestParam String areaName, @RequestParam String portfolio) {
//		return VfA3ColumnHeaderRepo.getByFormIdAndAreaNameAndPortfolio(formId, areaName, portfolio);
//	
	
	
	
	@GetMapping("getColumnHeader")
	public List<VfA3ColumnHeader> getColumnHeader (@RequestParam String formId) {
		return VfA3ColumnHeaderRepo.getByFormId(formId);
	
	
		
}
	
	
	
	
	
	
	
}
