package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.VueFrame.Model.Emailsample;
import com.Backend.VueFrame.Model.WfEmailConfigData;

public interface WfEmailConfigRepository extends JpaRepository<Emailsample, String> {
	
	@Query(value = "SELECT VF_EMAIL_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	String setEcSequence();

	List<Emailsample> findByStatus(String string);

//	List<WfEmailConfigData> saveAllAndFlush(List<WfEmailConfigData> setData);
	
	
	

}