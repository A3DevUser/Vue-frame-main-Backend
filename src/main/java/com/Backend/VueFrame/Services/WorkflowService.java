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
    response.put("VF_STAGE", params.get("VF_STAGE"));
    response.put("VF_STATUS", params.get("VF_STATUS"));
    response.put("VF_ACTION", params.get("VF_ACTION"));
    response.put("VF_ORGANISATION_ID", params.get("VF_ORGANISATION_ID"));
    response.put("VF_ROLE", params.get("VF_ROLE"));
    response.put("VF_PROCESS_INSTANCE_ID", params.get("VF_PROCESS_INSTANCE_ID"));
    response.put("VF_INSTANCE_ID", params.get("VF_INSTANCE_ID"));
    response.put("VF_CREATED_BY", params.get("VF_CREATED_BY"));
    response.put("VF_CREATED_ON", params.get("VF_CREATED_ON"));
    response.put("VF_MODIFIED_ON", params.get("VF_MODIFIED_ON"));
    response.put("VF_MODIFIED_BY", params.get("VF_MODIFIED_BY"));
    response.put("OBJ_ID", params.get("OBJ_ID"));
    response.put("formId", params.get("formId"));
    response.put("VF_CURRENT_USER", params.get("VF_CURRENT_USER"));


    

    return response;
}
          
          

}
