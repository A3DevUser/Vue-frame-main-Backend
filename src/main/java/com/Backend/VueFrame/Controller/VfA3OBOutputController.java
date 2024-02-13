package com.Backend.VueFrame.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.VFA3OnBoardingOutputData;
import com.Backend.VueFrame.Repository.VFA3OBOutputRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
             String testId = obj.getQUESTION_ID() != null ? obj.getQUESTION_ID() : "";
//             String associateVend = obj.getAssociate_Vend() != null ? obj.getAssociate_Vend() : "";
             String vfMainObjId = obj.getVF_MAIN_OBJ_ID() != null ? obj.getVF_MAIN_OBJ_ID() : "";

             obj.setId("OB-" + testId + vfMainObjId);
             out.add(obj);
         }
         
         System.out.println("out = "+out);

         List<VFA3OnBoardingOutputData> list = vfa3TestRepo.saveAllAndFlush(out);

         return list;
     }
     
     
//     @PostMapping("SubmitOnBoardingData")
//     public void submitData(@RequestBody String json) throws JsonMappingException, JsonProcessingException {
//    	 
//    	 ObjectMapper mapper = new ObjectMapper();
// 		
// 		 List<Map<String, String>> list = mapper.readValue(json, ArrayList.class);
//
//    	 for(Map<String, String> obj : list) {
//    		 System.out.println(obj);
//    	 }
//     }
     

     @GetMapping("getOBOutpuByIds")
 	
 	public List<VFA3OnBoardingOutputData> getAccountById(@RequestParam List<String> id) {
 	    

 		
 		List<VFA3OnBoardingOutputData> op = new ArrayList<>();
 		
// 		try {
// 			
// 			List<String> decodedIdS = new ArrayList<>();
// 			for (String encodeId : id) {
// 				String decodedId = URLDecoder.decode(encodeId, "UTF-8");
// 				decodedIdS.add(decodedId);
// 			}
// 			

 			List<VFA3OnBoardingOutputData> opTemp= vfa3TestRepo.findAllById(id);
 			
 			op.addAll(opTemp);
          
 			
// 		} catch (UnsupportedEncodingException e) {
// 			
//            e.printStackTrace();
//
// 					
	return op;
	
     }
	
	@GetMapping("fetchDataId")
	public List<VFA3OnBoardingOutputData> getData() {
		
		return vfa3TestRepo.findAll();
	}



	}


