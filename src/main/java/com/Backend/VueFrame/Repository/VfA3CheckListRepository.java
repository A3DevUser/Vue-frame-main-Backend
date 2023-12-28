package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.VfA3CheckListData;


@Repository
public interface VfA3CheckListRepository extends  JpaRepository<VfA3CheckListData, String> {

	List<VfA3CheckListData> getByFormId(String formId);
	
	

}
