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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WorkflowService {
	
	@Autowired
	private WorkflowRepository workFlowRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
	
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
	
	
	public String callInsertDataFromDynamicJsonArray(String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
		
		System.out.println("json = " + json);
		ObjectMapper mapper = new ObjectMapper();
		
		// data inserting in table.
		String status = workFlowRepo.insertDataFromDynamicJsonArray(json);
		
		// if data is inserted successfully then workflow procedure will run.
		if (status.equals("Data Inserted Successfully!")) {
			
			
			List<Map<String, String>> list = mapper.readValue(json, ArrayList.class);
			
			for(Map<String, String> obj : list) {
				
				// this will give true/false if the current object's grid_id is "main grid" or not. 
				Map<String, String> isMainAndFomrIdMap = getIsMainAndFormId(obj.get("GRID_ID"));
				
				System.out.println(isMainAndFomrIdMap.get("FORM_ID"));
				
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
		
		else {
			return status;
		}
		
		return status;
		
    }
	
	
	public void callImportExportAddData(String json, String currLoggedInUser) throws JsonMappingException, JsonProcessingException {
		
		System.out.println("ImportExportAddData = "+json);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Map<String, String>> list = mapper.readValue(json, ArrayList.class);
		
		List<Map<String, String>> returnList = new ArrayList<>();
		
		Map<String, String> objIdMap = new HashMap<>();
		
		String arr_list = workFlowRepo.getDefaultCols();
		
		List<String> defCols = mapper.readValue(arr_list, ArrayList.class);
		
		System.out.println("defCols - "+defCols);
		
		System.out.println("converted json = "+list);
		
		for(Map<String, String> obj : list) {
			// {single object}
			Map<String, String> isMainAndFomrIdMap = getIsMainAndFormId(obj.get("GRID_ID"));
			
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
				
				// adding $$ in VF_ORGANISATION_ID for drop down
				String orgValue = obj.get("VF_ORGANISATION_ID");
				
				if(orgValue.isBlank()) {
					System.out.println(orgValue);
				}
				else {
					obj.put("VF_ORGANISATION_ID",orgValue+"$$"+orgValue);
				}
				
				returnList.add(obj);
			}
		}
		
		System.out.println(objIdMap);
		
		for(Map<String, String> obj : list) {
			
			Map<String, String> isMainAndFomrIdMap = getIsMainAndFormId(obj.get("GRID_ID"));
			
			String formId = isMainAndFomrIdMap.get("FORM_ID");

			if(isMainAndFomrIdMap.get("IS_MAIN").equals("false")) {
				
				for(String colName : defCols) {
					if(colName.equals("VF_MAIN_OBJ_ID")) {
						String val = obj.get("MAIN OBJ ID");
						obj.put(colName, objIdMap.get(val));
					}
					else if(colName.equals("VF_OBJ_ID")) {
						String v_grid_id = obj.get("GRID_ID");
						String getImportVfObjId = a3PlanServ.getSeqId("WorkflowImpExpSeqId");
						String formatedObjId = v_grid_id+"-"+getImportVfObjId;
						obj.put(colName, formatedObjId);
					}
				}
				
				obj.put("formId", formId);
				
				System.out.println(obj);
				returnList.add(obj);
			}
		}
		
//		System.out.println(returnList);
		String StrReturnList = mapper.writeValueAsString(returnList);
		
		System.out.println("final result string list = "+StrReturnList);
//		workFlowRepo.insertDataFromDynamicJsonArray(StrReturnList);
		callInsertDataFromDynamicJsonArray(StrReturnList, currLoggedInUser);
		
	}
	
	
	public Map<String,String> getIsMainAndFormId(String gridId) throws JsonMappingException, JsonProcessingException {
		
		String data = workFlowRepo.getIsMainAndFormIdRepo(gridId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, String> map = mapper.readValue(data, HashMap.class);
		
		return map;
	}

	
	public void callSetGridData(String gridId) {
		workFlowRepo.setGridData(gridId);
	}
	
	
	public WorkflowData setWfId(@RequestBody WorkflowData setData) {
		if(setData.getWfId() == null) { // it's for workflow edit functionality
			String formattedWfId = a3PlanServ.getSeqId("WorkflowSeqId");
//		    String formattedWfId = "WF-" + seq;
		    setData.setWfId(formattedWfId);
		    return setData;
		}
		
		return setData;
	}
	
	public List<WorkflowData> setWorkflowData(@RequestParam List<WorkflowData> setData) {
		
		List<WorkflowData> list = workFlowRepo.saveAllAndFlush(setData);
		
		return list;
	}


	public List<Object> getJsonData(String formId, String VF_CURRENT_USER, String daysFlag) throws JsonMappingException, JsonProcessingException {
		System.out.println("iNSIDE getJsonData formId = " + formId);
		System.out.println("AFTER DATA FETCH => " + workFlowRepo.getJsonDataFromTable(formId, VF_CURRENT_USER, daysFlag));
		
		 ObjectMapper objectMapper = new ObjectMapper();

	        // Convert JSON string to List<Object>
	     List<Object> objectList = objectMapper.readValue(workFlowRepo.getJsonDataFromTable(formId, VF_CURRENT_USER, daysFlag), new TypeReference<List<Object>>() {});
	        
//		return workFlowRepo.getJsonDataFromTable(formId, VF_CURRENT_USER, daysFlag);
	     
	     return objectList;
		
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
	
	
	 public String getColumnData(String gridId) {
	        return workFlowRepo.getColumnData(gridId);
	    }
	 
	
	 public String getMultiColumnData(String gridId) {
	        return workFlowRepo.getMultiColumnData(gridId);
	    }

	public String getApprovedDataToAddTbl(String formId) {
		
		return workFlowRepo.getApprovedDataToAddTbl(formId);	    
	}
	 
	
}
