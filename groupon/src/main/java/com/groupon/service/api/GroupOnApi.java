package com.groupon.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.service.model.GroupOnModel;
import com.groupon.service.repository.GroupOnRepository;

@RestController
public class GroupOnApi {
	
	@Autowired
	GroupOnRepository groupOnRepository;
	
	@PostMapping("/company")
	public void createCompany(@RequestBody GroupOnModel groupOn) {
		groupOnRepository.save(groupOn);
	}
	
	@PutMapping("/company")
	public void updateCompany(@RequestBody GroupOnModel groupOn) {
		groupOnRepository.update(groupOn);
	}
	
	@DeleteMapping("/company")
	public void deleteCompany(@RequestBody GroupOnModel groupOn) {
		groupOnRepository.delete(groupOn);
	}
	
	@GetMapping("/company")
	public String[] getCompanies() {
		return groupOnRepository.getAll();
	}
	
	
}
