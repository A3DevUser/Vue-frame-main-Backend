package com.Backend.VueFrame.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Backend.VueFrame.Model.UserInfo;
 

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> { 
	Optional<UserInfo> findByName(String username); 
	
	
	@Query(value = "SELECT vf_user_id_seq.NEXTVAL FROM DUAL", nativeQuery = true)
	String setUserId();
	
}

