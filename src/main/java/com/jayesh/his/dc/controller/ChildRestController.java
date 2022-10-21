package com.jayesh.his.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.dc.binding.ChildRequest;
import com.jayesh.his.dc.binding.Summary;
import com.jayesh.his.dc.service.DcService;

@RestController
public class ChildRestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/childrens")
	public ResponseEntity<Summary> saveChilds(@RequestBody ChildRequest childRequest){
		Long caseNo = dcService.saveChildren(childRequest);
		Summary caseSummary = dcService.getCaseSummary(caseNo);
		return new ResponseEntity<Summary>(caseSummary,HttpStatus.OK);
	}
}
