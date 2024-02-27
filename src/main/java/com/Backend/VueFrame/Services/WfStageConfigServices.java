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
	
	
	public WfStageConfigData setConfigId(WfStageConfigData setData) {
		System.out.println(setData);
		
		if(setData.getConfigId() == null) { // it's for workflow edit functionality
			String seq = wfStageConfigRepo.setStageSequence();
			String formatedstr = "SC-"+seq;
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


