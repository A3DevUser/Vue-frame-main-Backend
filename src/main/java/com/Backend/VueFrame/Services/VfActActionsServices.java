package com.Backend.VueFrame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.VueFrame.Model.VfActActionsData;
import com.Backend.VueFrame.Repository.VfActActionsRepository;

@Service
public class VfActActionsServices {
	
	@Autowired
	private VfActActionsRepository vfActActionsRepo;
	
	public List<VfActActionsData> getActionData( String currUser)
	{
		return vfActActionsRepo.findByOwner(currUser);
	}
	

}
