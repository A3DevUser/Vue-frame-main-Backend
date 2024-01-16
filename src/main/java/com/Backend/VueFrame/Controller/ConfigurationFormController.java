package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.realm.CombinedRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.ColumnHeaderData;
import com.Backend.VueFrame.Model.CombinedData;
import com.Backend.VueFrame.Model.CombinedObject;
import com.Backend.VueFrame.Model.CombinedResultDTO;
import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.NavBarData;
import com.Backend.VueFrame.Model.SectionData;
import com.Backend.VueFrame.Repository.WorkflowRepository;
import com.Backend.VueFrame.Services.ColumnHeaderService;
import com.Backend.VueFrame.Services.ConfigurationFomrService;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;


@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class ConfigurationFormController {
	

	    @Autowired
	    private ConfigurationFomrService confService;
	    
	    @Autowired
	    private ColumnHeaderService confServ;
	    
	    @Autowired
	    private WorkflowRepository workflowRepo;
	    
	    @Autowired
		private RptDetailsServices rptDetailsServs;
	   

	    @PostMapping("postConfigData")
	    public Object configureAll(@RequestBody List<CombinedObject> combinedObjectList) throws JsonProcessingException {
	    	for(CombinedObject i : combinedObjectList) {
	    		System.out.println(i.getFormId());
	    	}
	    	
	    	Map<String,Object> obj = new HashMap<>();
	    	
	    	// if formId is null (it's for form edit functionality)
	    	if(combinedObjectList.get(0).getFormId() == null) {
	    		
	    		List<NavBarData> navBarDataList = new ArrayList<>();
		        List<GridData> gridDataList = new ArrayList<>();
		        
		        
		        
		        for (CombinedObject combinedObject : combinedObjectList) {
		          
		                // Create a new NavBarData instance
		                NavBarData navBarData = new NavBarData();
		                confService.setFormId(navBarData);	              
		                obj.put("formId",navBarData.getFormId());
		                navBarData.setNavName(combinedObject.getNavName());
		                navBarData.setNavStoredValue(combinedObject.getNavStoredValue());
		                navBarData.setNavigate("/GridForm");
		                navBarData.setSeqId(combinedObject.getSeqId());
		                navBarData.setCat(combinedObject.getCat());
		                navBarData.setTargetId(combinedObject.getTargetId());

		                navBarDataList.add(navBarData);

		                GridData gridData = new GridData();
		                confService.setGridId(gridData);
		                obj.put("gridId",gridData.getGridId());
		                gridData.setFormId(navBarData.getFormId());
		                gridData.setGridName(combinedObject.getGridName());
		                gridData.setDbTableName(combinedObject.getDbTableName());
		                gridData.setIsMrow(combinedObject.getIsMrow());
		                gridData.setIsMain("true");
		                gridData.setTargetId(combinedObject.getTargetId());
		                gridData.setIsMultiSelect(combinedObject.getIsMultiSelect());
		                gridData.setDsId(combinedObject.getDsId());
		                
		                
		                // Set other GridData fields as needed

		                // Set the gridId for GridData

		                // Add the GridData instance to the list
		                gridDataList.add(gridData);
		            }
		        

		        // Save the lists of NavBarData and GridData instances
		        List<NavBarData> updatedNavDataList = confService.SetNavData(navBarDataList);
		        List<GridData> savedGridDataList = confService.setGridData(gridDataList);

		        // You may want to return a response if needed
//		        List<String,String> Op = new List();
		        return ResponseEntity.ok(obj);
	    		
	    	}
	    	else {
	    		
	    		// using ObjectMapper dependancy to convert object into string.
	    		ObjectMapper mapper = new ObjectMapper();
	    		   
	    		// converting object into string
	    		String pJsonData = mapper.writeValueAsString(combinedObjectList);
	    		
	    		System.out.println(pJsonData);
	    		
	    		// Filtering json data for stored value
	    		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	    		
	    		confService.updateNavAndGrid(filteredJsonData);
	    	}
	    	
	    	return obj;
	        
	    }

	    
	    //Section Config Api
	    @PostMapping("postSectionData")
	    public Object getSecData(@RequestBody List<SectionData> secData) {
	    	
	        Map<String,Object> obj = new HashMap<>();
//    		HashMap<String, S> val = new HashMap<>();
	        
	    	for (SectionData sec :  secData) {
	    		confService.setSectionId(sec);
//	            obj.put("secId",sec.getSecId());
	            obj.put("formId", sec.getFormId());
//	            val.put("secId", sec.setSecName(sec.getSecId()));
	    	}
	    	List<SectionData> list = confService.setSectionData(secData);
	  		return obj;
	    }
	    	    
	    @PostMapping("postGridData")
	    public Object getGridData(@RequestBody List<GridData> gridData) throws JsonProcessingException {
	        Map<String,Object> obj = new HashMap<>();
	        
	        // taking 1st object's gridId
	        String gridId = gridData.get(0).getGridId();
	       
	        // using predefined method from workflowRepository to get is_main table or not.
	        Map<String, String> map1 = workflowRepo.getIsMainAndFormId(gridId);
	        
<<<<<<< HEAD
	        if(map1.get("IS_MAIN").equals("true")) {
=======
	        if(gridId == null || map1.get("IS_MAIN").equals("true")) { // if it is 'true' then it means new multirow creation is happening.
>>>>>>> 3166b297ba40cde3f5278386eab90985e012a527
	        
	        	String formId = null;
		    	for (GridData grid :  gridData) {
		    		confService.setGridId(grid);
		            obj.put("formId",grid.getFormId());
		            formId = grid.getFormId();	  
		            
		    	}
		    	List<GridData> list = confService.setGridData(gridData);
		    	String str = confService.getmrowUpdate(formId); 	    
		    	obj.put("errMsg",str);
		  		return obj;
	        }
	        else {
	        	
	        	// using ObjectMapper dependancy to convert object into string.
	    		ObjectMapper mapper = new ObjectMapper();
	    		   
	    		// converting object into string
	    		String pJsonData = mapper.writeValueAsString(gridData);
	    		
	    		System.out.println(pJsonData);
	    		
	    		// Filtering json data for stored value
	    		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	    		
	    		confService.updateMultGridDtls(filteredJsonData);
	        }
	        
	        return obj;       
	    }
		    
	    @PostMapping("postColumnData")
	    public Object getColumnData(@RequestBody List<ColumnHeaderData> columnData) throws JsonProcessingException {
	    	
	    	for(Object i : columnData) {
	    		System.out.println(i);
	    	}
	    	
	    	Map<String,Object> obj = new HashMap<>();
	    	
	    	// if 1st objects columnId is null (it's for form edit functionality)
	    	if(columnData.get(0).getColumnId() == null) {
	    		String formId = null;
		    	for (ColumnHeaderData column :  columnData) {
		    		confService.setColumnId(column);	            
		            obj.put("formId", column.getFormId());
		            formId = column.getFormId();	            
		    	}
		    	List<ColumnHeaderData> list = confService.SetColumnData(columnData);	
		    	String str = confServ.getGridDataResp(formId); 	    
		    	obj.put("errMsg",str);
		    	
		    	System.out.println(obj);
		  		return obj;
	    	}
	    	else {
	    		
	    		// using ObjectMapper dependancy to convert object into string.
	    		ObjectMapper mapper = new ObjectMapper();
	    		   
	    		// converting object into string
	    		String pJsonData = mapper.writeValueAsString(columnData);
	    		
	    		System.out.println(pJsonData);
	    		
	    		// Filtering json data for stored value
	    		String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
	    		
	    		confService.updateColumnHeader(filteredJsonData);
	    	}
	    	
	    	return obj;
	    	
	    }
	    

}


