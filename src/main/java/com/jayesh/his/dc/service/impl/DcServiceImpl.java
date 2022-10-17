package com.jayesh.his.dc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.his.dc.binding.Child;
import com.jayesh.his.dc.binding.Education;
import com.jayesh.his.dc.binding.Income;
import com.jayesh.his.dc.binding.PlanSelection;
import com.jayesh.his.dc.entity.DcCase;
import com.jayesh.his.dc.entity.DcChildren;
import com.jayesh.his.dc.entity.DcEducation;
import com.jayesh.his.dc.entity.DcIncome;
import com.jayesh.his.dc.repo.DcCasesRepo;
import com.jayesh.his.dc.repo.DcChildrenRepo;
import com.jayesh.his.dc.repo.DcEducationRepo;
import com.jayesh.his.dc.repo.DcIncomeRepo;
import com.jayesh.his.dc.repo.PlanRepo;
import com.jayesh.his.dc.service.DcService;
@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private DcIncomeRepo incomeRepo;
	@Autowired
	private DcEducationRepo educationRepo;
	@Autowired
	private DcChildrenRepo childrenRepo;
	@Autowired
	private DcCasesRepo casesReo;
	
	@Override
	public List<String> getPlanNames() {
		return planRepo.findPlanNames();
	}

	@Override
	public Long loadCaseNo(Integer appId) {
		Optional<Long> maxCaseNo = casesReo.findMaxCaseNo();
		DcCase dcCase=new DcCase();
		dcCase.setAppId(appId);
		if(maxCaseNo.isPresent()) {
			dcCase.setCaseNo(maxCaseNo.get()+1);
		}
		else {
			dcCase.setCaseNo(1L);
		}
		
		DcCase savedcase = casesReo.save(dcCase);
		return savedcase.getCaseNo();
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
		Optional<DcCase> findByCaseNo = casesReo.findByCaseNo(planSelection.getCaseNo());
		if(findByCaseNo.isPresent()) {
			DcCase dcCase = findByCaseNo.get();
			BeanUtils.copyProperties(planSelection, dcCase);
			DcCase updatedCase = casesReo.save(dcCase);
			return updatedCase.getCaseNo();
		}
		else
			return null;
	}

	@Override
	public Long saveIncomeData(Income income) {
		DcIncome dcIncome=new DcIncome();
		BeanUtils.copyProperties(income, dcIncome);
		DcIncome savedIncome = incomeRepo.save(dcIncome);
		return savedIncome.getCaseNo();
	}

	@Override
	public Long saveEducation(Education education) {
		DcEducation dcEducation=new DcEducation();
		BeanUtils.copyProperties(education, dcEducation);
		DcEducation savedEducation = educationRepo.save(dcEducation);
		return savedEducation.getCaseNo();
	}

	@Override
	public Long saveChildren(List<Child> childs) {

		List<DcChildren> dcChildrens=new ArrayList<>();
		
		for(Child child :childs) {
			DcChildren children=new DcChildren();
			BeanUtils.copyProperties(child, children);
			dcChildrens.add(children);
		}
		List<DcChildren> saveAll = childrenRepo.saveAll(dcChildrens);
		return saveAll.get(0).getCaseNo();
	}

}
