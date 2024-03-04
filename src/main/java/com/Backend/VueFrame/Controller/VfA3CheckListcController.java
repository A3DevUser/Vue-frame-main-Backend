package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VfA3CheckListData;
import com.Backend.VueFrame.Repository.VfA3CheckListRepository;


@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3CheckListcController {
	
	
	@Autowired
	private VfA3CheckListRepository vfA3CheckListRepo;
	
	//not in use
	@GetMapping("VFA3Checklist")
	public List<VfA3CheckListData> getCheckListData(@RequestParam String formId) {
		return vfA3CheckListRepo.getByFormId(formId);
	}
	
	

}
