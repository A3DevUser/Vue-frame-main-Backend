package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.VueFrame.Model.VfA3ColumnHeader;

public interface VfA3ColumnHeaderRepository extends JpaRepository<VfA3ColumnHeader, Integer>{
	

//	List<VfA3ColumnHeader> getByFormId(formId);//

//	List<VfA3ColumnHeader> getByFormId(String formId);

	
	List<VfA3ColumnHeader> getByFormIdAndAreaNameAndPortfolio(String formId, 
			String areaName, String portfolio);

	List<VfA3ColumnHeader> getByFormIdAndAreaName(String formId, String areaName);


	List<VfA3ColumnHeader> getByFormIdAndIsPageType(String formId, String isPageType);

	List<VfA3ColumnHeader> getByFormId(String formId);
}
