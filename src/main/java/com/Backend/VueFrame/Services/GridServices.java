package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Backend.VueFrame.Model.GridData;
import com.Backend.VueFrame.Repository.GridRepository;

@Service
public class GridServices {

	
	@Autowired
	private GridRepository gridRepo;
	
	public String getGridData(@RequestParam String formId) {
		
		return gridRepo.getGridData(formId);
		
		
	}
	
	
	public List<GridData> setGridData(@RequestParam List<GridData> setData) {
		
		List<GridData> list = gridRepo.saveAll(setData);
		
		return list;
	}
}
