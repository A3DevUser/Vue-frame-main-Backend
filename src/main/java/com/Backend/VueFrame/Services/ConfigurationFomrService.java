package com.Backend.VueFrame.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.ColumnHeaderData;
import com.Backend.VueFrame.Model.GenerateSequenceData;
import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Model.NavBarData;
import com.Backend.VueFrame.Model.SectionData;
import com.Backend.VueFrame.Repository.ColumnHeaderRepository;
import com.Backend.VueFrame.Repository.GridRepository;
import com.Backend.VueFrame.Repository.NavBarRepository;
import com.Backend.VueFrame.Repository.SectionRepository;

@Service
public class ConfigurationFomrService {
	
	
	@Autowired
	private NavBarRepository navRepo;
	
	@Autowired
	private GridRepository gridRepo;
	
	@Autowired
	private SectionRepository sectionRepo;
	
	@Autowired
	private ColumnHeaderRepository columnRepo;
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;
//	
//    @Autowired
//    private GenerateSeqRepository generateSeqRepo;
//	

	
	//Generate FomrId
	public NavBarData setFormId(@RequestBody NavBarData setData) {
	    String formattedFormId = a3PlanServ.getSeqId("NavBarSeqId");
//	    String formattedFormId = "FORM-" + seq;
	    setData.setFormId(formattedFormId);
	    return setData;
	}
	
	 //Set Nav/Form Data in NavaBar Table
    public List<NavBarData> SetNavData(@RequestBody List<NavBarData> setData) {
		
		List<NavBarData> list = navRepo.saveAll(setData);
		
		return list;
	}
    
	
	
//	//Generate GridId
//	public String setGridId() {
//		return gridRepo.setGridSequence();
//	}
//	
	 //Set GridId in Grid Table
    
    public GridData setGridId(@RequestBody GridData setData) {
    	String formattedGridId = a3PlanServ.getSeqId("MainGridSeqId");
//    	String formattedGridId = "GID-" + seq;
    	setData.setGridId(formattedGridId);
    	return setData;
	}
    
    
   
    
    
//    public void setGridId(HashMap<String, String> gridMap) {
//        for (String gridName : gridMap.keySet()) {
//            String nextValue = gridRepo.setGridSequence();
//            String formattedGridId = "GID-" + nextValue; // Customize the prefix as needed
//            gridMap.put(gridName, formattedGridId);
//        }
//    }
    //set Grid Data in GridTable
    public List<GridData> setGridData(@RequestBody List<GridData> setData) {
        List<GridData> updatedGridDataList = new ArrayList<>();

        for (GridData gridData : setData) {
            // Set isView based on dbTableName (example logic, replace with your own logic)
        	
        	String isView;
        	
        	if(gridData.getDbTableName() != null) {
        		isView = gridData.getDbTableName().trim() + "_view";
        	}
        	else {
        		isView = gridData.getDbTableName() + "_view";
        	}
            
            gridData.setIsView(isView);

            // Save the updated GridData
            GridData savedGridData = gridRepo.saveAndFlush(gridData);
            updatedGridDataList.add(savedGridData);
        }

        return updatedGridDataList;
    }
     
      //Set SectionId in Section Table
	    public SectionData setSectionId(@RequestBody SectionData setData) {
	    	// if secId already not present (it's for form edit functionality)
	    	if(setData.getSecId() == null) {
	    		String formattedSecId = a3PlanServ.getSeqId("SectionSeqId");
//			    String formattedSecId = "S-" + seq;
			    setData.setSecId(formattedSecId);
			    return setData;
	    	}
		    
	    	return setData;
		}
	    
      
      
      
      //set SectionData in section Table
      public List<SectionData> setSectionData(@RequestParam List<SectionData> setData) {
  		
  		List<SectionData> list = sectionRepo.saveAllAndFlush(setData);
  		
  		return list;
  	}
      
      //setColumnId in Column Data Table
      
      
      
      
      
      
      public ColumnHeaderData setColumnId(@RequestBody ColumnHeaderData setData) {
    		String formattedColumnId = a3PlanServ.getSeqId("ColumnHeaderSeqId");
//      	    String formattedColumnId = "COL-" + seq;
      	    setData.setColumnId(formattedColumnId);
      	    return setData;
  	}
      
 
      
      //set ColumnData
      public List<ColumnHeaderData> SetColumnData(@RequestBody List<ColumnHeaderData> setData) {
  		
  		List<ColumnHeaderData> list = columnRepo.saveAllAndFlush(setData);
  		
  		return list;
  	}

	
      public String getmrowUpdate(String formId) {
		return gridRepo.getMrowData(formId);
      }

      
      
//      public List<GenerateSequenceData> setSeqData(@RequestBody List<String> setData) {
//    	  
//    	  List<GenerateSequenceData> list = generateSeqRepo.saveAll(setData);
//    	  
//    	  return list;
//      }
      
      
   // form edit functionality (to update vf_navbar_details and vf_grid_details)
      public void updateNavAndGrid(String pJsonData) {
    	  
    	  columnRepo.updateNavAndGrid(pJsonData);
      }
      
      
   // form edit functionality (to update vf_column_header)
      public void updateColumnHeader(String pJsonData) {
    	  
    	  columnRepo.updateColumnHeader(pJsonData);
      }
      
      
   // form edit functionality (to update vf_grid_details for multirow tables)
      public void updateMultGridDtls(String pJsonData) {
    	  
    	  columnRepo.updateMultGridDtls(pJsonData);
      }
	
}
	



 

