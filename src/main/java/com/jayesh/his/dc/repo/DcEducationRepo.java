package com.jayesh.his.dc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.dc.entity.DcEducation;

public interface DcEducationRepo extends JpaRepository<DcEducation, Integer> {

	public DcEducation findByCaseNo(Long caseNo);
}
