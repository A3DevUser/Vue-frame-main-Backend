package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VFA3OnBoardingOutputData;
import com.Backend.VueFrame.Model.VFA3ReviewOutputData;
import com.Backend.VueFrame.Model.VFA3ReviewOutputData;
import com.Backend.VueFrame.Repository.VFA3ReviewOutputRepository;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class VFA3ReviewOutputController {
	
	@Autowired
	private VFA3ReviewOutputRepository vfReviewRepo;
	
	
	@PostMapping("SubmitReviewData")
    public List<VFA3ReviewOutputData> submitData(@RequestBody List<VFA3ReviewOutputData> testItems) {
        List<VFA3ReviewOutputData> out = new ArrayList<>();

        for (VFA3ReviewOutputData obj : testItems) {
            String testId = obj.getTestId() != null ? obj.getTestId() : "";
            String associateVend = obj.getAssociate_Vend() != null ? obj.getAssociate_Vend() : "";
            String vfMainObjId = obj.getVF_MAIN_OBJ_ID() != null ? obj.getVF_MAIN_OBJ_ID() : "";

            obj.setId("Review-" + testId + associateVend + vfMainObjId);
            out.add(obj);
        }

        List<VFA3ReviewOutputData> list = vfReviewRepo.saveAllAndFlush(out);

        return list;
    }

    @GetMapping("getReviewOutpuByIds")
	
	public List<VFA3ReviewOutputData> getAccountById(@RequestParam List<String> id) {
	    

		
		List<VFA3ReviewOutputData> op = new ArrayList<>();
		
			List<VFA3ReviewOutputData> opTemp= vfReviewRepo.findAllById(id);
			
			op.addAll(opTemp);
         
			 
		
	return op;
    }
	


}
