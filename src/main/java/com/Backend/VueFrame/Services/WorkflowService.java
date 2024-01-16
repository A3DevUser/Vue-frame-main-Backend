package com.Backend.VueFrame.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.FormData;
import com.Backend.VueFrame.Model.WorkflowData;
import com.Backend.VueFrame.Repository.WorkflowRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WorkflowService {
	
	@Autowired
	private WorkflowRepository workFlowRepo;
	
	public List<WorkflowData> getWorkFlowData(@RequestParam String formId) {
		
		return workFlowRepo.getByFormId(formId);
	}
	
	
	
//	public void callInsertDataFromDynamicJsonArray(String json) {
//		
//		System.out.println("json = " + json);
//		workFlowRepo.insertDataFromDynamicJsonArray(json);
//		
//		
//		
//    }
	
	
	public void callInsertDataFromDynamicJsonArray(String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
		
		System.out.println("json = " + json);
		// data inserting in table.
		workFlowRepo.insertDataFromDynamicJsonArray(json);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, String>> list = mapper.readValue(json, ArrayList.class);
		
		for(Map<String, String> obj : list) {
			
			// this will give true/false if the current object's grid_id is "main grid" or not. 
			Map<String, String> isMainAndFomrIdMap = workFlowRepo.getIsMainAndFormId(obj.get("GRID_ID"));
			
			if(isMainAndFomrIdMap.get("IS_MAIN").equals("true")) {
				
				System.out.println("workflow running - "+obj);
				System.out.println(currLoggedInUser);
				
				
				if(obj.get("VF_CREATED_BY").isBlank()) {
					System.out.println("if working");
					workFlowRepo.setGridData1(
							obj.get("VF_STAGE"),
							obj.get("VF_STATUS"),
							obj.get("VF_ACTION"), 
							obj.get("VF_ORGANISATION_ID"),
							obj.get("VF_ROLE"),
							obj.get("VF_PROCESS_INSTANCE_ID"),
							obj.get("VF_INSTANCE_ID"),
							currLoggedInUser,
							obj.get("VF_CREATED_ON"),
							obj.get("VF_MODIFIED_ON"),
							obj.get("VF_MODIFIED_BY"),
							obj.get("formId"),
							obj.get("VF_CURRENT_USER"),
							obj.get("VF_MAIN_OBJ_ID"));	
				}
				else {
					System.out.println("else working");
					workFlowRepo.setGridData1(
							obj.get("VF_STAGE"),
							obj.get("VF_STATUS"),
							obj.get("VF_ACTION"), 
							obj.get("VF_ORGANISATION_ID"),
							obj.get("VF_ROLE"),
							obj.get("VF_PROCESS_INSTANCE_ID"),
							obj.get("VF_INSTANCE_ID"),
							obj.get("VF_CREATED_BY"),
							obj.get("VF_CREATED_ON"),
							obj.get("VF_MODIFIED_ON"),
							obj.get("VF_MODIFIED_BY"),
							obj.get("formId"),
							obj.get("VF_CURRENT_USER"),
							obj.get("VF_MAIN_OBJ_ID"));	
				}
				
			}	
		}
		
    }
	
	
	public void callImportExportAddData(String json) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, String>> list = mapper.readValue(json, ArrayList.class);
		
		List<Map<String, String>> returnList = new ArrayList<>();
		
		Map<String, String> objIdMap = new HashMap<>();
		
		List<String> defCols = workFlowRepo.getDefaultCols();
	
		
		for(Map<String, String> obj : list) {
			// {single object}
			Map<String, String> isMainAndFomrIdMap = workFlowRepo.getIsMainAndFormId(obj.get("GRID_ID"));
			
			String formId = isMainAndFomrIdMap.get("FORM_ID");
			
			if(isMainAndFomrIdMap.get("IS_MAIN").equals("true")) {
				
				for(String colName : defCols) {
					if(colName.equals("VF_MAIN_OBJ_ID")) {
						String generatedObjId = workFlowRepo.generateObjId(formId);
						obj.put(colName, generatedObjId);
						
						objIdMap.put(obj.get("MAIN OBJ ID"), generatedObjId);
					}
					else {
						obj.put(colName, "");
					}
				}
				
				// adding formId in every object
				obj.put("formId", formId);
				
				System.out.println(obj);
				
				returnList.add(obj);
			}
		}
		
		System.out.println(objIdMap);
		
		for(Map<String, String> obj : list) {
			
			Map<String, String> isMainAndFomrIdMap = workFlowRepo.getIsMainAndFormId(obj.get("GRID_ID"));
			
			String formId = isMainAndFomrIdMap.get("FORM_ID");

			if(isMainAndFomrIdMap.get("IS_MAIN").equals("false")) {
				
				for(String colName : defCols) {
					if(colName.equals("VF_MAIN_OBJ_ID")) {
						String val = obj.get("MAIN OBJ ID");
						obj.put(colName, objIdMap.get(val));
					}
					else if(colName.equals("VF_OBJ_ID")) {
						String v_grid_id = obj.get("GRID_ID");
						String getImportVfObjId = workFlowRepo.getImportVfObjIdSeq();
						String formatedObjId = v_grid_id+"-"+getImportVfObjId;
						obj.put(colName, formatedObjId);
					}
				}
				
				obj.put("formId", formId);
				
				System.out.println(obj);
				returnList.add(obj);
			}
		}
		
		System.out.println(returnList);
		String StrReturnList = mapper.writeValueAsString(returnList);
		
		System.out.println(StrReturnList);
		workFlowRepo.insertDataFromDynamicJsonArray(StrReturnList);
		
	}

	
	public void callSetGridData(String gridId) {
		workFlowRepo.setGridData(gridId);
	}
	
	
	public WorkflowData setWfId(@RequestBody WorkflowData setData) {
		if(setData.getWfId() == null) { // it's for workflow edit functionality
			String seq = workFlowRepo.setWfSequence();
		    String formattedWfId = "WF-" + seq;
		    setData.setWfId(formattedWfId);
		    return setData;
		}
		
		return setData;
	}
	
	public List<WorkflowData> setWorkflowData(@RequestParam List<WorkflowData> setData) {
		
		List<WorkflowData> list = workFlowRepo.saveAllAndFlush(setData);
		
		return list;
	}


	public String getJsonData(String formId, String VF_CURRENT_USER, String daysFlag) {
		System.out.println("iNSIDE getJsonData formId = " + formId);
		System.out.println("AFTER DATA FETCH => " + workFlowRepo.getJsonDataFromTable(formId, VF_CURRENT_USER, daysFlag));
		return workFlowRepo.getJsonDataFromTable(formId, VF_CURRENT_USER, daysFlag);
		
	}

	
	public String getMultRowData(String formId, String mainObjId) {
		
		return workFlowRepo.getMultRowData(formId, mainObjId);
	}



	public String generateObjId(String formId) {
		
		String objId = workFlowRepo.generateObjId(formId);
		
		return objId;
		
	}
	
	
	public String setConfigData(String formId) {
		
		String setData = workFlowRepo.setConfigData(formId);
		
		return setData;
	}
	
	
	public String getWfEditData(String wfId) {
		
		String getData = workFlowRepo.getWfEditData(wfId);
		
		return getData;
	}
	
	
	 public List<String> getColumnData(String gridId) {
	        return workFlowRepo.getColumnData(gridId);
	    }
	
	 // api creation from madhur sir
//	public List<Map<String, String>> getCoiResAndVenDtls() {
//		
//		List<Map<String, String>> list_of_obj = workFlowRepo.getCoiResAndVenDtls();
//		
//		System.out.println(list_of_obj);
//		
//		return list_of_obj;
//	}


//public void setWFGridData1(
//        String VF_STAGE,
//        String VF_STATUS,
//        String VF_ACTION,
//        String VF_ORGANISATION_ID,
//        String VF_ROLE,
//        String VF_PROCESS_INSTANCE_ID,
//        String VF_INSTANCE_ID,
//        String VF_CREATED_BY,
//        String VF_CREATED_ON,
//        String VF_MODIFIED_ON,
//        String VF_MODIFIED_BY,
//        String formId,
//        String VF_CURRENT_USER,
//        String VF_OBJ_ID
//) {
//	workFlowRepo.setGridData1(
//            VF_STAGE,
//            VF_STATUS,
//            VF_ACTION,
//            VF_ORGANISATION_ID,
//            VF_ROLE,
//            VF_PROCESS_INSTANCE_ID,
//            VF_INSTANCE_ID,
//            VF_CREATED_BY,
//            VF_CREATED_ON,
//            VF_MODIFIED_ON,
//            VF_MODIFIED_BY,
//            formId,
//            VF_CURRENT_USER,
//            VF_OBJ_ID
//    );
//}

	
}
