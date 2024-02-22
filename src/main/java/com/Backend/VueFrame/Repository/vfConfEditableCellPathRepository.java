package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.vfConfEditableCellPath;

@Repository
public interface vfConfEditableCellPathRepository extends JpaRepository<vfConfEditableCellPath, String> {
	
	
	List<vfConfEditableCellPath> findAll();
	
	@Procedure(procedureName = "VF_GET_EDITABLE_PATH_PROC", outputParameterName = "v_result")
    String getEditableCellPath();
	
	
	@Procedure(procedureName = "VF_GET_EDITABLE_GID_FORMID", outputParameterName = "v_result")
    String getEditableGidFormId();

}
