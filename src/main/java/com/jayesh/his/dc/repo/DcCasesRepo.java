package com.jayesh.his.dc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jayesh.his.dc.entity.DcCase;

public interface DcCasesRepo extends JpaRepository<DcCase, Long> {

	@Query("select max(caseNo) from DcCase")
	public Optional<Long> findMaxCaseNo();
	
	public Optional<DcCase> findByCaseNo(Long caseNo);
}
