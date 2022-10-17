package com.jayesh.his.dc.service;


import java.util.List;

import com.jayesh.his.dc.binding.Child;
import com.jayesh.his.dc.binding.Education;
import com.jayesh.his.dc.binding.Income;
import com.jayesh.his.dc.binding.PlanSelection;

public interface DcService {

	public List<String> getPlanNames();
	public Long loadCaseNo(Integer appId);
	public Long savePlanSelection(PlanSelection planSelection); //here dto contains case no and plan name based on that retrieve case Id and appId
	public Long saveIncomeData(Income income); // here dto contains case no,emp income and property income
	public Long saveEducation(Education education); //here dto contains caseNo,highestQual,gradYear and universityName
	public Long saveChildren(List<Child> childs);
}
