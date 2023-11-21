package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.VfActActionsData;

@Repository
public interface VfActActionsRepository extends JpaRepository<VfActActionsData, String>{
	
	List<VfActActionsData> findByOwner(String owner);
}
