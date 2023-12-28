package com.Backend.VueFrame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.VueFrame.Model.TaskConfColumnHeader;
import com.Backend.VueFrame.Services.TaskConfColumnHeaderServices;


@RestController
@RequestMapping("VF/")
@CrossOrigin(origins = "*")
public class TaskConfColumnHeaderController {
	
	@Autowired
	private TaskConfColumnHeaderServices taskConfColumnHeaderServ;
	
	
	@GetMapping("getTaskConfColumn")
	public List<TaskConfColumnHeader> getTaskConfColumnHeader() {
		
		return taskConfColumnHeaderServ.getTaskConfColumnHeader();
	}
	
	@GetMapping("getTasksByUser")
	public String getTasksByUser(@RequestParam String currUser) {
		
		return taskConfColumnHeaderServ.getTasksByUser(currUser);
	}
}
