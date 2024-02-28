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
import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.WorkflowRepository;
import com.Backend.VueFrame.Services.LoggerService;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.Backend.VueFrame.Services.WorkflowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class WorkflowController {

	
	@Autowired
	private WorkflowService workFlowServ;
	
	@Autowired
	private LoggerService logServ;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	@Autowired
	private WorkflowRepository workFlowRepo;
	
	
	@GetMapping("getWFName")
	public List<WorkflowData> getWorkFlowData(@RequestParam String formId) {
		
		return workFlowServ.getWorkFlowData(formId);
	}
	
	
//	@PostMapping("callWorkflowProcedure")
//    public void callWorkflowProcedure(@RequestBody String jsonData) {
//		workFlowServ.callWorkflowProcedure(jsonData);
//S
//    }
	
	@PostMapping("callWorkflowProcedure")
	public Map<String, String> insertData(@RequestBody(required = false) String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
	    
		String status = "";
		
		Map<String, String> alert_msg = new HashMap<>();
		
		if (json != null) {
//	        logServ.log("e", "Error", "Error Details" + json);
//	        logServ.log("d", "Debug Subject", "Debug Details" + json);
			status = workFlowServ.callInsertDataFromDynamicJsonArray(json, currLoggedInUser);
	    }
		
		if (status.equals("Data Inserted Successfully!")) {
			alert_msg.put("valid", "true");
			alert_msg.put("message", "Data Inserted Successfully!");
		}
		else if (status.equals("Data Already Exist")) {
			alert_msg.put("valid", "false");
			alert_msg.put("message", "Data Already Exist");
		}
		else {
			
			alert_msg.put("valid", "false");
			alert_msg.put("message", "Failed To Insert Data");
		}
		
	    return alert_msg;
	}
	
	
	@PostMapping("importExportAddData")
	public void importExportAddData(@RequestBody(required = false) String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
		
		workFlowServ.callImportExportAddData(json, currLoggedInUser);
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
	 public Object setWorkflowData(@RequestBody List<WorkflowData> setData) throws JsonProcessingException {
		 
	     Map<String,Object> obj = new HashMap<>();

		 for (WorkflowData wf :  setData) {
			 workFlowServ.setWfId(wf);
             obj.put("wfId",wf.getWfId());
             obj.put("formId",wf.getFormId());
		 }
		 
		// using ObjectMapper dependancy to convert object into string.
	 	ObjectMapper mapper = new ObjectMapper();
	 		   
	 	// converting object into string
	 	String pJsonData = mapper.writeValueAsString(setData);
	 		
	 	System.out.println(pJsonData);
	 		
	 	// Filtering json data for stored value
	 	String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	 		
	 	List<WorkflowData> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<WorkflowData>>() {});
	 		
			 
		List<WorkflowData> list = workFlowServ.setWorkflowData(convertedObject);
		 
		 return obj;
		 
	 }
	 
	 
	 
	 //Get table data in JSON Format
	 @GetMapping("getTableData")
	 public List<Object> getJsonTableData(@RequestParam String formId, @RequestParam String VF_CURRENT_USER, 
			 						@RequestParam(name = "daysFlag", defaultValue = "NO_VALUE") String daysFlag) throws JsonMappingException, JsonProcessingException {
		 
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
	 
	 
	 @GetMapping("getMultiColumnData")
	    public String getColumnData(@RequestParam String gridId) {
	        return workFlowServ.getColumnData(gridId);
	    }
	 

	 
	 @GetMapping("getMultiData")
	    public String getMultiColumnData(@RequestParam String gridId) {
	        return workFlowServ.getMultiColumnData(gridId);
	    }
	 
	 @PostMapping("insertAuditId")
	    public void insertAuditId(@RequestBody String auditId) {
		 workFlowRepo.setAuditId(auditId);
	    }
	 
	@GetMapping("getApprovedDataToAddTbl")
	public String getApprovedDataToAddTbl(String formId) {
			
		return workFlowServ.getApprovedDataToAddTbl(formId);    
	}
	 
	
}
