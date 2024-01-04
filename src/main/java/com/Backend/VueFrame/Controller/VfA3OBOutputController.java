package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VFA3OnBoardingOutputData;
import com.Backend.VueFrame.Repository.VFA3OBOutputRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VfA3OBOutputController {
	
	
     @Autowired
     private VFA3OBOutputRepository vfa3TestRepo;

	
     @PostMapping("SubmitOnBoardingData")
     public List<VFA3OnBoardingOutputData> submitData(@RequestBody List<VFA3OnBoardingOutputData> testItems) {
         List<VFA3OnBoardingOutputData> out = new ArrayList<>();

         for (VFA3OnBoardingOutputData obj : testItems) {
             String testId = obj.getTestId() != null ? obj.getTestId() : "";
             String associateVend = obj.getAssociate_Vend() != null ? obj.getAssociate_Vend() : "";
             String vfMainObjId = obj.getVF_MAIN_OBJ_ID() != null ? obj.getVF_MAIN_OBJ_ID() : "";

             obj.setIdData("OB-" + testId + associateVend + vfMainObjId);
             out.add(obj);
         }

         List<VFA3OnBoardingOutputData> list = vfa3TestRepo.saveAllAndFlush(out);

         return list;
     }

     @GetMapping("getOBOutpuByIds")
 	
 	public List<VFA3OnBoardingOutputData> getAccountById(@RequestParam List<String> id) {
 	    

 		
 		List<VFA3OnBoardingOutputData> op = new ArrayList<>();
 		
 			List<VFA3OnBoardingOutputData> opTemp= vfa3TestRepo.findAllById(id);
 			
 			op.addAll(opTemp);
          
			 
		
	return op;
     }
	
//	@GetMapping("fetchDataId")
//	public List<VFA3OnBoardingOutputData> getData() {
//		
//		return vfa3TestRepo.findAll();
//	}



	}


