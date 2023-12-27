package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.VueFrame.Model.TaskConfColumnHeader;

public interface TaskConfColumnHeaderRepository extends JpaRepository<TaskConfColumnHeader, String>{
	
	List<TaskConfColumnHeader> findAll();
}
