package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Backend.VueFrame.Model.TaskConfColumnHeader;
import com.Backend.VueFrame.Repository.TaskConfColumnHeaderRepository;

@Service
public class TaskConfColumnHeaderServices {
	
	@Autowired
	private TaskConfColumnHeaderRepository taskConfColumnHeaderRepo;
	
	
	public List<TaskConfColumnHeader> getTaskConfColumnHeader() {
		
		return taskConfColumnHeaderRepo.findAll();
	}
}
