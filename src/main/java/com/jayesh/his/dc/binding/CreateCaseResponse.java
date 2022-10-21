package com.jayesh.his.dc.binding;

import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponse {
	private Long caseNo;
	private Map<Integer, String> planNames;

}
