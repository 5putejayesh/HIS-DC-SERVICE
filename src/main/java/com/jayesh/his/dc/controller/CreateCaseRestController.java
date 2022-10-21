package com.jayesh.his.dc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.dc.binding.CreateCaseResponse;
import com.jayesh.his.dc.binding.PlanSelection;
import com.jayesh.his.dc.service.DcService;

@RestController
public class CreateCaseRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId){
		
		Long caseNo = dcService.loadCaseNo(appId);
		Map<Integer, String> plans = dcService.getPlanNames();
		
		CreateCaseResponse response= new CreateCaseResponse();
		response.setCaseNo(caseNo);
		response.setPlanNames(plans);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
