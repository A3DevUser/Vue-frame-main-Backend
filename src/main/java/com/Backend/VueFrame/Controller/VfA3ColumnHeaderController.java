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
	public List<VfA3ColumnHeader> getVfA3ColumnHeader (@RequestParam String formId) {
		return VfA3ColumnHeaderRepo.getByFormId(formId);
		
			
	}

}
