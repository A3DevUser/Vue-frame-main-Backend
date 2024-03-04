package com.Backend.VueFrame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.AuthRequest;
import com.Backend.VueFrame.Model.UserInfo;
import com.Backend.VueFrame.Services.LoggerService;
import com.Backend.VueFrame.Services.UserInfoService;
import com.Backend.VueFrame.security.JwtService; 

@RestController
@RequestMapping("/auth") 
@CrossOrigin(origins  =  "*")
public class UserController { 

	@Autowired
	private UserInfoService service; 

	@Autowired
	private JwtService jwtService; 
	
	@Autowired
	private LoggerService logServ;

	@Autowired
	private AuthenticationManager authenticationManager; 

	//not in use
	@GetMapping("/welcome") 
	public String welcome() { 
		return "Welcome this endpoint is not secure"; 
	} 
	//not in use
	@GetMapping("/user/welcomeSecure") 
	public String welcomeSecure() { 
		return "Welcome this endpoint is secure"; 
	} 
	//not in use
	@PostMapping("/addNewUser") 
	public String addNewUser(@RequestBody UserInfo userInfo) { 
		return service.addUser(userInfo); 
	} 
	//not in use
	@GetMapping("/user/userProfile") 
	@PreAuthorize("hasAuthority('ROLE_USER')") 
	public String userProfile() { 
		return "Welcome to User Profile"; 
	} 
	//not in use
	@GetMapping("/admin/adminProfile") 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	public String adminProfile() { 
		return "Welcome to Admin Profile"; 
	} 

	@PostMapping("/generateToken") 
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
		System.out.println("Inside authenticateAndGetToken authRequest = " + authRequest.toString());
		 logServ.log("e", "JWT Token Generation", "Error Details" + authRequest);
		 logServ.log("d", "debug", "Error Details" + authRequest);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
		if (authentication.isAuthenticated()) { 
			return jwtService.generateToken(authRequest.getUsername()); 
		} else { 
			throw new UsernameNotFoundException("invalid user request !"); 
		} 
	} 

} 
