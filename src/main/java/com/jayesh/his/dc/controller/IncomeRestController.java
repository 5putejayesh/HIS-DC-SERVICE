package com.jayesh.his.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.dc.binding.Income;
import com.jayesh.his.dc.service.DcService;

@RestController
public class IncomeRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody Income income){
		Long caseNo = dcService.saveIncomeData(income);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
}
