package com.jayesh.his.dc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.dc.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
