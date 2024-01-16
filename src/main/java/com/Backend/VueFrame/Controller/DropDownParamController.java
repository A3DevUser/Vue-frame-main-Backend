package com.Backend.VueFrame.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.ColumnHeaderData;
import com.Backend.VueFrame.Model.DropDownData;
import com.Backend.VueFrame.Model.DropDownParamModel;
import com.Backend.VueFrame.Model.RptColumnDtls;
import com.Backend.VueFrame.Services.DropDownParamService;
import com.Backend.VueFrame.Services.RptDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("VF/")
@CrossOrigin(origins = "*")
@RestController
public class DropDownParamController {
	
	@Autowired
	private DropDownParamService eDropServ;
	
	@Autowired
	private RptDetailsServices rptDetailsServs;
	
	
	@PostMapping("setddparam")
	public  ResponseEntity<List<DropDownParamModel>> setDDParam (@RequestBody List<DropDownParamModel> ddData) throws JsonMappingException, JsonProcessingException{
		//List<DropDownParamModel> list = eDropServ.setDataDropDownParam(ddData);
		
	    List<DropDownParamModel> resultList = new ArrayList<>();

    	for (DropDownParamModel dropData :  ddData) {
    		DropDownParamModel updateData = eDropServ.setParamData(dropData);
            resultList.add(updateData);

//            obj.put("columnId",column.getColumnId());

    	}
    	
    	// using ObjectMapper dependancy to convert object into string.
    	ObjectMapper mapper = new ObjectMapper();
    	 		   
    	// converting object into string
    	String pJsonData = mapper.writeValueAsString(ddData);
    	 		
    	System.out.println(pJsonData);
    	 		
    	// Filtering json data for stored value
    	String filteredJsonData = rptDetailsServs.getJsonFilterforStoredVal(pJsonData);
    	 		
    	List<DropDownParamModel> convertedObject = mapper.readValue(filteredJsonData, new TypeReference<List<DropDownParamModel>>() {});
    	
    	List<DropDownParamModel> list = eDropServ.setDataDropDownParam(convertedObject);
        return new ResponseEntity<>(list, HttpStatus.OK);
	
	}	
	
	
	
	
	
	
}
