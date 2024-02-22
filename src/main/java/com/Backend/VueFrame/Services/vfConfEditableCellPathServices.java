package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.vfConfEditableCellPath;
import com.Backend.VueFrame.Repository.vfConfEditableCellPathRepository;

@Service
public class vfConfEditableCellPathServices {
	@Autowired
	private vfConfEditableCellPathRepository vfConfEditableCellPathRepo;
	
	public String getEditableCellPath(){
		return vfConfEditableCellPathRepo.getEditableCellPath();
	}
	
	
	public String getEditableGidFormId(){
		return vfConfEditableCellPathRepo.getEditableGidFormId();
	}

}
