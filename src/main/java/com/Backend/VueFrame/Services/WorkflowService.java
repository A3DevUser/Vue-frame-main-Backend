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


public Map<String, String> getWfData(@RequestBody Map<String, String> params) {
    // Your logic here, if needed

    // Creating a response map for demonstration purposes
    Map<String, String> response = new HashMap<>();
    response.put("stage", params.get("stage"));
    response.put("status", params.get("status"));
    response.put("action", params.get("action"));
    response.put("org", params.get("org"));
    response.put("role", params.get("role"));
    response.put("pid", params.get("pid"));
    response.put("instanceId", params.get("instanceId"));
    response.put("createdBy", params.get("createdBy"));
    response.put("createdOn", params.get("createdOn"));
    response.put("modifiedOn", params.get("modifiedOn"));
    response.put("modifiedBy", params.get("modifiedBy"));
    response.put("objId", params.get("objId"));
    response.put("formId", params.get("formId"));
    response.put("currentUser", params.get("currentUser"));


    

    return response;
}
          
          

}
