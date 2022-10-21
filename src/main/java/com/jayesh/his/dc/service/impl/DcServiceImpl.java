package com.jayesh.his.dc.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.his.dc.binding.Child;
import com.jayesh.his.dc.binding.ChildRequest;
import com.jayesh.his.dc.binding.Education;
import com.jayesh.his.dc.binding.Income;
import com.jayesh.his.dc.binding.PlanSelection;
import com.jayesh.his.dc.binding.Summary;
import com.jayesh.his.dc.entity.DcCase;
import com.jayesh.his.dc.entity.DcChildren;
import com.jayesh.his.dc.entity.DcEducation;
import com.jayesh.his.dc.entity.DcIncome;
import com.jayesh.his.dc.entity.Plan;
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
	public Map<Integer,String> getPlanNames() {
		List<Plan> plans = planRepo.findAll();
		return plans.stream().collect(Collectors.toMap(Plan::getPlanId, Plan::getPlanName));
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
	public Long saveChildren(ChildRequest childRequest) {

		List<DcChildren> dcChildrens=new ArrayList<>();
		Long caseNo = childRequest.getCaseNo();
		for(Child child : childRequest.getChilds()) {
			DcChildren children=new DcChildren();
			BeanUtils.copyProperties(child, children);
			children.setCaseNo(caseNo);
			dcChildrens.add(children);
		}
		List<DcChildren> saveAll = childrenRepo.saveAll(dcChildrens);
		return saveAll.get(0).getCaseNo();
	}

	@Override
	public Summary getCaseSummary(Long caseNo) {
		Optional<DcCase> dcCase = casesReo.findByCaseNo(caseNo);
		if(dcCase.isPresent()) {
			DcCase caseDtl = dcCase.get();
			
			Summary  summary=new Summary();
			DcIncome dcIncome = incomeRepo.findByCaseNo(caseNo);
			Income income=new Income();
			BeanUtils.copyProperties(dcIncome, income);
			
			summary.setIncome(income);
			
			DcEducation dcEducation = educationRepo.findByCaseNo(caseNo);
			Education education=new Education();
			BeanUtils.copyProperties(dcEducation, education);
			
			summary.setEducation(education);
			
			List<Child> childs=new ArrayList<>();
			List<DcChildren> dcChildrens = childrenRepo.findByCaseNo(caseNo);
			for(DcChildren dcChild : dcChildrens) {
				Child child= new Child();
				
				BeanUtils.copyProperties(dcChild, child);
				childs.add(child);
			}
			summary.setChilds(childs);
			
			Optional<Plan> plan = planRepo.findById(caseDtl.getPlanId());
			
			if(plan.isPresent()) {
				summary.setPlan(plan.get().getPlanName());
			}

			return summary;
		}
		
		return null;
	}

}
