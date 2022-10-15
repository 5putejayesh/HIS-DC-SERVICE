package com.jayesh.his.dc.service.impl;

import java.util.Map;

import com.jayesh.his.dc.binding.DcCasesDto;
import com.jayesh.his.dc.binding.DcChildrenDto;
import com.jayesh.his.dc.binding.DcEducationDto;
import com.jayesh.his.dc.binding.DcIncomeDto;
import com.jayesh.his.dc.service.DcService;

public class DcServiceImpl implements DcService {

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createCase(DcCasesDto dcCasesDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePlanToCase(DcCasesDto dcCasesDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createIncomeDtls(DcIncomeDto incomeDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEducationDtls(DcEducationDto educationDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addChildrenDtls(DcChildrenDto childrenDto) {
		// TODO Auto-generated method stub
		return false;
	}

}
