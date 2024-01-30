package com.Backend.VueFrame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.VueFrame.Model.VfVRMRatingData;

public interface VfVrmRatingRepo  extends JpaRepository<VfVRMRatingData, String>{

}
