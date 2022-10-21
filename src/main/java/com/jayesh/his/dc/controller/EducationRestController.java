package com.jayesh.his.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.dc.binding.Education;
import com.jayesh.his.dc.service.DcService;

@RestController
public class EducationRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/education")
	public ResponseEntity<Long> saveEducation(@RequestBody Education education){
		Long caseNo = dcService.saveEducation(education);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
}
