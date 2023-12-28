package com.Backend.VueFrame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.Backend.VueFrame.Model.TaskConfColumnHeader;

public interface TaskConfColumnHeaderRepository extends JpaRepository<TaskConfColumnHeader, String> {
	
	List<TaskConfColumnHeader> findAll();
	
	@Procedure(procedureName = "GET_TASKS_BY_USER", outputParameterName = "v_result")
	String getTasksByUser(@Param("v_curr_user") String currUser);
}
