package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.VFA3OnBoardingOutputData;

@Repository
public interface VFA3OBOutputRepository extends JpaRepository<VFA3OnBoardingOutputData, String> {
	
	
	
	
	

}
