package com.jayesh.his.dc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jayesh.his.dc.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

	@Query("select distinct(planName) from Plan")
	public List<String> findPlanNames();
}
