package com.jayesh.his.dc.service;

import java.util.Map;

import com.jayesh.his.dc.binding.DcCasesDto;
import com.jayesh.his.dc.binding.DcChildrenDto;
import com.jayesh.his.dc.binding.DcEducationDto;
import com.jayesh.his.dc.binding.DcIncomeDto;

public interface DcService {

	public Map<Integer, String> getPlanCategories();
	public Integer createCase(DcCasesDto dcCasesDTO); // here dto contains only appId
	public boolean updatePlanToCase(DcCasesDto dcCasesDTO); //here dto contains case no and plan name based on that retrieve case Id and appId
	public boolean createIncomeDtls(DcIncomeDto incomeDto); // here dto contains case no,emp income and property income
	public boolean createEducationDtls(DcEducationDto educationDto); //here dto contains caseNo,highestQual,gradYear and universityName
	public boolean addChildrenDtls(DcChildrenDto childrenDto); // here dto contains caseNo and set<ChildDto>
}
