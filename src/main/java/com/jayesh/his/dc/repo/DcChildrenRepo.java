package com.jayesh.his.dc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.dc.entity.DcChildren;

public interface DcChildrenRepo extends JpaRepository<DcChildren, Integer> {
	List<DcChildren> findByCaseNo(Long caseNo);
}
