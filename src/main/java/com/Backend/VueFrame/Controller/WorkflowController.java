package com.Backend.VueFrame.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.FormData;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Services.LoggerService;
import com.Backend.VueFrame.Services.WorkflowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class WorkflowController {

	
	@Autowired
	private WorkflowService workFlowServ;
	
	@Autowired
	private LoggerService logServ;
	
	@GetMapping("getWFName")
	public List<WorkflowData> getWorkFlowData(@RequestParam String formId) {
		
		return workFlowServ.getWorkFlowData(formId);
	}
	
	
//	@PostMapping("callWorkflowProcedure")
//    public void callWorkflowProcedure(@RequestBody String jsonData) {
//		workFlowServ.callWorkflowProcedure(jsonData);
//S
//    }
//	
	@PostMapping("callWorkflowProcedure")
	public String insertData(@RequestBody(required = false) String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
	    if (json != null) {
//	        logServ.log("e", "Error", "Error Details" + json);
//	        logServ.log("d", "Debug Subject", "Debug Details" + json);
	        workFlowServ.callInsertDataFromDynamicJsonArray(json, currLoggedInUser);
	    }

	    return json;
	}
	
	
	@PostMapping("importExportAddData")
	public void importExportAddData(@RequestBody(required = false) String json) throws JsonMappingException, JsonProcessingException {
		
		workFlowServ.callImportExportAddData(json);
	}
	
	
	
//	
//	 @PostMapping("callWorkflowProcedure")
//	    public String callWorkflowProcedure(@RequestBody String json, @RequestParam(required = false) String GRID_ID) {
//
//		 logServ.log("e", "Error", "Error Details" + json);
//	        logServ.log("d", "Debug Subject", "Debug Details" + json);
//
//	        workFlowServ.callInsertDataFromDynamicJsonArray(json);
//
//	        if (GRID_ID != null) {
//	            workFlowServ.callSetGridData(GRID_ID);
//	        }
//
//	        return json;
//	    }
//	 
	 
	
	
	 
//	@PostMapping("setWorkFlowGridData")
//    public void setWFGridData(@RequestBody Map<String, String> request) {
//		workFlowServ.setWFGridData1(
//				request.get("VF_STAGE"),
//				request.get("VF_STATUS"),
//				request.get("VF_ACTION"),
//				request.get("VF_ORGANISATION_ID"),
//				request.get("VF_ROLE"),
//				request.get("VF_PROCESS_INSTANCE_ID"),
//				request.get("VF_INSTANCE_ID"),
//				request.get("VF_CREATED_BY"),
//				request.get("VF_CREATED_ON"),
//				request.get("VF_MODIFIED_ON"),
//				request.get("VF_MODIFIED_BY"),
//				request.get("formId"),
//				request.get("VF_CURRENT_USER"),
//				request.get("VF_OBJ_ID"));
//		
//	}
				
	
//	 
	 
	 @PostMapping("setWorkflowData")
	 public Object setWorkflowData(@RequestBody List<WorkflowData> setData) {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (WorkflowData wf :  setData) {
			 workFlowServ.setWfId(wf);
             obj.put("wfId",wf.getWfId());
             obj.put("formId",wf.getFormId());
		 }
			 
		 List<WorkflowData> list = workFlowServ.setWorkflowData(setData);
		 
		 return obj;
		 
	 }
	 
	 
	 
	 //Get table data in JSON Format
	 @GetMapping("getTableData")
	 public String getJsonTableData(@RequestParam String formId, @RequestParam String VF_CURRENT_USER, 
			 						@RequestParam(name = "daysFlag", defaultValue = "NO_VALUE") String daysFlag) {
		 
		 System.out.println("INSIDE getJsonTableData");
		 return workFlowServ.getJsonData(formId, VF_CURRENT_USER, daysFlag);
	 }
	 
	 
	 @GetMapping("getMultRowData")
	 public String getMultRowData(@RequestParam String formId, @RequestParam String mainObjId) {
		 
		 return workFlowServ.getMultRowData(formId, mainObjId);
	 }
	 
	 
//	//Get table data in JSON Format
//		 @GetMapping("getTableData")
//		 public String getJsonTableData(@RequestParam String formId) {
//			 
//			 System.out.println("INSIDE getJsonTableData");
//			 return workFlowServ.getJsonData(formId);
//		 }
	 
	 
//	 @PostMapping("getWfMainData")
//	    public Map<String, String> getWfData(@RequestBody Map<String, String> params) {
//		 Map<String, String> list = workFlowServ.getWfData(params);
//		 return list;
//	       
//	    }
	 

	 @GetMapping("generateObjId")
	 public String getObjId(@RequestParam String formId) {
		 
		 String objId = workFlowServ.generateObjId(formId);
		 
		 System.out.println(objId);
		 
		 return objId;
	 }
	 
	 
	 // to get all form config data for form edit functionality
	 @GetMapping("getConfigData")
	 public String getConfigData(@RequestParam String formId) {
		 
		 String setData = workFlowServ.setConfigData(formId);
		 return setData;
	 }
	 
	 
	 // to get all workflow data for workflow edit functionality
	 @GetMapping("getWfEditData")
	 public String getWfEditData(@RequestParam String wfId) {
		 
		 String getData = workFlowServ.getWfEditData(wfId);
		 
		 return getData;
	 }
	  
	
}
