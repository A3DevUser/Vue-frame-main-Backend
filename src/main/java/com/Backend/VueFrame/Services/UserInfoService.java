package com.Backend.VueFrame.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Backend.VueFrame.Model.NavBarData;
import com.Backend.VueFrame.Model.UserInfo;
import com.Backend.VueFrame.Repository.UserInfoRepository;



@Service
public class UserInfoService implements UserDetailsService { 

	@Autowired
	private UserInfoRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 
	
	@Autowired
	private A3ReviewPlanService a3PlanServ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 

		Optional<UserInfo> userDetail = repository.findByName(username); 

		// Converting userDetail to UserDetails 
		return userDetail.map(UserInfoDetails::new) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	} 
	
	
	
//	public String addUser(UserInfo userInfo) { 
//		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
//		userInfo.setId(114);
//		repository.save(userInfo); 
//		return "User Added Successfully"; 
//	} 

	
	 public String addUser(@RequestBody UserInfo userInfo) {
	        String UserId = a3PlanServ.getSeqId("UserInfoSeqId");
//	        String UserId = "USER-" + seq;
	        userInfo.setId(UserId);

	        userInfo.setPassword(encoder.encode(userInfo.getPassword()));

	        repository.save(userInfo);

	        return "User Added Successfully";
	    }
	
	

} 

