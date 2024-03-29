package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Backend.VueFrame.Model.DropDownParamModel;
import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Repository.DropDownParamRepo;

@Service
public class DropDownParamService {

	@Autowired
	private DropDownParamRepo eDropRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	 public DropDownParamModel setParamData(DropDownParamModel setData) {
		 
		 if(setData.getparamId() == null) {
			 String formattedParamId = a3PlanServ.getSeqId("DropDownParamSeqId");
//			 String formattedParamId = "P-" + seq;
			 setData.setparamId(formattedParamId);
			 return setData;
		 }
		 
		 return setData;
		    
	 }
	
	public List<DropDownParamModel> setDataDropDownParam(List <DropDownParamModel> setData){
		List<DropDownParamModel> list = eDropRepo.saveAllAndFlush(setData);
		return list;
		
	}
}
