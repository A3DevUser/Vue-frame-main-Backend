package com.Backend.VueFrame.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.FormData;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.WorkflowRepository;

@Service
public class WorkflowService {
	
	@Autowired
	private WorkflowRepository workFlowRepo;
	
	public List<WorkflowData> getWorkFlowData(@RequestParam String formId) {
		
		return workFlowRepo.getByFormId(formId);
	}
	
	
	
	public void callInsertDataFromDynamicJsonArray(String json) {
		
		System.out.println("json = " + json);
		workFlowRepo.insertDataFromDynamicJsonArray(json);
		
		
		
    }
	
	public void callSetGridData(String gridId) {
		workFlowRepo.setGridData(gridId);
	}
	
	
	public WorkflowData setWfId(@RequestBody WorkflowData setData) {
		String seq = workFlowRepo.setWfSequence();
	    String formattedWfId = "WF-" + seq;
	    setData.setWfId(formattedWfId);
	    return setData;
	}
	
public List<WorkflowData> setWorkflowData(@RequestParam List<WorkflowData> setData) {
		
		List<WorkflowData> list = workFlowRepo.saveAll(setData);
		
		return list;
	}


public String getJsonData(String formId) {
	System.out.println("iNSIDE getJsonData formId = " + formId);
	System.out.println("AFTER DATA FETCH => " + workFlowRepo.getJsonDataFromTable(formId));
	return workFlowRepo.getJsonDataFromTable(formId);
	
}


public String generateObjId(String formId) {
	
	String objId = workFlowRepo.generateObjId(formId);
	
	return objId;
	
}


public void setWFGridData1(
        String VF_STAGE,
        String VF_STATUS,
        String VF_ACTION,
        String VF_ORGANISATION_ID,
        String VF_ROLE,
        String VF_PROCESS_INSTANCE_ID,
        String VF_INSTANCE_ID,
        String VF_CREATED_BY,
        String VF_CREATED_ON,
        String VF_MODIFIED_ON,
        String VF_MODIFIED_BY,
        String OBJ_ID,
        String formId,
        String VF_CURRENT_USER,
        String VF_OBJ_ID
) {
	workFlowRepo.setGridData1(
            VF_STAGE,
            VF_STATUS,
            VF_ACTION,
            VF_ORGANISATION_ID,
            VF_ROLE,
            VF_PROCESS_INSTANCE_ID,
            VF_INSTANCE_ID,
            VF_CREATED_BY,
            VF_CREATED_ON,
            VF_MODIFIED_ON,
            VF_MODIFIED_BY,
            OBJ_ID,
            formId,
            VF_CURRENT_USER,
            VF_OBJ_ID
    );
}
          
          

}
