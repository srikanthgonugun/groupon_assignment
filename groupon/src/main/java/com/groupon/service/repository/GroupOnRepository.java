package com.groupon.service.repository;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import com.groupon.service.model.GroupOnModel;
import com.groupon.service.util.GroupOnList;

@Repository
public class GroupOnRepository {
	
	GroupOnList groupOnList = new GroupOnList();
	
	public void save(GroupOnModel groupOn) {
		groupOnList.add(groupOn.getCompanyName());		
	}
	
	public void delete(GroupOnModel groupOn) {
		groupOnList.removeByName(groupOn.getCompanyName());		
	}
	
	public void update(GroupOnModel groupOn) {
		groupOnList.updateByName(groupOn.getOldCompanyName(), groupOn.getCompanyName());		
	}
	
	public String[] getAll() {
		return groupOnList.getAll();
	}


}
