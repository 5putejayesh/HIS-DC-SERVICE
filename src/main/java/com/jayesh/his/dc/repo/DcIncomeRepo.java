package com.jayesh.his.dc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.dc.entity.DcIncome;

public interface DcIncomeRepo extends JpaRepository<DcIncome, Integer> {
	public DcIncome findByCaseNo(Long caseNo);
}
