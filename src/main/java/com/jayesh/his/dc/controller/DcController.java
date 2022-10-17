package com.jayesh.his.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.dc.binding.PlanSelection;
import com.jayesh.his.dc.service.DcService;

@RestController
public class DcController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/case/{appId}")
	public ResponseEntity<Long> createCase(@PathVariable Integer appId){
		return new ResponseEntity<>(dcService.loadCaseNo(appId),HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<Long> updatePlan(@RequestBody PlanSelection planSelection){
		return new ResponseEntity<>(dcService.savePlanSelection(planSelection),HttpStatus.OK);
	}
}
