package com.jayesh.his.dc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.dc.entity.CitizenAppEntity;


public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer> {

}
