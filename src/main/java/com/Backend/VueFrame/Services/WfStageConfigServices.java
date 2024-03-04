package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.WfStageConfigData;
import com.Backend.VueFrame.Repository.WfStageConfigRepository;

@Service
public class WfStageConfigServices {
	
	@Autowired
	private WfStageConfigRepository wfStageConfigRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
	public WfStageConfigData setConfigId(WfStageConfigData setData) {
		System.out.println(setData);
		
		if(setData.getConfigId() == null) { // it's for workflow edit functionality
			String formatedstr = a3PlanServ.getSeqId("WfStageConfigSeqId");
//			String formatedstr = "SC-"+seq;
			setData.setConfigId(formatedstr);
			return setData;
		}
		
		System.out.println(setData);
		
		return setData;
	}
	
	public List<WfStageConfigData> setWfStageConfig(List<WfStageConfigData> setData) {
		
		System.out.println("setData before savaAllAndFlush = "+setData);
		
		List<WfStageConfigData> list = wfStageConfigRepo.saveAllAndFlush(setData);
		
		System.out.println("WfStageConfigData = "+list);
		return list;
	}
	
}


