package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.A3TestData;

@Repository
public interface VFA3TestRepository extends JpaRepository<A3TestData, String> {
	
	
	
	
	

}
